package vue.Piece;

import javax.swing.*;
import java.awt.*;

public class SauterelleNoir extends JLabel{
    private Image logo;

    public SauterelleNoir(){
        super();
        logo = new ImageIcon("image/Noir/jeton_sauterelle.png").getImage();
        this.setPreferredSize(new Dimension(70, 60));
    }

    public void paintComponent(Graphics g) {
        g.drawImage(logo,0,0,70,60,null);
    }
}
