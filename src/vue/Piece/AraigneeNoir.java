package vue.Piece;

import javax.swing.*;
import java.awt.*;

public class AraigneeNoir extends JLabel{
    private Image logo;

    public AraigneeNoir(){
        super();
        logo = new ImageIcon("image/Noir/jeton_araignee.png").getImage();
        this.setPreferredSize(new Dimension(70, 60));
    }

    public void paintComponent(Graphics g) {
        g.drawImage(logo,0,0,70,60,null);
    }
}
