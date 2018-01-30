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

    // Méthode d'attaque
    public void attaquer(Joueur joueur, int x, int y){
        int verif = joueur.carteBateaux.verification(x,y);
        if (verif == 1) {
            joueur.porteAvion.pertePointDeVie();
        }
        if (verif == 2) {
            joueur.croiseur.pertePointDeVie();
        }
        if (verif == 3) {
            joueur.contreTorpilleur.pertePointDeVie();
        }
        if (verif == 4) {
            joueur.sousMarin.pertePointDeVie();
        }
        if (verif == 5) {
            joueur.torpilleur.pertePointDeVie();
        }
    }

    // Méthode de déplacement
    public void deplacer(String direction){
        if(direction.equals("HAUT")){

        }
        else if(direction.equals("BAS")){

        }
        else if(direction.equals("DROITE")){

        }
        else if(direction.equals("GAUCHE")){

        }
    }

    // Méthode de rotation
    public void rotation(String direction){
        if(direction == "GAUCHE"){

        }
        else if(direction == "DROITE"){

        }
    }

    // Vérification de colision
    private boolean verificationColision(){
        return false;
    }

    // Obtenir la direction du bateau ( HAUT, BAS, GAUCHE, DROITE)
    private String getDirection(){
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
