package vue;

import javax.swing.*;
import java.awt.*;

public class Pastille extends JLabel {
    Image logo;
    public final int espace = 10;

    public Pastille(){
        super();
        logo = new ImageIcon("image/jeton_selection.png").getImage();
        this.setPreferredSize(new Dimension(40, 40+espace));
    }

    public void paintComponent(Graphics g) {
            g.drawImage(logo,0,espace,this.getWidth(), this.getHeight()-espace, null);
        }
}
