package vue.Piece;

import javax.swing.*;
import java.awt.*;

public class AbeilleBlanc extends Jeton{
    public AbeilleBlanc(){
        super();
        logo = new ImageIcon("image/Blanc/jeton_blanc_inventaire/jeton_blanc_abeille_x1.png").getImage();
        logoHover = new ImageIcon("image/Blanc/jeton_blanc_inventaire_hover/jeton_blanc_abeille_hover_x1.png").getImage();
        logoCourant = logo;
    }

    public void paintComponent(Graphics g) {
        g.drawImage(logoCourant,pos_x,pos_y,null);
    }

    public void decremente() {
        logoCourant = logoVide;
    }
}
