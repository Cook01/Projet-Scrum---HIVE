package controleur.ControlBouton;

import model.Plateau;
import vue.Credit;
import vue.Fenetre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlBoutonCacher implements ActionListener {
    Credit credit;
    Plateau plateau;

    public ControlBoutonCacher(Plateau plateau, Credit credit) {
        this.plateau = plateau;
        this.credit = credit;

        credit.setControlBoutonCacher(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        credit.setVisible(false);
    }
}
