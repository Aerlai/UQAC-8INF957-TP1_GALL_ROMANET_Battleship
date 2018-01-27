package InterfaceGraphique;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class InterfaceUtilisateur extends JFrame {

    public InterfaceUtilisateur(){
        //Définit un titre pour notre fenêtre
        this.setTitle("BattleShip+");
        //Définit sa taille : 400 pixels de large et 100 pixels de haut
        this.setSize(1000, 700);
        //Nous demandons maintenant à notre objet de se positionner au centre
        this.setLocationRelativeTo(null);
        //Termine le processus lorsqu'on clique sur la croix rouge
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //On limite le resize
        this.setResizable(false);

        this.setContentPane(new PlateauDeJeuA());

        //On rend la fenetre visible
        this.setVisible(true);
    }

}
