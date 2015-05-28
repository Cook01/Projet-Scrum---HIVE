package vue.Piece;

import javax.swing.*;
import java.awt.*;

public class FourmiNoir extends Jeton{
    private Image logo1, logoHover1, logo2, logoHover2;

    public FourmiNoir(){
        super();
        logo = new ImageIcon("image/Noir/jeton_noir_inventaire/jeton_noir_fourmi_x3.png").getImage();
        logoHover = new ImageIcon("image/Noir/jeton_noir_inventaire_hover/jeton_noir_fourmi_hover_x3.png").getImage();
        logo1 = new ImageIcon("image/Noir/jeton_noir_inventaire/jeton_noir_fourmi_x2.png").getImage();
        logoHover1 = new ImageIcon("image/Noir/jeton_noir_inventaire_hover/jeton_noir_fourmi_hover_x2.png").getImage();
        logo2 = new ImageIcon("image/Noir/jeton_noir_inventaire/jeton_noir_fourmi_x1.png").getImage();
        logoHover2 = new ImageIcon("image/Noir/jeton_noir_inventaire_hover/jeton_noir_fourmi_hover_x1.png").getImage();
        logoCourant = logo;
    }

    public void paintComponent(Graphics g) {
        g.drawImage(logoCourant,pos_x,pos_y,null);
    }

    public void selection() {
        super.selection();
        if(logoCourant==logo1)
            logoCourant = logoHover1;
        if(logoCourant==logo2)
            logoCourant = logoHover2;
    }


    public void deselection() {
        super.deselection();
        if(logoCourant==logoHover1)
            logoCourant = logo1;
        if(logoCourant==logoHover2)
            logoCourant = logo2;
    }

    public void decremente() {
        if(logoCourant==logoHover)
            logoCourant = logo1;
        if(logoCourant==logoHover1)
            logoCourant = logo2;
        if(logoCourant==logoHover2)
            logoCourant = logoVide;
    }
}
