package Carte;

import Noyau.ImplementationJoueur;

import java.util.Observable;
import java.util.concurrent.ThreadLocalRandom;

public class Carte extends Observable {

    public int TailleX=10;
    public int tailleY=10;

    private Element matrice[][] = {{null,null,null,null,null,null,null,null,null,null},
                          {null,null,null,null,null,null,null,null,null,null},
                          {null,null,null,null,null,null,null,null,null,null},
                          {null,null,null,null,null,null,null,null,null,null},
                          {null,null,null,null,null,null,null,null,null,null},
                          {null,null,null,null,null,null,null,null,null,null},
                          {null,null,null,null,null,null,null,null,null,null},
                          {null,null,null,null,null,null,null,null,null,null},
                          {null,null,null,null,null,null,null,null,null,null},
                          {null,null,null,null,null,null,null,null,null,null}};

    public Carte(){
        matrice = new Element[10][10];
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                matrice[i][j]= new Element(false, false, 6);
            }
        }

    }

    public static Carte randomCarte(){
        int TailleX=10, tailleY =10;
        Carte carte = new Carte();
        carte.matrice = new Element[TailleX][tailleY];
        int randomx = 0;
        int randomy = 0;
        boolean deployed = false;

        //torpilleur
        while(!deployed){
            randomx = ThreadLocalRandom.current().nextInt(0, TailleX );
            randomy = ThreadLocalRandom.current().nextInt(0, tailleY );
            if(carte.matrice[randomx][randomy]==null){
                carte.placerBateau(randomx,randomy,5,true);
                deployed=true;
            }
        }
    deployed=false;
        while(!deployed){
            randomx = ThreadLocalRandom.current().nextInt(0, TailleX );
            randomy = ThreadLocalRandom.current().nextInt(0, tailleY );
            if(carte.matrice[randomx][randomy]==null){
                carte.placerBateau(randomx,randomy,5,true);
                deployed=true;
            }
        }

        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if(carte.matrice[i][j]==null){
                    carte.matrice[i][j]= new Element(false, false, 6);
                }
            }
        }
        return carte;
    }

    // méthode d'ajout d'impacts
    public void placerImpact(int x, int y){
        matrice[x][y]= new Element(false,false,6);
    }
    // méthode d'ajout d'impacts
    public void placerImpactBateau(int x, int y){
        matrice[x][y]= new Element(true,false,6);
    }
    // méthode d'ajout de bateaux
    public void placerBateau(int x, int y, int id, boolean avant){
        matrice[x][y]= new Element(true, avant, id);
    }
    // méthode de vérification d'une position
    public int verification(int x, int y) {
        if (matrice[x][y] != null) return matrice[x][y].getID();
        return 0; // 0 = rien
    }
    // rafraichir la carte
    public void refresh(ImplementationJoueur joueur){
        // on efface les données
        for(int i=0;i<10;i++){
            for (int j=0;j<10;j++ ){
                matrice[i][j]=null;
            }
        }
        // On place les données des bateaux
        // porte Avion
        placerBateau(joueur.porteAvion.getB1X(),joueur.porteAvion.getB1Y(), 1, true); // Avant du bateau
        placerBateau(joueur.porteAvion.getB2X(),joueur.porteAvion.getB2Y(), 1, false);
        placerBateau(joueur.porteAvion.getB3X(),joueur.porteAvion.getB3Y(), 1, false);
        placerBateau(joueur.porteAvion.getB4X(),joueur.porteAvion.getB4Y(), 1, false);
        placerBateau(joueur.porteAvion.getB5X(),joueur.porteAvion.getB5Y(), 1, false);
        // croiseur
        placerBateau(joueur.croiseur.getB1X(),joueur.croiseur.getB1Y(), 2, true); // Avant du bateau
        placerBateau(joueur.croiseur.getB2X(),joueur.croiseur.getB2Y(), 2, false);
        placerBateau(joueur.croiseur.getB3X(),joueur.croiseur.getB3Y(), 2, false);
        placerBateau(joueur.croiseur.getB4X(),joueur.croiseur.getB4Y(), 2, false);
        // Contre torpilleur
        placerBateau(joueur.contreTorpilleur.getB1X(),joueur.contreTorpilleur.getB1Y(), 3, true); // Avant du bateau
        placerBateau(joueur.contreTorpilleur.getB2X(),joueur.contreTorpilleur.getB2Y(), 3, false);
        placerBateau(joueur.contreTorpilleur.getB3X(),joueur.contreTorpilleur.getB3Y(), 3, false);
        // Sous marin
        placerBateau(joueur.sousMarin.getB1X(),joueur.sousMarin.getB1Y(), 4, true); // Avant du bateau
        placerBateau(joueur.sousMarin.getB2X(),joueur.sousMarin.getB2Y(), 4, false);
        placerBateau(joueur.sousMarin.getB3X(),joueur.sousMarin.getB3Y(), 4, false);
        // torpilleur
        placerBateau(joueur.torpilleur.getB1X(),joueur.torpilleur.getB1Y(), 5, true); // Avant du bateau
        placerBateau(joueur.torpilleur.getB2X(),joueur.torpilleur.getB2Y(), 5, false);
    }

    public int getTailleX() {
        return TailleX;
    }

    public void setTailleX(int tailleX) {
        TailleX = tailleX;
    }

    public int getTailleY() {
        return tailleY;
    }

    public void setTailleY(int tailleY) {
        this.tailleY = tailleY;
    }

    public Element getCase(int x, int y){
        return this.matrice[x][y];
    }
}
