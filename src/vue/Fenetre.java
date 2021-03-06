package vue;

import model.Plateau;
import vue.ImagePanel.EcranAccueil;
import vue.ImagePanel.RucheBlanc;
import vue.ImagePanel.RucheNoir;
import vue.Piece.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;


public class Fenetre extends JFrame {
    public final static int TAILLE_FENETRE_X = 800;
    public final static int TAILLE_FENETRE_Y = 600;
    private Plateau plateau;
    private JButton boutonMenu, boutonJouer, bouton1, bouton2, bouton3, boutonCredit;
    private JPanel jpAbeilleBlanc, jpAraigneeBlanc, jpFourmiBlanc, jpSauterelleBlanc, jpScarabeeBlanc;
    private JPanel jpAbeilleNoir, jpAraigneeNoir, jpFourmiNoir, jpSauterelleNoir, jpScarabeeNoir;
    private JPanel jpDefaut;
    public JMenuItem jMenuItem, jMenuCredit;
    private Grille grille;


    public Fenetre(Plateau plateau) {
        this.plateau = plateau;

        initialiseEcranAccueil();
        initialiseEcranMenu();
        initialisePlateau();
        initMenu();

        setSize(TAILLE_FENETRE_X, TAILLE_FENETRE_Y);
        setTitle("Honey moon");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        affichageEcranAccueil();
    }


    private void initialiseEcranMenu() {
        boutonJouer = new JButton("Démarrer");
        bouton1 = new JButton("Bouton 1");
        bouton2 = new JButton("Bouton 2");
        bouton3 = new JButton("Bouton 3");
        boutonCredit = new JButton("Credit");
    }


    private void initialiseEcranAccueil() {
        boutonMenu = new JButton("Jouer !");
    }


    private void affichageEcranAccueil() {
        JPanel panelAccueil = new EcranAccueil();
        JPanel conteneurBoutonJouer = new JPanel();
        JPanel conteneurBoutonCredit = new JPanel();

        panelAccueil.setLayout(new BoxLayout(panelAccueil, BoxLayout.Y_AXIS));
        conteneurBoutonJouer.setOpaque(false);
        conteneurBoutonCredit.setOpaque(false);
        conteneurBoutonJouer.add(boutonMenu);
        conteneurBoutonCredit.add(boutonCredit);

        panelAccueil.add(Box.createVerticalStrut((int)(TAILLE_FENETRE_Y*0.68)));
        panelAccueil.add(conteneurBoutonJouer);
        panelAccueil.add(conteneurBoutonCredit);

        setContentPane(panelAccueil);
    }


    public void affichageEcranMenu() {
        JPanel panelAccueil = new EcranAccueil();
        JPanel conteneurBoutonJouer = new JPanel();
        JPanel conteneurBouton1 = new JPanel();
        JPanel conteneurBouton2 = new JPanel();
        JPanel conteneurBouton3 = new JPanel();

        panelAccueil.setLayout(new BoxLayout(panelAccueil, BoxLayout.Y_AXIS));
        conteneurBoutonJouer.setOpaque(false);
        conteneurBouton1.setOpaque(false);
        conteneurBouton2.setOpaque(false);
        conteneurBouton3.setOpaque(false);

        panelAccueil.add(Box.createVerticalStrut((int)(TAILLE_FENETRE_Y*0.6)));
        conteneurBoutonJouer.add(boutonJouer);
        panelAccueil.add(conteneurBoutonJouer);
        panelAccueil.add(Box.createVerticalStrut((int)(TAILLE_FENETRE_Y*0.02)));
        conteneurBouton1.add(bouton1);
        panelAccueil.add(conteneurBouton1);
        panelAccueil.add(Box.createVerticalStrut((int)(TAILLE_FENETRE_Y*0.02)));
        conteneurBouton2.add(bouton2);
        panelAccueil.add(conteneurBouton2);
        panelAccueil.add(Box.createVerticalStrut((int)(TAILLE_FENETRE_Y*0.02)));
        conteneurBouton3.add(bouton3);
        panelAccueil.add(conteneurBouton3);

        setContentPane(panelAccueil);
    }


