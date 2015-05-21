package vue;

import model.Plateau;
import vue.ImagePanel.PlateauJeu;

import java.awt.*;


public class Grille extends PlateauJeu {
    private ArrayImage imagePiece;
    public Point centre;

    public Grille(Fenetre fenetre){
        super(fenetre);
        setPreferredSize(new Dimension((int) (Fenetre.TAILLE_FENETRE_X * 0.86), Fenetre.TAILLE_FENETRE_Y));
        setOpaque(false);
        col = 25;
        row = 25;
        pas_x = (int)(80.6/1.3);
        pas_y = 68;
        bordure_x=10;
        bordure_y=3;
        centre = new Point(3, 3);
    }


    public void initiliser(Plateau plateau, boolean avecIndicateurPlacement, boolean avecIndicateurDeplacement) {
        imagePiece = new ArrayImage(plateau, avecIndicateurPlacement, avecIndicateurDeplacement);
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Image image;
        int x, y, posX, posY;

        for(int i = 0; i < imagePiece.getImages().size(); i++) {
            image = imagePiece.getImages().get(i);
            x = imagePiece.getIndicePlacementImage().get(i).x+centre.x;
            y = imagePiece.getIndicePlacementImage().get(i).y+centre.y;
            posX = (int)((pas_x+2.1) * x + bordure_x) + position.x;

            if(x%2==0)
                posY = (int)((pas_y+4.8) * y + bordure_y + position.y);
            else if (centre.x%2==0)
                posY = (int)((pas_y+4.8) * y + bordure_y - pas_y /2 + position.y);
            else posY = (int)((pas_y+4.8) * y + bordure_y + pas_y /2 + position.y);

            g.drawImage(image, posX, posY, 80, pas_y, this);
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
