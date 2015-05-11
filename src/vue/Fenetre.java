package vue;

import model.Plateau;
import vue.ImagePanel.EcranAccueil;
import vue.ImagePanel.PlateauJeu;
import vue.Piece.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class Fenetre extends JFrame {
    private Plateau plateau;
    private JButton boutonJouer;
    public final static int TAILLE_FENETRE_X = 960;
    public final static int TAILLE_FENETRE_Y = 600;
    private JPanel jpAbeilleBlanc, jpAraigneeBlanc, jpFourmiBlanc, jpSauterelleBlanc, jpScarabeeBlanc;
    private JPanel jpAbeilleNoir, jpAraigneeNoir, jpFourmiNoir, jpSauterelleNoir, jpScarabeeNoir;
    private Grille grille;


    public Fenetre(Plateau plateau) {
        this.plateau = plateau;

        initialiseEcranAccueil();
        initialisePlateau();

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
        JPanel panelAccueil = new EcranAccueil();
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

    public void initialisePlateau(){
        JLabel abeilleBlanc = new AbeilleBlanc();
        JLabel araigneeBlanc = new AraigneeBlanc();
        JLabel fourmiBlanc = new FourmiBlanc();
        JLabel sauterelleBlanc = new SauterelleBlanc();
        JLabel scarabeeBlanc = new ScarabeeBlanc();
        JLabel abeilleNoir = new AbeilleNoir();
        JLabel araigneeNoir = new AraigneeNoir();
        JLabel fourmiNoir = new FourmiNoir();
        JLabel sauterelleNoir = new SauterelleNoir();
        JLabel scarabeeNoir = new ScarabeeNoir();

        jpAbeilleBlanc = new JPanel();
        jpAbeilleBlanc.add(abeilleBlanc);
        jpAraigneeBlanc = new JPanel();
        jpAraigneeBlanc.add(araigneeBlanc);
        jpFourmiBlanc = new JPanel();
        jpFourmiBlanc.add(fourmiBlanc);
        jpSauterelleBlanc = new JPanel();
        jpSauterelleBlanc.add(sauterelleBlanc);
        jpScarabeeBlanc = new JPanel();
        jpScarabeeBlanc.add(scarabeeBlanc);

        jpAbeilleNoir = new JPanel();
        jpAbeilleNoir.add(abeilleNoir);
        jpAraigneeNoir = new JPanel();
        jpAraigneeNoir.add(araigneeNoir);
        jpFourmiNoir = new JPanel();
        jpFourmiNoir.add(fourmiNoir);
        jpSauterelleNoir = new JPanel();
        jpSauterelleNoir.add(sauterelleNoir);
        jpScarabeeNoir = new JPanel();
        jpScarabeeNoir.add(scarabeeNoir);

        grille = new Grille();
    }

    public void affichagePlateau(boolean avecIndicateurPlacement, boolean avecIndicateurDeplacement) {
        JPanel panelPlateau = new PlateauJeu();
        JPanel inventaireBlanc = new JPanel();
        JPanel inventaireNoir = new JPanel();

        panelPlateau.setLayout(new BorderLayout());

        inventaireBlanc.setLayout(new GridLayout(6, 1));
        inventaireBlanc.setPreferredSize(new Dimension((int) (TAILLE_FENETRE_X * 0.18), TAILLE_FENETRE_Y));
        JPanel jpInventaireBlanc = new JPanel();
        jpInventaireBlanc.add(new JLabel("Inventaire Blanc"));
        JPanel case1Blanc = new JPanel();
        case1Blanc.setLayout(new BorderLayout());
        case1Blanc.add(jpInventaireBlanc, BorderLayout.CENTER);
        JPanel indicateurAbeilleBlanc = new JPanel();
        indicateurAbeilleBlanc.add(new JLabel("x " + plateau.getJoueurBlanc().nbAbeilleDisponible()));
        JPanel globAbeilleBlanc = new JPanel();
        globAbeilleBlanc.setLayout(new BoxLayout(globAbeilleBlanc, BoxLayout.Y_AXIS));
        globAbeilleBlanc.add(jpAbeilleBlanc);
        globAbeilleBlanc.add(indicateurAbeilleBlanc);
        JPanel case2Blanc = new JPanel();
        case2Blanc.setLayout(new BorderLayout());
        case2Blanc.add(globAbeilleBlanc, BorderLayout.CENTER);
        JPanel indicateurAraigneeBlanc = new JPanel();
        indicateurAraigneeBlanc.add(new JLabel("x " + plateau.getJoueurBlanc().nbAraigneeDisponible()));
        JPanel globAraigneeBlanc = new JPanel();
        globAraigneeBlanc.setLayout(new BoxLayout(globAraigneeBlanc, BoxLayout.Y_AXIS));
        globAraigneeBlanc.add(jpAraigneeBlanc);
        globAraigneeBlanc.add(indicateurAraigneeBlanc);
        JPanel case3Blanc = new JPanel();
        case3Blanc.setLayout(new BorderLayout());
        case3Blanc.add(globAraigneeBlanc, BorderLayout.CENTER);
        JPanel indicateurFourmiBlanc = new JPanel();
        indicateurFourmiBlanc.add(new JLabel("x " + plateau.getJoueurBlanc().nbFourmiDisponible()));
        JPanel globFourmiBlanc = new JPanel();
        globFourmiBlanc.setLayout(new BoxLayout(globFourmiBlanc, BoxLayout.Y_AXIS));
        globFourmiBlanc.add(jpFourmiBlanc);
        globFourmiBlanc.add(indicateurFourmiBlanc);
        JPanel case4Blanc = new JPanel();
        case4Blanc.setLayout(new BorderLayout());
        case4Blanc.add(globFourmiBlanc, BorderLayout.CENTER);
        JPanel indicateurSauterelleBlanc = new JPanel();
        indicateurSauterelleBlanc.add(new JLabel("x " + plateau.getJoueurBlanc().nbSauterelleDisponible()));
        JPanel globSauterelleBlanc = new JPanel();
        globSauterelleBlanc.setLayout(new BoxLayout(globSauterelleBlanc, BoxLayout.Y_AXIS));
        globSauterelleBlanc.add(jpSauterelleBlanc);
        globSauterelleBlanc.add(indicateurSauterelleBlanc);
        JPanel case5Blanc = new JPanel();
        case5Blanc.setLayout(new BorderLayout());
        case5Blanc.add(globSauterelleBlanc, BorderLayout.CENTER);
        JPanel indicateurScarabeeBlanc = new JPanel();
        indicateurScarabeeBlanc.add(new JLabel("x " + plateau.getJoueurBlanc().nbScarabeeDisponible()));
        JPanel globScarabeeBlanc = new JPanel();
        globScarabeeBlanc.setLayout(new BoxLayout(globScarabeeBlanc, BoxLayout.Y_AXIS));
        globScarabeeBlanc.add(jpScarabeeBlanc);
        globScarabeeBlanc.add(indicateurScarabeeBlanc);
        JPanel case6Blanc = new JPanel();
        case6Blanc.setLayout(new BorderLayout());
        case6Blanc.add(globScarabeeBlanc, BorderLayout.CENTER);
        inventaireBlanc.add(case1Blanc);
        inventaireBlanc.add(case2Blanc);
        inventaireBlanc.add(case3Blanc);
        inventaireBlanc.add(case4Blanc);
        inventaireBlanc.add(case5Blanc);
        inventaireBlanc.add(case6Blanc);

        inventaireNoir.setLayout(new GridLayout(6, 1));
        inventaireNoir.setPreferredSize(new Dimension((int) (TAILLE_FENETRE_X * 0.18), TAILLE_FENETRE_Y));
        JPanel jpInventaireNoir = new JPanel();
        jpInventaireNoir.add(new JLabel("Inventaire Noir"));
        JPanel case1Noir = new JPanel();
        case1Noir.setLayout(new BorderLayout());
        case1Noir.add(jpInventaireNoir, BorderLayout.CENTER);
        JPanel indicateurAbeilleNoir = new JPanel();
        indicateurAbeilleNoir.add(new JLabel("x " + plateau.getJoueurNoir().nbAbeilleDisponible()));
        JPanel globAbeilleNoir = new JPanel();
        globAbeilleNoir.setLayout(new BoxLayout(globAbeilleNoir, BoxLayout.Y_AXIS));
        globAbeilleNoir.add(jpAbeilleNoir);
        globAbeilleNoir.add(indicateurAbeilleNoir);
        JPanel case2Noir = new JPanel();
        case2Noir.setLayout(new BorderLayout());
        case2Noir.add(globAbeilleNoir, BorderLayout.CENTER);
        JPanel indicateurAraigneeNoir = new JPanel();
        indicateurAraigneeNoir.add(new JLabel("x " + plateau.getJoueurNoir().nbAraigneeDisponible()));
        JPanel globAraigneeNoir = new JPanel();
        globAraigneeNoir.setLayout(new BoxLayout(globAraigneeNoir, BoxLayout.Y_AXIS));
        globAraigneeNoir.add(jpAraigneeNoir);
        globAraigneeNoir.add(indicateurAraigneeNoir);
        JPanel case3Noir = new JPanel();
        case3Noir.setLayout(new BorderLayout());
        case3Noir.add(globAraigneeNoir, BorderLayout.CENTER);
        JPanel indicateurFourmiNoir = new JPanel();
        indicateurFourmiNoir.add(new JLabel("x " + plateau.getJoueurNoir().nbFourmiDisponible()));
        JPanel globFourmiNoir = new JPanel();
        globFourmiNoir.setLayout(new BoxLayout(globFourmiNoir, BoxLayout.Y_AXIS));
        globFourmiNoir.add(jpFourmiNoir);
        globFourmiNoir.add(indicateurFourmiNoir);
        JPanel case4Noir = new JPanel();
        case4Noir.setLayout(new BorderLayout());
        case4Noir.add(globFourmiNoir, BorderLayout.CENTER);
        JPanel indicateurSauterelleNoir = new JPanel();
        indicateurSauterelleNoir.add(new JLabel("x " + plateau.getJoueurNoir().nbSauterelleDisponible()));
        JPanel globSauterelleNoir = new JPanel();
        globSauterelleNoir.setLayout(new BoxLayout(globSauterelleNoir, BoxLayout.Y_AXIS));
        globSauterelleNoir.add(jpSauterelleNoir);
        globSauterelleNoir.add(indicateurSauterelleNoir);
        JPanel case5Noir = new JPanel();
        case5Noir.setLayout(new BorderLayout());
        case5Noir.add(globSauterelleNoir, BorderLayout.CENTER);
        JPanel indicateurScarabeeNoir = new JPanel();
        indicateurScarabeeNoir.add(new JLabel("x " + plateau.getJoueurNoir().nbScarabeeDisponible()));
        JPanel globScarabeeNoir = new JPanel();
        globScarabeeNoir.setLayout(new BoxLayout(globScarabeeNoir, BoxLayout.Y_AXIS));
        globScarabeeNoir.add(jpScarabeeNoir);
        globScarabeeNoir.add(indicateurScarabeeNoir);
        JPanel case6Noir = new JPanel();
        case6Noir.setLayout(new BorderLayout());
        case6Noir.add(globScarabeeNoir, BorderLayout.CENTER);
        inventaireNoir.add(case1Noir);
        inventaireNoir.add(case2Noir);
        inventaireNoir.add(case3Noir);
        inventaireNoir.add(case4Noir);
        inventaireNoir.add(case5Noir);
        inventaireNoir.add(case6Noir);

        grille.initiliser(plateau, avecIndicateurPlacement, avecIndicateurDeplacement);

        panelPlateau.add(inventaireBlanc, BorderLayout.WEST);
        panelPlateau.add(grille, BorderLayout.CENTER);
        panelPlateau.add(inventaireNoir, BorderLayout.EAST);

        setContentPane(panelPlateau);
    }

    public void setControlInventaire(MouseListener ml) {
        jpAbeilleBlanc.addMouseListener(ml);
        jpAraigneeBlanc.addMouseListener(ml);
        jpFourmiBlanc.addMouseListener(ml);
        jpSauterelleBlanc.addMouseListener(ml);
        jpScarabeeBlanc.addMouseListener(ml);

        jpAbeilleNoir.addMouseListener(ml);
        jpAraigneeNoir.addMouseListener(ml);
        jpFourmiNoir.addMouseListener(ml);
        jpSauterelleNoir.addMouseListener(ml);
        jpScarabeeNoir.addMouseListener(ml);
    }

    public void setControlGrille(MouseListener ml) {
        grille.addMouseListener(ml);
    }

    public JPanel getJpAbeilleBlanc() {
        return jpAbeilleBlanc;
    }

    public JPanel getJpAraigneeBlanc() {
        return jpAraigneeBlanc;
    }

    public JPanel getJpFourmiBlanc() {
        return jpFourmiBlanc;
    }

    public JPanel getJpSauterelleBlanc() {
        return jpSauterelleBlanc;
    }

    public JPanel getJpScarabeeBlanc() {
        return jpScarabeeBlanc;
    }

    public JPanel getJpAbeilleNoir() {
        return jpAbeilleNoir;
    }

    public JPanel getJpAraigneeNoir() {
        return jpAraigneeNoir;
    }

    public JPanel getJpFourmiNoir() {
        return jpFourmiNoir;
    }

    public JPanel getJpSauterelleNoir() {
        return jpSauterelleNoir;
    }

    public JPanel getJpScarabeeNoir() {
        return jpScarabeeNoir;
    }

    public Grille getGrille() {
        return grille;
    }
}
