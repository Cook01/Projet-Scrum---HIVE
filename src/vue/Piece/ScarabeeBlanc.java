package vue.Piece;

import javax.swing.*;
import java.awt.*;

public class ScarabeeBlanc extends Jeton{
    public ScarabeeBlanc(){
        super();
        logo = new ImageIcon("image/Blanc/jeton_blanc_inventaire/jeton_blanc_scarabee.png").getImage();
    }

    public void paintComponent(Graphics g) {
        g.drawImage(logo,pos_x,pos_y,taille_x,taille_y,null);
    }
}
