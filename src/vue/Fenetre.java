package vue;

import model.Jeu;
import javax.swing.*;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame {
    Jeu jeu;
    JButton boutonJouer;
    final static int TAILLE_FENETRE_X = 800;
    final static int TAILLE_FENETRE_Y = 500;

    public Fenetre(Jeu jeu) {
        this.jeu = jeu;

        initialiseEcranAccueil();

        setSize(TAILLE_FENETRE_X, TAILLE_FENETRE_Y);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        affichageEcranAccueil();
    }

    private void initialiseEcranAccueil() {
        boutonJouer = new JButton("Démarrer");
    }

    private void affichageEcranAccueil() {
        JPanel panelAccueil = new ImagePanel();
        JPanel conteneurBoutonJouer = new JPanel();

        panelAccueil.setLayout(new BoxLayout(panelAccueil, BoxLayout.Y_AXIS));
        conteneurBoutonJouer.setLayout(new BoxLayout(conteneurBoutonJouer, BoxLayout.X_AXIS));
        conteneurBoutonJouer.setOpaque(true);

        panelAccueil.add(Box.createVerticalStrut((int)(TAILLE_FENETRE_Y*0.8)));
        conteneurBoutonJouer.add(boutonJouer);
        panelAccueil.add(conteneurBoutonJouer);

        setContentPane(panelAccueil);
    }

    public void setControlBoutonJouer(ActionListener al) {
        boutonJouer.addActionListener(al);
    }
}
