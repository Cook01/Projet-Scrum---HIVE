package model.typePiece;

import model.ArrayListPoint;
import model.Joueur;
import model.Piece;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

public class Sauterelle extends Piece{
    public Sauterelle(Joueur joueur) {
        super(joueur, TypePieceEnum.Sauterelle);
    }

    public ArrayListPoint getDeplacementPossible() {
        ArrayListPoint deplacementPossible = new ArrayListPoint();

        if(peutSeDeplacer()) {
            Piece temp;

            temp = dessus;
            if(temp != null){
                while(temp.getDessus() != null){
                    temp = temp.getDessus();
                }
                deplacementPossible.add(temp.getVoisin("dessus"));
            }

            temp = dessus_droite;
            if(temp != null){
                while(temp.getDessus_droite() != null){
                    temp = temp.getDessus_droite();
                }
                deplacementPossible.add(temp.getVoisin("dessus"));
            }

            temp = dessous_droite;
            if(temp != null){
                while(temp.getDessous_droite() != null){
                    temp = temp.getDessous_droite();
                }
                deplacementPossible.add(temp.getVoisin("dessus"));
            }

            temp = dessous;
            if(temp != null){
                while(temp.getDessous() != null){
                    temp = temp.getDessous();
                }
                deplacementPossible.add(temp.getVoisin("dessus"));
            }

            temp = dessous_gauche;
            if(temp != null){
                while(temp.getDessous_gauche() != null){
                    temp = temp.getDessous_gauche();
                }
                deplacementPossible.add(temp.getVoisin("dessus"));
            }

            temp = dessus_gauche;
            if(temp != null){
                while(temp.getDessus_gauche() != null){
                    temp = temp.getDessus_gauche();
                }
                deplacementPossible.add(temp.getVoisin("dessus"));
            }
        }

        return deplacementPossible;
    }
}
