package model;

import model.typePiece.*;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class PlateauTest {

        /***** placer *****/
        @Test
        public void posee_premiere_piece_reine() {
                Joueur joueur = new Joueur("Blanc");
                Abeille abeille = new Abeille(joueur);
                Plateau plateau = new Plateau();

                plateau.placer(abeille, new Point(0,0));
                Assert.assertTrue(abeille.getPosition().equals(new Point(0,0)));
        }

        @Test
        public void posee_premiere_piece_reine_echec() {
                Abeille abeille = new Abeille(new Joueur("Blanc"));
                Plateau plateau = new Plateau();

                plateau.placer(abeille, new Point(1,1));
                Assert.assertNull(abeille.getPosition());
        }

        @Test
        public void  posee_seconde_piece_fourmie_reussite() {
                Abeille abeille = new Abeille(new Joueur("Blanc"));
                Plateau plateau = new Plateau();
                Fourmi fourmi = new Fourmi(new Joueur("Blanc"));

                plateau.placer(abeille, new Point(0, 0));
                plateau.placer(fourmi, new Point(0, 1));
                Assert.assertTrue(fourmi.getPosition().equals(new Point(0,1)));
        }

        @Test
        public void  posee_seconde_piece_fourmie_echec_mauvaise_position() {
                Abeille abeille = new Abeille(new Joueur("Blanc"));
                Plateau plateau = new Plateau();
                Fourmi fourmi = new Fourmi(new Joueur("Blanc"));

                plateau.placer(abeille, new Point(0, 0));
                plateau.placer(fourmi, new Point(5, 5));
                Assert.assertNull(fourmi.getPosition());
        }

        @Test
        public void posee_seconde_piece_sur_la_premiere_impossible() {
                Abeille abeille = new Abeille(new Joueur("Blanc"));
                Plateau plateau = new Plateau();
                Fourmi fourmi = new Fourmi(new Joueur("Blanc"));

                plateau.placer(abeille, new Point(0, 0));
                plateau.placer(fourmi, new Point(0,0));
                Assert.assertNull(fourmi.getPosition());
        }

        @Test
        public void enlever_dependance_existante_avec_depence_restante() {
                Plateau plateau = new Plateau();
                Piece piece = new Abeille(new Joueur("blanc"));
                plateau.placer(piece, new Point(0, 0));
                Piece piece1 = new Abeille(new Joueur("blanc"));
                plateau.placer(piece1, new Point(0, 1));
                Piece piece2 = new Abeille(new Joueur("blanc"));
                plateau.placer(piece2, new Point(0, -1));
                plateau.casserDependance(piece1);
                Assert.assertTrue(piece.getVoisinNull().size()==5);
                Assert.assertFalse(piece.getVoisinNull().contient(new Point(0, -1)));
        }

        @Test
        public void placer_un_scarabee_plateau_vide() {
                Plateau plateau = new Plateau();
                Scarabee scarabee = new Scarabee(new Joueur("Blanc"));
                plateau.placer(scarabee, new Point(0,0));
                Assert.assertTrue(scarabee.getPosition().equals(new Point(0,0)));
        }

        @Test
        public void placer_un_scarabee_plateau_non_vide() {
                Plateau plateau = new Plateau();
                Scarabee scarabee = new Scarabee(new Joueur("Blanc"));
                plateau.placer(new Abeille(new Joueur("Blanc")), new Point(0, 0));
                plateau.placer(scarabee, new Point(1,0));
                Assert.assertTrue(scarabee.getPosition().equals(new Point(1,0)));
        }

        /***** Jouer : tours *****/
        @Test
        public void posee_piece_premier_tour() {
                Plateau plateau = new Plateau();
                Fourmi fourmi = new Fourmi(plateau.getJoueurBlanc());
                Fourmi fourmiBis = new Fourmi(plateau.getJoueurNoir());

                plateau.jouer(fourmi, new Point(0, 0));
                plateau.jouer(fourmiBis, new Point(1, 0));
                Assert.assertTrue(fourmi.getPosition().equals(new Point(0, 0)));
                Assert.assertTrue(fourmiBis.getPosition().equals(new Point(1, 0)));
        }

        @Test
        public void posee_piece_tours_suivant_incorrect() {
                Plateau plateau = new Plateau();
                Fourmi fourmi = new Fourmi(plateau.getJoueurBlanc());
                Fourmi fourmiBis = new Fourmi(plateau.getJoueurNoir());
                Fourmi fourmiTh = new Fourmi(plateau.getJoueurBlanc());

                plateau.jouer(fourmi, new Point(0, 0));
                plateau.jouer(fourmiBis, new Point(0, 1));
                plateau.jouer(fourmiTh, new Point(1, 1));
                Assert.assertTrue(fourmi.getPosition().equals(new Point(0, 0)));
                Assert.assertTrue(fourmiBis.getPosition().equals(new Point(0, 1)));
                Assert.assertNull(fourmiTh.getPosition());
        }

        @Test
        public void posee_piece_tours_suivant() {
                Plateau plateau = new Plateau();
                Fourmi fourmi = new Fourmi(plateau.getJoueurBlanc());
                Fourmi fourmiBis = new Fourmi(plateau.getJoueurNoir());
                Fourmi fourmiTh = new Fourmi(plateau.getJoueurBlanc());

                plateau.jouer(fourmi, new Point(0, 0));
                plateau.jouer(fourmiBis, new Point(0, 1));
                plateau.jouer(fourmiTh, new Point(0, -1));
                Assert.assertTrue(fourmi.getPosition().equals(new Point(0, 0)));
                Assert.assertTrue(fourmiBis.getPosition().equals(new Point(0, 1)));
                Assert.assertTrue(fourmiTh.getPosition().equals(new Point(0, -1)));
        }


        /***** setDependance *****/
        @Test
        public void piece_position_pair(){
                Plateau plateau = new Plateau();
                Abeille abeille = new Abeille(new Joueur("Blanc"));
                Fourmi fourmi1 = new Fourmi(new Joueur("Blanc"));
                Fourmi fourmi2 = new Fourmi(new Joueur("Blanc"));
                Fourmi fourmi3 = new Fourmi(new Joueur("Blanc"));
                Fourmi fourmi4 = new Fourmi(new Joueur("Blanc"));
                Fourmi fourmi5 = new Fourmi(new Joueur("Blanc"));
                Fourmi fourmi6 = new Fourmi(new Joueur("Blanc"));

                plateau.placer(abeille, new Point(0, 0));
                plateau.placer(fourmi1, new Point(0, 1));
                plateau.placer(fourmi2, new Point(1, 1));
                plateau.placer(fourmi3, new Point(1, 0));
                plateau.placer(fourmi4, new Point(0, -1));
                plateau.placer(fourmi5, new Point(-1, 0));
                plateau.placer(fourmi6, new Point(-1, 1));

                Assert.assertTrue(abeille.getDessus()== fourmi1);
                Assert.assertTrue(abeille.getDessus_droite()== fourmi2);
                Assert.assertTrue(abeille.getDessous_droite()== fourmi3);
                Assert.assertTrue(abeille.getDessous()== fourmi4);
                Assert.assertTrue(abeille.getDessous_gauche()== fourmi5);
                Assert.assertTrue(abeille.getDessus_gauche()== fourmi6);
        }

        @Test
        public void piece_position_impair(){
                Plateau plateau = new Plateau();
                Abeille abeille = new Abeille(new Joueur("Blanc"));
                Fourmi fourmi1 = new Fourmi(new Joueur("Blanc"));
                Fourmi fourmi2 = new Fourmi(new Joueur("Blanc"));
                Fourmi fourmi3 = new Fourmi(new Joueur("Blanc"));
                Fourmi fourmi4 = new Fourmi(new Joueur("Blanc"));
                Fourmi fourmi5 = new Fourmi(new Joueur("Blanc"));
                Fourmi fourmi6 = new Fourmi(new Joueur("Blanc"));

                plateau.placer(abeille, new Point(0, 0));
                plateau.placer(fourmi1, new Point(1, 0));
                plateau.placer(fourmi2, new Point(1, 1));
                plateau.placer(fourmi3, new Point(2, 0));
                plateau.placer(fourmi4, new Point(2, -1));
                plateau.placer(fourmi5, new Point(1, -1));
                plateau.placer(fourmi6, new Point(0, -1));

                Assert.assertTrue(fourmi1.getDessus()== fourmi2);
                Assert.assertTrue(fourmi1.getDessus_droite()== fourmi3);
                Assert.assertTrue(fourmi1.getDessous_droite()== fourmi4);
                Assert.assertTrue(fourmi1.getDessous()== fourmi5);
                Assert.assertTrue(fourmi1.getDessous_gauche()== fourmi6);
                Assert.assertTrue(fourmi1.getDessus_gauche()== abeille);
        }


        /***** estPlacementPossible ******/
        @Test
        public void liste_placement_plateau_vide() {
                Plateau plateau = new Plateau();
                Assert.assertTrue(plateau.getPlacementPossible().contains(new Point(0, 0)));
        }

        @Test
        public void liste_placement_plateau_une_piece() {
                Plateau plateau = new Plateau();
                plateau.placer(new Abeille(new Joueur("blanc")), new Point(0, 0));
                Assert.assertTrue(plateau.getPlacementPossible().size()==6);
                Assert.assertTrue(plateau.getPlacementPossible().contient(new Point(1, 0)));
                Assert.assertTrue(plateau.getPlacementPossible().contient(new Point(1, 1)));
                Assert.assertTrue(plateau.getPlacementPossible().contient(new Point(0, 1)));
                Assert.assertTrue(plateau.getPlacementPossible().contient(new Point(-1, 1)));
                Assert.assertTrue(plateau.getPlacementPossible().contient(new Point(-1, -0)));
                Assert.assertTrue(plateau.getPlacementPossible().contient(new Point(0, -1)));
        }

        /***** Enlever dépendances *****/
        @Test
        public void enlever_dependance_inexistante() {
                Plateau plateau = new Plateau();
                Piece piece = new Abeille(new Joueur("blanc"));
                plateau.placer(piece, new Point(0, 0));
                Piece piece1 = new Abeille(new Joueur("blanc"));
                plateau.placer(piece1, new Point(2, 2));
                plateau.casserDependance(piece1);
                Assert.assertTrue(piece.getVoisinNull().size()==6);
        }


        @Test
        public void enlever_dependance_existante() {
                Plateau plateau = new Plateau();
                Piece piece = new Abeille(new Joueur("blanc"));
                plateau.placer(piece, new Point(0, 0));
                Piece piece1 = new Abeille(new Joueur("blanc"));
                plateau.placer(piece1, new Point(0, 1));
                plateau.casserDependance(piece1);
                Assert.assertTrue(piece.getVoisinNull().size()==6);
        }

        /***** DEPLACER *****/
        @Test
        public void deplacement_non_pose() {
                Plateau plateau = new Plateau();
                Fourmi fourmi = new Fourmi(new Joueur("Blanc"));

                plateau.deplacer(fourmi, new Point(0, 2));
                Assert.assertNull(fourmi.getPosition());
        }

        @Test
        public void deplacement_non_autorise_piece_bloque() {
                Abeille abeille = new Abeille(new Joueur("Blanc"));
                Plateau plateau = new Plateau();
                Fourmi fourmi = new Fourmi(new Joueur("Blanc"));

                plateau.placer(abeille, new Point(0, 0));
                plateau.placer(fourmi, new Point(0, 1));
                plateau.placer(new Abeille(new Joueur("Blanc")), new Point(0, 2));
                plateau.deplacer(fourmi, new Point(1, 1));
                Assert.assertFalse(fourmi.getPosition().equals(new Point(1,1)));
        }

        @Test
        public void deplacement_sur_une_autre_piece() {
                Abeille abeille = new Abeille(new Joueur("Blanc"));
                Plateau plateau = new Plateau();
                Fourmi fourmi = new Fourmi(new Joueur("Blanc"));

                plateau.placer(abeille, new Point(0, 0));
                plateau.placer(fourmi, new Point(0, 1));
                plateau.deplacer(fourmi, new Point(0, 0));
                Assert.assertFalse(fourmi.getPosition().equals(new Point(0,0)));
        }

        @Test
        public void deplacement_non_autorise() {
                Abeille abeille = new Abeille(new Joueur("Blanc"));
                Plateau plateau = new Plateau();
                Fourmi fourmi = new Fourmi(new Joueur("Blanc"));

                plateau.placer(abeille, new Point(0, 0));
                plateau.placer(fourmi, new Point(0, 1));
                plateau.deplacer(fourmi, new Point(0, 2));
                Assert.assertFalse(fourmi.getPosition().equals(new Point(0,2)));
        }

        @Test
        public void deplacement_autorise() {
                Abeille abeille = new Abeille(new Joueur("Blanc"));
                Plateau plateau = new Plateau();
                Fourmi fourmi = new Fourmi(new Joueur("Blanc"));

                plateau.placer(abeille, new Point(0, 0));
                plateau.placer(fourmi, new Point(0, 1));
                plateau.deplacer(fourmi, new Point(0, -1));
                Assert.assertTrue(fourmi.getPosition().equals(new Point(0,-1)));
        }

        @Test
        public void deplacement_autorise_Scarabee() {
                Abeille abeille = new Abeille(new Joueur("Blanc"));
                Plateau plateau = new Plateau();
                Scarabee scarabee = new Scarabee(new Joueur("Blanc"));

                plateau.placer(abeille, new Point(0, 0));
                plateau.placer(scarabee, new Point(0, 1));
                plateau.deplacer(scarabee, new Point(1, 1));
                Assert.assertTrue(scarabee.getPosition().equals(new Point(1, 1)));
        }

        /***** JOUER *****/
        @Test
        public void jouer_placement() {
                Plateau plateau = new Plateau();
                Piece abeille = new Abeille(new Joueur("noir"));
                plateau.jouer(abeille, new Point(0,0));
                Assert.assertTrue(abeille.getPosition().equals(new Point(0,0)));
        }

        @Test
        public void jouer_deplacement() {
                Plateau plateau = new Plateau();
                Piece abeille = new Abeille(new Joueur("noir"));
                plateau.jouer(abeille, new Point(0,0));
                plateau.jouer(new Abeille(new Joueur("noir")), new Point(0,1));
                plateau.jouer(abeille, new Point(1,1));
                Assert.assertTrue(abeille.getPosition().equals(new Point(1,1)));
        }

        /***** GET PIECE *****/
        @Test
        public void get_piece_joueur_plateau_vide() {
                Plateau plateau = new Plateau();
                Assert.assertNull(plateau.getPiece(new Point(0, 0), plateau.getJoueurBlanc()));
        }

        @Test
        public void get_piece_joueur_invalide() {
                Plateau plateau = new Plateau();
                plateau.jouer(new Abeille(plateau.getJoueurBlanc()), new Point(0,0));
                Assert.assertNull(plateau.getPiece(new Point(1, 0), plateau.getJoueurBlanc()));
        }

        @Test
        public void get_piece_joueur_mauvais_joueur(){
                Plateau plateau = new Plateau();
                plateau.jouer(new Abeille(plateau.getJoueurBlanc()), new Point(0,0));
                Assert.assertNull(plateau.getPiece(new Point(1, 0), plateau.getJoueurNoir()));
        }

        @Test
        public void get_piece_joueur_valide(){
                Plateau plateau = new Plateau();
                Abeille abeille = new Abeille(plateau.getJoueurBlanc());
                plateau.jouer(abeille, new Point(0,0));
                plateau.jouer(new Abeille(plateau.getJoueurBlanc()), new Point(1,0));
                Assert.assertTrue(plateau.getPiece(new Point(0, 0), plateau.getJoueurBlanc()).equals(abeille));
        }

        @Test
        public void get_piece_joueur_pile_valide(){
                Plateau plateau = new Plateau();
                Scarabee scarabee = new Scarabee(plateau.getJoueurNoir());
                Scarabee scarabee2 = new Scarabee(plateau.getJoueurBlanc());
                plateau.jouer(new Abeille(plateau.getJoueurBlanc()), new Point(0,0));
                plateau.jouer(scarabee, new Point(0,-1));
                plateau.jouer(scarabee2, new Point(0,1));
                plateau.jouer(scarabee, new Point(0,0));
                plateau.jouer(scarabee2, new Point(0,0));
                Assert.assertTrue(plateau.getPiece(new Point(0, 0), plateau.getJoueurBlanc()).equals(scarabee2));
        }

        @Test
        public void get_piece_joueur_pile_invalide(){
                Plateau plateau = new Plateau();
                Scarabee scarabee = new Scarabee(plateau.getJoueurNoir());
                Scarabee scarabee2 = new Scarabee(plateau.getJoueurBlanc());
                plateau.jouer(new Abeille(plateau.getJoueurBlanc()), new Point(0,0));
                plateau.jouer(scarabee, new Point(0,-1));
                plateau.jouer(scarabee2, new Point(0,1));
                plateau.jouer(scarabee, new Point(0,0));
                plateau.jouer(scarabee2, new Point(0,0));
                Assert.assertNull(plateau.getPiece(new Point(0, 0), plateau.getJoueurNoir()));
        }

        /***** GET PIECE SIMPLE *****/
        @Test
        public void get_piece_plateau_vide() {
                Plateau plateau = new Plateau();
                Assert.assertNull(plateau.getPiece(new Point(0, 0)));
        }

        @Test
        public void get_piece_invalide() {
                Plateau plateau = new Plateau();
                plateau.jouer(new Abeille(plateau.getJoueurBlanc()), new Point(0,0));
                Assert.assertNull(plateau.getPiece(new Point(1, 0)));
        }

        @Test
        public void get_piece_valide(){
                Plateau plateau = new Plateau();
                Abeille abeille = new Abeille(plateau.getJoueurBlanc());
                plateau.jouer(abeille, new Point(0,0));
                plateau.jouer(new Abeille(plateau.getJoueurBlanc()), new Point(1,0));
                Assert.assertTrue(plateau.getPiece(new Point(0, 0)).equals(abeille));
        }

        @Test
        public void get_piece_pile_valide(){
                Plateau plateau = new Plateau();
                Scarabee scarabee = new Scarabee(plateau.getJoueurNoir());
                Scarabee scarabee2 = new Scarabee(plateau.getJoueurBlanc());
                plateau.jouer(new Abeille(plateau.getJoueurBlanc()), new Point(0,0));
                plateau.jouer(scarabee, new Point(0,-1));
                plateau.jouer(scarabee2, new Point(0,1));
                plateau.jouer(scarabee, new Point(0,0));
                plateau.jouer(scarabee2, new Point(0,0));
                Assert.assertTrue(plateau.getPiece(new Point(0, 0)).equals(scarabee2));
        }

        /***** GET PIECE SIMPLE *****/
        @Test
        public void get_piece_base_plateau_vide() {
                Plateau plateau = new Plateau();
                Assert.assertNull(plateau.getPieceBase(new Point(0, 0)));
        }

        @Test
        public void get_piece_base_invalide() {
                Plateau plateau = new Plateau();
                plateau.jouer(new Abeille(plateau.getJoueurBlanc()), new Point(0,0));
                Assert.assertNull(plateau.getPieceBase(new Point(1, 0)));
        }

        @Test
        public void get_piece_base_valide(){
                Plateau plateau = new Plateau();
                Abeille abeille = new Abeille(plateau.getJoueurBlanc());
                plateau.jouer(abeille, new Point(0,0));
                plateau.jouer(new Abeille(plateau.getJoueurBlanc()), new Point(1,0));
                Assert.assertTrue(plateau.getPieceBase(new Point(0, 0)).equals(abeille));
        }

        @Test
        public void get_piece_base_pile_valide(){
                Plateau plateau = new Plateau();
                Abeille abeille = new Abeille(plateau.getJoueurBlanc());
                Scarabee scarabee = new Scarabee(plateau.getJoueurNoir());
                Scarabee scarabee2 = new Scarabee(plateau.getJoueurBlanc());
                plateau.jouer(scarabee, new Point(0,0));
                plateau.jouer(abeille, new Point(0,1));
                plateau.jouer(scarabee2, new Point(0,2));
                plateau.jouer(scarabee, new Point(0,1));
                plateau.jouer(scarabee2, new Point(0,1));
                Assert.assertTrue(plateau.getPieceBase(new Point(0, 1)).equals(abeille));
        }

        /***** FIN DE JEU *****/
        @Test
        public void perdant_sans_piece_impossible() {
                Plateau plateau = new Plateau();
                Assert.assertNull(plateau.perdant());
        }

        @Test
        public void perdant_avec_piece_sans_abeille_impossible() {
                Plateau plateau = new Plateau();
                plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, 0));
                plateau.placer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, -1));
                plateau.placer(new Scarabee(plateau.getJoueurBlanc()), new Point(0, 1));
                plateau.placer(new Sauterelle(plateau.getJoueurBlanc()), new Point(1, 1));
                plateau.placer(new Araignee(plateau.getJoueurBlanc()), new Point(1, 0));
                plateau.placer(new Fourmi(plateau.getJoueurBlanc()), new Point(-1, 1));
                plateau.placer(new Scarabee(plateau.getJoueurBlanc()), new Point(-1, 0));
                Assert.assertNull(plateau.perdant());
        }

        @Test
        public void perdant_avec_piece_avec_abeille_impossible() {
                Plateau plateau = new Plateau();
                plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, 0));
                plateau.placer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, -1));
                plateau.placer(new Scarabee(plateau.getJoueurBlanc()), new Point(0, 1));
                plateau.placer(new Sauterelle(plateau.getJoueurBlanc()), new Point(1, 1));
                plateau.placer(new Araignee(plateau.getJoueurBlanc()), new Point(1, 0));
                plateau.placer(new Fourmi(plateau.getJoueurBlanc()), new Point(-1, 1));
                plateau.placer(new Abeille(plateau.getJoueurBlanc()), new Point(-1, 0));
                Assert.assertNull(plateau.perdant());
        }

        @Test
        public void perdant_avec_piece_avec_abeille() {
                Plateau plateau = new Plateau();
                plateau.jouer(new Abeille(plateau.getJoueurBlanc()), new Point(0, 0));
                plateau.placer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, -1));
                plateau.placer(new Scarabee(plateau.getJoueurBlanc()), new Point(0, 1));
                plateau.placer(new Sauterelle(plateau.getJoueurBlanc()), new Point(1, 1));
                plateau.placer(new Araignee(plateau.getJoueurBlanc()), new Point(1, 0));
                plateau.placer(new Fourmi(plateau.getJoueurBlanc()), new Point(-1, 1));
                plateau.placer(new Scarabee(plateau.getJoueurBlanc()), new Point(-1, 0));
                Assert.assertTrue(plateau.perdant().equals(plateau.getJoueurBlanc()));
        }

        @Test
        public void deux_perdants_impossible() {
                Plateau plateau = new Plateau();
                plateau.jouer(new Abeille(plateau.getJoueurBlanc()), new Point(0, 0));
                plateau.placer(new Abeille(plateau.getJoueurNoir()), new Point(0, 1));
                plateau.placer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, -1));
                plateau.placer(new Sauterelle(plateau.getJoueurBlanc()), new Point(1,1));
                plateau.placer(new Araignee(plateau.getJoueurBlanc()), new Point(1,0));
                plateau.placer(new Fourmi(plateau.getJoueurBlanc()), new Point(-1,1));
                plateau.placer(new Fourmi(plateau.getJoueurBlanc()), new Point(-1,0));
                plateau.placer(new Scarabee(plateau.getJoueurBlanc()), new Point(0,2));
                plateau.placer(new Scarabee(plateau.getJoueurBlanc()), new Point(-1,2));
                plateau.placer(new Scarabee(plateau.getJoueurBlanc()), new Point(1, 2));
                Assert.assertNull(plateau.perdant());
        }

        @Test
        public void egalite_sans_piece_impossible() {
                Plateau plateau = new Plateau();
                Assert.assertFalse(plateau.egalite());
        }

        @Test
        public void egalite_avec_piece_sans_abeille_impossible() {
                Plateau plateau = new Plateau();
                plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, 0));
                plateau.placer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, -1));
                plateau.placer(new Scarabee(plateau.getJoueurBlanc()), new Point(0, 1));
                plateau.placer(new Sauterelle(plateau.getJoueurBlanc()), new Point(1, 1));
                plateau.placer(new Araignee(plateau.getJoueurBlanc()), new Point(1, 0));
                plateau.placer(new Fourmi(plateau.getJoueurBlanc()), new Point(-1, 1));
                plateau.placer(new Scarabee(plateau.getJoueurBlanc()), new Point(-1, 0));
                Assert.assertFalse(plateau.egalite());
        }

        @Test
        public void egalite_avec_piece_avec_abeille_impossible() {
                Plateau plateau = new Plateau();
                plateau.jouer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, 0));
                plateau.placer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, -1));
                plateau.placer(new Scarabee(plateau.getJoueurBlanc()), new Point(0, 1));
                plateau.placer(new Sauterelle(plateau.getJoueurBlanc()), new Point(1, 1));
                plateau.placer(new Araignee(plateau.getJoueurBlanc()), new Point(1, 0));
                plateau.placer(new Abeille(plateau.getJoueurBlanc()), new Point(-1, 1));
                plateau.placer(new Scarabee(plateau.getJoueurBlanc()), new Point(-1, 0));
                Assert.assertFalse(plateau.egalite());
        }

        @Test
        public void egalite_avec_piece_avec_abeille_gagnant_impossible() {
                Plateau plateau = new Plateau();
                plateau.jouer(new Abeille(plateau.getJoueurBlanc()), new Point(0, 0));
                plateau.placer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, -1));
                plateau.placer(new Scarabee(plateau.getJoueurBlanc()), new Point(0, 1));
                plateau.placer(new Sauterelle(plateau.getJoueurBlanc()), new Point(1, 1));
                plateau.placer(new Araignee(plateau.getJoueurBlanc()), new Point(1, 0));
                plateau.placer(new Fourmi(plateau.getJoueurBlanc()), new Point(-1, 1));
                plateau.placer(new Scarabee(plateau.getJoueurBlanc()), new Point(-1, 0));
                Assert.assertFalse(plateau.egalite());
        }

        @Test
        public void egalite_possible() {
                Plateau plateau = new Plateau();
                plateau.jouer(new Abeille(plateau.getJoueurBlanc()), new Point(0, 0));
                plateau.placer(new Abeille(plateau.getJoueurNoir()), new Point(0, 1));
                plateau.placer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, -1));
                plateau.placer(new Sauterelle(plateau.getJoueurBlanc()), new Point(1,1));
                plateau.placer(new Araignee(plateau.getJoueurBlanc()), new Point(1,0));
                plateau.placer(new Fourmi(plateau.getJoueurBlanc()), new Point(-1,1));
                plateau.placer(new Fourmi(plateau.getJoueurBlanc()), new Point(-1,0));
                plateau.placer(new Scarabee(plateau.getJoueurBlanc()), new Point(0,2));
                plateau.placer(new Scarabee(plateau.getJoueurBlanc()), new Point(-1,2));
                plateau.placer(new Scarabee(plateau.getJoueurBlanc()), new Point(1,2));
                Assert.assertTrue(plateau.egalite());
        }

        /***** REINITIALISER *****/
        @Test
        public void reinitialiser_plateau() {
                Plateau plateau = new Plateau();
                plateau.jouer(new Abeille(plateau.getJoueurBlanc()), new Point(0, 0));
                plateau.placer(new Abeille(plateau.getJoueurNoir()), new Point(0, 1));
                plateau.placer(new Fourmi(plateau.getJoueurBlanc()), new Point(0, -1));
                plateau.placer(new Sauterelle(plateau.getJoueurBlanc()), new Point(1, 1));
                plateau.placer(new Araignee(plateau.getJoueurBlanc()), new Point(1, 0));
                plateau.placer(new Fourmi(plateau.getJoueurBlanc()), new Point(-1,1));
                plateau.placer(new Fourmi(plateau.getJoueurBlanc()), new Point(-1,0));
                plateau.placer(new Scarabee(plateau.getJoueurBlanc()), new Point(0,2));
                plateau.placer(new Scarabee(plateau.getJoueurBlanc()), new Point(-1,2));
                plateau.placer(new Scarabee(plateau.getJoueurBlanc()), new Point(1,2));
                plateau.reinitialiser();
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
}