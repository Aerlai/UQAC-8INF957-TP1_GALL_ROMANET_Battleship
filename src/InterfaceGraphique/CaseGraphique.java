package InterfaceGraphique;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by Malomek on 02/02/2018.
 */

public class CaseGraphique extends JPanel {

    int[] id;
    InterfaceUtilisateur interfaceUtilisateur;


    public CaseGraphique(int x, int y, InterfaceUtilisateur vue){
        super();
        this.id= new int[2];
        id[0]=x;
        id[1]=y;
        this.interfaceUtilisateur = vue;
        setBackground(Color.white);
        setLayout(new BorderLayout());

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseEntered(MouseEvent arg0) {
                super.mouseClicked(arg0);
               // if (vue.platteau1.getCase(id).getEtat()==0){}
            }

            @Override
            public void mouseExited(MouseEvent arg0) {
                super.mouseExited(arg0);
                //if (vue.platteau1.getCase(id).getEtat()!=0);
            }

            @Override
            public void mousePressed(MouseEvent arg0) {
                if (arg0.getButton() == 3) {
                } else {

                }
            }
        });
        }

}
