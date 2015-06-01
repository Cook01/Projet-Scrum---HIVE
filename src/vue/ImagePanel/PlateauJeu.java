package vue.ImagePanel;

import vue.Fenetre;

import javax.swing.*;
import java.awt.*;

public class PlateauJeu extends JPanel{
    private Image Background;
    public final ImageIcon backIcon;
    public Point position;
    private Fenetre fenetre;
    public int pas_x, pas_y, row, col, bordure_x, bordure_y;

    public PlateauJeu( Fenetre fenetre) {
        super();
        ClassLoader cl = this.getClass().getClassLoader();
        this.fenetre = fenetre;
        backIcon = new ImageIcon(cl.getResource("image/plateau_v4.jpg"));
        Background = backIcon.getImage();
        position = new Point(0,0);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(Background, position.x, position.y, this);
    }

    public void deplaceHaut() {
        if(position.y+10<= 0)
            position.y += 10;
    }

    public void deplaceBas() {
        if(position.y-10>= -backIcon.getIconHeight()+fenetre.getGrille().getHeight())
            position.y -= 10;

    }

    public void deplaceGauche() {
        if(position.x+10<= 0)
            position.x += 10;
    }

    public void deplaceDroite() {
        if(position.x-10>= -backIcon.getIconWidth()+fenetre.getGrille().getWidth())
            position.x -= 10;
    }
}