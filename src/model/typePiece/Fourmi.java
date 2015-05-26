package model.typePiece;

import model.ArrayListPoint;
import model.Joueur;
import model.Piece;

import java.awt.*;

public class Fourmi extends Piece{
    public Fourmi(Joueur joueur) {
        super(joueur, TypePieceEnum.Fourmi);
    }

    public ArrayListPoint getDeplacementPossible() {
        ArrayListPoint deplacementPossible = new ArrayListPoint();
        ArrayList<Piece> pieceBord = getBords(new ArrayList<Piece>(), new ArrayList<Piece>());
        if(peutSeDeplacer()) {
            for(Piece bord : pieceBord){
            	deplacementPossible.addAll(dessus_gauche.getVoisinNull());
            }
        }
        return deplacementPossible;
    }

    public ArrayList<Piece> getBords(ArrayList<Piece> pieceBord, ArrayList<Piece> pieceDejaCheck){

    	if(getVoisinNull().size() >= 1){
    		pieceBord.add(this);
    	}

    	pieceDejaCheck.add(this);

    	if(dessus != NULL && pieceDejaCheck.indexOf(dessus) == -1){
    		pieceBord = dessus.getBords(pieceBord, pieceDejaCheck);
    	}

    	if(dessus_droite != NULL && pieceDejaCheck.indexOf(dessus_droite) == -1){
    		pieceBord = dessus_droite.getBords(pieceBord, pieceDejaCheck);
    	}

    	if(dessous_droite != NULL && pieceDejaCheck.indexOf(dessous_droite) == -1){
    		pieceBord = dessous_droite.getBords(pieceBord, pieceDejaCheck);
    	}

    	if(dessous != NULL && pieceDejaCheck.indexOf(dessous) == -1){
    		pieceBord = dessous.getBords(pieceBord, pieceDejaCheck);
    	}

    	if(dessous_gauche != NULL && pieceDejaCheck.indexOf(dessous_gauche) == -1){
    		pieceBord = dessous_gauche.getBords(pieceBord, pieceDejaCheck);
    	}

    	if(dessus_gauche != NULL && pieceDejaCheck.indexOf(dessus_gauche) == -1){
    		pieceBord = dessus_gauche.getBords(pieceBord, pieceDejaCheck);
    	}

    	return pieceBord;
    }
}
