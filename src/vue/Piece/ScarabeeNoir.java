package vue.Piece;

import javax.swing.*;
import java.awt.*;

public class ScarabeeNoir extends JLabel{
    private Image logo;

    public ScarabeeNoir(){
        super();
        logo = new ImageIcon("image/Noir/jeton_scarabee.png").getImage();
        this.setPreferredSize(new Dimension(70, 60));
    }

    public void paintComponent(Graphics g) {
        g.drawImage(logo,0,0,70,60,null);
    }
}
