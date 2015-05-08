package controleur;

import model.Plateau;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlBoutonJeu implements ActionListener {
    Fenetre fenetre;
    Plateau plateau;

    public ControlBoutonJeu(Plateau plateau, Fenetre fenetre) {
        this.plateau = plateau;
        this.fenetre = fenetre;

        fenetre.setControlBoutonJouer(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fenetre.affichagePlateau(false, false);
        fenetre.revalidate();
    }
}
