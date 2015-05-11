package vue.ImagePanel;

import javax.swing.*;
import java.awt.*;

public class PlateauJeu extends JPanel{
    private Image Background;

    public PlateauJeu() {
        super();
        Background = new ImageIcon("image/plateau_jeu_hive2.jpg").getImage();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(Background, 0, 0, getWidth(),getHeight(),this);
    }
}