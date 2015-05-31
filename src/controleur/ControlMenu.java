package controleur;

import model.Plateau;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlMenu implements ActionListener {
    Fenetre fenetre;
    Plateau plateau;

    public ControlMenu(Fenetre f, Plateau p){
        this.fenetre = f;
        this.plateau = p;
        fenetre.setControlMenu(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==fenetre.jMenuItem){
            plateau.reinitialiser();
            fenetre.reinitialiser();
            fenetre.affichagePlateau(false, false);
            fenetre.revalidate();
        }
    }

}
