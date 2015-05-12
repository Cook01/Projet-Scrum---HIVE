package model.typePiece;

import model.ArrayListPoint;
import model.Joueur;
import model.Piece;

public class Fourmi extends Piece{
    public Fourmi(Joueur joueur) {
        super(joueur, TypePieceEnum.Fourmi);
    }

    public ArrayListPoint getDeplacementPossible() {
        return null;
    }
}
