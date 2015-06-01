package controleur;

import model.Plateau;
import vue.Credit;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlMenu implements ActionListener {
    Fenetre fenetre;
    Plateau plateau;
    Credit credit;

    public ControlMenu(Fenetre f, Plateau p, Credit credit){
        this.fenetre = f;
        this.plateau = p;
        this.credit = credit;
        fenetre.setControlMenu(this);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==fenetre.jMenuItem){
            plateau.reinitialiser();
            fenetre.reinitialiser();
            fenetre.affichagePlateau(false, false);
            fenetre.revalidate();
        } else if (e.getSource()==fenetre.jMenuCredit) {
            credit.setVisible(true);
        }
    }

}
