package model.typePiece;

import model.ArrayListPoint;
import model.Joueur;
import model.Piece;

import java.awt.*;

public class Sauterelle extends Piece{
    public Sauterelle(Joueur joueur) {
        super(joueur, TypePieceEnum.Sauterelle);
    }

    public ArrayListPoint getDeplacementPossible() {
        ArrayListPoint deplacementPossible = new ArrayListPoint();
        ArrayListPoint tmpDeplacement = new ArrayListPoint();
        ArrayListPoint voisinLibre = getVoisinNull(); //renvoi cases libres autour de pièce
        if(peutSeDeplacer()) {
            Piece temp;
            if(dessus != null){
                temp = dessus;
                while(temp != null){
                    temp = dessus.getDessus();
                }
                //deplacementPossible.add();
            }

            if(dessus_droite != null){
                temp = dessus_droite;
                while(temp != null){
                    temp = dessus_droite.getDessus_droite();
                }
                //deplacementPossible.add();
            }

            if(dessus_gauche != null){
                temp = dessus_gauche;
                while(temp != null){
                    temp = dessus_gauche.getDessus_gauche();
                }
                //deplacementPossible.add();
            }

            if(dessous != null){
                temp = dessous;
                while(dessous != null){
                    temp = dessous.getDessous();
                }
                //deplacementPossible.add();
            }

            if(dessous_gauche != null){
                temp = dessous_gauche;
                while(dessous_gauche != null){
                    temp = dessous_gauche.getDessous_gauche();
                }
                //deplacementPossible.add();
            }

            if(dessous_droite != null){
                temp = dessous_droite;
                while(dessous_droite != null){
                    temp = dessous_droite.getDessous_droite();
                }
                //deplacementPossible.add();
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
