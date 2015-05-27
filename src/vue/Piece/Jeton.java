package vue.Piece;

import javax.swing.*;
import java.awt.*;

public abstract class Jeton extends JLabel{
    protected final int pos_x = 0, pos_y = 0, taille_x=100, taille_y=60;
    protected Image logo, logoHover;
    protected Image logoCourant, logoVide;

    public Jeton(){
        super();
        logoVide = null;
        this.setPreferredSize(new Dimension(taille_x, taille_y));
    }

    public void selection() {
        if(logoCourant==logo)
            logoCourant = logoHover;
    }

    public void deselection() {
        if(logoCourant==logoHover)
            logoCourant = logo;
    }

    public abstract void decremente();
}
