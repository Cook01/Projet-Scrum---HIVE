package controleur.ControlBouton;

import model.Plateau;
import vue.Credit;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlBoutonCredit implements ActionListener {
    Fenetre fenetre;
    Plateau plateau;
    Credit credit;

    public ControlBoutonCredit(Plateau plateau, Fenetre fenetre, Credit credit) {
        this.plateau = plateau;
        this.fenetre = fenetre;
        this.credit = credit;

        fenetre.setControlBoutonCredit(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        credit.setVisible(true);
    }
}
