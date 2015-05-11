package model;

import model.typePiece.*;
import java.util.ArrayList;

public class Joueur {
    private final String couleur;
    private ArrayList<Piece> ensemblePieceDisponible;

    public Joueur(String string) {
        int i;
        couleur = string;
        ensemblePieceDisponible = new ArrayList<Piece>();
        ensemblePieceDisponible.add(new Abeille(this));
        for(i=0; i<2; i++)
            ensemblePieceDisponible.add(new Araignee(this));
        for(i=0; i<3; i++)
            ensemblePieceDisponible.add(new Fourmi(this));
        for(i=0; i<2; i++)
            ensemblePieceDisponible.add(new Scarabee(this));
        for(i=0; i<3; i++)
            ensemblePieceDisponible.add(new Sauterelle(this));
    }

    public int nbAbeilleDisponible() {
        int count = 0;
        for(Piece piece : ensemblePieceDisponible)
            if(piece instanceof Abeille)
                count++;
        return count;
    }

    public int nbAraigneeDisponible() {
        int count = 0;
        for(Piece piece : ensemblePieceDisponible)
            if(piece instanceof Araignee)
                count++;
        return count;
    }

    public int nbFourmiDisponible() {
        int count = 0;
        for(Piece piece : ensemblePieceDisponible)
            if(piece instanceof Fourmi)
                count++;
        return count;
    }

    public int nbSauterelleDisponible() {
        int count = 0;
        for(Piece piece : ensemblePieceDisponible)
            if(piece instanceof Sauterelle)
                count++;
        return count;
    }

    public int nbScarabeeDisponible() {
        int count = 0;
        for(Piece piece : ensemblePieceDisponible)
            if(piece instanceof Scarabee)
                count++;
        return count;
    }

    public Piece getAbeille() {
        Piece selection = null;
        for(Piece piece : ensemblePieceDisponible)
            if(piece instanceof Abeille)
                selection = piece;
        ensemblePieceDisponible.remove(selection);
        return selection;
    }

    public Piece getAraignee() {
        Piece selection = null;
        for(Piece piece : ensemblePieceDisponible)
            if(piece instanceof Araignee)
                selection = piece;
        ensemblePieceDisponible.remove(selection);
        return selection;
    }

    public Piece getFourmi() {
        Piece selection = null;
        for(Piece piece : ensemblePieceDisponible)
            if(piece instanceof Fourmi)
                selection = piece;
        ensemblePieceDisponible.remove(selection);
        return selection;
    }

    public Piece getSauterelle() {
        Piece selection = null;
        for(Piece piece : ensemblePieceDisponible)
            if(piece instanceof Sauterelle)
                selection = piece;
        ensemblePieceDisponible.remove(selection);
        return selection;
    }

    public Piece getScarabe() {
        Piece selection = null;
        for(Piece piece : ensemblePieceDisponible)
            if(piece instanceof Scarabee)
                selection = piece;
        ensemblePieceDisponible.remove(selection);
        return selection;
    }

    public ArrayList<Piece> getEnsemblePieceDisponible() {
        return ensemblePieceDisponible;
    }

    public String getCouleur() {
        return couleur;
    }
}