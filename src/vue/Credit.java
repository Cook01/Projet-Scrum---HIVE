package vue;

import vue.ImagePanel.EcranCredit;

import javax.swing.*;
import java.awt.*;
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
        JPanel jGlobal = new EcranCredit();
        JPanel conteneurBoutonJouer = new JPanel();
        JPanel conteneurBoutonCredit = new JPanel();
        JPanel conteneurEspace = new JPanel();

        jGlobal.setLayout(new BorderLayout());
        conteneurBoutonCredit.setLayout(new BoxLayout(conteneurBoutonCredit, BoxLayout.X_AXIS));
        conteneurBoutonCredit.setOpaque(false);
        conteneurEspace.setOpaque(false);
        conteneurBoutonJouer.setOpaque(false);

        conteneurEspace.add(Box.createVerticalStrut((int) (TAILLE_FENETRE_Y * 0.8)));
        jGlobal.add(conteneurEspace, BorderLayout.NORTH);
        conteneurBoutonCredit.add(Box.createHorizontalStrut((int) (TAILLE_FENETRE_X * 0.25)));
        conteneurBoutonJouer.add(boutonCacher);
        conteneurBoutonCredit.add(conteneurBoutonJouer);
        jGlobal.add(conteneurBoutonCredit, BorderLayout.WEST);

        setContentPane(jGlobal);
    }

    public void setControlBoutonCacher(ActionListener al) {
        boutonCacher.addActionListener(al);
    }

}
