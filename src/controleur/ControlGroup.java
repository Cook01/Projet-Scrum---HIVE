package controleur;

import controleur.ControlBouton.*;
import model.Plateau;
import vue.Fenetre;

public class ControlGroup {
    public ControlGroup(Plateau plateau) {
        Fenetre fenetre = new Fenetre(plateau);

        new ControlBoutonGroup(plateau, fenetre);
        new ControlInventaire(plateau, fenetre);
        new ControlGrille(plateau, fenetre);
        new ControlMenu(fenetre, plateau);

        fenetre.setVisible(true);
    }
}
