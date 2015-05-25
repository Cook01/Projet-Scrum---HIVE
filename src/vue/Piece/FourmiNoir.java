package vue.Piece;

import javax.swing.*;
import java.awt.*;

public class FourmiNoir extends Jeton{
    public FourmiNoir(){
        super();
        logo = new ImageIcon("image/Noir/jeton_noir_inventaire/jeton_noir_fourmi.png").getImage();
    }

    public void paintComponent(Graphics g) {
        g.drawImage(logo,pos_x,pos_y,this.getWidth(), this.getHeight(),null);
    }
}
