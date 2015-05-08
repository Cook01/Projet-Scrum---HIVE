package model;

import java.awt.*;

public abstract class Piece {
    protected Point position;
    protected Piece dessus, dessus_droite, dessous_droite, dessous, dessous_gauche, dessus_gauche;
    protected Joueur joueur;

    public Piece(Joueur joueur){
        dessus = dessus_droite = dessous_droite = dessous = dessous_gauche = dessus_gauche = null;
        this.joueur = joueur;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point point) {
        position = new Point(point);
    }

    public ArrayListPoint getVoisinNull() {
        ArrayListPoint voisinNull = new ArrayListPoint();
        if(dessus==null) {
            voisinNull.add(new Point(position.x, position.y + 1));
        }
        if(dessus_droite==null) {
            if(position.x%2==0) {
                voisinNull.add(new Point(position.x + 1, position.y + 1));
            } else {
                voisinNull.add(new Point(position.x + 1, position.y));
            }
        }
        if(dessous_droite==null) {
            if(position.x%2==0) {
                voisinNull.add(new Point(position.x + 1, position.y));
            } else {
                voisinNull.add(new Point(position.x + 1, position.y - 1));
            }
        }
        if(dessous==null) {
            voisinNull.add(new Point(position.x, position.y - 1));
        }
        if(dessous_gauche==null) {
            if(position.x%2==0) {
                voisinNull.add(new Point(position.x - 1, position.y));
            } else {
                voisinNull.add(new Point(position.x - 1, position.y - 1));
            }        }
        if(dessus_gauche==null) {
            if(position.x%2==0) {
                voisinNull.add(new Point(position.x - 1, position.y + 1));
            } else {
                voisinNull.add(new Point(position.x - 1, position.y));
            }
        }
        return voisinNull;
    }

    public void setVoisin(Point point, Piece piece) {
        if(point.x == position.x ) {
            if(point.y == position.y + 1) dessus = piece;
            else dessous = piece;
        }else if (point.x == position.x + 1) {
            if(position.x%2==0) {
                if(point.y == position.y + 1) dessus_droite = piece;
                else dessous_droite = piece;
            } else {
                if(point.y == position.y) dessus_droite = piece;
                else dessous_droite = piece;
            }
        } else {
            if(position.x%2==0) {
                if(point.y == position.y + 1) dessus_gauche = piece;
                else dessous_gauche = piece;
            } else {
                if(point.y == position.y) dessus_gauche = piece;
                else dessous_gauche = piece;
            }
        }
    }

    public abstract ArrayListPoint getDeplacementPossible();

    protected boolean peutSeDeplacer(){
        ArrayListPoint pointLibre = getVoisinNull();
        if(pointLibre.size()==0) return false;
        if(pointLibre.size()==1) return false;
        if(pointLibre.size()==2) {
            if (dessus != null && dessus_droite != null && dessous_droite != null && dessous != null) return true;
            if (dessus_droite != null && dessous_droite != null && dessous != null && dessous_gauche != null) return true;
            if (dessous_droite != null && dessous != null && dessous_gauche != null && dessus_gauche != null) return true;
            if (dessous != null && dessous_gauche != null && dessus_gauche != null && dessus != null) return true;
            if (dessous_gauche != null && dessus_gauche != null && dessus != null && dessus_droite != null) return true;
            if (dessus_gauche != null && dessus != null && dessus_droite != null && dessous_droite != null) return true;
            return false;
        }
        if (pointLibre.size()==3) {
            if (dessus != null && dessus_droite != null && dessous_droite != null) return true;
            if (dessus_droite != null && dessous_droite != null && dessous != null) return true;
            if (dessous_droite != null && dessous != null && dessous_gauche != null) return true;
            if (dessous != null && dessous_gauche != null && dessus_gauche != null) return true;
            if (dessous_gauche != null && dessus_gauche != null && dessus != null) return true;
            if (dessus_gauche != null && dessus != null && dessus_droite != null) return true;
            return false;
        }
        if(pointLibre.size()==4) {
            if (dessus != null && dessus_droite != null) return true;
            if (dessus_droite != null && dessous_droite != null) return true;
            if (dessous_droite != null && dessous != null) return true;
            if (dessous != null && dessous_gauche != null) return true;
            if (dessous_gauche != null && dessus_gauche != null) return true;
            if (dessus_gauche != null && dessus != null) return true;
            return false;
        }
        return pointLibre.size() == 5;
    }

    public Piece getDessus() {
        return dessus;
    }

    public Piece getDessus_droite() {
        return dessus_droite;
    }

    public Piece getDessous() {
        return dessous;
    }

    public Piece getDessous_droite() {
        return dessous_droite;
    }

    public Piece getDessous_gauche() {
        return dessous_gauche;
    }

    public Piece getDessus_gauche() {
        return dessus_gauche;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void retireVoisin(Piece piece) {
        if(dessus == piece) dessus = null;
        else if(dessus_droite == piece) dessus_droite = null;
        else if(dessous_droite == piece) dessous_droite = null;
        else if(dessous == piece) dessous = null;
        else if(dessous_gauche == piece) dessous_gauche = null;
        else if(dessus_gauche == piece) dessus_gauche = null;
    }

    public void nettoyerVoisin() {
        dessus = dessus_droite = dessous_droite = dessous = dessous_gauche = dessus_gauche = null;
    }
}