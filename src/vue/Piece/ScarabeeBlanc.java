package vue.Piece;

import javax.swing.*;
import java.awt.*;

public class ScarabeeBlanc extends Jeton{
    private Image logo1, logoHover1;

    public ScarabeeBlanc(){
        super();
        logo = new ImageIcon("image/Blanc/jeton_blanc_inventaire/jeton_blanc_scarabee_x2.png").getImage();
        logoHover = new ImageIcon("image/Blanc/jeton_blanc_inventaire_hover/jeton_blanc_scarabee_hover_x2.png").getImage();
        logo1 = new ImageIcon("image/Blanc/jeton_blanc_inventaire/jeton_blanc_scarabee_x1.png").getImage();
        logoHover1 = new ImageIcon("image/Blanc/jeton_blanc_inventaire_hover/jeton_blanc_scarabee_hover_x1.png").getImage();
        logoCourant = logo;
    }

    public void paintComponent(Graphics g) {
        g.drawImage(logoCourant,pos_x,pos_y,null);
    }

    public void selection() {
        super.selection();
        if(logoCourant==logo1)
            logoCourant = logoHover1;
    }


    public void deselection() {
        super.deselection();
        if(logoCourant==logoHover1)
            logoCourant = logo1;
    }

    public void decremente() {
        if(logoCourant==logoHover)
            logoCourant = logo1;
        if(logoCourant==logoHover1)
            logoCourant = logoVide;
    }
}
