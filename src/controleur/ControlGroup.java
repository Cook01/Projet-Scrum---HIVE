package controleur;

import controleur.ControlBouton.*;
import model.Plateau;
import vue.Credit;
import vue.Fenetre;

public class ControlGroup {
    public ControlGroup(Plateau plateau) {
        Fenetre fenetre = new Fenetre(plateau);
        Credit credit = new Credit();

        new ControlBoutonGroup(plateau, fenetre, credit);
        new ControlInventaire(plateau, fenetre);
        new ControlGrille(plateau, fenetre);
        new ControlMenu(fenetre, plateau, credit);

        credit.setVisible(false);
        fenetre.setVisible(true);
    }
}
