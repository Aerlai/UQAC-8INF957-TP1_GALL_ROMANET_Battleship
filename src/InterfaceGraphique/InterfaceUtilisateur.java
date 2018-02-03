package InterfaceGraphique;

import Carte.Carte;

import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import javax.swing.border.Border;

public class InterfaceUtilisateur extends JFrame implements Observer, ActionListener {

    Carte platteau1;
    Carte platteau2;
    Carte platteau3;
    Carte platteau4;
    int tailleX;
    int tailleY;

    CaseGraphique[][] cases ;

    JMenuItem nouvellepartie;
    JMenuItem sauvegarder;
    JMenuItem charger;


    public InterfaceUtilisateur(Carte carte){

        this.platteau1 =Carte.randomCarte();
        this.platteau2 =Carte.randomCarte();
        this.platteau3 =Carte.randomCarte();
        this.platteau4 =Carte.randomCarte();

        this.tailleX=carte.getTailleX();
        this.tailleY=carte.getTailleY();


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Battleship+");
        setSize(tailleX*2, tailleY*2);

        JMenuBar barremenu = new JMenuBar();
        JMenu menu = new JMenu("Jeu");

        nouvellepartie = new JMenuItem("Nouvelle Partie");
        nouvellepartie.addActionListener(this);
        sauvegarder = new JMenuItem("Sauvegarder");
        sauvegarder.addActionListener(this);

        menu.add(nouvellepartie);
        menu.add(sauvegarder);

        barremenu.add(menu);
        setJMenuBar(barremenu);

        JComponent jc = new JPanel (new GridLayout(tailleY*2, tailleX*2));
        Border limite = BorderFactory.createLineBorder(Color.black,1);

        cases = new CaseGraphique[tailleX*2][tailleY*2];

        for(int i = 0; i < tailleX; i++){
            for(int j = 0; j< tailleY; j++){
                CaseGraphique cg = new CaseGraphique(i,j, this);
                platteau1.getCase(i, j).addObserver(this);
                cases[i][j]=cg;
                cg.setBorder(limite);
                jc.add(cg);
            }
        }
        jc.setBorder(limite);


        for(int i = 0; i < tailleX; i++){
            for(int j = tailleY; j< tailleY*2; j++){
                CaseGraphique cg = new CaseGraphique(i,j, this);
                platteau2.getCase(i, j-tailleY).addObserver(this);
                cases[i][j]=cg;
                cg.setBorder(limite);
                jc.add(cg);
            }
        }
        jc.setBorder(limite);

        for(int i = tailleX; i < tailleX*2; i++){
            for(int j = 0; j< tailleY; j++){
                CaseGraphique cg = new CaseGraphique(i,j, this);
                platteau3.getCase(i-tailleX, j).addObserver(this);
                cases[i][j]=cg;
                cg.setBorder(limite);
                jc.add(cg);
            }
        }
        jc.setBorder(limite);

        for(int i = tailleX; i < tailleX*2; i++){
            for(int j = tailleY; j< tailleY*2; j++){
                CaseGraphique cg = new CaseGraphique(i,j, this);
                platteau4.getCase(i-tailleX, j-tailleY).addObserver(this);
                cases[i][j]=cg;
                cg.setBorder(limite);
                jc.add(cg);
            }
        }

        jc.setBorder(limite);

        add(jc);
        setContentPane(jc);

        platteau1.addObserver(this);
        platteau2.addObserver(this);
        platteau3.addObserver(this);
        platteau4.addObserver(this);
    }

    public static void run(){

            InterfaceUtilisateur ui = new InterfaceUtilisateur(new Carte());
            ui.setVisible(true);
            ui.update(ui.platteau1, ui);

    }


    @Override
    @SuppressWarnings("empty-statement")
    public void update(Observable o, Object arg) {
        boolean findujeu = false;
        boolean defaite = false;
        int etat;
        JLabel label;
        String texte;



        int id=0;
        for(int i=0;i<tailleX;i++)
        {
            for(int j=0;j<tailleY;j++)
            {   id = platteau1.getCase(i, j).getID();
                paintCase(cases[i][j], id);
                cases[i][j].validate();
                cases[i][j].repaint();
            }
        }
        for(int i=0;i<tailleX;i++)
        {
            for(int j=tailleY;j<tailleY*2;j++)
            {   id = platteau2.getCase(i, j-tailleY).getID();
                paintCase(cases[i][j], id);
                cases[i][j].validate();
                cases[i][j].repaint();
            }
        }
        for(int i=tailleX;i<tailleX*2;i++)
        {
            for(int j=0;j<tailleY;j++)
            {   id = id = platteau3.getCase(i-tailleX, j).getID();
                paintCase(cases[i][j], id);
                cases[i][j].validate();
                cases[i][j].repaint();
            }
        }
        for(int i=tailleX;i<tailleX*2;i++)
        {
            for(int j=tailleY;j<tailleY*2;j++)
            {   id=id = platteau4.getCase(i-tailleX, j-tailleY).getID();
                paintCase(cases[i][j], id);
                cases[i][j].validate();
                cases[i][j].repaint();
            }
        }

    }

    public void paintCase(CaseGraphique casegraphique, int id){

        switch (id){
            case 1:casegraphique.setBackground(Color.GRAY);break;
            case 2:casegraphique.setBackground(Color.GRAY);break;
            case 3:casegraphique.setBackground(Color.GRAY);break;
            case 4:casegraphique.setBackground(Color.GRAY);break;
            case 5:casegraphique.setBackground(Color.RED);break;
            case 6:casegraphique.setBackground(Color.GRAY);break;
            default:casegraphique.setBackground(Color.GRAY);break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == nouvellepartie){
            this.setVisible(false);
            InterfaceUtilisateur iu;
            iu = new InterfaceUtilisateur(new Carte());
            iu.setVisible(true);
        }
        if(e.getSource() == sauvegarder){
            //platteau1.sauvegarder();
            JOptionPane.showMessageDialog(rootPane, "La partie a été sauvegardée");
        }
        if(e.getSource() == charger){
            this.setVisible(false);
            InterfaceUtilisateur iu;
            iu = new InterfaceUtilisateur(new Carte());
            iu.setVisible(true);
            iu.update(platteau1, iu);
        }

    }

}

    /*public InterfaceUtilisater(){
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

        this.setContentPane(new PlateauDouble());

        //On rend la fenetre visible
        this.setVisible(true);
    }*/


