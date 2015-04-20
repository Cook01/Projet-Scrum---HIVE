import controleur.ControlGroup;
import model.Jeu;

public class application {
    public static void main (String argv[]) {
        Jeu jeu = new Jeu();
        new ControlGroup(jeu);
    }
}
