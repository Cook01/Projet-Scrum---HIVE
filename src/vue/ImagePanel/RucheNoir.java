package vue.ImagePanel;

import model.Plateau;

import javax.swing.*;
import java.awt.*;

public class RucheNoir extends JPanel {
    private Plateau plateau;
    private Image Background, Background_hover;

    public RucheNoir(Plateau plateau) {
        super();
        this.plateau = plateau;
        Background = new ImageIcon("image/inventaire/ruche_inventaire_noir.jpg").getImage();
        Background_hover = new ImageIcon("image/inventaire/ruche_inventaire_noir_hover.jpg").getImage();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(plateau.getJoueurQuiJoue().couleur.equals("Noir"))
            g.drawImage(Background_hover, 0, 0, getWidth(),getHeight(),this);
        else g.drawImage(Background, 0, 0, getWidth(),getHeight(),this);

    }
}