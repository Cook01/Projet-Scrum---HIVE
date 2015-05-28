package model;


import org.junit.Assert;
import model.typePiece.Abeille;
import org.junit.Test;

import java.awt.*;

public class PieceTest {
    @Test
    public void positionTest() {
        Piece piece = new Abeille(new Joueur("blanc"));
        piece.setPosition(new Point(5,5));
        Assert.assertTrue(piece.getPosition().equals(new Point(5,5)));
    }

    @Test
    public void getVoisinNullSansVoisinTest() {
        Piece piece = new Abeille(new Joueur("blanc"));
        piece.setPosition(new Point(5, 5));
        ArrayListPoint voisinNull = piece.getVoisinNull();
        Assert.assertTrue(voisinNull.size() == 6);
        Assert.assertTrue(voisinNull.contient(new Point(4, 5)));
        Assert.assertTrue(voisinNull.contient(new Point(4, 4)));
        Assert.assertTrue(voisinNull.contient(new Point(5, 4)));
        Assert.assertTrue(voisinNull.contient(new Point(5, 6)));
        Assert.assertTrue(voisinNull.contient(new Point(6, 5)));
        Assert.assertTrue(voisinNull.contient(new Point(6, 4)));
    }

    @Test
    public void getVoisinNullAvecUnVoisinTest() {
        Piece piece = new Abeille(new Joueur("blanc"));
        piece.setPosition(new Point(5, 5));
        piece.setVoisin(new Point(4,5), new Abeille(new Joueur("noir")));
        ArrayListPoint voisinNull = piece.getVoisinNull();
        Assert.assertTrue(voisinNull.size() == 5);
        Assert.assertTrue(voisinNull.contient(new Point(4, 4)));
        Assert.assertTrue(voisinNull.contient(new Point(5, 4)));
        Assert.assertTrue(voisinNull.contient(new Point(5, 6)));
        Assert.assertTrue(voisinNull.contient(new Point(6, 5)));
        Assert.assertTrue(voisinNull.contient(new Point(6, 4)));
    }

    @Test
    public void getVoisinNullAvecSixVoisinTest() {
        Piece piece = new Abeille(new Joueur("blanc"));
        piece.setPosition(new Point(5, 5));
        piece.setVoisin(new Point(4, 5), new Abeille(new Joueur("noir")));
        piece.setVoisin(new Point(5, 4), new Abeille(new Joueur("noir")));
        piece.setVoisin(new Point(5, 6), new Abeille(new Joueur("noir")));
        piece.setVoisin(new Point(6, 5), new Abeille(new Joueur("noir")));
        piece.setVoisin(new Point(4, 4), new Abeille(new Joueur("noir")));
        piece.setVoisin(new Point(6,4), new Abeille(new Joueur("noir")));
        Assert.assertTrue(piece.getVoisinNull().size() == 0);
    }

    @Test
    public void retirerUnVoisinTest() {
        Piece piece = new Abeille(new Joueur("blanc"));
        Piece piece_a_retirer = new Abeille(new Joueur("noir"));
        piece.setPosition(new Point(5, 5));
        piece.setVoisin(new Point(4, 5), piece_a_retirer);
        piece.retireVoisin(piece_a_retirer);
        ArrayListPoint voisinNull = piece.getVoisinNull();
        Assert.assertTrue(voisinNull.size() == 6);
        Assert.assertTrue(voisinNull.contient(new Point(4, 5)));
    }

    @Test
    public void retirerTousLesvoisinsTest() {
        Piece piece = new Abeille(new Joueur("blanc"));
        piece.setPosition(new Point(5, 5));
        piece.setVoisin(new Point(4, 5), new Abeille(new Joueur("noir")));
        piece.setVoisin(new Point(4, 4), new Abeille(new Joueur("noir")));
        piece.setVoisin(new Point(5, 4), new Abeille(new Joueur("noir")));
        piece.nettoyerVoisin();
        Assert.assertTrue(piece.getVoisinNull().size() == 6);
    }

    @Test
    public void nePeutPasSeDeplacerTest() {
        Piece piece = new Abeille(new Joueur("blanc"));
        Piece piece1 = new Abeille(new Joueur("blanc"));
        Piece piece2 = new Abeille(new Joueur("blanc"));
        Piece piece3 = new Abeille(new Joueur("blanc"));
        Piece piece4 = new Abeille(new Joueur("blanc"));
        Piece piece5 = new Abeille(new Joueur("blanc"));
        Piece piece6 = new Abeille(new Joueur("blanc"));
        piece.setPosition(new Point(5, 5));
        piece.setVoisin(new Point(4, 5), piece1);
        piece.setVoisin(new Point(5, 4), piece2);
        piece.setVoisin(new Point(5, 6), piece3);
        piece.setVoisin(new Point(6, 5), piece4);
        piece.setVoisin(new Point(4, 4), piece5);
        piece.setVoisin(new Point(6, 4), piece6);
        Assert.assertFalse(piece.peutSeDeplacer());
        piece.retireVoisin(piece3);
        Assert.assertFalse(piece.peutSeDeplacer());
        piece.retireVoisin(piece2);
        Assert.assertFalse(piece.peutSeDeplacer());
        piece.retireVoisin(piece1);
        Assert.assertFalse(piece.peutSeDeplacer());
        piece.retireVoisin(piece4);
        Assert.assertFalse(piece.peutSeDeplacer());
    }

    @Test
    public void PeutSeDeplacerTest() {
        Piece piece = new Abeille(new Joueur("blanc"));
        Piece piece1 = new Abeille(new Joueur("blanc"));
        Piece piece2 = new Abeille(new Joueur("blanc"));
        Piece piece3 = new Abeille(new Joueur("blanc"));
        Piece piece4 = new Abeille(new Joueur("blanc"));
        piece.setPosition(new Point(5, 5));
        piece.setVoisin(new Point(4, 4), piece1);
        Assert.assertTrue(piece.peutSeDeplacer());
        piece.setVoisin(new Point(4, 5), piece2);
        Assert.assertTrue(piece.peutSeDeplacer());
        piece.setVoisin(new Point(5, 6), piece3);
        Assert.assertTrue(piece.peutSeDeplacer());
        piece.setVoisin(new Point(6, 5), piece4);
        Assert.assertTrue(piece.peutSeDeplacer());
    }
}

