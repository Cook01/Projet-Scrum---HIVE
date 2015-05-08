package model;

import model.typePiece.Fourmi;
import model.typePiece.Abeille;
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
        public void liste_placement_possible() {
                Plateau plateau = new Plateau();
                Abeille abeille = new Abeille(new Joueur("Blanc"));

                plateau.placer(abeille, new Point(0,0));
                Assert.assertTrue(abeille.getVoisinNull().contains(new Point(0, 1)));
                Assert.assertTrue(abeille.getVoisinNull().contains(new Point(1, 1)));
                Assert.assertTrue(abeille.getVoisinNull().contains(new Point(1, 0)));
                Assert.assertTrue(abeille.getVoisinNull().contains(new Point(0, -1)));
                Assert.assertTrue(abeille.getVoisinNull().contains(new Point(-1, 1)));
                Assert.assertTrue(abeille.getVoisinNull().contains(new Point(-1, 0)));
        }

        @Test
        public void liste_placement_possible_avec_une_piece_autour() {
                Plateau plateau = new Plateau();
                Abeille abeille = new Abeille(new Joueur("Blanc"));
                Fourmi fourmi = new Fourmi(new Joueur("Blanc"));

                plateau.placer(abeille, new Point(0, 0));
                plateau.placer(fourmi, new Point(0, 1));
                Assert.assertFalse(abeille.getVoisinNull().contains(new Point(0, 1)));
                Assert.assertTrue(abeille.getVoisinNull().contains(new Point(1, 1)));
                Assert.assertTrue(abeille.getVoisinNull().contains(new Point(1, 0)));
                Assert.assertTrue(abeille.getVoisinNull().contains(new Point(0, -1)));
                Assert.assertTrue(abeille.getVoisinNull().contains(new Point(-1, 1)));
                Assert.assertTrue(abeille.getVoisinNull().contains(new Point(-1, 0)));
        }

        @Test
        public void liste_placement_possible_vide() {
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
                plateau.placer(fourmi5, new Point(-1, 1));
                plateau.placer(fourmi6, new Point(-1, 0));
                Assert.assertTrue(abeille.getVoisinNull().size() == 0);
        }


}