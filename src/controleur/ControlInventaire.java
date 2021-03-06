package controleur;

import model.Plateau;
import model.typePiece.*;
import vue.Fenetre;
import vue.Piece.Jeton;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControlInventaire implements MouseListener{
    Fenetre fenetre;
    Plateau plateau;

    public ControlInventaire(Plateau plateau, Fenetre fenetre) {
        this.plateau = plateau;
        this.fenetre = fenetre;

        fenetre.setControlInventaire(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Jeton jeton;
        boolean invalide = false;
        if(plateau.getPieceSelectionne()== null) {
            if (plateau.getJoueurQuiJoue() == plateau.getJoueurBlanc()) {
                if (plateau.tour != 4 ||
                        plateau.getJoueurQuiJoue().nbAbeilleDisponible() == 0 || e.getSource() == fenetre.getJpAbeilleBlanc()) {
                    if (e.getSource() == fenetre.getJpAbeilleBlanc() && plateau.getJoueurBlanc().nbAbeilleDisponible() > 0) {
                        plateau.setPieceSelectionne(new Abeille(plateau.getJoueurBlanc()));
                        jeton = (Jeton) (fenetre.getJpAbeilleBlanc().getComponent(0));
                        jeton.selection();
                    } else if (e.getSource() == fenetre.getJpAraigneeBlanc() && plateau.getJoueurBlanc().nbAraigneeDisponible() > 0) {
                        plateau.setPieceSelectionne(new Araignee(plateau.getJoueurBlanc()));
                        jeton = (Jeton) (fenetre.getJpAraigneeBlanc().getComponent(0));
                        jeton.selection();
                    } else if (e.getSource() == fenetre.getJpFourmiBlanc() && plateau.getJoueurBlanc().nbFourmiDisponible() > 0) {
                        plateau.setPieceSelectionne(new Fourmi(plateau.getJoueurBlanc()));
                        jeton = (Jeton) (fenetre.getJpFourmiBlanc().getComponent(0));
                        jeton.selection();
                    } else if (e.getSource() == fenetre.getJpSauterelleBlanc() && plateau.getJoueurBlanc().nbSauterelleDisponible() > 0) {
                        plateau.setPieceSelectionne(new Sauterelle(plateau.getJoueurBlanc()));
                        jeton = (Jeton) (fenetre.getJpSauterelleBlanc().getComponent(0));
                        jeton.selection();
                    } else if (e.getSource() == fenetre.getJpScarabeeBlanc() && plateau.getJoueurBlanc().nbScarabeeDisponible() > 0) {
                        plateau.setPieceSelectionne(new Scarabee(plateau.getJoueurBlanc()));
                        jeton = (Jeton) (fenetre.getJpScarabeeBlanc().getComponent(0));
                        jeton.selection();
                    } else invalide = true;
                } else invalide = true;
            } else {
                if (plateau.tour != 4 ||
                        plateau.getJoueurQuiJoue().nbAbeilleDisponible() == 0 || e.getSource() == fenetre.getJpAbeilleNoir()) {
                    if (e.getSource() == fenetre.getJpAbeilleNoir() && plateau.getJoueurNoir().nbAbeilleDisponible() > 0) {
                        plateau.setPieceSelectionne(new Abeille(plateau.getJoueurNoir()));
                        jeton = (Jeton) (fenetre.getJpAbeilleNoir().getComponent(0));
                        jeton.selection();
                    } else if (e.getSource() == fenetre.getJpAraigneeNoir() && plateau.getJoueurNoir().nbAraigneeDisponible() > 0) {
                        plateau.setPieceSelectionne(new Araignee(plateau.getJoueurNoir()));
                        jeton = (Jeton) (fenetre.getJpAraigneeNoir().getComponent(0));
                        jeton.selection();
                    } else if (e.getSource() == fenetre.getJpFourmiNoir() && plateau.getJoueurNoir().nbFourmiDisponible() > 0) {
                        plateau.setPieceSelectionne(new Fourmi(plateau.getJoueurNoir()));
                        jeton = (Jeton) (fenetre.getJpFourmiNoir().getComponent(0));
                        jeton.selection();
                    } else if (e.getSource() == fenetre.getJpSauterelleNoir() && plateau.getJoueurNoir().nbSauterelleDisponible() > 0) {
                        plateau.setPieceSelectionne(new Sauterelle(plateau.getJoueurNoir()));
                        jeton = (Jeton) (fenetre.getJpSauterelleNoir().getComponent(0));
                        jeton.selection();
                    } else if (e.getSource() == fenetre.getJpScarabeeNoir() && plateau.getJoueurNoir().nbScarabeeDisponible() > 0) {
                        plateau.setPieceSelectionne(new Scarabee(plateau.getJoueurNoir()));
                        jeton = (Jeton) (fenetre.getJpScarabeeNoir().getComponent(0));
                        jeton.selection();
                    } else invalide = true;
                } else invalide = true;
            }
            if (!invalide) {
                fenetre.affichagePlateau(true, false);
                fenetre.revalidate();
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
