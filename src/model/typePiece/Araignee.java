package model.typePiece;

import model.ArrayListPoint;
import model.Joueur;
import model.Piece;

import java.awt.*;

public class Araignee extends Piece{
    public Araignee(Joueur joueur){
        super(joueur);
    }

    public ArrayListPoint getDeplacementPossible() {
        return null;
    }
}
