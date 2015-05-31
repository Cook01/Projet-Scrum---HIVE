package model.TypePiece;

import model.Joueur;
import model.typePiece.Sauterelle;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class SauterelleTest {
    @Test
    public void DeplacementImpossibleSansVoisinTest(){
        Sauterelle sauterelle = new Sauterelle(new Joueur("blanc"));
        sauterelle.setPosition(new Point(3, 3));
        Assert.assertTrue(sauterelle.getDeplacementPossible().size()==0);
    }

    @Test
    public void DeplacementPossibleUnVoisinHautTest(){
        Sauterelle sauterelle = new Sauterelle(new Joueur("blanc"));
        Sauterelle sauterelle1 = new Sauterelle(new Joueur("blanc"));
        sauterelle.setPosition(new Point(5, 5));
        sauterelle1.setPosition(new Point(5, 6));
        sauterelle1.setVoisin(new Point(5, 5), sauterelle);
        sauterelle.setVoisin(new Point(5, 6), sauterelle1);
        Assert.assertTrue(sauterelle.getDeplacementPossible().size() == 1);
        Assert.assertTrue(sauterelle.getDeplacementPossible().contient(new Point(5, 7)));
    }

    @Test
    public void DeplacementPossibleUnVoisinHautGaucheTest(){
        Sauterelle sauterelle = new Sauterelle(new Joueur("blanc"));
        Sauterelle sauterelle1 = new Sauterelle(new Joueur("blanc"));
        sauterelle.setPosition(new Point(5, 5));
        sauterelle1.setPosition(new Point(4, 6));
        sauterelle1.setVoisin(new Point(5, 5), sauterelle);
        sauterelle.setVoisin(new Point(4, 6), sauterelle1);
        Assert.assertTrue(sauterelle.getDeplacementPossible().size() == 1);
        Assert.assertTrue(sauterelle.getDeplacementPossible().contient(new Point(3, 6)));
    }
    @Test
    public void DeplacementPossibleUnVoisinHautDroiteTest(){
        Sauterelle sauterelle = new Sauterelle(new Joueur("blanc"));
        Sauterelle sauterelle1 = new Sauterelle(new Joueur("blanc"));
        sauterelle.setPosition(new Point(5, 5));
        sauterelle1.setPosition(new Point(6, 6));
        sauterelle1.setVoisin(new Point(5, 5), sauterelle);
        sauterelle.setVoisin(new Point(6, 6), sauterelle1);
        Assert.assertTrue(sauterelle.getDeplacementPossible().size() == 1);
        Assert.assertTrue(sauterelle.getDeplacementPossible().contient(new Point(7, 6)));
    }
    @Test
    public void DeplacementPossibleUnVoisinBasGaucheTest(){
        Sauterelle sauterelle = new Sauterelle(new Joueur("blanc"));
        Sauterelle sauterelle1 = new Sauterelle(new Joueur("blanc"));
        sauterelle.setPosition(new Point(5, 5));
        sauterelle1.setPosition(new Point(4, 5));
        sauterelle1.setVoisin(new Point(5, 5), sauterelle);
        sauterelle.setVoisin(new Point(4, 5), sauterelle1);
        Assert.assertTrue(sauterelle.getDeplacementPossible().size() == 1);
        Assert.assertTrue(sauterelle.getDeplacementPossible().contient(new Point(3, 6)));
    }
    @Test
    public void DeplacementPossibleUnVoisinBasDroiteTest(){
        Sauterelle sauterelle = new Sauterelle(new Joueur("blanc"));
        Sauterelle sauterelle1 = new Sauterelle(new Joueur("blanc"));
        sauterelle.setPosition(new Point(5, 5));
        sauterelle1.setPosition(new Point(6, 5));
        sauterelle1.setVoisin(new Point(5, 5), sauterelle);
        sauterelle.setVoisin(new Point(6, 5), sauterelle1);
        Assert.assertTrue(sauterelle.getDeplacementPossible().size() == 1);
        Assert.assertTrue(sauterelle.getDeplacementPossible().contient(new Point(7, 6)));
    }
    @Test
    public void DeplacementPossibleUnVoisinBasTest(){
        Sauterelle sauterelle = new Sauterelle(new Joueur("blanc"));
        Sauterelle sauterelle1 = new Sauterelle(new Joueur("blanc"));
        sauterelle.setPosition(new Point(5, 5));
        sauterelle1.setPosition(new Point(5, 4));
        sauterelle1.setVoisin(new Point(5, 5), sauterelle);
        sauterelle.setVoisin(new Point(5, 4), sauterelle1);
        Assert.assertTrue(sauterelle.getDeplacementPossible().size() == 1);
        Assert.assertTrue(sauterelle.getDeplacementPossible().contient(new Point(5, 3)));
    }

    @Test
    public void DeplacementPossibleLigneVoisinTest(){
        Sauterelle sauterelle = new Sauterelle(new Joueur("blanc"));
        Sauterelle sauterelle1 = new Sauterelle(new Joueur("blanc"));
        Sauterelle sauterelle2 = new Sauterelle(new Joueur("blanc"));
        sauterelle.setPosition(new Point(5, 5));
        sauterelle1.setPosition(new Point(5, 6));
        sauterelle2.setPosition(new Point(5, 7));
        sauterelle.setVoisin(new Point(5, 6), sauterelle1);
        sauterelle1.setVoisin(new Point(5, 5), sauterelle);
        sauterelle1.setVoisin(new Point(5, 7), sauterelle2);
        sauterelle2.setVoisin(new Point(5, 6), sauterelle1);
        Assert.assertTrue(sauterelle.getDeplacementPossible().size() == 1);
        Assert.assertTrue(sauterelle.getDeplacementPossible().contient(new Point(5, 8)));
    }

    // Cas où il a des voisins en ligne et une case vide dans la ligne
    @Test
    public void DeplacementPossibleLigneAvecTrouTest(){
        Sauterelle sauterelle = new Sauterelle(new Joueur("blanc"));
        Sauterelle sauterelle1 = new Sauterelle(new Joueur("blanc"));
        Sauterelle sauterelle2 = new Sauterelle(new Joueur("blanc"));
        Sauterelle sauterelle3 = new Sauterelle(new Joueur("blanc"));
        sauterelle.setPosition(new Point(5, 5));
        sauterelle1.setPosition(new Point(5, 6));
        sauterelle2.setPosition(new Point(5, 7));
        sauterelle3.setPosition(new Point(5, 9));
        sauterelle.setVoisin(new Point(5, 6), sauterelle1);
        sauterelle1.setVoisin(new Point(5, 5), sauterelle);
        sauterelle1.setVoisin(new Point(5, 7), sauterelle2);
        sauterelle2.setVoisin(new Point(5, 6), sauterelle1);
        Assert.assertTrue(sauterelle.getDeplacementPossible().size() == 1);
        Assert.assertTrue(sauterelle.getDeplacementPossible().contient(new Point(5, 8)));
    }

}
