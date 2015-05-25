package controleur;

import model.Joueur;
import model.Piece;
import model.Plateau;
import model.typePiece.*;
import vue.Fenetre;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControlGrille implements MouseListener, KeyListener{
    private Fenetre fenetre;
    private Plateau plateau;

    public ControlGrille(Plateau plateau, Fenetre fenetre) {
        this.plateau = plateau;
        this.fenetre = fenetre;
        fenetre.setControlGrille(this, this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        boolean invalide = false;
        if(e.getButton() == MouseEvent.BUTTON3) {
            plateau.setPieceSelectionne(null);
            fenetre.affichagePlateau(false, false);
            fenetre.revalidate();
        } else {
            if (fenetre.getGrille().getImagePiece().getImages().size() != 0) {
                int pas_x = fenetre.getGrille().getPas_x();
                Integer x = null;
                for (int i = 0; i < fenetre.getGrille().getCol(); i++) {
                    if (e.getX()-fenetre.getGrille().position.x > (int)((pas_x+1.5) * i + fenetre.getGrille().bordure_x + pas_x*1.3 / 4)
                            && e.getX()-fenetre.getGrille().position.x < (int)((pas_x+1.5) * i + fenetre.getGrille().bordure_x + pas_x*1.3 / 4 *3)) {
                        x = i;
                        break;
                    }
                }
                if (x != null) {
                    int pas_y = fenetre.getGrille().getPas_y();
                    Integer y = null;
                    if (x % 2 == 0) {
                        for (int i = 0; i < fenetre.getGrille().getRow(); i++) {
                            if (e.getY()-fenetre.getGrille().position.y > (pas_y+4) * i + fenetre.getGrille().bordure_y
                                    && e.getY()-fenetre.getGrille().position.y < (pas_y+4) * i + fenetre.getGrille().bordure_x + pas_y) {
                                y = i;
                                break;
                            }
                        }
                    } else if(fenetre.getGrille().centre.x%2==0){
                        for (int i = 0; i < fenetre.getGrille().getRow(); i++) {
                            if (e.getY()-fenetre.getGrille().position.y > (pas_y+4) * i + fenetre.getGrille().bordure_y - pas_y /2
                                    && e.getY()-fenetre.getGrille().position.y < (pas_y+4) * i + fenetre.getGrille().bordure_x + pas_y - pas_y /2) {
                                y = i;
                                break;
                            }
                        }
                    } else {
                        for (int i = 0; i < fenetre.getGrille().getRow(); i++) {
                            if (e.getY()-fenetre.getGrille().position.y > (pas_y+4) * i + fenetre.getGrille().bordure_y + pas_y /2
                                    && e.getY()-fenetre.getGrille().position.y < (pas_y+4) * i + fenetre.getGrille().bordure_x + pas_y + pas_y /2) {
                                y = i;
                                break;
                            }
                        }
                    }
                    if (y != null) {
                        Point position = new Point(x-fenetre.getGrille().centre.x, y-fenetre.getGrille().centre.y);
                        if (plateau.getPieceSelectionne() != null) {
                            if (fenetre.getGrille().getImagePiece().getIndicePlacementImage().contains(position)) {
                                Piece piece = plateau.getPieceSelectionne();
                                Piece tmpPiece = piece;
                                if(piece.getPosition()==null) {
                                    if (plateau.getPlacementPossible().contient(position)) {
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
                                    }else {
                                        invalide = true;
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
                                    adaptationPlateauVue();
                                    Joueur perdant = plateau.perdant();
                                    fenetre.revalidate();
                                    if(perdant != null || plateau.egalite()) {
                                        Joueur gagnant;
                                        if(!plateau.egalite()) {
                                            if (plateau.getJoueurBlanc() == perdant)
                                                gagnant = plateau.getJoueurNoir();
                                            else gagnant = plateau.getJoueurBlanc();
                                            JOptionPane.showMessageDialog(fenetre, "L'abeille du joueur " + perdant.couleur + " est bloquée.\n Le joueur " + gagnant.couleur + " gagne la partie.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                                        } else JOptionPane.showMessageDialog(fenetre, "Les deux abeilles sont bloquées.\n Il y a donc égalité.", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                                        plateau.reinitialiser();
                                        fenetre.reinitialiser();
                                        fenetre.affichagePlateau(false, false);
                                        fenetre.revalidate();
                                    }
                                }
                            }
                        } else {
                            if(plateau.getJoueurQuiJoue() == plateau.getPiece(position).getJoueur()) {
                                if(plateau.tour!=4 || plateau.getJoueurQuiJoue().nbAbeilleDisponible()==0) {
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
    }

    private void adaptationPlateauVue() {
        for(Point point : fenetre.getGrille().getImagePiece().getIndicePlacementImage()) {
           if(point.x+fenetre.getGrille().centre.x==0)
               fenetre.getGrille().centre.x++;
            if(point.x+fenetre.getGrille().centre.x==24)
                fenetre.getGrille().centre.x--;
            if(fenetre.getGrille().centre.x%2==0) {
                if(point.x%2==0) {
                    if (point.y + fenetre.getGrille().centre.y == 0)
                        fenetre.getGrille().centre.y++;
                    if (point.y + fenetre.getGrille().centre.y == 23)
                        fenetre.getGrille().centre.y--;
                } else {
                    if (point.y + fenetre.getGrille().centre.y == 1)
                        fenetre.getGrille().centre.y++;
                    if (point.y + fenetre.getGrille().centre.y == 24)
                        fenetre.getGrille().centre.y--;
                }
            } else {
                if (point.y + fenetre.getGrille().centre.y == 0)
                    fenetre.getGrille().centre.y++;
                if (point.y + fenetre.getGrille().centre.y == 23)
                    fenetre.getGrille().centre.y--;
            }
        }
        fenetre.affichagePlateau(false, true);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            fenetre.getGrille().deplaceHaut();
        }else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            fenetre.getGrille().deplaceBas();
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            fenetre.getGrille().deplaceGauche();
        }else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            fenetre.getGrille().deplaceDroite();
        }
        fenetre.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
