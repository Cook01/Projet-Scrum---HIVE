package controleur;

import model.Jeu;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlBoutonJeu implements ActionListener {
    Fenetre fenetre;
    Jeu jeu;

    public ControlBoutonJeu(Jeu jeu, Fenetre fenetre) {
        this.jeu = jeu;
        this.fenetre = fenetre;

        fenetre.setControlBoutonJouer(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
