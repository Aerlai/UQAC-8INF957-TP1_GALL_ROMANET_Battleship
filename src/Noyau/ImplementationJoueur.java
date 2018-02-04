package Noyau;

import Bateaux.*;
import Carte.Carte;

public class ImplementationJoueur implements Joueur {
    // Nom du joueur
    String nom;
    int bateauactuel;

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
        bateauactuel=0;
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
        joueur.inspectionBateaux();
        tourFini();
    }

    // Déplacement durant la partie
    public void deplacer(int id, String directionDuDeplacement){
        if(id==1){
             porteAvion.deplacer(directionDuDeplacement, this);
        }
        if(id==2){
            croiseur.deplacer(directionDuDeplacement, this);
        }
        if(id==3){
            contreTorpilleur.deplacer(directionDuDeplacement, this);
        }
        if(id==4){
            sousMarin.deplacer(directionDuDeplacement, this);
        }
        if(id==5){
            torpilleur.deplacer(directionDuDeplacement, this);
        }
    }

    // Rotation de bateau TODO
    public void tourner( Bateau ship){

    }

    public void placerhaut(int id, int x, int y){ //place la tete du bateau aux coordonnees indiquees
        switch (id){
            case 1:
                for(int i=0;i<5;i++){
                    placer(1,i+1,x+i,y);
                }
            break;
            case 2:
                for(int i=0;i<4;i++){
                    placer(2,i+1,x+i,y);
                }
                break;
            case 3:
                for(int i=0;i<3;i++){
                    placer(3,i+1,x+i,y);
                }
                break;
            case 4:
                for(int i=0;i<3;i++){
                    placer(4,i+1,x+i,y);
                }
                break;
            case 5:
                for(int i=0;i<2;i++){
                    placer(5,i+1,x+i,y);
                }
                break;
        }
    }
    public void placerbas(int id, int x, int y){ //place la tete du bateau aux coordonnees indiquees
        switch (id){
            case 1:
                for(int i=0;i<5;i++){
                    placer(1,i+1,x-i,y);
                }
                break;
            case 2:
                for(int i=0;i<4;i++){
                    placer(2,i+1,x-i,y);
                }
                break;
            case 3:
                for(int i=0;i<3;i++){
                    placer(3,i+1,x-i,y);
                }
                break;
            case 4:
                for(int i=0;i<3;i++){
                    placer(4,i+1,x-i,y);
                }
                break;
            case 5:
                for(int i=0;i<2;i++){
                    placer(5,i+1,x-i,y);
                }
                break;
        }
    }
    public void placergauche(int id, int x, int y){ //place la tete du bateau aux coordonnees indiquees, le reste a sa droite
        switch (id){
            case 1:
                for(int i=0;i<5;i++){
                    placer(1,i+1,x,y+i);
                }
                break;
            case 2:
                for(int i=0;i<4;i++){
                    placer(2,i+1,x,y+i);
                }
                break;
            case 3:
                for(int i=0;i<3;i++){
                    placer(3,i+1,x,y+i);
                }
                break;
            case 4:
                for(int i=0;i<3;i++){
                    placer(4,i+1,x,y+i);
                }
                break;
            case 5:
                for(int i=0;i<2;i++){
                    placer(5,i+1,x,y+i);
                }
                break;
        }
    }
    public void placerdroite(int id, int x, int y){ //place la tete du bateau aux coordonnees indiquees le reste à sa gauche
        switch (id){
            case 1:
                for(int i=0;i<5;i++){
                    placer(1,i+1,x,y-i);
                }
                break;
            case 2:
                for(int i=0;i<4;i++){
                    placer(2,i+1,x,y-i);
                }
                break;
            case 3:
                for(int i=0;i<3;i++){
                    placer(3,i+1,x,y-i);
                }
                break;
            case 4:
                for(int i=0;i<3;i++){
                    placer(4,i+1,x,y-i);
                }
                break;
            case 5:
                for(int i=0;i<2;i++){
                    placer(5,i+1,x,y-i);
                }
                break;
        }
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

    public int subit(int x, int y){
        return this.carteBateaux.subitAttaque(x,y);
    }

    public void tourFini(){
        this.bateauactuel++;
        if(this.bateauactuel>5)this.bateauactuel=0;
    }

    public void inspectionBateau(Bateau bateau){
        if(bateau.isMort()){
            this.perdBateau(bateau);
        }
    }

    public void inspectionBateaux(){
        if(porteAvion!=null&&porteAvion.isMort()){
            this.perdBateau(porteAvion);
            porteAvion=null;
        }
        if(torpilleur!=null&&torpilleur.isMort()){
            this.perdBateau(torpilleur);
            torpilleur=null;
        }
        if(contreTorpilleur!=null&&contreTorpilleur.isMort()){
            this.perdBateau(contreTorpilleur);
            contreTorpilleur=null;
        }
        if(sousMarin!=null&&sousMarin.isMort()){
            this.perdBateau(sousMarin);
            sousMarin=null;
        }
        if(croiseur!=null&&croiseur.isMort()){
            this.perdBateau(croiseur);
            croiseur=null;
        }
    }

    public boolean estVivant(){
        return !((porteAvion==null)&&(torpilleur==null)&&(contreTorpilleur==null)&&(sousMarin==null)&&(croiseur==null));
    }

    public Bateau getBateauEnJeu(){
        switch(bateauactuel){
            case 1 : return porteAvion;
            case 2 : return croiseur;
            case 3 : return contreTorpilleur;
            case 4 : return sousMarin;
            case 5 : return torpilleur;
        }
        return null;
    }

    public void perdBateau(Bateau titanic){
        if(titanic.getId()==1){
            carteBateaux.videCase(titanic.getB1X(),titanic.getB1Y());
            carteBateaux.videCase(titanic.getB2X(),titanic.getB2Y());
            carteBateaux.videCase(titanic.getB3X(),titanic.getB3Y());
            carteBateaux.videCase(titanic.getB4X(),titanic.getB4Y());
            carteBateaux.videCase(titanic.getB5X(),titanic.getB5Y());
        }
        if(titanic.getId()==2){
            carteBateaux.videCase(titanic.getB1X(),titanic.getB1Y());
            carteBateaux.videCase(titanic.getB2X(),titanic.getB2Y());
            carteBateaux.videCase(titanic.getB3X(),titanic.getB3Y());
            carteBateaux.videCase(titanic.getB4X(),titanic.getB4Y());
        }
        if(titanic.getId()==3){
            carteBateaux.videCase(titanic.getB1X(),titanic.getB1Y());
            carteBateaux.videCase(titanic.getB2X(),titanic.getB2Y());
            carteBateaux.videCase(titanic.getB3X(),titanic.getB3Y());
        }
        if(titanic.getId()==4){
            carteBateaux.videCase(titanic.getB1X(),titanic.getB1Y());
            carteBateaux.videCase(titanic.getB2X(),titanic.getB2Y());
            carteBateaux.videCase(titanic.getB3X(),titanic.getB3Y());
        }
        if(titanic.getId()==5){
            carteBateaux.videCase(titanic.getB1X(),titanic.getB1Y());
            carteBateaux.videCase(titanic.getB2X(),titanic.getB2Y());
        }
    }

    //get carte
    public Carte getCarteBateaux(){
        return carteBateaux;
    }
    public Carte getCarteImpacts(){
        return carteImpacts;
    }
    public ImplementationJoueur getJoueur(){
        return this;
    }

    public Bateau getPorteAvion(){ return this.porteAvion;}
}
