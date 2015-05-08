package controleur;

import model.Plateau;
import model.typePiece.*;
import vue.Fenetre;

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
        boolean invalide = false;
        if(plateau.getJoueurQuiJoue()==plateau.getJoueurBlanc()) {
            if (e.getSource() == fenetre.getJpAbeilleBlanc() && plateau.getJoueurBlanc().nbAbeilleDisponible()>0) {
                plateau.setPieceSelectionne(new Abeille(plateau.getJoueurBlanc()));
                System.out.println("Abeille Blanc");
            } else if (e.getSource() == fenetre.getJpAraigneeBlanc() && plateau.getJoueurBlanc().nbAraigneeDisponible()>0) {
                plateau.setPieceSelectionne(new Araignee(plateau.getJoueurBlanc()));
                System.out.println("Araignee Blanc");
            } else if (e.getSource() == fenetre.getJpFourmiBlanc() && plateau.getJoueurBlanc().nbFourmiDisponible()>0) {
                plateau.setPieceSelectionne(new Fourmi(plateau.getJoueurBlanc()));
                System.out.println("Fourmi Blanc");
            } else if (e.getSource() == fenetre.getJpSauterelleBlanc() && plateau.getJoueurBlanc().nbSauterelleDisponible()>0) {
                plateau.setPieceSelectionne(new Sauterelle(plateau.getJoueurBlanc()));
                System.out.println("Sauterelle Blanc");
            } else if (e.getSource() == fenetre.getJpScarabeeBlanc() && plateau.getJoueurBlanc().nbScarabeeDisponible()>0) {
                plateau.setPieceSelectionne(new Scarabee(plateau.getJoueurBlanc()));
                System.out.println("Scarabee Blanc");
            }else invalide = true;
        } else {
            if (e.getSource() == fenetre.getJpAbeilleNoir() && plateau.getJoueurNoir().nbAbeilleDisponible()>0) {
                plateau.setPieceSelectionne(new Abeille(plateau.getJoueurNoir()));
                System.out.println("Abeille Noir");
            } else if (e.getSource() == fenetre.getJpAraigneeNoir() && plateau.getJoueurNoir().nbAraigneeDisponible()>0) {
                plateau.setPieceSelectionne(new Araignee(plateau.getJoueurNoir()));
                System.out.println("Araignée Noir");
            } else if (e.getSource() == fenetre.getJpFourmiNoir() && plateau.getJoueurNoir().nbFourmiDisponible()>0) {
                plateau.setPieceSelectionne(new Fourmi(plateau.getJoueurNoir()));
                System.out.println("Fourmi Noir");
            } else if (e.getSource() == fenetre.getJpSauterelleNoir() && plateau.getJoueurNoir().nbSauterelleDisponible()>0) {
                plateau.setPieceSelectionne(new Sauterelle(plateau.getJoueurNoir()));
                System.out.println("Sauterelle Noir");
            } else if (e.getSource() == fenetre.getJpScarabeeNoir() && plateau.getJoueurNoir().nbScarabeeDisponible()>0) {
                plateau.setPieceSelectionne(new Scarabee(plateau.getJoueurNoir()));
                System.out.println("Scarabee Noir");
            }else invalide = true;
        }
        if(!invalide) {
            fenetre.affichagePlateau(true, false);
            fenetre.revalidate();
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
