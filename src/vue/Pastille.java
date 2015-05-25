package vue;

import javax.swing.*;
import java.awt.*;

public class Pastille extends JLabel {
    Image logo;

    public Pastille(){
        super();
        logo = new ImageIcon("image/jeton_selection.png").getImage();
        this.setPreferredSize(new Dimension(50, 50));
    }

    public void paintComponent(Graphics g) {
            g.drawImage(logo,0,0,this.getWidth(), this.getHeight(), null);
        }
}
