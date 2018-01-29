package Bateaux;

import Noyau.*;

public class Bateau {

    // Point de vie du bateau
    int vie;
    // Coulé ?
    boolean mort;
    // Taille du bateau ( type )
    int taille;
    // Positions des blocs du bateau
    int b1X;
    int b1Y;
    int b2X;
    int b2Y;
    int b3X;
    int b3Y;
    int b4X;
    int b4Y;
    int b5X;
    int b5Y;

    Bateau(){
        vie = 2;
        mort = false;
    }

    // Méthode d'attaque
    public void attaquer(Joueur joueur, int x, int y){

    }

    // Méthode de déplacement
    public void deplacer(String direction){
        if(direction == "HAUT"){

        }
        else if(direction == "BAS"){

        }
        else if(direction == "DROITE"){

        }
        else if(direction == "GAUCHE"){

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
}
