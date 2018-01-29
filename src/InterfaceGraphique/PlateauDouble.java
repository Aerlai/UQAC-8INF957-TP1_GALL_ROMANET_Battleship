package InterfaceGraphique;

import javax.swing.*;
import java.awt.*;

public class PlateauDouble extends JPanel {

    public void paintComponent(Graphics g){

        // JOUEAUR A
        // On génère la grille d'impacts
        for(int x = 1; x <= 10; x++){
            for(int y = 1; y <= 10; y++){
                g.drawRoundRect(10+x*30, 5+y*30, 25, 25, 10, 10);
            }
        }

        // On génère la grille de bateaux
        for(int x = 1; x <= 10; x++){
            for(int y = 1; y <= 10; y++){
                g.drawRoundRect(10+x*30, 320+y*30, 25, 25, 10, 10);
            }
        }

        // JOUEAUR B
        // On génère la grille d'impacts
        for(int x = 1; x <= 10; x++){
            for(int y = 1; y <= 10; y++){
                g.drawRoundRect(630+x*30, 5+y*30, 25, 25, 10, 10);
            }
        }

        // On génère la grille de bateaux
        for(int x = 1; x <= 10; x++){
            for(int y = 1; y <= 10; y++){
                g.drawRoundRect(630+x*30, 320+y*30, 25, 25, 10, 10);
            }
        }

        //g.fillRoundRect(55, 65, 55, 30, 5, 5);

    }
}
