package model;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class JoueurTest {
    @Test
    public void inventaire_base_piece_placable() {
        Joueur joueur = new Joueur("Blanc");
        Assert.assertEquals(joueur.nbAbeilleDisponible(), 1);
        Assert.assertEquals(joueur.nbAraigneeDisponible(), 2);
        Assert.assertEquals(joueur.nbFourmiDisponible(), 3);
        Assert.assertEquals(joueur.nbSauterelleDisponible(), 3);
        Assert.assertEquals(joueur.nbScarabeeDisponible(), 2);
    }

    @Test
    public void inventaire_base_piece_placable_apres_placement_fourmi() {
        Joueur joueur = new Joueur("Blanc");
        Plateau plateau = new Plateau();
        plateau.jouer(joueur.getAbeille(), new Point(0,0));
        plateau.jouer(joueur.getAraignee(), new Point(0,1));
        plateau.jouer(joueur.getFourmi(), new Point(0,2));
        plateau.jouer(joueur.getSauterelle(), new Point(0,3));
        plateau.jouer(joueur.getScarabe(), new Point(0,0));
        Assert.assertEquals(joueur.nbAbeilleDisponible(), 0);
        Assert.assertEquals(joueur.nbAraigneeDisponible(), 1);
        Assert.assertEquals(joueur.nbFourmiDisponible(), 2);
        Assert.assertEquals(joueur.nbSauterelleDisponible(), 2);
        Assert.assertEquals(joueur.nbScarabeeDisponible(), 1);
    }
}
