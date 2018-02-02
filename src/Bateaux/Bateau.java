package Bateaux;

import Noyau.*;

public class Bateau {

    //ID du bateau
    protected int id;
    // Point de vie du bateau
    private int vie;
    // Coulé ?
    private boolean mort;
    // Taille du bateau ( type )
    protected int taille;
    // Positions des blocs du bateau
    private int b1X;
    private int b1Y;
    private int b2X;
    private int b2Y;
    private int b3X;
    private int b3Y;
    private int b4X;
    private int b4Y;
    private int b5X;
    private int b5Y;

    public Bateau(){
        vie = 2;
        mort = false;
    }

    // get
    public int getB1Y() {
        return b1Y;
    }
    public int getB2X() {
        return b2X;
    }
    public int getB2Y() {
        return b2Y;
    }
    public int getB1X() {
        return b1X;
    }
    public int getB3X() {
        return b3X;
    }
    public int getB3Y() {
        return b3Y;
    }
    public int getB4X() {
        return b4X;
    }
    public int getB5X() {
        return b5X;
    }
    public int getB4Y() {
        return b4Y;
    }
    public int getB5Y() {
        return b5Y;
    }
    // set
    public void setB1X(int b1X) {
        this.b1X = b1X;
    }
    public void setB1Y(int b1Y) {
        this.b1Y = b1Y;
    }
    public void setB2X(int b2X) {
        this.b2X = b2X;
    }
    public void setB2Y(int b2Y) {
        this.b2Y = b2Y;
    }
    public void setB3X(int b3X) {
        this.b3X = b3X;
    }
    public void setB3Y(int b3Y) {
        this.b3Y = b3Y;
    }
    public void setB4X(int b4X) {
        this.b4X = b4X;
    }
    public void setB4Y(int b4Y) {
        this.b4Y = b4Y;
    }
    public void setB5X(int b5X) {
        this.b5X = b5X;
    }
    public void setB5Y(int b5Y) {
        this.b5Y = b5Y;
    }

    // Méthode d'attaque
    public void attaquer(Joueur joueur, int x, int y){
        int verif = joueur.carteBateaux.verification(x,y);
        if (verif == 1) {
            System.out.println("Touché le porte avion");
            joueur.porteAvion.pertePointDeVie();
        }
        if (verif == 2) {
            joueur.croiseur.pertePointDeVie();
            System.out.println("Touché le croiseur");
        }
        if (verif == 3) {
            joueur.contreTorpilleur.pertePointDeVie();
            System.out.println("Touché le contre torpilleur");
        }
        if (verif == 4) {
            joueur.sousMarin.pertePointDeVie();
            System.out.println("Touché le sous marin");
        }
        if (verif == 5) {
            joueur.torpilleur.pertePointDeVie();
            System.out.println("Touché le torpilleur");
        }
        else
            System.out.println("Pas d'impact");
    }

    // Méthode de déplacement -- PAR SURCHARGE
    public void deplacer(String direction, Joueur joueur){

    }

    // Méthode de rotation -- PAR SURCHARGE
    public void rotation(String directionDeRotation){

    }

    // Vérification de colision
    private boolean verificationColision(){
        return false;
    }

    // Obtenir la direction du bateau ( HAUT, BAS, GAUCHE, DROITE)
    protected String getDirection(){
        // Horizontal
        if(b1Y == b2Y){
            if(b1Y < b2Y) return "GAUCHE";
            else return "DROITE";
        }
        // Vertical
        else if(b1X == b2X){
            if(b1Y<b2Y) return "HAUT";
            else return "BAS";
        }
        return null;
    }

    // methode perte 1 point de vie
    public void pertePointDeVie(){
        vie--;
        if( vie <= 0) mort = true;
    }


}
