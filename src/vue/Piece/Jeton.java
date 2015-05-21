package vue.Piece;

import javax.swing.*;
import java.awt.*;

public abstract class Jeton extends JLabel{
    protected final int pos_x = 0, pos_y = 0, taille_x=65, taille_y=60;
    protected Image logo;

    public Jeton(){
        super();
        this.setPreferredSize(new Dimension(taille_x, taille_y));
    }
}
