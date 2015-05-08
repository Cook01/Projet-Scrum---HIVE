package controleur;

import model.Plateau;
import vue.Fenetre;

public class ControlGroup {
    public ControlGroup(Plateau plateau) {
        Fenetre fenetre = new Fenetre(plateau);

        new ControlBoutonJeu(plateau, fenetre);
        new ControlInventaire(plateau, fenetre);
        new ControlGrille(plateau, fenetre);

        fenetre.setVisible(true);
    }
}
