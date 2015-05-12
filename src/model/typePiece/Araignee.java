package model.typePiece;

import model.ArrayListPoint;
import model.Joueur;
import model.Piece;

public class Araignee extends Piece{
    public Araignee(Joueur joueur){
        super(joueur, TypePieceEnum.Araignee);
    }

    public ArrayListPoint getDeplacementPossible() {
        return null;
    }
}
