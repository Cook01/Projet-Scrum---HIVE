package model.typePiece;

import model.ArrayListPoint;
import model.Joueur;
import model.Piece;

public class Sauterelle extends Piece{
    public Sauterelle(Joueur joueur) {
        super(joueur, TypePieceEnum.Sauterelle);
    }

    public ArrayListPoint getDeplacementPossible() {
        return null;
    }
}
