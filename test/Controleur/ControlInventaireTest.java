package Controleur;

import controleur.ControlInventaire;
import model.Plateau;
import model.typePiece.*;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import vue.Fenetre;

import java.awt.*;
import java.awt.event.MouseEvent;

public class ControlInventaireTest {
    @Test
    public void selection_piece_inventaire_Abeille_Blanc() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getSource()).thenReturn(fenetre.getJpAbeilleBlanc());
        ControlInventaire controlInventaire = new ControlInventaire(plateau, fenetre);
        controlInventaire.mouseClicked(mouseEvent);
        Assert.assertTrue(plateau.getPieceSelectionne() instanceof Abeille
                && plateau.getPieceSelectionne().getJoueur() == plateau.getJoueurBlanc());
    }

    @Test
    public void selection_piece_inventaire_Fourmi_Blanc() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getSource()).thenReturn(fenetre.getJpFourmiBlanc());
        ControlInventaire controlInventaire = new ControlInventaire(plateau, fenetre);
        controlInventaire.mouseClicked(mouseEvent);
        Assert.assertTrue(plateau.getPieceSelectionne() instanceof Fourmi
                && plateau.getPieceSelectionne().getJoueur() == plateau.getJoueurBlanc());
    }

    @Test
    public void selection_piece_inventaire_Areignee_Blanc() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getSource()).thenReturn(fenetre.getJpAraigneeBlanc());
        ControlInventaire controlInventaire = new ControlInventaire(plateau, fenetre);
        controlInventaire.mouseClicked(mouseEvent);
        Assert.assertTrue(plateau.getPieceSelectionne() instanceof Araignee
                && plateau.getPieceSelectionne().getJoueur() == plateau.getJoueurBlanc());
    }

    @Test
    public void selection_piece_inventaire_Sauterelle_Blanc() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getSource()).thenReturn(fenetre.getJpSauterelleBlanc());
        ControlInventaire controlInventaire = new ControlInventaire(plateau, fenetre);
        controlInventaire.mouseClicked(mouseEvent);
        Assert.assertTrue(plateau.getPieceSelectionne() instanceof Sauterelle
                && plateau.getPieceSelectionne().getJoueur() == plateau.getJoueurBlanc());
    }

    @Test
    public void selection_piece_inventaire_Scarabee_Blanc() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getSource()).thenReturn(fenetre.getJpScarabeeBlanc());
        ControlInventaire controlInventaire = new ControlInventaire(plateau, fenetre);
        controlInventaire.mouseClicked(mouseEvent);
        Assert.assertTrue(plateau.getPieceSelectionne() instanceof Scarabee
                && plateau.getPieceSelectionne().getJoueur() == plateau.getJoueurBlanc());
    }

    @Test
    public void selection_piece_inventaire_Abeille_Noir() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        plateau.jouer(new Abeille(plateau.getJoueurBlanc()), new Point(0,0));
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getSource()).thenReturn(fenetre.getJpAbeilleNoir());
        ControlInventaire controlInventaire = new ControlInventaire(plateau, fenetre);
        controlInventaire.mouseClicked(mouseEvent);
        Assert.assertTrue(plateau.getPieceSelectionne() instanceof Abeille
                && plateau.getPieceSelectionne().getJoueur() == plateau.getJoueurNoir());
    }

    @Test
    public void selection_piece_inventaire_Fourmi_Noir() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        plateau.jouer(new Abeille(plateau.getJoueurBlanc()), new Point(0,0));
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getSource()).thenReturn(fenetre.getJpFourmiNoir());
        ControlInventaire controlInventaire = new ControlInventaire(plateau, fenetre);
        controlInventaire.mouseClicked(mouseEvent);
        Assert.assertTrue(plateau.getPieceSelectionne() instanceof Fourmi
                && plateau.getPieceSelectionne().getJoueur() == plateau.getJoueurNoir());
    }

    @Test
    public void selection_piece_inventaire_Areignee_Noir() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        plateau.jouer(new Abeille(plateau.getJoueurBlanc()), new Point(0,0));
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getSource()).thenReturn(fenetre.getJpAraigneeNoir());
        ControlInventaire controlInventaire = new ControlInventaire(plateau, fenetre);
        controlInventaire.mouseClicked(mouseEvent);
        Assert.assertTrue(plateau.getPieceSelectionne() instanceof Araignee
                && plateau.getPieceSelectionne().getJoueur() == plateau.getJoueurNoir());
    }

    @Test
    public void selection_piece_inventaire_Sauterelle_Noir() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        plateau.jouer(new Abeille(plateau.getJoueurBlanc()), new Point(0,0));
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getSource()).thenReturn(fenetre.getJpSauterelleNoir());
        ControlInventaire controlInventaire = new ControlInventaire(plateau, fenetre);
        controlInventaire.mouseClicked(mouseEvent);
        Assert.assertTrue(plateau.getPieceSelectionne() instanceof Sauterelle
                && plateau.getPieceSelectionne().getJoueur() == plateau.getJoueurNoir());
    }

    @Test
    public void selection_piece_inventaire_Scarabee_Noir() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        plateau.jouer(new Abeille(plateau.getJoueurBlanc()), new Point(0,0));
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getSource()).thenReturn(fenetre.getJpScarabeeNoir());
        ControlInventaire controlInventaire = new ControlInventaire(plateau, fenetre);
        controlInventaire.mouseClicked(mouseEvent);
        Assert.assertTrue(plateau.getPieceSelectionne() instanceof Scarabee
                && plateau.getPieceSelectionne().getJoueur() == plateau.getJoueurNoir());
    }

    @Test
    public void selection_piece_inventaire_deja_selectionner () {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        plateau.setPieceSelectionne(new Abeille(plateau.getJoueurBlanc()));
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getSource()).thenReturn(fenetre.getJpFourmiBlanc());
        ControlInventaire controlInventaire = new ControlInventaire(plateau, fenetre);
        controlInventaire.mouseClicked(mouseEvent);
        Assert.assertTrue(plateau.getPieceSelectionne() instanceof Abeille
                && plateau.getPieceSelectionne().getJoueur() == plateau.getJoueurBlanc());
    }

    @Test
    public void selection_piece_inventaire_pInexistant_blanc() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getSource()).thenReturn(null);
        ControlInventaire controlInventaire = new ControlInventaire(plateau, fenetre);
        controlInventaire.mouseClicked(mouseEvent);
        Assert.assertNull(plateau.getPieceSelectionne());
    }

    @Test
    public void selection_piece_inventaire_pInexistant_noir() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        plateau.jouer(new Abeille(plateau.getJoueurBlanc()), new Point(0,0));
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getSource()).thenReturn(null);
        ControlInventaire controlInventaire = new ControlInventaire(plateau, fenetre);
        controlInventaire.mouseClicked(mouseEvent);
        Assert.assertNull(plateau.getPieceSelectionne());
    }

    @Test
    public void selection_piece_inventaire_quatrieme_tours_impossible_blanc() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0,0));
        plateau.jouer(new Fourmi(plateau.getJoueurNoir()), new Point(0,1));
        plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0,2));
        plateau.jouer(new Fourmi(plateau.getJoueurNoir()), new Point(0,3));
        plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0,4));
        plateau.jouer(new Fourmi(plateau.getJoueurNoir()), new Point(0,5));
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getSource()).thenReturn(fenetre.getJpFourmiBlanc());
        ControlInventaire controlInventaire = new ControlInventaire(plateau, fenetre);
        controlInventaire.mouseClicked(mouseEvent);
        Assert.assertNull(plateau.getPieceSelectionne());
    }

    @Test
    public void selection_piece_inventaire_quatrieme_tours_possible_blanc() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0,0));
        plateau.jouer(new Fourmi(plateau.getJoueurNoir()), new Point(0,1));
        plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0,2));
        plateau.jouer(new Fourmi(plateau.getJoueurNoir()), new Point(0,3));
        plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0,4));
        plateau.jouer(new Fourmi(plateau.getJoueurNoir()), new Point(0,5));
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getSource()).thenReturn(fenetre.getJpAbeilleBlanc());
        ControlInventaire controlInventaire = new ControlInventaire(plateau, fenetre);
        controlInventaire.mouseClicked(mouseEvent);
        Assert.assertTrue(plateau.getPieceSelectionne() instanceof Abeille
                && plateau.getPieceSelectionne().getJoueur() == plateau.getJoueurBlanc());
    }

    @Test
    public void selection_piece_inventaire_quatrieme_tours_impossible_noir() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0,0));
        plateau.jouer(new Fourmi(plateau.getJoueurNoir()), new Point(0,1));
        plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0,2));
        plateau.jouer(new Fourmi(plateau.getJoueurNoir()), new Point(0,3));
        plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0,4));
        plateau.jouer(new Fourmi(plateau.getJoueurNoir()), new Point(0,5));
        plateau.jouer(new Abeille(plateau.getJoueurBlanc()), new Point(0,6));
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getSource()).thenReturn(fenetre.getJpFourmiNoir());
        ControlInventaire controlInventaire = new ControlInventaire(plateau, fenetre);
        controlInventaire.mouseClicked(mouseEvent);
        Assert.assertNull(plateau.getPieceSelectionne());
    }

    @Test
    public void selection_piece_inventaire_quatrieme_tours_possible_noir() {
        Plateau plateau = new Plateau();
        Fenetre fenetre = new Fenetre(plateau);
        plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0,0));
        plateau.jouer(new Fourmi(plateau.getJoueurNoir()), new Point(0,1));
        plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0,2));
        plateau.jouer(new Fourmi(plateau.getJoueurNoir()), new Point(0,3));
        plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0,4));
        plateau.jouer(new Fourmi(plateau.getJoueurNoir()), new Point(0,5));
        plateau.jouer(new Abeille(plateau.getJoueurBlanc()), new Point(0,6));
        MouseEvent mouseEvent = Mockito.mock(MouseEvent.class);
        Mockito.when(mouseEvent.getSource()).thenReturn(fenetre.getJpAbeilleNoir());
        ControlInventaire controlInventaire = new ControlInventaire(plateau, fenetre);
        controlInventaire.mouseClicked(mouseEvent);
        Assert.assertTrue(plateau.getPieceSelectionne() instanceof Abeille
                && plateau.getPieceSelectionne().getJoueur() == plateau.getJoueurNoir());
    }
}
