package model.TypePiece;

import model.Joueur;
import model.typePiece.Abeille;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class AbeilleTest {
    @Test
    public void DeplacementImpossibleSansVoisinTest() {
        Abeille abeille = new Abeille(new Joueur("blanc"));
        abeille.setPosition(new Point(5, 5));
        Assert.assertTrue(abeille.getDeplacementPossible().size()==0);
    }

    @Test
    public void DeplacementImpossibleDeuxVoisinTest() {
        Abeille abeille = new Abeille(new Joueur("blanc"));
        Abeille abeille1 = new Abeille(new Joueur("blanc"));
        Abeille abeille2 = new Abeille(new Joueur("blanc"));
        abeille1.setPosition(new Point(5, 4));
        abeille2.setPosition(new Point(5, 6));
        abeille.setPosition(new Point(5, 5));
        abeille.setVoisin(new Point(5, 4), abeille1);
        abeille.setVoisin(new Point(5, 6), abeille2);
        abeille1.setVoisin(new Point(5, 5), abeille2);
        abeille2.setVoisin(new Point(5, 5), abeille2);
        Assert.assertTrue(abeille.getDeplacementPossible().size() == 0);
    }

    @Test
    public void DeplacementPossibleUnVoisinTest() {
        Abeille abeille = new Abeille(new Joueur("blanc"));
        Abeille abeille1 = new Abeille(new Joueur("blanc"));
        abeille1.setPosition(new Point(5, 4));
        abeille.setPosition(new Point(5, 5));
        abeille.setVoisin(new Point(5, 4), abeille1);
        abeille1.setVoisin(new Point(5, 5), abeille);
        Assert.assertTrue(abeille.getDeplacementPossible().size() == 2);
        Assert.assertTrue(abeille.getDeplacementPossible().contient(new Point(4, 4)));
        Assert.assertTrue(abeille.getDeplacementPossible().contient(new Point(6, 4)));
    }

    @Test
    public void DeplacementPossibleDeuxVoisinTest() {
        Abeille abeille = new Abeille(new Joueur("blanc"));
        Abeille abeille1 = new Abeille(new Joueur("blanc"));
        Abeille abeille2 = new Abeille(new Joueur("blanc"));
        abeille1.setPosition(new Point(4, 4));
        abeille2.setPosition(new Point(4, 5));
        abeille.setPosition(new Point(5, 5));
        abeille.setVoisin(new Point(4, 4), abeille1);
        abeille.setVoisin(new Point(4, 5), abeille2);
        abeille1.setVoisin(new Point(5, 5), abeille2);
        abeille1.setVoisin(new Point(4, 5), abeille2);
        abeille2.setVoisin(new Point(5, 5), abeille2);
        abeille2.setVoisin(new Point(4, 4), abeille2);
        Assert.assertTrue(abeille.getDeplacementPossible().size()==2);
        Assert.assertTrue(abeille.getDeplacementPossible().contient(new Point(5, 4)));
        Assert.assertTrue(abeille.getDeplacementPossible().contient(new Point(5, 6)));
    }
}
