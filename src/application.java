import controleur.ControlGroup;
import model.Plateau;

public class application {
    public static void main (String argv[]) {
        Plateau plateau = new Plateau();
        new ControlGroup(plateau);
    }
}