    public void setControlBoutonJouer(ActionListener al) {
        boutonJouer.addActionListener(al);
    }

    public void setControlBoutonMenu(ActionListener al) {
        boutonMenu.addActionListener(al);
    }

    public void setControlBouton1(ActionListener al) {
        bouton1.addActionListener(al);
    }

    public void setControlBouton2(ActionListener al) {
        bouton2.addActionListener(al);
    }

    public void setControlBouton3(ActionListener al) {
        bouton3.addActionListener(al);
    }

    public void setControlBoutonCredit(ActionListener al) {
        boutonCredit.addActionListener(al);
    }

    public void initMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        jMenuItem = new JMenuItem("Nouvelle Partie");
        jMenuCredit = new JMenuItem("Credit");
        menu.add(jMenuItem);
        menu.add(jMenuCredit);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    public void setControlMenu(ActionListener cMenu) {
        jMenuItem.addActionListener(cMenu);
        jMenuCredit.addActionListener(cMenu);
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

        jpDefaut = new JPanel();
        jpDefaut.setOpaque(false);

        grille = new Grille(this);
        grille.setFocusable(true);
    }


    private JPanel caseInventaire(EnumJeton jeton){
        JPanel indicateurPiece = new JPanel();
        JPanel typePiece;
        JPanel globInventaire = new JPanel();
        JPanel caseInventaire = new JPanel();

        indicateurPiece.setOpaque(false);
        globInventaire.setOpaque(false);
        caseInventaire.setOpaque(false);

        globInventaire.setLayout(new BoxLayout(globInventaire, BoxLayout.Y_AXIS));
        caseInventaire.setLayout(new BorderLayout());
        switch(jeton){
            case AbeilleBlanc:
                typePiece = jpAbeilleBlanc;
                break;
            case AbeilleNoir:
                typePiece = jpAbeilleNoir;
                break;
            case AraigneeBlanc:
                typePiece = jpAraigneeBlanc;
                break;
            case AraigneeNoir:
                typePiece = jpAraigneeNoir;
                break;
            case FourmiBlanc:
                typePiece = jpFourmiBlanc;
                break;
            case FourmiNoir:
                typePiece = jpFourmiNoir;
                break;
            case SauterelleBlanc:
                typePiece = jpSauterelleBlanc;
                break;
            case SauterelleNoir:
                typePiece = jpSauterelleNoir;
                break;
            case ScarabeeBlanc:
                typePiece = jpScarabeeBlanc;
                break;
            case ScarabeeNoir:
                typePiece = jpScarabeeNoir;
                break;
            default:
                typePiece = jpDefaut;
                indicateurPiece.add(new JLabel("Problème du Jeton"));
        }

        typePiece.setOpaque(false);

        globInventaire.add(typePiece);
        caseInventaire.add(globInventaire, BorderLayout.CENTER);

        return caseInventaire;
    }


    private JPanel affichageInventaireJoueurBlanc(){
        JPanel globalInventaire = new RucheBlanc(plateau);
        globalInventaire.setLayout(new BoxLayout(globalInventaire, BoxLayout.Y_AXIS));

        JPanel inventaire = new JPanel();
        inventaire.setOpaque(false);

        inventaire.setLayout(new GridLayout(5, 1));
        inventaire.setPreferredSize(new Dimension((int) (TAILLE_FENETRE_X * 0.17), (int)(TAILLE_FENETRE_Y-TAILLE_FENETRE_Y*0.1)));

        inventaire.add(caseInventaire(EnumJeton.AbeilleBlanc));
        inventaire.add(caseInventaire(EnumJeton.AraigneeBlanc));
        inventaire.add(caseInventaire(EnumJeton.FourmiBlanc));
        inventaire.add(caseInventaire(EnumJeton.SauterelleBlanc));
        inventaire.add(caseInventaire(EnumJeton.ScarabeeBlanc));

        globalInventaire.add(Box.createVerticalStrut(80));
        globalInventaire.add(inventaire);

        return globalInventaire;
    }


