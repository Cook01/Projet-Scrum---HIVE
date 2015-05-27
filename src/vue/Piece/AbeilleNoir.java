package vue.Piece;

import javax.swing.*;
import java.awt.*;

public class AbeilleNoir extends Jeton{
    public AbeilleNoir(){
        super();
        logo = new ImageIcon("image/Noir/jeton_noir_inventaire/jeton_noir_abeille_x1.png").getImage();
        logoHover = new ImageIcon("image/Noir/jeton_noir_inventaire_hover/jeton_noir_abeille_hover_x1.png").getImage();
        logoCourant = logo;
    }

    public void paintComponent(Graphics g) {
        g.drawImage(logoCourant,pos_x,pos_y,null);
    }

    public void decremente() {
        logoCourant = logoVide;
    }
}
