package controleur.ControlBouton;

import model.Plateau;
import vue.Fenetre;

public class ControlBoutonGroup {
    public ControlBoutonGroup(Plateau plateau, Fenetre fenetre) {
        new ControlBoutonJeu(plateau, fenetre);
        new ControlBoutonMenu(plateau, fenetre);
        new ControlBouton1(plateau, fenetre);
        new ControlBouton2(plateau, fenetre);
        new ControlBouton3(plateau, fenetre);
    }
}
