package Bateaux;

import Noyau.*;

public class Bateau {

    // Point de vie du bateau
    int vie;
    // Coulé ?
    boolean mort;
    // Taille du bateau ( type )
    int taille;

    Bateau(){
        vie = 2;
        mort = false;
    }

    // Méthode d'attaque
    public void attaquer(Joueur joueur, int x, int y){

    }

    // Méthode de déplacement
    public void deplacer(String direction){

    }

    // Méthode de rotation
    public void rotation(){

    }

    // Vérification de colision
    private boolean verificationColision(){
        return false;
    }
}
