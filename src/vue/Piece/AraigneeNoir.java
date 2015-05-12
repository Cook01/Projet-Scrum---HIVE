package vue.Piece;

import javax.swing.*;
import java.awt.*;

public class AraigneeNoir extends Jeton{
    public AraigneeNoir(){
        super();
        logo = new ImageIcon("image/Noir/jeton_araignee.png").getImage();
    }

    public void paintComponent(Graphics g) {
        g.drawImage(logo,pos_x,pos_y,taille_x,taille_y,null);
    }
}
