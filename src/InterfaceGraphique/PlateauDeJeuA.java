package InterfaceGraphique;

import java.awt.Graphics;
import javax.swing.JPanel;

public class PlateauDeJeuA extends JPanel{

    public void paintComponent(Graphics g){
        //Vous verrez cette phrase chaque fois que la méthode sera invoquée
        System.out.println("Je suis exécutée !");

        // On génère la grille d'impacts
        for(int x = 1; x <= 10; x++){
            for(int y = 1; y <= 10; y++){
                g.drawRoundRect(10+x*30, 10+y*30, 25, 25, 10, 10);
            }
        }

        // On génère la grille de bateaux
        for(int x = 1; x <= 10; x++){
            for(int y = 1; y <= 10; y++){
                g.drawRoundRect(10+x*30, 290+y*30, 25, 25, 10, 10);
            }
        }

        //g.fillRoundRect(55, 65, 55, 30, 5, 5);

    }
}