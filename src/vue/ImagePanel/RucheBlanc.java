package vue.ImagePanel;

import model.Plateau;

import javax.swing.*;
import java.awt.*;

public class RucheBlanc extends JPanel {
    private Plateau plateau;
    private Image Background, Background_hover;

    public RucheBlanc(Plateau plateau) {
        super();
        ClassLoader cl = this.getClass().getClassLoader();
        this.plateau = plateau;
        Background = new ImageIcon(cl.getResource("image/inventaire/ruche_inventaire_blanc.jpg")).getImage();
        Background_hover = new ImageIcon(cl.getResource("image/inventaire/ruche_inventaire_blanc_hover.jpg")).getImage();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(plateau.getJoueurQuiJoue().couleur.equals("Blanc"))
            g.drawImage(Background_hover, 0, 0, getWidth(),getHeight(),this);
        else g.drawImage(Background, 0, 0, getWidth(),getHeight(),this);
    }
}