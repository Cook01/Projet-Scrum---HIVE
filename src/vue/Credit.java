package vue;

import vue.ImagePanel.EcranAccueil;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Credit extends JFrame{
    public final static int TAILLE_FENETRE_X = 800;
    public final static int TAILLE_FENETRE_Y = 600;
    private JButton boutonCacher;

    public Credit() {
        initCredit();

        affichageCredit();

        setSize(TAILLE_FENETRE_X, TAILLE_FENETRE_Y);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Credit");
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    private void initCredit() {
        boutonCacher = new JButton("Fermer");
    }

    private void affichageCredit() {
        JPanel jGlobal = new EcranAccueil();
        JPanel conteneurBoutonJouer = new JPanel();

        jGlobal.setLayout(new BoxLayout(jGlobal, BoxLayout.Y_AXIS));
        conteneurBoutonJouer.setOpaque(false);

        jGlobal.add(Box.createVerticalStrut((int) (TAILLE_FENETRE_Y * 0.8)));
        conteneurBoutonJouer.add(boutonCacher);
        jGlobal.add(conteneurBoutonJouer);

        setContentPane(jGlobal);
    }

    public void setControlBoutonCacher(ActionListener al) {
        boutonCacher.addActionListener(al);
    }

}
