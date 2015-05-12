package vue.Piece;

import javax.swing.*;
import java.awt.*;

public class SauterelleNoir extends Jeton{
    public SauterelleNoir(){
        super();
        logo = new ImageIcon("image/Noir/jeton_sauterelle.png").getImage();
    }

    public void paintComponent(Graphics g) {
        g.drawImage(logo,pos_x,pos_y,taille_x,taille_y,null);
    }
}
