package model.typePiece;

import model.ArrayListPoint;
import model.Joueur;
import model.Piece;

import java.awt.*;


public class Abeille extends Piece {
    public Abeille(Joueur joueur){
        super(joueur, TypePieceEnum.Abeille);
    }

    public ArrayListPoint getDeplacementPossible() {
        ArrayListPoint deplacementPossible = new ArrayListPoint();
        ArrayListPoint tmpDeplacement = new ArrayListPoint();
        ArrayListPoint voisinLibre = getVoisinNull();
        if(peutSeDeplacer()) {
            if(dessus!=null){
                tmpDeplacement.addAll(dessus.getVoisinNull());
            }
            if(dessus_droite!=null){
                tmpDeplacement.addAll(dessus_droite.getVoisinNull());
            }
            if(dessous_droite!=null){
                tmpDeplacement.addAll(dessous_droite.getVoisinNull());
            }
            if(dessous!=null){
                tmpDeplacement.addAll(dessous.getVoisinNull());
            }
            if(dessous_gauche!=null){
                tmpDeplacement.addAll(dessous_gauche.getVoisinNull());
            }
            if(dessus_gauche!=null){
                tmpDeplacement.addAll(dessus_gauche.getVoisinNull());
            }
        }
        for(Point point : voisinLibre) {
            if(tmpDeplacement.contient(point)) {
                deplacementPossible.add(point);
            }
        }
        return deplacementPossible;
    }
}