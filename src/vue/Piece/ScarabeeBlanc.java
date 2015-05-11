package vue.Piece;

import javax.swing.*;
import java.awt.*;

public class ScarabeeBlanc extends JLabel{
    private Image logo;

    public ScarabeeBlanc(){
        super();
        logo = new ImageIcon("image/Blanc/jeton_scarabee.png").getImage();
        this.setPreferredSize(new Dimension(70, 60));
    }

    public void paintComponent(Graphics g) {
        g.drawImage(logo,0,0,70,60,null);
    }
}
