package controleur.ControlBouton;

import model.Plateau;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlBouton1 implements ActionListener {
    Fenetre fenetre;
    Plateau plateau;

    public ControlBouton1(Plateau plateau, Fenetre fenetre) {
        this.plateau = plateau;
        this.fenetre = fenetre;

        fenetre.setControlBouton1(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fenetre.affichagePlateau(false, false);
        fenetre.revalidate();
    }
}
