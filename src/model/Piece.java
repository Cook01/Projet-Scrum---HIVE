package model;

import model.typePiece.TypePieceEnum;

import java.awt.*;
import java.util.ArrayList;

public abstract class Piece {
    public final TypePieceEnum typePiece;
    protected Point position;
    protected Piece dessus, dessus_droite, dessous_droite, dessous, dessous_gauche, dessus_gauche, sky;
    protected Joueur joueur;


    public Piece getSky() {
        return sky;
    }

    public void setSky(Piece sky) {
        this.sky = sky;
    }

    public Piece(Joueur joueur, TypePieceEnum typePiece){

        dessus = dessus_droite = dessous_droite = dessous = dessous_gauche = dessus_gauche = sky = null;
        this.joueur = joueur;
        this.typePiece = typePiece;
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
            }
        }
        if(dessus_gauche==null) {
            if(position.x%2==0) {
                voisinNull.add(new Point(position.x - 1, position.y + 1));
            } else {
                voisinNull.add(new Point(position.x - 1, position.y));
            }
        }
        return voisinNull;
    }

    public Point getVoisin(String string) {
        if(string != null) {
            if (string.equals("dessus")) {
                return new Point(position.x, position.y + 1);
            }
            if (string.equals("dessus_droite")) {
                if (position.x % 2 == 0) {
                    return new Point(position.x + 1, position.y + 1);
                } else {
                    return new Point(position.x + 1, position.y);
                }
            }
            if (string.equals("dessous_droite")) {
                if (position.x % 2 == 0) {
                    return new Point(position.x + 1, position.y);
                } else {
                    return new Point(position.x + 1, position.y - 1);
                }
            }
            if (string.equals("dessous")) {
                return new Point(position.x, position.y - 1);
            }
            if (string.equals("dessous_gauche")) {
                if (position.x % 2 == 0) {
                    return new Point(position.x - 1, position.y);
                } else {
                    return new Point(position.x - 1, position.y - 1);
                }
            }
            if (string.equals("dessus_gauche")) {
                if (position.x % 2 == 0) {
                    return new Point(position.x - 1, position.y + 1);
                } else {
                    return new Point(position.x - 1, position.y);
                }
            }
        }

        return null;
    }

    public void setVoisin(Point point, Piece piece) {
        if(point.x == position.x ) {
            if(point.y == position.y + 1) {
                if (dessus == null) dessus = piece;
            }else if(dessous==null)dessous = piece;
        }else if (point.x == position.x + 1) {
            if(position.x%2==0) {
                if(point.y == position.y + 1) {
                    if (dessus_droite == null) dessus_droite = piece;
                } else if(dessous_droite==null) dessous_droite = piece;
            } else {
                if(point.y == position.y) {
                    if (dessus_droite == null) dessus_droite = piece;
                } else if(dessous_droite==null)dessous_droite = piece;
            }
        } else {
            if(position.x%2==0) {
                if(point.y == position.y + 1) {
                    if (dessus_gauche == null) dessus_gauche = piece;
                } else if(dessous_gauche==null) dessous_gauche = piece;
            } else {
                if(point.y == position.y) {
                    if (dessus_gauche == null) dessus_gauche = piece;
                } else if(dessous_gauche==null) dessous_gauche = piece;
            }
        }
    }

    public void retireVoisin(Piece piece) {
        if(dessus == piece) dessus = null;
        else if(dessus_droite == piece) dessus_droite = null;
        else if(dessous_droite == piece) dessous_droite = null;
        else if(dessous == piece) dessous = null;
        else if(dessous_gauche == piece) dessous_gauche = null;
        else if(dessus_gauche == piece) dessus_gauche = null;
        else if(sky == piece) sky = null;
    }

    public void nettoyerVoisin() {
        dessus = dessus_droite = dessous_droite = dessous = dessous_gauche = dessus_gauche = null;
    }

    public boolean peutSeDeplacer(){
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

    protected ArrayList<Piece> getBords(ArrayList<Piece> pieceBord, ArrayList<Piece> pieceDejaCheck){

        if(getVoisinNull().size() >= 1){
            pieceBord.add(this);
        }

        pieceDejaCheck.add(this);

        if(dessus != null && pieceDejaCheck.indexOf(dessus) == -1){
            pieceBord = dessus.getBords(pieceBord, pieceDejaCheck);
        }

        if(dessus_droite != null && pieceDejaCheck.indexOf(dessus_droite) == -1){
            pieceBord = dessus_droite.getBords(pieceBord, pieceDejaCheck);
        }

        if(dessous_droite != null && pieceDejaCheck.indexOf(dessous_droite) == -1){
            pieceBord = dessous_droite.getBords(pieceBord, pieceDejaCheck);
        }

        if(dessous != null && pieceDejaCheck.indexOf(dessous) == -1){
            pieceBord = dessous.getBords(pieceBord, pieceDejaCheck);
        }

        if(dessous_gauche != null && pieceDejaCheck.indexOf(dessous_gauche) == -1){
            pieceBord = dessous_gauche.getBords(pieceBord, pieceDejaCheck);
        }

        if(dessus_gauche != null && pieceDejaCheck.indexOf(dessus_gauche) == -1){
            pieceBord = dessus_gauche.getBords(pieceBord, pieceDejaCheck);
        }

        return pieceBord;
    }

    public abstract ArrayListPoint getDeplacementPossible();

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
}
