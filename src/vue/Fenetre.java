package vue;

import model.Joueur;
import model.Plateau;
import vue.ImagePanel.EcranAccueil;
import vue.ImagePanel.PlateauJeu;
import vue.Piece.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;


public class Fenetre extends JFrame {
    public final static int TAILLE_FENETRE_X = 960;
    public final static int TAILLE_FENETRE_Y = 600;
    private Plateau plateau;
    private JButton boutonJouer;
    private JPanel jpAbeilleBlanc, jpAraigneeBlanc, jpFourmiBlanc, jpSauterelleBlanc, jpScarabeeBlanc;
    private JPanel jpAbeilleNoir, jpAraigneeNoir, jpFourmiNoir, jpSauterelleNoir, jpScarabeeNoir;
    private JPanel jpDefaut;
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

        jpDefaut = new JPanel();

        grille = new Grille();
    }


    private JPanel caseInventaireNom(Joueur joueur) {
        JPanel jpInventaire = new JPanel();
        JPanel caseNomInventaire = new JPanel();

        caseNomInventaire.setLayout(new BorderLayout());
        if(joueur==plateau.getJoueurBlanc())
            jpInventaire.add(new JLabel("Inventaire Blanc"));
        else jpInventaire.add(new JLabel("Inventaire Noir"));
        caseNomInventaire.add(Box.createVerticalStrut((int)(caseNomInventaire.getHeight()*0.4)), BorderLayout.SOUTH);
        caseNomInventaire.add(jpInventaire, BorderLayout.CENTER);

        return jpInventaire;
    }


    private JPanel caseInventaire(EnumJeton jeton){
        JPanel indicateurPiece = new JPanel();
        JPanel typePiece;
        JPanel globInventaire = new JPanel();
        JPanel caseInventaire = new JPanel();

        globInventaire.setLayout(new BoxLayout(globInventaire, BoxLayout.Y_AXIS));
        caseInventaire.setLayout(new BorderLayout());
        switch(jeton){
            case AbeilleBlanc:
                typePiece = jpAbeilleBlanc;
                indicateurPiece.add(new JLabel("x " + plateau.getJoueurBlanc().nbAbeilleDisponible()));
                break;
            case AbeilleNoir:
                typePiece = jpAbeilleNoir;
                indicateurPiece.add(new JLabel("x " + plateau.getJoueurNoir().nbAbeilleDisponible()));
                break;
            case AraigneeBlanc:
                typePiece = jpAraigneeBlanc;
                indicateurPiece.add(new JLabel("x " + plateau.getJoueurBlanc().nbAraigneeDisponible()));
                break;
            case AraigneeNoir:
                typePiece = jpAraigneeNoir;
                indicateurPiece.add(new JLabel("x " + plateau.getJoueurNoir().nbAraigneeDisponible()));
                break;
            case FourmiBlanc:
                typePiece = jpFourmiBlanc;
                indicateurPiece.add(new JLabel("x " + plateau.getJoueurBlanc().nbFourmiDisponible()));
                break;
            case FourmiNoir:
                typePiece = jpFourmiNoir;
                indicateurPiece.add(new JLabel("x " + plateau.getJoueurNoir().nbFourmiDisponible()));
                break;
            case SauterelleBlanc:
                typePiece = jpSauterelleBlanc;
                indicateurPiece.add(new JLabel("x " + plateau.getJoueurBlanc().nbSauterelleDisponible()));
                break;
            case SauterelleNoir:
                typePiece = jpSauterelleNoir;
                indicateurPiece.add(new JLabel("x " + plateau.getJoueurNoir().nbSauterelleDisponible()));
                break;
            case ScarabeeBlanc:
                typePiece = jpScarabeeBlanc;
                indicateurPiece.add(new JLabel("x " + plateau.getJoueurBlanc().nbScarabeeDisponible()));
                break;
            case ScarabeeNoir:
                typePiece = jpScarabeeNoir;
                indicateurPiece.add(new JLabel("x " + plateau.getJoueurNoir().nbScarabeeDisponible()));
                break;
            default:
                typePiece = jpDefaut;
                indicateurPiece.add(new JLabel("Problème du Jeton"));
        }
        globInventaire.add(typePiece);
        globInventaire.add(indicateurPiece);
        caseInventaire.add(globInventaire, BorderLayout.CENTER);

        return caseInventaire;
    }


    private JPanel affichageInventaireJoueurBlanc(){
        JPanel inventaire = new JPanel();

        inventaire.setLayout(new GridLayout(6, 1));
        inventaire.setPreferredSize(new Dimension((int) (TAILLE_FENETRE_X * 0.18), TAILLE_FENETRE_Y));

        inventaire.add(caseInventaireNom(plateau.getJoueurBlanc()));
        inventaire.add(caseInventaire(EnumJeton.AbeilleBlanc));
        inventaire.add(caseInventaire(EnumJeton.AraigneeBlanc));
        inventaire.add(caseInventaire(EnumJeton.FourmiBlanc));
        inventaire.add(caseInventaire(EnumJeton.SauterelleBlanc));
        inventaire.add(caseInventaire(EnumJeton.ScarabeeBlanc));

        return inventaire;
    }


    private JPanel affichageInventaireJoueurNoir(){
        JPanel inventaire = new JPanel();

        inventaire.setLayout(new GridLayout(6, 1));
        inventaire.setPreferredSize(new Dimension((int) (TAILLE_FENETRE_X * 0.18), TAILLE_FENETRE_Y));

        inventaire.add(caseInventaireNom(plateau.getJoueurNoir()));
        inventaire.add(caseInventaire(EnumJeton.AbeilleNoir));
        inventaire.add(caseInventaire(EnumJeton.AraigneeNoir));
        inventaire.add(caseInventaire(EnumJeton.FourmiNoir));
        inventaire.add(caseInventaire(EnumJeton.SauterelleNoir));
        inventaire.add(caseInventaire(EnumJeton.ScarabeeNoir));

        return inventaire;
    }


    public void affichagePlateau(boolean avecIndicateurPlacement, boolean avecIndicateurDeplacement) {
        JPanel panelPlateau = new PlateauJeu();
        JPanel inventaireBlanc = affichageInventaireJoueurBlanc();
        JPanel inventaireNoir = affichageInventaireJoueurNoir();

        panelPlateau.setLayout(new BorderLayout());

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
