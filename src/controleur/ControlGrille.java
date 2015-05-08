package controleur;

import model.Piece;
import model.Plateau;
import model.typePiece.*;
import vue.Fenetre;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControlGrille implements MouseListener{
    Fenetre fenetre;
    Plateau plateau;

    public ControlGrille(Plateau plateau, Fenetre fenetre) {
        this.plateau = plateau;
        this.fenetre = fenetre;

        fenetre.setControlGrille(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        boolean invalide = false;
        if(e.getButton()==MouseEvent.BUTTON3) {
            plateau.setPieceSelectionne(null);
            fenetre.affichagePlateau(false, false);
            fenetre.revalidate();
        }else {
            if (fenetre.getGrille().getImagePiece().getImages().size() != 0) {
                int pas_x = fenetre.getGrille().getPas_x();
                Integer x = null;
                for (int i = 0; i < fenetre.getGrille().getCol(); i++) {
                    if (e.getX() > pas_x * i + (int) (fenetre.getGrille().getWidth() * 0.1) + pas_x * 1.3 / 4
                            && e.getX() < pas_x * i + (int) (fenetre.getGrille().getWidth() * 0.1) + pas_x * 1.3 / 4 * 3)
                        x = i;
                }
                if (x != null) {
                    int pas_y = fenetre.getGrille().getPas_y();
                    Integer y = null;
                    if ((x + plateau.getPositionPieceXMin() - 1) % 2 == 0) {
                        for (int i = 0; i < fenetre.getGrille().getRow(); i++)
                            if (e.getY() > pas_y * i + (int) (fenetre.getGrille().getHeight() * 0.15)
                                    && e.getY() < pas_y * (i + 1) + (int) (fenetre.getGrille().getHeight() * 0.15))
                                y = i;
                    } else {
                        for (int i = 0; i < fenetre.getGrille().getRow(); i++)
                            if (e.getY() > pas_y * i + (int) (fenetre.getGrille().getHeight() * 0.15) - pas_y / 2
                                    && e.getY() < pas_y * (i + 1) + (int) (fenetre.getGrille().getHeight() * 0.15) - pas_y / 2)
                                y = i;
                    }
                    if (y != null) {
                        Point position = new Point(x + plateau.getPositionPieceXMin() - 1, y + plateau.getPositionPieceYMin() - 1);
                        if (plateau.getPieceSelectionne() != null) {
                            if (fenetre.getGrille().getImagePiece().getIndicePlacementImage().contains(position)) {
                                Piece piece = plateau.getPieceSelectionne();
                                Piece tmpPiece = piece;
                                if(piece.getPosition()==null) {
                                    if (piece.getJoueur() == plateau.getJoueurBlanc()) {
                                        if (piece instanceof Abeille)
                                            tmpPiece = plateau.getJoueurBlanc().getAbeille();
                                        else if (piece instanceof Araignee)
                                            tmpPiece = plateau.getJoueurBlanc().getAraignee();
                                        else if (piece instanceof Fourmi)
                                            tmpPiece = plateau.getJoueurBlanc().getFourmi();
                                        else if (piece instanceof Sauterelle)
                                            tmpPiece = plateau.getJoueurBlanc().getSauterelle();
                                        else if (piece instanceof Scarabee)
                                            tmpPiece = plateau.getJoueurBlanc().getScarabe();
                                    } else {
                                        if (piece instanceof Abeille)
                                            tmpPiece = plateau.getJoueurNoir().getAbeille();
                                        else if (piece instanceof Araignee)
                                            tmpPiece = plateau.getJoueurNoir().getAraignee();
                                        else if (piece instanceof Fourmi)
                                            tmpPiece = plateau.getJoueurNoir().getFourmi();
                                        else if (piece instanceof Sauterelle)
                                            tmpPiece = plateau.getJoueurNoir().getSauterelle();
                                        else if (piece instanceof Scarabee)
                                            tmpPiece = plateau.getJoueurNoir().getScarabe();
                                    }
                                } else {
                                    if (position.equals(tmpPiece.getPosition())) {
                                        invalide = true;
                                    }
                                    for(Piece chaquePiece : plateau.getPiece_pose())
                                        if(chaquePiece.getPosition().equals(position))
                                            invalide = true;
                                }
                                if (!invalide) {
                                    plateau.jouer(tmpPiece, position);
                                    plateau.setPieceSelectionne(null);
                                    fenetre.affichagePlateau(false, false);
                                    fenetre.revalidate();
                                }
                            }
                        } else {
                            if(plateau.getJoueurQuiJoue() == plateau.getPiece(position).getJoueur()) {
                                plateau.setPieceSelectionne(plateau.getPiece(position));
                                fenetre.affichagePlateau(false, true);
                                fenetre.revalidate();
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
