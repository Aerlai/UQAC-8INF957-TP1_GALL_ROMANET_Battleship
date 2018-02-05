package InterfaceGraphique;

import Carte.Carte;
import Noyau.ImplementationJoueur;
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

    CaseGraphique[][] cases1 ;//Grille Bateaux joueurA
    CaseGraphique[][] cases2 ;//Grille Impacts joueurA
    CaseGraphique[][] cases3 ;//Grille Impacts joueurB
    CaseGraphique[][] cases4 ;//Grille Bateaux joueurB

    JMenuItem nouvellepartie;
    JMenuItem sauvegarder;
    JMenuItem charger;

    boolean fin; //indicateur si la partie est terminée ou non


    public InterfaceUtilisateur(Joueur joueurA, Joueur joueurB ){

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Battleship+");
        this.setSize(1000, 700);

        JMenuBar barremenu = new JMenuBar();
        JMenu menu = new JMenu("Jeu");

        //la barre de menu avec les éléments ci dessous n'est pas encore fonctionnelle
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
        //mainjc.add(labelA);
        //mainjc.add(labelB);
        mainjc.add(jc3);
        mainjc.add(jc4);
        add(mainjc);
        setContentPane(mainjc);

        /*joueurA.getCarteBateaux().addObserver(this);
        joueurA.getCarteImpacts().addObserver(this);
        joueurB.getCarteBateaux().addObserver(this);
        joueurB.getCarteImpacts().addObserver(this);*/

        this.setVisible(true);

        this.updatemapspecifique(joueurA.getCarteBateaux(),1);
        this.updatemapspecifique(joueurA.getCarteImpacts(),2);
        this.updatemapspecifique(joueurB.getCarteBateaux(),4);
        this.updatemapspecifique(joueurB.getCarteImpacts(),3);
        ajoutBateaux(joueurA,1);
        ajoutBateaux(joueurB,2);

        fin=false;
        int tourjoueur=0;
        while(!fin){
            if(tourjoueur==0){
                tour(joueurA, tourjoueur, joueurB);
            }
            if(tourjoueur==1){
                tour(joueurB, tourjoueur, joueurA);
            }
            tourjoueur++;
            if(tourjoueur>1)tourjoueur=0;
        }
        fin();
        this.setVisible(false);
    }

    @Override
    public void update(Observable o, Object arg){


    }

    //Ici on met à jour une grille de l'interface specifique en fonction de la carte du jeu qui lui correspond
    public void updatemapspecifique(Carte map, int numcarte) {
        int id=0;
        for(int i=0;i<tailleX;i++)
        {
            for(int j=0;j<tailleY;j++)
            {   id = map.verification(i,j);
                if(numcarte==1){
                    paintCase(cases1[i][j], id);
                    cases1[i][j].validate();
                    cases1[i][j].repaint();
                }
                if(numcarte==2){
                    paintCase(cases2[i][j], id);
                    cases2[i][j].validate();
                    cases2[i][j].repaint();
                }
                if(numcarte==3){
                    paintCase(cases3[i][j], id);
                    cases3[i][j].validate();
                    cases3[i][j].repaint();
                }
                if(numcarte==4){
                    paintCase(cases4[i][j], id);
                    cases4[i][j].validate();
                    cases4[i][j].repaint();
                }
            }
        }
    }

    //Repeint une case en fonction de son contenu
    public void paintCase(CaseGraphique casegraphique, int id){
        switch (id){
            case 1:casegraphique.setBackground(Color.BLUE);break; //porteAvion
            case 2:casegraphique.setBackground(Color.GREEN);break; //croiseur
            case 3:casegraphique.setBackground(Color.YELLOW);break; //contreTorpilleur
            case 4:casegraphique.setBackground(Color.MAGENTA);break; //sousMarin
            case 5:casegraphique.setBackground(Color.PINK);break; //Torpilleur
            case 6:casegraphique.setBackground(Color.GRAY);break; //vide
            case 7:casegraphique.setBackground(Color.ORANGE);break; //impact
            case 8:casegraphique.setBackground(Color.RED);break;   //impact sur bateau

            default:casegraphique.setBackground(Color.GRAY);break;
        }
    }

    public void ajoutBateaux(Joueur joueur, int numjoueur){  //Cette procédure permet à un joueur de placer tous ses bateaux un par un

        String choixdujoueur;
        String nomjoueur="";
        if(numjoueur-1==0)nomjoueur="JOUEUR A";
        if(numjoueur-1==1)nomjoueur="JOUEUR B";
        String bateaux[] = new String[5];
        bateaux[0] ="Torpilleur";
        bateaux[1] ="SousMarin";
        bateaux[2] ="Croiseur";
        bateaux[3] ="ContreTorpilleur";
        bateaux[4] ="PorteAvion";
        int idbateau=0;
        int choix[] = new int[2];
        String emplacementtete = "";

        for(int i=0;i<bateaux.length;i++){
            choix[0]=-1;choix[1]=-1;
            boolean valid;
            valid = true;
            while(valid) {
                try {
                    while (choix[0] < 0 || choix[0] > tailleY || choix[1] < 0 || choix[1] > tailleY) {
                        String Texte = nomjoueur + ", placer  le " + bateaux[i] + " (merci d'utiliser le format \"x y POSITION\" avec position= H B G D\n";
                        choixdujoueur = JOptionPane.showInputDialog(Texte);
                        if(choixdujoueur == null) System.exit(0);
                        choix[0] = Integer.parseInt(choixdujoueur.split(" ")[0]);
                        choix[1] = Integer.parseInt(choixdujoueur.split(" ")[1]);
                        emplacementtete = choixdujoueur.split(" ")[2];
                    }
                    valid = false;

                    switch (bateaux[i]){
                        case "Torpilleur":idbateau=5;break;
                        case "SousMarin":idbateau=4;break;
                        case "Croiseur":idbateau=2;break;
                        case "ContreTorpilleur":idbateau=3;break;
                        case "PorteAvion":idbateau=1;break;
                    }
                    System.out.println("idbateau : "+ idbateau);
                    switch(emplacementtete){
                        case "H":joueur.placerhaut(idbateau,choix[0],choix[1]);break;
                        case "B":joueur.placerbas(idbateau,choix[0],choix[1]);break;
                        case "G":joueur.placergauche(idbateau,choix[0],choix[1]);break;
                        case "D":joueur.placerdroite(idbateau,choix[0],choix[1]);break;
                    }
                    if(numjoueur==1){
                        this.updatemapspecifique(joueur.getCarteBateaux(),1);
                    }
                    if(numjoueur==2){
                        this.updatemapspecifique(joueur.getCarteBateaux(),4);

                    }
                } catch (Exception e) {
                    System.out.println("mauvaise expression");
                }
            }
        }
    }

    public void fin(){  //Cette fonction affiche un message de fin du jeu
        String texte = "Le jeu est fini !";
        JOptionPane.showInputDialog(texte);
    }

    public void tour(Joueur joueur, int numjoueur, Joueur adversaire){ //demande à un joueur ce qu'il veut faire durant son tour et execute son choix
        String choixdujoueur;
        int choix;
        String nomjoueur="";
        if(numjoueur==0)nomjoueur="JOUEUR A";
        if(numjoueur==1)nomjoueur="JOUEUR B";
        try {
            String Texte = "Choisissez une action " + nomjoueur + " :\n";
            Texte += "1 : TIR \n";
            Texte += "2 : DEPLACEMENT \n";
            Texte += "3 : PASSER LE TOUR\n";
            do {
                choixdujoueur = JOptionPane.showInputDialog(Texte);
                if(choixdujoueur == null) System.exit(0);
                choix = Integer.parseInt(choixdujoueur);
            } while (choix != 1 && choix != 2 && choix != 3);

            if (choix == 3) {
                joueur.tourFini();
                return;
            }
            if (choix == 2) {
                deplacer(joueur, numjoueur, adversaire);
            }
            if (choix == 1) {
                attaque(joueur, numjoueur, adversaire);
            }
        }catch (Exception e){
            System.out.println("Mauvaise expression");
        }
    }

    private void deplacer(Joueur joueur, int numjoueur, Joueur adversaire){ //TODO

    }

    //Si il choisit de tirer cette fonction permet au joueur d'attaquer avec chacun de ses navires restants un par un
    private void attaque(Joueur joueur, int numjoueur, Joueur adversaire){
        int choixtir[]= new int[2];
        String choixdujoueur="";
        String nomjoueur="";
        if(numjoueur==0)nomjoueur="JOUEUR A";
        if(numjoueur==1)nomjoueur="JOUEUR B";
        String Texte;
        boolean valid;

        // Porte Avion
        if(joueur.getPorteAvion().isMort() == false && adversaire.estVivant()) {
            valid = true;
            while(valid) {
                try {
                    choixtir[0] = -1;
                    choixtir[1] = -1;
                    while (choixtir[0] < 0 || choixtir[0] > tailleY || choixtir[1] < 0 || choixtir[1] > tailleY) {
                        Texte = nomjoueur + ", Quelles sont les coordonnées à viser par le porte-avions ?\n";
                        choixdujoueur = JOptionPane.showInputDialog(Texte);
                        choixtir[0] = Integer.parseInt(choixdujoueur.split(" ")[0]);
                        choixtir[1] = Integer.parseInt(choixdujoueur.split(" ")[1]);
                    }
                    if(choixdujoueur != null) {
                        // Attaque
                        joueur.attaquer((ImplementationJoueur) adversaire, joueur.getPorteAvion(), choixtir[0], choixtir[1]);
                        // Update de la map
                        if (numjoueur == 0) {
                            updatemapspecifique(adversaire.getCarteBateaux(), 4);
                            updatemapspecifique(joueur.getCarteImpacts(), 2);
                        }
                        if (numjoueur == 1) {
                            updatemapspecifique(adversaire.getCarteBateaux(), 1);
                            updatemapspecifique(joueur.getCarteImpacts(), 3);
                        }
                    }
                    valid = false;
                } catch (Exception e) {
                    System.out.println("Mauvaise expression");
                }
            }
        }

        // Croiseur
        if(joueur.getCroiseur().isMort() == false && adversaire.estVivant()){
            valid = true;
            while(valid) {
                try {
                    choixtir[0] = -1;
                    choixtir[1] = -1;
                    while (choixtir[0] < 0 || choixtir[0] > tailleY || choixtir[1] < 0 || choixtir[1] > tailleY) {
                        Texte = nomjoueur + ", Quelles sont les coordonnées à viser par le croiseur ?\n";
                        choixdujoueur = JOptionPane.showInputDialog(Texte);
                        choixtir[0] = Integer.parseInt(choixdujoueur.split(" ")[0]);
                        choixtir[1] = Integer.parseInt(choixdujoueur.split(" ")[1]);
                    }
                    if(choixdujoueur != null) {
                        // Attaque
                        joueur.attaquer((ImplementationJoueur) adversaire, joueur.getCroiseur(), choixtir[0], choixtir[1]);
                        // Update de la map
                        if (numjoueur == 0) {
                            updatemapspecifique(adversaire.getCarteBateaux(), 4);
                            updatemapspecifique(joueur.getCarteImpacts(), 2);
                        }
                        if (numjoueur == 1) {
                            updatemapspecifique(adversaire.getCarteBateaux(), 1);
                            updatemapspecifique(joueur.getCarteImpacts(), 3);
                        }
                    }
                    valid = false;
                } catch (Exception e) {
                    System.out.println("Mauvaise expression");
                }
            }
        }

        // Contre torpilleur
        if(joueur.getContreTorpilleur().isMort() == false && adversaire.estVivant()){
            valid = true;
            while(valid) {
                try {
                    choixtir[0] = -1;
                    choixtir[1] = -1;
                    while (choixtir[0] < 0 || choixtir[0] > tailleY || choixtir[1] < 0 || choixtir[1] > tailleY) {
                        Texte = nomjoueur + ", Quelles sont les coordonnées à viser par le contre torpilleur ?\n";
                        choixdujoueur = JOptionPane.showInputDialog(Texte);
                        choixtir[0] = Integer.parseInt(choixdujoueur.split(" ")[0]);
                        choixtir[1] = Integer.parseInt(choixdujoueur.split(" ")[1]);
                    }
                    if(choixdujoueur != null) {
                        // Attaque
                        joueur.attaquer((ImplementationJoueur) adversaire, joueur.getContreTorpilleur(), choixtir[0], choixtir[1]);
                        // Update de la map
                        if (numjoueur == 0) {
                            updatemapspecifique(adversaire.getCarteBateaux(), 4);
                            updatemapspecifique(joueur.getCarteImpacts(), 2);
                        }
                        if (numjoueur == 1) {
                            updatemapspecifique(adversaire.getCarteBateaux(), 1);
                            updatemapspecifique(joueur.getCarteImpacts(), 3);
                        }
                    }
                    valid = false;
                } catch (Exception e) {
                    System.out.println("Mauvaise expression");
                }
            }
        }

        // Sous marin
        if(joueur.getSousMarrin().isMort() == false && adversaire.estVivant()){
            valid = true;
            while(valid) {
                try {
                    choixtir[0] = -1;
                    choixtir[1] = -1;
                    while (choixtir[0] < 0 || choixtir[0] > tailleY || choixtir[1] < 0 || choixtir[1] > tailleY) {
                        Texte = nomjoueur + ", Quelles sont les coordonnées à viser par le sous marin ?\n";
                        choixdujoueur = JOptionPane.showInputDialog(Texte);
                        choixtir[0] = Integer.parseInt(choixdujoueur.split(" ")[0]);
                        choixtir[1] = Integer.parseInt(choixdujoueur.split(" ")[1]);
                    }
                    if(choixdujoueur != null) {
                        // Attaque
                        joueur.attaquer((ImplementationJoueur) adversaire, joueur.getSousMarrin(), choixtir[0], choixtir[1]);
                        // Update de la map
                        if (numjoueur == 0) {
                            updatemapspecifique(adversaire.getCarteBateaux(), 4);
                            updatemapspecifique(joueur.getCarteImpacts(), 2);
                        }
                        if (numjoueur == 1) {
                            updatemapspecifique(adversaire.getCarteBateaux(), 1);
                            updatemapspecifique(joueur.getCarteImpacts(), 3);
                        }
                    }
                    valid = false;
                } catch (Exception e) {
                    System.out.println("Mauvaise expression");
                }
            }
        }

        // Torpilleur
        if(joueur.getTorpilleur().isMort() == false && adversaire.estVivant()){
            valid = true;
            while(valid) {
                try {
                    choixtir[0] = -1;
                    choixtir[1] = -1;
                    while (choixtir[0] < 0 || choixtir[0] > tailleY || choixtir[1] < 0 || choixtir[1] > tailleY) {
                        Texte = nomjoueur + ", Quelles sont les coordonnées à viser par le torpilleur ?\n";
                        choixdujoueur = JOptionPane.showInputDialog(Texte);
                        choixtir[0] = Integer.parseInt(choixdujoueur.split(" ")[0]);
                        choixtir[1] = Integer.parseInt(choixdujoueur.split(" ")[1]);
                    }
                    if(choixdujoueur != null) {
                        // Attaque
                        joueur.attaquer((ImplementationJoueur) adversaire, joueur.getTorpilleur(), choixtir[0], choixtir[1]);
                        // Update de la map
                        if (numjoueur == 0) {
                            updatemapspecifique(adversaire.getCarteBateaux(), 4);
                            updatemapspecifique(joueur.getCarteImpacts(), 2);
                        }
                        if (numjoueur == 1) {
                            updatemapspecifique(adversaire.getCarteBateaux(), 1);
                            updatemapspecifique(joueur.getCarteImpacts(), 3);
                        }
                    }
                    valid = false;
                } catch (Exception e) {
                    System.out.println("Mauvaise expression");
                }
            }
        }
        if(!adversaire.estVivant()){
            fin=true;
        }
    }


    //@Override
    public void actionPerformed(ActionEvent e) {
    }

}

