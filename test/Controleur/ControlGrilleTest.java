package Controleur;

import controleur.ControlGrille;
import model.Joueur;
import model.Plateau;
import model.typePiece.Abeille;
import model.typePiece.Fourmi;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import vue.Fenetre;

import java.awt.*;
import java.awt.event.MouseEvent;

public class ControlGrilleTest {
    @Test
    public void grille_clic_gauche_deselection() {
        Plateau plateau = new Plateau();
        plateau.setPieceSelectionne(new Abeille(plateau.getJoueurBlanc()));
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getButton()).thenReturn(MouseEvent.BUTTON3);
        ControlGrille controlGrille = new ControlGrille(plateau, new Fenetre(plateau));
        controlGrille.mouseClicked(mouseEvent);
        Assert.assertNull(plateau.getPieceSelectionne());
    }

    @Test
    public void selection_grille_vide() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        fenetre.affichagePlateau(false, false);
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getButton()).thenReturn(MouseEvent.BUTTON1);
        ControlGrille controlGrille = new ControlGrille(plateau, fenetre);
        controlGrille.mouseClicked(mouseEvent);
        Assert.assertNull(plateau.getPieceSelectionne());
    }

    @Test
    public void selection_grille_x_inexistant() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        plateau.jouer(new Abeille(plateau.getJoueurBlanc()), new Point(0,0));
        fenetre.affichagePlateau(false, false);
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getButton()).thenReturn(MouseEvent.BUTTON1);
        for(int i=0; i<fenetre.getGrille().getCol(); i++)
            Mockito.when(mouseEvent.getX()).thenReturn(1);
        ControlGrille controlGrille = new ControlGrille(plateau, fenetre);
        controlGrille.mouseClicked(mouseEvent);
        Assert.assertNull(plateau.getPieceSelectionne());
    }

    @Test
    public void selection_grille_y_inexistant() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        plateau.placer(new Abeille(plateau.getJoueurBlanc()), new Point(0,0));
        fenetre.affichagePlateau(false, false);
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getButton()).thenReturn(MouseEvent.BUTTON1);
        for(int i=0; i<3; i++)
            Mockito.when(mouseEvent.getX()).thenReturn((int)((fenetre.getGrille().pas_x+1.5) * 3 + fenetre.getGrille().bordure_x + fenetre.getGrille().pas_x*1.3 / 4) + 1);
        for(int i=0; i<3; i++)
            Mockito.when(mouseEvent.getY()).thenReturn(1);
        ControlGrille controlGrille = new ControlGrille(plateau, fenetre);
        controlGrille.mouseClicked(mouseEvent);
        Assert.assertNull(plateau.getPieceSelectionne());
    }

    @Test
    public void selection_grille_y_existant_pair() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        plateau.placer(new Abeille(plateau.getJoueurBlanc()), new Point(0, 0));
        fenetre.affichagePlateau(false, false);
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getButton()).thenReturn(MouseEvent.BUTTON1);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getX()).thenReturn(239);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getY()).thenReturn(289);
        ControlGrille controlGrille = new ControlGrille(plateau, fenetre);
        controlGrille.mouseClicked(mouseEvent);
        Assert.assertTrue(plateau.getPieceSelectionne() instanceof Abeille
                && plateau.getPieceSelectionne().getJoueur() == plateau.getJoueurBlanc());
    }

    @Test
    public void selection_grille_y_existant_impair_centre_pair() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        fenetre.getGrille().centre.x = 4;
        plateau.placer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, 0));
        plateau.placer(new Abeille(plateau.getJoueurBlanc()), new Point(1, 0));
        fenetre.affichagePlateau(false, false);
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getButton()).thenReturn(MouseEvent.BUTTON1);
        for(int i=0; i<6; i++)
            Mockito.when(mouseEvent.getX()).thenReturn(360);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getY()).thenReturn(217);
        ControlGrille controlGrille = new ControlGrille(plateau, fenetre);
        controlGrille.mouseClicked(mouseEvent);
        Assert.assertTrue(plateau.getPieceSelectionne() instanceof Abeille
                && plateau.getPieceSelectionne().getJoueur() == plateau.getJoueurBlanc());
    }

    @Test
    public void selection_grille_y_existant_impair_centre_impair() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        plateau.placer(new Abeille(plateau.getJoueurBlanc()), new Point(0, 0));
        plateau.placer(new Fourmi(plateau.getJoueurBlanc()), new Point(1, 0));
        fenetre.affichagePlateau(false, false);
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getButton()).thenReturn(MouseEvent.BUTTON1);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getX()).thenReturn(302);
        for(int i=0; i<5; i++)
            Mockito.when(mouseEvent.getY()).thenReturn(255);
        ControlGrille controlGrille = new ControlGrille(plateau, fenetre);
        controlGrille.mouseClicked(mouseEvent);
        Assert.assertTrue(plateau.getPieceSelectionne() instanceof Fourmi
                && plateau.getPieceSelectionne().getJoueur() == plateau.getJoueurBlanc());
    }

    @Test
    public void selection_piece_inexistante() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        plateau.setPieceSelectionne(new Abeille(plateau.getJoueurBlanc()));
        fenetre.affichagePlateau(true, false);
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getButton()).thenReturn(MouseEvent.BUTTON1);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getX()).thenReturn(302);
        for(int i=0; i<5; i++)
            Mockito.when(mouseEvent.getY()).thenReturn(255);
        ControlGrille controlGrille = new ControlGrille(plateau, fenetre);
        controlGrille.mouseClicked(mouseEvent);
        Assert.assertTrue(plateau.getPieceSelectionne() instanceof Abeille
                && plateau.getPieceSelectionne().getJoueur() == plateau.getJoueurBlanc());
        Assert.assertTrue(plateau.getPiece_pose().size()==0);
    }

    @Test
    public void selection_piece_deplacement_sur_elle_meme() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        Abeille abeille = new Abeille(plateau.getJoueurBlanc());
        plateau.jouer(abeille, new Point(0, 0));
        plateau.jouer(new Abeille(plateau.getJoueurNoir()), new Point(0, 1));
        plateau.setPieceSelectionne(abeille);
        fenetre.affichagePlateau(false, true);
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getButton()).thenReturn(MouseEvent.BUTTON1);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getX()).thenReturn(239);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getY()).thenReturn(289);
        ControlGrille controlGrille = new ControlGrille(plateau, fenetre);
        controlGrille.mouseClicked(mouseEvent);
        Assert.assertTrue(plateau.getPieceSelectionne() == abeille);
    }

    @Test
    public void selection_piece_deplacement_sur_autre_piece() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        Abeille abeille = new Abeille(plateau.getJoueurBlanc());
        plateau.jouer(abeille, new Point(0, 0));
        plateau.jouer(new Abeille(plateau.getJoueurNoir()), new Point(1, 0));
        plateau.setPieceSelectionne(abeille);
        fenetre.affichagePlateau(false, true);
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getButton()).thenReturn(MouseEvent.BUTTON1);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getX()).thenReturn(302);
        for(int i=0; i<5; i++)
            Mockito.when(mouseEvent.getY()).thenReturn(255);
        ControlGrille controlGrille = new ControlGrille(plateau, fenetre);
        controlGrille.mouseClicked(mouseEvent);
        Assert.assertTrue(plateau.getPieceSelectionne() == abeille);
    }

    @Test
    public void selection_piece_deplacement_quatrieme_tour_sauf_abeille() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, 0));
        plateau.jouer(new Abeille(plateau.getJoueurNoir()), new Point(0, 1));
        plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, -1));
        plateau.jouer(new Abeille(plateau.getJoueurNoir()), new Point(0, 2));
        plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, -2));
        plateau.jouer(new Abeille(plateau.getJoueurNoir()), new Point(0, 3));
        fenetre.affichagePlateau(false, false);
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getButton()).thenReturn(MouseEvent.BUTTON1);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getX()).thenReturn(239);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getY()).thenReturn(289);
        ControlGrille controlGrille = new ControlGrille(plateau, fenetre);
        controlGrille.mouseClicked(mouseEvent);
        Assert.assertNull(plateau.getPieceSelectionne());
    }

    @Test
    public void selection_piece_deplacement_quatrieme_tour_avec_abeille() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        Abeille abeille = (Abeille) plateau.getJoueurBlanc().getAbeille();
        plateau.jouer(abeille, new Point(0, 0));
        plateau.jouer(new Abeille(plateau.getJoueurNoir()), new Point(0, 1));
        plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, -1));
        plateau.jouer(new Abeille(plateau.getJoueurNoir()), new Point(0, 2));
        plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, -2));
        plateau.jouer(new Abeille(plateau.getJoueurNoir()), new Point(0, 3));
        fenetre.affichagePlateau(false, false);
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getButton()).thenReturn(MouseEvent.BUTTON1);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getX()).thenReturn(239);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getY()).thenReturn(289);
        ControlGrille controlGrille = new ControlGrille(plateau, fenetre);
        controlGrille.mouseClicked(mouseEvent);
        Assert.assertTrue(plateau.getPieceSelectionne() == abeille);
    }
}
