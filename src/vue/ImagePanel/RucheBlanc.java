package vue.ImagePanel;

import javax.swing.*;
import java.awt.*;

public class RucheBlanc extends JPanel {
    private Image Background;

    public RucheBlanc() {
        super();
        Background = new ImageIcon("image/ruche_inventaire_blanc.jpg").getImage();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(Background, 0, 0, getWidth(),getHeight(),this);
    }
}