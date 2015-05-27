package model.typePiece;

import model.ArrayListPoint;
import model.Joueur;
import model.Piece;

import java.util.ArrayList;

public class Fourmi extends Piece{
    public Fourmi(Joueur joueur) {
        super(joueur, TypePieceEnum.Fourmi);
    }

    public ArrayListPoint getDeplacementPossible() {
        ArrayListPoint deplacementPossible = new ArrayListPoint();
        ArrayList<Piece> pieceBord = getBords(new ArrayList<Piece>(), new ArrayList<Piece>());
        if(peutSeDeplacer()) {
            for(Piece bord : pieceBord){
            	deplacementPossible.addAll(bord.getVoisinNull());
            }
        }
        return deplacementPossible;
    }
}
