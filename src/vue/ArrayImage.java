package vue;

import model.ArrayListPoint;
import model.Piece;
import model.Plateau;
import model.typePiece.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class ArrayImage {
    private Plateau plateau;
    private ArrayList<Image> images;
    private ArrayListPoint indicePlacementImage;


    public ArrayImage(Plateau plateau, boolean avecIndicateurPlacement, boolean avecIndicateurDeplacement){
        this.plateau = plateau;
        images = new ArrayList<Image>();
        indicePlacementImage = new ArrayListPoint();
        if(avecIndicateurPlacement) {
            if(plateau.getPiece_pose().size() != 0) {
                for(Piece piece : plateau.getPiece_pose()) {
                    images.add(associationImage(piece));
                    indicePlacementImage.add(piece.getPosition());
                }
                for(Point point : plateau.getPlacementPossible()) {
                    images.add(accessible());
                    indicePlacementImage.add(point);
                }
            } else {
                images.add(accessible());
                indicePlacementImage.add(new Point(0,0));
            }
        } else if (avecIndicateurDeplacement) {
            if(plateau.getPiece_pose().size() != 0) {
                for(Piece piece : plateau.getPiece_pose()) {
                    images.add(associationImage(piece));
                    indicePlacementImage.add(piece.getPosition());
                }
                if(plateau.getPieceSelectionne() != null && plateau.getPieceSelectionne().getDeplacementPossible()!=null) {
                    for (Point point : plateau.getPieceSelectionne().getDeplacementPossible()) {
                        images.add(accessible());
                        indicePlacementImage.add(point);
                    }
                }
            } else {
                images.add(accessible());
                indicePlacementImage.add(new Point(0,0));
            }
        } else {
            if(plateau.getPiece_pose().size() != 0) {
                for(Piece piece : plateau.getPiece_pose()) {
                    images.add(associationImage(piece));
                    indicePlacementImage.add(piece.getPosition());
                }
            }
        }
    }


    private Image accessible() {
        return new ImageIcon("image/jeton_selection.png").getImage();
    }


    private Image associationImage(Piece piece) {
        if(piece.getJoueur()==plateau.getJoueurBlanc()) {
            switch (piece.typePiece) {
                case Abeille:
                    return new ImageIcon("image/Blanc/jeton_abeille.png").getImage();
                case Araignee:
                    return new ImageIcon("image/Blanc/jeton_araignee.png").getImage();
                case Fourmi:
                    return new ImageIcon("image/Blanc/jeton_fourmi.png").getImage();
                case Sauterelle:
                    return new ImageIcon("image/Blanc/jeton_sauterelle.png").getImage();
                case Scarabee:
                    return new ImageIcon("image/Blanc/jeton_scarabee.png").getImage();
            }
        }else{
            if (piece instanceof Abeille)
                return new ImageIcon("image/Noir/jeton_abeille.png").getImage();
            else if (piece instanceof Araignee)
                return new ImageIcon("image/Noir/jeton_araignee.png").getImage();
            else if (piece instanceof Fourmi)
                return new ImageIcon("image/Noir/jeton_fourmi.png").getImage();
            else if (piece instanceof Sauterelle)
                return new ImageIcon("image/Noir/jeton_sauterelle.png").getImage();
            else if (piece instanceof Scarabee)
                return new ImageIcon("image/Noir/jeton_scarabee.png").getImage();
        }
        return null;
    }


    public ArrayList<Image> getImages() {
        return images;
    }


    public ArrayList<Point> getIndicePlacementImage() {
        return indicePlacementImage;
    }
}
