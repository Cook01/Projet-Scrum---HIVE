package controleur.ControlBouton;

import model.Plateau;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlBoutonMenu implements ActionListener {
    Fenetre fenetre;
    Plateau plateau;

    public ControlBoutonMenu(Plateau plateau, Fenetre fenetre) {
        this.plateau = plateau;
        this.fenetre = fenetre;

        fenetre.setControlBoutonMenu(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        fenetre.affichagePlateau(false, false);
        fenetre.revalidate();
    }
}
