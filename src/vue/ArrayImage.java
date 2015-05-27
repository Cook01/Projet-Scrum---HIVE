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
        Image image;
        if(piece.getJoueur()==plateau.getJoueurBlanc()) {
            switch (piece.typePiece) {
                case Abeille:
                    if(plateau.getPieceSelectionne() == piece)
                        image = new ImageIcon("image/Blanc/jeton_blanc_hover/jeton_blanc_abeille_hover.png").getImage();
                    else image = new ImageIcon("image/Blanc/jeton_blanc/jeton_blanc_abeille.png").getImage();
                    return image;
                case Araignee:
                    if(plateau.getPieceSelectionne() == piece)
                        image = new ImageIcon("image/Blanc/jeton_blanc_hover/jeton_blanc_araignee_hover.png").getImage();
                    else image = new ImageIcon("image/Blanc/jeton_blanc/jeton_blanc_araignee.png").getImage();
                    return image;
                case Fourmi:
                    if(plateau.getPieceSelectionne() == piece)
                        image = new ImageIcon("image/Blanc/jeton_blanc_hover/jeton_blanc_fourmi_hover.png").getImage();
                    else image = new ImageIcon("image/Blanc/jeton_blanc/jeton_blanc_fourmi.png").getImage();
                    return image;
                case Sauterelle:
                    if(plateau.getPieceSelectionne() == piece)
                        image = new ImageIcon("image/Blanc/jeton_blanc_hover/jeton_blanc_sauterelle_hover.png").getImage();
                    else image = new ImageIcon("image/Blanc/jeton_blanc/jeton_blanc_sauterelle.png").getImage();
                    return image;
                case Scarabee:
                    if(plateau.getPieceSelectionne() == piece)
                        image = new ImageIcon("image/Blanc/jeton_blanc_hover/jeton_blanc_scarabee_hover.png").getImage();
                    else image = new ImageIcon("image/Blanc/jeton_blanc/jeton_blanc_scarabee.png").getImage();
                    return image;
            }
        }else {
            switch (piece.typePiece) {
                case Abeille:
                    if(plateau.getPieceSelectionne() == piece)
                        image = new ImageIcon("image/Noir/jeton_noir_hover/jeton_noir_abeille_hover.png").getImage();
                    else image = new ImageIcon("image/Noir/jeton_noir/jeton_noir_abeille.png").getImage();
                    return image;
                case Araignee:
                    if(plateau.getPieceSelectionne() == piece)
                        image = new ImageIcon("image/Noir/jeton_noir_hover/jeton_noir_araignee_hover.png").getImage();
                    else image = new ImageIcon("image/Noir/jeton_noir/jeton_noir_araignee.png").getImage();
                    return image;
                case Fourmi:
                    if(plateau.getPieceSelectionne() == piece)
                        image = new ImageIcon("image/Noir/jeton_noir_hover/jeton_noir_fourmi_hover.png").getImage();
                    else image = new ImageIcon("image/Noir/jeton_noir/jeton_noir_fourmi.png").getImage();
                    return image;
                case Sauterelle:
                    if(plateau.getPieceSelectionne() == piece)
                        image = new ImageIcon("image/Noir/jeton_noir_hover/jeton_noir_sauterelle_hover.png").getImage();
                    else image = new ImageIcon("image/Noir/jeton_noir/jeton_noir_sauterelle.png").getImage();
                    return image;
                case Scarabee:
                    if(plateau.getPieceSelectionne() == piece)
                        image = new ImageIcon("image/Noir/jeton_noir_hover/jeton_noir_scarabee_hover.png").getImage();
                    else image = new ImageIcon("image/Noir/jeton_noir/jeton_noir_scarabee.png").getImage();
                    return image;
            }
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
