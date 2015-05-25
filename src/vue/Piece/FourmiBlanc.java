package vue.Piece;

import javax.swing.*;
import java.awt.*;

public class FourmiBlanc extends Jeton{
    public FourmiBlanc(){
        super();
        logo = new ImageIcon("image/Blanc/jeton_blanc_inventaire/jeton_blanc_fourmi.png").getImage();
    }

    public void paintComponent(Graphics g) {
        g.drawImage(logo,pos_x,pos_y,this.getWidth(), this.getHeight(),null);
    }
}
