package model.typePiece;

import model.ArrayListPoint;
import model.Joueur;
import model.Piece;

import java.awt.*;

public class Sauterelle extends Piece{
    public Sauterelle(Joueur joueur) {
        super(joueur);
    }

    public ArrayListPoint getDeplacementPossible() {
        return null;
    }
}