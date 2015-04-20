package vue;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    private Image Background;

    public ImagePanel() {
        super();
        Background = new ImageIcon("image/plateau_jeu_hive2.jpg").getImage();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(Background, 0, 0, getWidth(),getHeight(),this);
    }
}
