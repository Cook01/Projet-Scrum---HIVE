package Controleur;

import controleur.ControlGrille;
import model.Plateau;
import model.typePiece.*;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import vue.Fenetre;

import java.awt.*;
import java.awt.event.KeyEvent;
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

    @Test
    public void selection_piece_abeille_blanc() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, 0));
        plateau.jouer(new Abeille(plateau.getJoueurNoir()), new Point(0, -1));
        plateau.setPieceSelectionne(new Abeille(plateau.getJoueurBlanc()));
        fenetre.affichagePlateau(true, false);
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getButton()).thenReturn(MouseEvent.BUTTON1);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getX()).thenReturn(239);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getY()).thenReturn(359);
        ControlGrille controlGrille = new ControlGrille(plateau, fenetre);
        controlGrille.mouseClicked(mouseEvent);
        Assert.assertTrue(plateau.getPiece(new Point(0, 1)) instanceof Abeille
                && plateau.getPiece(new Point(0, 1)).getJoueur() == plateau.getJoueurBlanc());
    }

    @Test
    public void selection_piece_Fourmi_blanc() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, 0));
        plateau.jouer(new Abeille(plateau.getJoueurNoir()), new Point(0, -1));
        plateau.setPieceSelectionne(new Fourmi(plateau.getJoueurBlanc()));
        fenetre.affichagePlateau(true, false);
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getButton()).thenReturn(MouseEvent.BUTTON1);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getX()).thenReturn(239);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getY()).thenReturn(359);
        ControlGrille controlGrille = new ControlGrille(plateau, fenetre);
        controlGrille.mouseClicked(mouseEvent);
        Assert.assertTrue(plateau.getPiece(new Point(0, 1)) instanceof Fourmi
                && plateau.getPiece(new Point(0, 1)).getJoueur() == plateau.getJoueurBlanc());
    }

    @Test
    public void selection_piece_Araignee_blanc() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, 0));
        plateau.jouer(new Abeille(plateau.getJoueurNoir()), new Point(0, -1));
        plateau.setPieceSelectionne(new Araignee(plateau.getJoueurBlanc()));
        fenetre.affichagePlateau(true, false);
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getButton()).thenReturn(MouseEvent.BUTTON1);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getX()).thenReturn(239);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getY()).thenReturn(359);
        ControlGrille controlGrille = new ControlGrille(plateau, fenetre);
        controlGrille.mouseClicked(mouseEvent);
        Assert.assertTrue(plateau.getPiece(new Point(0, 1)) instanceof Araignee
                && plateau.getPiece(new Point(0, 1)).getJoueur() == plateau.getJoueurBlanc());
    }

    @Test
    public void selection_piece_Sauterelle_blanc() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, 0));
        plateau.jouer(new Abeille(plateau.getJoueurNoir()), new Point(0, -1));
        plateau.setPieceSelectionne(new Sauterelle(plateau.getJoueurBlanc()));
        fenetre.affichagePlateau(true, false);
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getButton()).thenReturn(MouseEvent.BUTTON1);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getX()).thenReturn(239);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getY()).thenReturn(359);
        ControlGrille controlGrille = new ControlGrille(plateau, fenetre);
        controlGrille.mouseClicked(mouseEvent);
        Assert.assertTrue(plateau.getPiece(new Point(0, 1)) instanceof Sauterelle
                && plateau.getPiece(new Point(0, 1)).getJoueur() == plateau.getJoueurBlanc());
    }

    @Test
    public void selection_piece_Scarabee_blanc() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, 0));
        plateau.jouer(new Abeille(plateau.getJoueurNoir()), new Point(0, -1));
        plateau.setPieceSelectionne(new Scarabee(plateau.getJoueurBlanc()));
        fenetre.affichagePlateau(true, false);
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getButton()).thenReturn(MouseEvent.BUTTON1);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getX()).thenReturn(239);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getY()).thenReturn(359);
        ControlGrille controlGrille = new ControlGrille(plateau, fenetre);
        controlGrille.mouseClicked(mouseEvent);
        Assert.assertTrue(plateau.getPiece(new Point(0, 1)) instanceof Scarabee
                && plateau.getPiece(new Point(0, 1)).getJoueur() == plateau.getJoueurBlanc());
    }

    @Test
    public void selection_piece_abeille_noir() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, 0));
        plateau.jouer(new Abeille(plateau.getJoueurNoir()), new Point(0, -1));
        plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, 1));
        plateau.setPieceSelectionne(new Abeille(plateau.getJoueurNoir()));
        fenetre.affichagePlateau(true, false);
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getButton()).thenReturn(MouseEvent.BUTTON1);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getX()).thenReturn(239);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getY()).thenReturn(148);
        ControlGrille controlGrille = new ControlGrille(plateau, fenetre);
        controlGrille.mouseClicked(mouseEvent);
        Assert.assertTrue(plateau.getPiece(new Point(0, -2)) instanceof Abeille
                && plateau.getPiece(new Point(0, -2)).getJoueur() == plateau.getJoueurNoir());
    }

    @Test
    public void selection_piece_fourmi_noir() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, 0));
        plateau.jouer(new Abeille(plateau.getJoueurNoir()), new Point(0, -1));
        plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, 1));
        plateau.setPieceSelectionne(new Fourmi(plateau.getJoueurNoir()));
        fenetre.affichagePlateau(true, false);
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getButton()).thenReturn(MouseEvent.BUTTON1);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getX()).thenReturn(239);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getY()).thenReturn(148);
        ControlGrille controlGrille = new ControlGrille(plateau, fenetre);
        controlGrille.mouseClicked(mouseEvent);
        Assert.assertTrue(plateau.getPiece(new Point(0, -2)) instanceof Fourmi
                && plateau.getPiece(new Point(0, -2)).getJoueur() == plateau.getJoueurNoir());
    }

    @Test
    public void selection_piece_araignee_noir() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, 0));
        plateau.jouer(new Abeille(plateau.getJoueurNoir()), new Point(0, -1));
        plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, 1));
        plateau.setPieceSelectionne(new Araignee(plateau.getJoueurNoir()));
        fenetre.affichagePlateau(true, false);
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getButton()).thenReturn(MouseEvent.BUTTON1);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getX()).thenReturn(239);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getY()).thenReturn(148);
        ControlGrille controlGrille = new ControlGrille(plateau, fenetre);
        controlGrille.mouseClicked(mouseEvent);
        Assert.assertTrue(plateau.getPiece(new Point(0, -2)) instanceof Araignee
                && plateau.getPiece(new Point(0, -2)).getJoueur() == plateau.getJoueurNoir());
    }

    @Test
    public void selection_piece_sauterelle_noir() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, 0));
        plateau.jouer(new Abeille(plateau.getJoueurNoir()), new Point(0, -1));
        plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, 1));
        plateau.setPieceSelectionne(new Sauterelle(plateau.getJoueurNoir()));
        fenetre.affichagePlateau(true, false);
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getButton()).thenReturn(MouseEvent.BUTTON1);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getX()).thenReturn(239);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getY()).thenReturn(148);
        ControlGrille controlGrille = new ControlGrille(plateau, fenetre);
        controlGrille.mouseClicked(mouseEvent);
        Assert.assertTrue(plateau.getPiece(new Point(0, -2)) instanceof Sauterelle
                && plateau.getPiece(new Point(0, -2)).getJoueur() == plateau.getJoueurNoir());
    }

    @Test
    public void selection_piece_scarabee_noir() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, 0));
        plateau.jouer(new Abeille(plateau.getJoueurNoir()), new Point(0, -1));
        plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, 1));
        plateau.setPieceSelectionne(new Scarabee(plateau.getJoueurNoir()));
        fenetre.affichagePlateau(true, false);
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getButton()).thenReturn(MouseEvent.BUTTON1);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getX()).thenReturn(239);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getY()).thenReturn(148);
        ControlGrille controlGrille = new ControlGrille(plateau, fenetre);
        controlGrille.mouseClicked(mouseEvent);
        Assert.assertTrue(plateau.getPiece(new Point(0, -2)) instanceof Scarabee
                && plateau.getPiece(new Point(0, -2)).getJoueur() == plateau.getJoueurNoir());
    }

    @Test
    public void perdant_test_blanc() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getButton()).thenReturn(MouseEvent.BUTTON1);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getX()).thenReturn(239);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getY()).thenReturn(359);

        plateau.jouer(plateau.getJoueurBlanc().getAbeille(), new Point(0, 0));
        plateau.jouer(plateau.getJoueurNoir().getAbeille(), new Point(0, -1));
        plateau.jouer(new Araignee(plateau.getJoueurBlanc()), new Point(-1, 1));
        plateau.jouer(new Fourmi(plateau.getJoueurNoir()), new Point(-1, -1));
        plateau.jouer(new Scarabee(plateau.getJoueurBlanc()), new Point(1, 1));
        plateau.jouer(new Fourmi(plateau.getJoueurNoir()), new Point(1, -1));
        plateau.jouer(new Sauterelle(plateau.getJoueurBlanc()), new Point(1, 2));
        plateau.jouer(plateau.getPiece(new Point(-1, -1)), new Point(-1, 0));
        plateau.jouer(new Sauterelle(plateau.getJoueurBlanc()), new Point(1, 3));
        plateau.jouer(plateau.getPiece(new Point(1, -1)), new Point(1, 0));
        plateau.placer(new Scarabee(plateau.getJoueurBlanc()), new Point(0, 2));
        plateau.setPieceSelectionne(plateau.getPiece(new Point(0, 2)));
        fenetre.affichagePlateau(false, true);
        ControlGrille controlGrille = new ControlGrille(plateau, fenetre);
        controlGrille.mouseClicked(mouseEvent);

        Assert.assertTrue(plateau.getPiece_pose().size() == 0);
        Assert.assertTrue(plateau.getJoueurBlanc().nbAbeilleDisponible() == 1);
        Assert.assertTrue(plateau.getJoueurBlanc().nbFourmiDisponible() == 3);
        Assert.assertTrue(plateau.getJoueurBlanc().nbAraigneeDisponible() == 2);
        Assert.assertTrue(plateau.getJoueurBlanc().nbScarabeeDisponible()==2);
        Assert.assertTrue(plateau.getJoueurBlanc().nbSauterelleDisponible()==3);
        Assert.assertTrue(plateau.getJoueurNoir().nbAbeilleDisponible()==1);
        Assert.assertTrue(plateau.getJoueurNoir().nbFourmiDisponible()==3);
        Assert.assertTrue(plateau.getJoueurNoir().nbAraigneeDisponible()==2);
        Assert.assertTrue(plateau.getJoueurNoir().nbScarabeeDisponible()==2);
        Assert.assertTrue(plateau.getJoueurNoir().nbSauterelleDisponible()==3);
        Assert.assertTrue(plateau.getJoueurQuiJoue()==plateau.getJoueurBlanc());
        Abeille abeille = new Abeille(plateau.getJoueurBlanc());
        plateau.jouer(abeille, new Point(0,0));
        Assert.assertTrue(abeille.getPosition().equals(new Point(0,0)));
    }

    @Test
    public void perdant_test_noir() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getButton()).thenReturn(MouseEvent.BUTTON1);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getX()).thenReturn(301);
        for(int i=0; i<7; i++)
            Mockito.when(mouseEvent.getY()).thenReturn(115);

        plateau.jouer(new Sauterelle(plateau.getJoueurBlanc()), new Point(0, 0));
        plateau.jouer(plateau.getJoueurNoir().getAbeille(), new Point(0, -1));
        plateau.jouer(new Araignee(plateau.getJoueurBlanc()), new Point(-1, 1));
        plateau.jouer(new Fourmi(plateau.getJoueurNoir()), new Point(-1, -1));
        plateau.jouer(new Scarabee(plateau.getJoueurBlanc()), new Point(1, 1));
        plateau.jouer(new Fourmi(plateau.getJoueurNoir()), new Point(1, -1));
        plateau.jouer(plateau.getJoueurBlanc().getAbeille(), new Point(1, 2));
        plateau.jouer(plateau.getPiece(new Point(-1, -1)), new Point(-1, 0));
        plateau.jouer(new Sauterelle(plateau.getJoueurBlanc()), new Point(1, 3));
        plateau.jouer(plateau.getPiece(new Point(1, -1)), new Point(1, 0));
        plateau.jouer(new Scarabee(plateau.getJoueurBlanc()), new Point(0, 2));
        plateau.deplacer(plateau.getPiece(new Point(0, 2)), new Point(0, 1));
        plateau.placer(new Fourmi(plateau.getJoueurNoir()), new Point(0, -2));
        plateau.placer(new Fourmi(plateau.getJoueurNoir()), new Point(1, -1));
        plateau.placer(new Fourmi(plateau.getJoueurNoir()), new Point(-1, -1));
        plateau.placer(new Fourmi(plateau.getJoueurNoir()), new Point(-1, -2));
        plateau.setPieceSelectionne(new Scarabee(plateau.getJoueurBlanc()));
        fenetre.affichagePlateau(true, false);
        ControlGrille controlGrille = new ControlGrille(plateau, fenetre);
        controlGrille.mouseClicked(mouseEvent);

        Assert.assertTrue(plateau.getPiece_pose().size() == 0);
        Assert.assertTrue(plateau.getJoueurBlanc().nbAbeilleDisponible() == 1);
        Assert.assertTrue(plateau.getJoueurBlanc().nbFourmiDisponible() == 3);
        Assert.assertTrue(plateau.getJoueurBlanc().nbAraigneeDisponible() == 2);
        Assert.assertTrue(plateau.getJoueurBlanc().nbScarabeeDisponible()==2);
        Assert.assertTrue(plateau.getJoueurBlanc().nbSauterelleDisponible()==3);
        Assert.assertTrue(plateau.getJoueurNoir().nbAbeilleDisponible()==1);
        Assert.assertTrue(plateau.getJoueurNoir().nbFourmiDisponible()==3);
        Assert.assertTrue(plateau.getJoueurNoir().nbAraigneeDisponible()==2);
        Assert.assertTrue(plateau.getJoueurNoir().nbScarabeeDisponible()==2);
        Assert.assertTrue(plateau.getJoueurNoir().nbSauterelleDisponible()==3);
        Assert.assertTrue(plateau.getJoueurQuiJoue()==plateau.getJoueurBlanc());
        Abeille abeille = new Abeille(plateau.getJoueurBlanc());
        plateau.jouer(abeille, new Point(0,0));
        Assert.assertTrue(abeille.getPosition().equals(new Point(0,0)));
    }

    @Test
    public void egalite_test() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getButton()).thenReturn(MouseEvent.BUTTON1);
        for(int i=0; i<4; i++)
            Mockito.when(mouseEvent.getX()).thenReturn(301);
        for(int i=0; i<7; i++)
            Mockito.when(mouseEvent.getY()).thenReturn(115);

        plateau.jouer(plateau.getJoueurBlanc().getAbeille(), new Point(0, 0));
        plateau.jouer(plateau.getJoueurNoir().getAbeille(), new Point(0, -1));
        plateau.jouer(new Araignee(plateau.getJoueurBlanc()), new Point(-1, 1));
        plateau.jouer(new Fourmi(plateau.getJoueurNoir()), new Point(-1, -1));
        plateau.jouer(new Scarabee(plateau.getJoueurBlanc()), new Point(1, 1));
        plateau.jouer(new Fourmi(plateau.getJoueurNoir()), new Point(1, -1));
        plateau.jouer(new Sauterelle(plateau.getJoueurBlanc()), new Point(1, 2));
        plateau.jouer(plateau.getPiece(new Point(-1, -1)), new Point(-1, 0));
        plateau.jouer(new Sauterelle(plateau.getJoueurBlanc()), new Point(1, 3));
        plateau.jouer(plateau.getPiece(new Point(1, -1)), new Point(1, 0));
        plateau.jouer(new Scarabee(plateau.getJoueurBlanc()), new Point(0, 2));
        plateau.deplacer(plateau.getPiece(new Point(0, 2)), new Point(0, 1));
        plateau.placer(new Fourmi(plateau.getJoueurNoir()), new Point(0, -2));
        plateau.placer(new Fourmi(plateau.getJoueurNoir()), new Point(1, -1));
        plateau.placer(new Fourmi(plateau.getJoueurNoir()), new Point(-1, -1));
        plateau.placer(new Fourmi(plateau.getJoueurNoir()), new Point(-1, -2));
        plateau.setPieceSelectionne(new Scarabee(plateau.getJoueurBlanc()));
        fenetre.affichagePlateau(true, false);
        ControlGrille controlGrille = new ControlGrille(plateau, fenetre);
        controlGrille.mouseClicked(mouseEvent);

        Assert.assertTrue(plateau.getPiece_pose().size() == 0);
        Assert.assertTrue(plateau.getJoueurBlanc().nbAbeilleDisponible() == 1);
        Assert.assertTrue(plateau.getJoueurBlanc().nbFourmiDisponible() == 3);
        Assert.assertTrue(plateau.getJoueurBlanc().nbAraigneeDisponible() == 2);
        Assert.assertTrue(plateau.getJoueurBlanc().nbScarabeeDisponible()==2);
        Assert.assertTrue(plateau.getJoueurBlanc().nbSauterelleDisponible()==3);
        Assert.assertTrue(plateau.getJoueurNoir().nbAbeilleDisponible()==1);
        Assert.assertTrue(plateau.getJoueurNoir().nbFourmiDisponible()==3);
        Assert.assertTrue(plateau.getJoueurNoir().nbAraigneeDisponible()==2);
        Assert.assertTrue(plateau.getJoueurNoir().nbScarabeeDisponible()==2);
        Assert.assertTrue(plateau.getJoueurNoir().nbSauterelleDisponible()==3);
        Assert.assertTrue(plateau.getJoueurQuiJoue()==plateau.getJoueurBlanc());
        Abeille abeille = new Abeille(plateau.getJoueurBlanc());
        plateau.jouer(abeille, new Point(0,0));
        Assert.assertTrue(abeille.getPosition().equals(new Point(0,0)));
    }

    @Test
    public void deplacement_bas_autorise() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        fenetre.affichagePlateau(false, false);
        KeyEvent keyEvent = Mockito.mock(KeyEvent.class);
        Mockito.when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_DOWN);
        ControlGrille controlGrille = new ControlGrille(plateau, fenetre);
        controlGrille.keyPressed(keyEvent);
        Assert.assertTrue(fenetre.getGrille().position.y == -10);
    }

    @Test
    public void deplacement_droite_autorise() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        fenetre.affichagePlateau(false, false);
        KeyEvent keyEvent = Mockito.mock(KeyEvent.class);
        Mockito.when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_RIGHT);
        ControlGrille controlGrille = new ControlGrille(plateau, fenetre);
        controlGrille.keyPressed(keyEvent);
        Assert.assertTrue(fenetre.getGrille().position.x == -10);
    }

    @Test
    public void deplacement_haut_autorise() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        ControlGrille controlGrille = new ControlGrille(plateau, fenetre);
        fenetre.affichagePlateau(false, false);
        KeyEvent keyEvent = Mockito.mock(KeyEvent.class);
        Mockito.when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_DOWN);
        controlGrille.keyPressed(keyEvent);
        Mockito.when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_UP);
        controlGrille.keyPressed(keyEvent);
        Assert.assertTrue(fenetre.getGrille().position.y == 0);
    }

    @Test
    public void deplacement_gauche_autorise() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        ControlGrille controlGrille = new ControlGrille(plateau, fenetre);
        fenetre.affichagePlateau(false, false);
        KeyEvent keyEvent = Mockito.mock(KeyEvent.class);
        Mockito.when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_RIGHT);
        controlGrille.keyPressed(keyEvent);
        Mockito.when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_LEFT);
        controlGrille.keyPressed(keyEvent);
        Assert.assertTrue(fenetre.getGrille().position.x == 0);
    }

    @Test
    public void deplacement_haut_non_autorise() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        fenetre.affichagePlateau(false, false);
        KeyEvent keyEvent = Mockito.mock(KeyEvent.class);
        Mockito.when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_UP);
        ControlGrille controlGrille = new ControlGrille(plateau, fenetre);
        controlGrille.keyPressed(keyEvent);
        Assert.assertTrue(fenetre.getGrille().position.y == 0);
    }

    @Test
    public void deplacement_gauche_non_autorise() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        fenetre.affichagePlateau(false, false);
        KeyEvent keyEvent = Mockito.mock(KeyEvent.class);
        Mockito.when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_LEFT);
        ControlGrille controlGrille = new ControlGrille(plateau, fenetre);
        controlGrille.keyPressed(keyEvent);
        Assert.assertTrue(fenetre.getGrille().position.x == 0);
    }

    @Test
    public void deplacement_bas_non_autorise() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        fenetre.affichagePlateau(false, false);
        fenetre.getGrille().position.y = -fenetre.getGrille().backIcon.getIconHeight()+fenetre.getGrille().getHeight();
        KeyEvent keyEvent = Mockito.mock(KeyEvent.class);
        Mockito.when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_DOWN);
        ControlGrille controlGrille = new ControlGrille(plateau, fenetre);
        controlGrille.keyPressed(keyEvent);
        Assert.assertTrue(fenetre.getGrille().position.y == -fenetre.getGrille().backIcon.getIconHeight()+fenetre.getGrille().getHeight());
    }

    @Test
    public void deplacement_droit_non_autorise() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        fenetre.affichagePlateau(false, false);
        fenetre.getGrille().position.x = -fenetre.getGrille().backIcon.getIconWidth()+fenetre.getGrille().getWidth();
        KeyEvent keyEvent = Mockito.mock(KeyEvent.class);
        Mockito.when(keyEvent.getKeyCode()).thenReturn(KeyEvent.VK_RIGHT);
        ControlGrille controlGrille = new ControlGrille(plateau, fenetre);
        controlGrille.keyPressed(keyEvent);
        Assert.assertTrue(fenetre.getGrille().position.x == -fenetre.getGrille().backIcon.getIconWidth()+fenetre.getGrille().getWidth());
    }
}
