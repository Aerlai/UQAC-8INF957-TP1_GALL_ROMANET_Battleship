package Noyau;

import Bateaux.*;
import Carte.Carte;

public class ImplementationJoueur implements Joueur {
    // Nom du joueur
    String nom;

    // Création de 2 cartes :
    // - 1 Carte de placement des bateaux
    // - 1 Carte d'impacts
    public Carte carteBateaux, carteImpacts;

    // Les bateaux du joueur
    public PorteAvion porteAvion;
    public Croiseur croiseur;
    public ContreTorpilleur contreTorpilleur;
    public SousMarin sousMarin;
    public Torpilleur torpilleur;


    // Constructeur de Joueur
    ImplementationJoueur(){
        carteBateaux = new Carte();
        carteImpacts = new Carte();

        porteAvion = new PorteAvion();
        croiseur = new Croiseur();
        contreTorpilleur = new ContreTorpilleur();
        sousMarin = new SousMarin();
        torpilleur = new Torpilleur();
    }

    // attaque d'une position de l'adversaire
    public void attaquer(ImplementationJoueur joueur, Bateau bateauAttaquant,  int x, int y){
        int id = joueur.carteBateaux.verification(x,y);
        if (id == 0){
            this.carteImpacts.placerImpact(x,y);
        }
        if (id == 1 || id == 2 || id == 3 || id == 4 || id == 5 ){
            this.carteImpacts.placerImpactBateau(x,y);
            bateauAttaquant.attaquer(joueur, x, y);
        }
    }

    // Déplacement durant la partie TODO
    public void deplacer(int id, String directionDuDeplacement){
        if(id==1){
            // porteAvion.deplacer();
        }
    }

    // Rotation de bateau TODO
    public void tourner( Bateau ship){

    }

    // Placement initial des bateaux par le joueur
    public void placer(int id, int bloc, int x, int y){
        if(id ==1){ // porte avion
            if(bloc == 1){
                porteAvion.setB1X(x);
                porteAvion.setB1Y(y);
                carteBateaux.placerBateau(x,y,1,true);
            }
            if(bloc == 2){
                porteAvion.setB2X(x);
                porteAvion.setB2Y(y);
                carteBateaux.placerBateau(x,y,1,false);
            }
            if(bloc == 3){
                porteAvion.setB3X(x);
                porteAvion.setB3Y(y);
                carteBateaux.placerBateau(x,y,1,false);
            }
            if(bloc == 4){
                porteAvion.setB4X(x);
                porteAvion.setB4Y(y);
                carteBateaux.placerBateau(x,y,1,false);
            }
            if(bloc == 5){
                porteAvion.setB5X(x);
                porteAvion.setB5Y(y);
                carteBateaux.placerBateau(x,y,1,false);
            }
        }
        if(id ==2){ // croiseur
            if(bloc == 1){
                croiseur.setB1X(x);
                croiseur.setB1Y(y);
                carteBateaux.placerBateau(x,y,2,true);
            }
            if(bloc == 2){
                croiseur.setB2X(x);
                croiseur.setB2Y(y);
                carteBateaux.placerBateau(x,y,2,false);
            }
            if(bloc == 3){
                croiseur.setB3X(x);
                croiseur.setB3Y(y);
                carteBateaux.placerBateau(x,y,2,false);
            }
            if(bloc == 4){
                croiseur.setB4X(x);
                croiseur.setB4Y(y);
                carteBateaux.placerBateau(x,y,2,false);
            }
        }
        if(id ==3){ // contre torpilleur
            if(bloc == 1){
                contreTorpilleur.setB1X(x);
                contreTorpilleur.setB1Y(y);
                carteBateaux.placerBateau(x,y,3,true);
            }
            if(bloc == 2){
                contreTorpilleur.setB2X(x);
                contreTorpilleur.setB2Y(y);
                carteBateaux.placerBateau(x,y,3,false);
            }
            if(bloc == 3){
                contreTorpilleur.setB3X(x);
                contreTorpilleur.setB3Y(y);
                carteBateaux.placerBateau(x,y,3,false);
            }
        }
        if(id ==4){ // sous marin
            if(bloc == 1){
                sousMarin.setB1X(x);
                sousMarin.setB1Y(y);
                carteBateaux.placerBateau(x,y,4,true);
            }
            if(bloc == 2){
                sousMarin.setB2X(x);
                sousMarin.setB2Y(y);
                carteBateaux.placerBateau(x,y,4,false);
            }
            if(bloc == 3){
                sousMarin.setB3X(x);
                sousMarin.setB3Y(y);
                carteBateaux.placerBateau(x,y,4,false);
            }
        }
        if(id ==5){
            if(bloc == 1){
                torpilleur.setB1X(x);
                torpilleur.setB1Y(y);
                carteBateaux.placerBateau(x,y,5,true);
            }
            if(bloc == 2){
                torpilleur.setB2X(x);
                torpilleur.setB2Y(y);
                carteBateaux.placerBateau(x,y,5,false);
            }
        }
    }
}