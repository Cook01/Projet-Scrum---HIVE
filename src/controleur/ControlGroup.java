package controleur;

import model.Jeu;
import vue.Fenetre;

/**
 * Created by Nathanaël on 20/04/2015.
 */
public class ControlGroup {
    public ControlGroup(Jeu jeu) {
        Fenetre fenetre;

        fenetre = new Fenetre(jeu);

        fenetre.setVisible(true);
    }
}
