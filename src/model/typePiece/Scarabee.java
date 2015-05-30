package model.typePiece;

import model.ArrayListPoint;
import model.Joueur;
import model.Piece;
import model.Plateau;

import java.awt.*;

public class Scarabee extends Piece{

    private Piece ground;

    public Scarabee(Joueur joueur) {
        super(joueur, TypePieceEnum.Scarabee);
    }
    public void setPosition(Point point, Plateau p) {
        Piece a;
        a = p.getPiece(point);
        if(a != null) {
            this.ground = a;
            a.setSky(this);
        }
        else {
            if (this.ground !=null) {
                this.ground.setSky(null);
            }
            this.ground = null;
        }
        position = new Point(point);
    }

    public boolean peutSeDeplacer(){
        if (ground != null)
            return true;
        else
            return super.peutSeDeplacer();
    }

    public ArrayListPoint getDeplacementPossible() {
        ArrayListPoint deplacementPossible = new ArrayListPoint();
        ArrayListPoint tmpDeplacement = new ArrayListPoint();
        ArrayListPoint voisinLibre = getVoisinNull();
        if(peutSeDeplacer()) {
            if (dessus != null) {
                tmpDeplacement.addAll(dessus.getVoisinNull());
                deplacementPossible.add(dessus.getPosition());
            }
            if (dessus_droite != null) {
                tmpDeplacement.addAll(dessus_droite.getVoisinNull());
                deplacementPossible.add(dessus_droite.getPosition());
            }
            if (dessous_droite != null) {
                tmpDeplacement.addAll(dessous_droite.getVoisinNull());
                deplacementPossible.add(dessous_droite.getPosition());
            }
            if (dessous != null) {
                tmpDeplacement.addAll(dessous.getVoisinNull());
                deplacementPossible.add(dessous.getPosition());
            }
            if (dessous_gauche != null) {
                tmpDeplacement.addAll(dessous_gauche.getVoisinNull());
                deplacementPossible.add(dessous_gauche.getPosition());
            }
            if (dessus_gauche != null) {
                tmpDeplacement.addAll(dessus_gauche.getVoisinNull());
                deplacementPossible.add(dessus_gauche.getPosition());
            }
        }
        for(Point point : voisinLibre) {
            if(tmpDeplacement.contient(point)) {
                deplacementPossible.add(point);
            }
        }
        return deplacementPossible;
    }

    public Piece getGround() {
        return ground;
    }
}
