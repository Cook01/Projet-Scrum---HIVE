package vue.ImagePanel;

import javax.swing.*;
import java.awt.*;

public class EcranAccueil extends JPanel {
    private Image Background;

    public EcranAccueil() {
        super();
        Background = new ImageIcon("image/honneymoon_proto_800x600.jpg").getImage();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(Background, 0, 0, getWidth(),getHeight(),this);
    }
}
