package vue;

import model.Plateau;

import javax.swing.*;
import java.awt.*;

public class Grille extends JPanel{
    private ArrayImage imagePiece;
    private int pas_x, pas_y, row, col;
    private Plateau plateau;

    public Grille(){
        super();
        setPreferredSize(new Dimension((int) (Fenetre.TAILLE_FENETRE_X * 0.86), Fenetre.TAILLE_FENETRE_Y));
        setOpaque(false);
    }

    public void initiliser(Plateau plateau, boolean avecIndicateurPlacement, boolean avecIndicateurDeplacement) {
        this.plateau = plateau;
        imagePiece = new ArrayImage(plateau, avecIndicateurPlacement, avecIndicateurDeplacement);
        col = plateau.getPositionPieceXMax()-plateau.getPositionPieceXMin()+3;
        row = plateau.getPositionPieceYMax()-plateau.getPositionPieceYMin()+3;
        pas_x = (int)(this.getWidth()*0.8) / col;
        pas_y = (int)(this.getHeight()*0.7) / row;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Image image;
        int x, y, posX, posY;
        for(int i = 0; i < imagePiece.getImages().size(); i++) {
            image = imagePiece.getImages().get(i);
            x = imagePiece.getIndicePlacementImage().get(i).x-plateau.getPositionPieceXMin()+1;
            y = imagePiece.getIndicePlacementImage().get(i).y-plateau.getPositionPieceYMin()+1;
            posX = pas_x * x + (int)(this.getWidth()*0.1);
            if(imagePiece.getIndicePlacementImage().get(i).x%2==0)
                posY = pas_y * y + (int)(this.getHeight()*0.15);
            else posY = pas_y * y + (int)(this.getHeight()*0.15) - pas_y /2;
            g.drawImage(image, posX, posY, (int)(pas_x*1.3), pas_y, this);
        }
    }

    public ArrayImage getImagePiece() {
        return imagePiece;
    }

    public int getPas_x() {
        return pas_x;
    }

    public int getPas_y() {
        return pas_y;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
