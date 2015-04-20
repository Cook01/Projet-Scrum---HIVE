package controleur;

import model.Jeu;
import vue.Fenetre;

public class ControlGroup {
    public ControlGroup(Jeu jeu) {
        Fenetre fenetre;

        fenetre = new Fenetre(jeu);

        fenetre.setVisible(true);
    }
}