    private JPanel affichageInventaireJoueurNoir(){
        JPanel globalInventaire = new RucheNoir(plateau);
        globalInventaire.setLayout(new BoxLayout(globalInventaire, BoxLayout.Y_AXIS));

        JPanel inventaire = new JPanel();
        inventaire.setOpaque(false);

        inventaire.setLayout(new GridLayout(5, 1));
        inventaire.setPreferredSize(new Dimension((int) (TAILLE_FENETRE_X * 0.17), TAILLE_FENETRE_Y));

        inventaire.add(caseInventaire(EnumJeton.AbeilleNoir));
        inventaire.add(caseInventaire(EnumJeton.AraigneeNoir));
        inventaire.add(caseInventaire(EnumJeton.FourmiNoir));
        inventaire.add(caseInventaire(EnumJeton.SauterelleNoir));
        inventaire.add(caseInventaire(EnumJeton.ScarabeeNoir));

        globalInventaire.add(Box.createVerticalStrut(80));
        globalInventaire.add(inventaire);

        return globalInventaire;
    }


    public void affichagePlateau(boolean avecIndicateurPlacement, boolean avecIndicateurDeplacement) {
        JPanel panelPlateau = new JPanel();
        JPanel inventaireBlanc = affichageInventaireJoueurBlanc();
        JPanel inventaireNoir = affichageInventaireJoueurNoir();

        panelPlateau.setLayout(new BorderLayout());

        grille.initiliser(plateau, avecIndicateurPlacement, avecIndicateurDeplacement);

        panelPlateau.add(inventaireBlanc, BorderLayout.WEST);
        panelPlateau.add(grille, BorderLayout.CENTER);
        panelPlateau.add(inventaireNoir, BorderLayout.EAST);

        setContentPane(panelPlateau);
        grille.requestFocusInWindow();
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


    public void setControlGrille(MouseListener ml, KeyListener kl) {
        grille.addMouseListener(ml);
        grille.addKeyListener(kl);
    }

    public void deselection() {
        Jeton jeton;
        jeton = (Jeton)(jpAbeilleBlanc.getComponent(0));
        jeton.deselection();
        jeton = (Jeton)(jpAraigneeBlanc.getComponent(0));
        jeton.deselection();
        jeton = (Jeton)(jpSauterelleBlanc.getComponent(0));
        jeton.deselection();
        jeton = (Jeton)(jpScarabeeBlanc.getComponent(0));
        jeton.deselection();
        jeton = (Jeton)(jpFourmiBlanc.getComponent(0));
        jeton.deselection();
        jeton = (Jeton)(jpAbeilleNoir.getComponent(0));
        jeton.deselection();
        jeton = (Jeton)(jpAraigneeNoir.getComponent(0));
        jeton.deselection();
        jeton = (Jeton)(jpSauterelleNoir.getComponent(0));
        jeton.deselection();
        jeton = (Jeton)(jpScarabeeNoir.getComponent(0));
        jeton.deselection();
        jeton = (Jeton)(jpFourmiNoir.getComponent(0));
        jeton.deselection();
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

    public void reinitialiser() {
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

        jpAbeilleBlanc.removeAll();
        jpAbeilleBlanc.add(abeilleBlanc);
        jpAraigneeBlanc.removeAll();
        jpAraigneeBlanc.add(araigneeBlanc);
        jpFourmiBlanc.removeAll();
        jpFourmiBlanc.add(fourmiBlanc);
        jpSauterelleBlanc.removeAll();
        jpSauterelleBlanc.add(sauterelleBlanc);
        jpScarabeeBlanc.removeAll();
        jpScarabeeBlanc.add(scarabeeBlanc);

        jpAbeilleNoir.removeAll();
        jpAbeilleNoir.add(abeilleNoir);
        jpAraigneeNoir.removeAll();
        jpAraigneeNoir.add(araigneeNoir);
        jpFourmiNoir.removeAll();
        jpFourmiNoir.add(fourmiNoir);
        jpSauterelleNoir.removeAll();
        jpSauterelleNoir.add(sauterelleNoir);
        jpScarabeeNoir.removeAll();
        jpScarabeeNoir.add(scarabeeNoir);

        grille.centre = new Point(3,3);
    }
}
