package InterfaceGraphique;

import Carte.Carte;
import Noyau.Joueur;

import java.awt.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;
import javax.swing.border.Border;

public class InterfaceUtilisateur extends JFrame implements Observer, ActionListener {

    int tailleX = 10;
    int tailleY = 10;

    CaseGraphique[][] cases1 ;
    CaseGraphique[][] cases2 ;
    CaseGraphique[][] cases3 ;
    CaseGraphique[][] cases4 ;

    JMenuItem nouvellepartie;
    JMenuItem sauvegarder;
    JMenuItem charger;


    public InterfaceUtilisateur(Joueur joueurA, Joueur joueurB ){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Battleship+");
        this.setSize(1000, 700);

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


        JComponent mainjc = new JPanel (new GridLayout(2, 2));
        JComponent jc1 = new JPanel (new GridLayout(tailleY, tailleX));
        JComponent jc2 = new JPanel (new GridLayout(tailleY, tailleX));
        JComponent jc3 = new JPanel (new GridLayout(tailleY, tailleX));
        JComponent jc4 = new JPanel (new GridLayout(tailleY, tailleX));

        Border limitecase = BorderFactory.createLineBorder(Color.black,1);
        Border limitegrille = BorderFactory.createLineBorder(Color.black,7);


        cases1 = new CaseGraphique[tailleX][tailleY];
        cases2 = new CaseGraphique[tailleX][tailleY];
        cases3 = new CaseGraphique[tailleX][tailleY];
        cases4 = new CaseGraphique[tailleX][tailleY];


        for(int i = 0; i < tailleX; i++){
            for(int j = 0; j< tailleY; j++){
                CaseGraphique cg = new CaseGraphique(i,j, this);
                joueurA.getCarteImpacts().getCase(i, j).addObserver(this);
                cases2[i][j]=cg;
                cg.setBorder(limitecase);
                jc1.add(cg);
            }
        }
        jc1.setBorder(limitegrille);

        for(int i = 0; i < tailleX; i++){
            for(int j = 0; j< tailleY; j++){
                CaseGraphique cg = new CaseGraphique(i,j, this);
                joueurB.getCarteImpacts().getCase(i, j).addObserver(this);
                cases3[i][j]=cg;
                cg.setBorder(limitecase);
                jc2.add(cg);
            }
        }
        jc2.setBorder(limitegrille);

        for(int i = 0; i < tailleX; i++){
            for(int j = 0; j< tailleY; j++){
                CaseGraphique cg = new CaseGraphique(i,j, this);
                joueurA.getCarteBateaux().getCase(i, j).addObserver(this);
                cases1[i][j]=cg;
                cg.setBorder(limitecase);
                jc3.add(cg);
            }
        }
        jc3.setBorder(limitegrille);


        for(int i = 0; i < tailleX; i++){
            for(int j = 0; j< tailleY; j++){
                CaseGraphique cg = new CaseGraphique(i,j, this);
                joueurB.getCarteBateaux().getCase(i, j).addObserver(this);
                cases4[i][j]=cg;
                cg.setBorder(limitecase);
                jc4.add(cg);
            }
        }
        jc4.setBorder(limitegrille);


        mainjc.add(jc1);
        mainjc.add(jc2);
        mainjc.add(jc3);
        mainjc.add(jc4);
        add(mainjc);
        setContentPane(mainjc);

        joueurA.getCarteBateaux().addObserver(this);
        joueurA.getCarteImpacts().addObserver(this);
        joueurB.getCarteBateaux().addObserver(this);
        joueurB.getCarteImpacts().addObserver(this);

        this.setVisible(true);

        this.updatemap(joueurA.getCarteBateaux());
        this.updatemap(joueurA.getCarteImpacts());
        this.updatemap(joueurB.getCarteBateaux());
        this.updatemap(joueurB.getCarteImpacts());
    }

    @Override
    public void update(Observable o, Object arg){


    }

    public void updatemap(Carte map ) {
        boolean findujeu = false;
        boolean defaite = false;
        int etat;
        JLabel label;
        String texte;



        int id=0;
        for(int i=0;i<tailleX;i++)
        {
            for(int j=0;j<tailleY;j++)
            {   id = map.verification(i,j);
                paintCase(cases1[i][j], id);
                cases1[i][j].validate();
                cases1[i][j].repaint();
                paintCase(cases2[i][j], id);
                cases2[i][j].validate();
                cases2[i][j].repaint();
                paintCase(cases3[i][j], id);
                cases3[i][j].validate();
                cases3[i][j].repaint();
                paintCase(cases4[i][j], id);
                cases4[i][j].validate();
                cases4[i][j].repaint();
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

    //@Override
    public void actionPerformed(ActionEvent e) {
/*
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
        */

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


