package Bateaux;

import Noyau.ImplementationJoueur;

public class PorteAvion extends Bateau {

    public PorteAvion() {
        taille = 5;
        id = 1;
    }

    // Méthode de déplacement
    public void deplacer(String directionDuDeplacement, ImplementationJoueur joueur){
        String directionDuBateau = this.getDirection();
        if(directionDuBateau.equals("HAUT")){
            if(directionDuDeplacement.equals("HAUT") && joueur.carteBateaux.verification(this.getB1X(), this.getB1Y() - 1) == 0) {
                this.setB1Y(this.getB1Y()-1);
                this.setB2Y(this.getB2Y()-1);
                this.setB3Y(this.getB3Y()-1);
                this.setB4Y(this.getB4Y()-1);
                this.setB5Y(this.getB5Y()-1);
            }
            else if(directionDuDeplacement.equals("BAS") && joueur.carteBateaux.verification(this.getB3X(), this.getB3Y() + 1) == 0) {
                this.setB1Y(this.getB1Y()+1);
                this.setB2Y(this.getB2Y()+1);
                this.setB3Y(this.getB3Y()+1);
                this.setB4Y(this.getB4Y()+1);
                this.setB5Y(this.getB5Y()+1);
            }
            else if (directionDuDeplacement.equals("DROITE")
                    && joueur.carteBateaux.verification(this.getB1X()+1, this.getB1Y()) == 0
                    && joueur.carteBateaux.verification(this.getB2X()+1, this.getB2Y()) == 0
                    && joueur.carteBateaux.verification(this.getB3X()+1, this.getB3Y()) == 0
                    && joueur.carteBateaux.verification(this.getB4X()+1, this.getB4Y()) == 0
                    && joueur.carteBateaux.verification(this.getB5X()+1, this.getB5Y()) == 0) {
                this.setB1X(this.getB1X()+1);
                this.setB2X(this.getB2X()+1);
                this.setB3X(this.getB3X()+1);
                this.setB4X(this.getB4X()+1);
                this.setB5X(this.getB5X()+1);
            }
            else if (directionDuDeplacement.equals("GAUCHE")
                    && joueur.carteBateaux.verification(this.getB1X()-1, this.getB1Y()) == 0
                    && joueur.carteBateaux.verification(this.getB2X()-1, this.getB2Y()) == 0
                    && joueur.carteBateaux.verification(this.getB3X()-1, this.getB3Y()) == 0
                    && joueur.carteBateaux.verification(this.getB4X()-1, this.getB4Y()) == 0
                    && joueur.carteBateaux.verification(this.getB5X()-1, this.getB5Y()) == 0) {
                this.setB1X(this.getB1X()-1);
                this.setB2X(this.getB2X()-1);
                this.setB3X(this.getB3X()-1);
                this.setB4X(this.getB4X()-1);
                this.setB5X(this.getB5X()-1);
            }
        }
        else if(directionDuBateau.equals("BAS")){
            if(directionDuDeplacement.equals("HAUT") && joueur.carteBateaux.verification(this.getB3X(), this.getB3Y() - 1) == 0) {
                this.setB1Y(this.getB1Y()-1);
                this.setB2Y(this.getB2Y()-1);
                this.setB3Y(this.getB3Y()-1);
                this.setB4Y(this.getB4Y()-1);
                this.setB5Y(this.getB5Y()-1);
            }
            else if(directionDuDeplacement.equals("BAS") && joueur.carteBateaux.verification(this.getB1X(), this.getB1Y() + 1) == 0) {
                this.setB1Y(this.getB1Y()+1);
                this.setB2Y(this.getB2Y()+1);
                this.setB3Y(this.getB3Y()+1);
                this.setB4Y(this.getB4Y()+1);
                this.setB5Y(this.getB5Y()+1);
            }
            else if (directionDuDeplacement.equals("DROITE")
                    && joueur.carteBateaux.verification(this.getB1X()+1, this.getB1Y()) == 0
                    && joueur.carteBateaux.verification(this.getB2X()+1, this.getB2Y()) == 0
                    && joueur.carteBateaux.verification(this.getB3X()+1, this.getB3Y()) == 0
                    && joueur.carteBateaux.verification(this.getB4X()+1, this.getB4Y()) == 0
                    && joueur.carteBateaux.verification(this.getB5X()+1, this.getB5Y()) == 0) {
                this.setB1X(this.getB1X()+1);
                this.setB2X(this.getB2X()+1);
                this.setB3X(this.getB3X()+1);
                this.setB4X(this.getB4X()+1);
                this.setB5X(this.getB5X()+1);
            }
            else if (directionDuDeplacement.equals("GAUCHE")
                    && joueur.carteBateaux.verification(this.getB1X()-1, this.getB1Y()) == 0
                    && joueur.carteBateaux.verification(this.getB2X()-1, this.getB2Y()) == 0
                    && joueur.carteBateaux.verification(this.getB3X()-1, this.getB3Y()) == 0
                    && joueur.carteBateaux.verification(this.getB4X()-1, this.getB4Y()) == 0
                    && joueur.carteBateaux.verification(this.getB5X()-1, this.getB5Y()) == 0) {
                this.setB1X(this.getB1X()-1);
                this.setB2X(this.getB2X()-1);
                this.setB3X(this.getB3X()-1);
                this.setB4X(this.getB4X()-1);
                this.setB5X(this.getB5X()-1);
            }

        }
        else if(directionDuBateau.equals("DROITE")){
            if(directionDuDeplacement.equals("HAUT")
                    && joueur.carteBateaux.verification(this.getB1X(), this.getB1Y() - 1) == 0
                    && joueur.carteBateaux.verification(this.getB2X(), this.getB2Y() - 1) == 0
                    && joueur.carteBateaux.verification(this.getB3X(), this.getB3Y() - 1) == 0
                    && joueur.carteBateaux.verification(this.getB4X(), this.getB4Y() - 1) == 0
                    && joueur.carteBateaux.verification(this.getB5X(), this.getB5Y() - 1) == 0) {
                this.setB1Y(this.getB1Y()-1);
                this.setB2Y(this.getB2Y()-1);
                this.setB3Y(this.getB3Y()-1);
                this.setB4Y(this.getB4Y()-1);
                this.setB5Y(this.getB5Y()-1);
            }
            else if(directionDuDeplacement.equals("BAS")
                    && joueur.carteBateaux.verification(this.getB1X(), this.getB1Y() + 1) == 0
                    && joueur.carteBateaux.verification(this.getB2X(), this.getB2Y() + 1) == 0
                    && joueur.carteBateaux.verification(this.getB3X(), this.getB3Y() + 1) == 0
                    && joueur.carteBateaux.verification(this.getB4X(), this.getB4Y() + 1) == 0
                    && joueur.carteBateaux.verification(this.getB5X(), this.getB5Y() + 1) == 0) {
                this.setB1Y(this.getB1Y()+1);
                this.setB2Y(this.getB2Y()+1);
                this.setB3Y(this.getB3Y()+1);
                this.setB4Y(this.getB4Y()+1);
                this.setB5Y(this.getB5Y()+1);
            }
            else if (directionDuDeplacement.equals("DROITE")
                    && joueur.carteBateaux.verification(this.getB1X()+1, this.getB1Y()) == 0) {
                this.setB1X(this.getB1X()+1);
                this.setB2X(this.getB2X()+1);
                this.setB3X(this.getB3X()+1);
                this.setB4X(this.getB4X()+1);
                this.setB5X(this.getB5X()+1);
            }
            else if (directionDuDeplacement.equals("GAUCHE")
                    && joueur.carteBateaux.verification(this.getB3X()-1, this.getB3Y()) == 0) {
                this.setB1X(this.getB1X()-1);
                this.setB2X(this.getB2X()-1);
                this.setB3X(this.getB3X()-1);
                this.setB4X(this.getB4X()-1);
                this.setB5X(this.getB5X()-1);
            }
        }
        else if(directionDuBateau.equals("GAUCHE")){
            if(directionDuDeplacement.equals("HAUT")
                    && joueur.carteBateaux.verification(this.getB1X(), this.getB1Y() - 1) == 0
                    && joueur.carteBateaux.verification(this.getB2X(), this.getB2Y() - 1) == 0
                    && joueur.carteBateaux.verification(this.getB3X(), this.getB3Y() - 1) == 0
                    && joueur.carteBateaux.verification(this.getB4X(), this.getB4Y() - 1) == 0
                    && joueur.carteBateaux.verification(this.getB5X(), this.getB5Y() - 1) == 0) {
                this.setB1Y(this.getB1Y()-1);
                this.setB2Y(this.getB2Y()-1);
                this.setB3Y(this.getB3Y()-1);
                this.setB4Y(this.getB4Y()-1);
                this.setB5Y(this.getB5Y()-1);
            }
            else if(directionDuDeplacement.equals("BAS")
                    && joueur.carteBateaux.verification(this.getB1X(), this.getB1Y() + 1) == 0
                    && joueur.carteBateaux.verification(this.getB2X(), this.getB2Y() + 1) == 0
                    && joueur.carteBateaux.verification(this.getB3X(), this.getB3Y() + 1) == 0
                    && joueur.carteBateaux.verification(this.getB4X(), this.getB4Y() + 1) == 0
                    && joueur.carteBateaux.verification(this.getB5X(), this.getB5Y() + 1) == 0) {
                this.setB1Y(this.getB1Y()+1);
                this.setB2Y(this.getB2Y()+1);
                this.setB3Y(this.getB3Y()+1);
                this.setB4Y(this.getB4Y()+1);
                this.setB5Y(this.getB5Y()+1);
            }
            else if (directionDuDeplacement.equals("DROITE")
                    && joueur.carteBateaux.verification(this.getB3X()+1, this.getB3Y()) == 0) {
                this.setB1X(this.getB1X()+1);
                this.setB2X(this.getB2X()+1);
                this.setB3X(this.getB3X()+1);
                this.setB4X(this.getB4X()+1);
                this.setB5X(this.getB5X()+1);
            }
            else if (directionDuDeplacement.equals("GAUCHE")
                    && joueur.carteBateaux.verification(this.getB1X()-1, this.getB1Y()) == 0) {
                this.setB1X(this.getB1X()-1);
                this.setB2X(this.getB2X()-1);
                this.setB3X(this.getB3X()-1);
                this.setB4X(this.getB4X()-1);
                this.setB5X(this.getB5X()-1);
            }

        }
    }

    // Méthode de rotation TODO
    public void rotation(String directionDeRotation){
        String directionDuBateau = this.getDirection();
        if(directionDuBateau == "HAUT"){
            if(directionDeRotation == "GAUCHE"){/*
                if(        joueur.carteBateaux.verification(this.getB2X(), this.getB2Y() - 1) == 0
                        && joueur.carteBateaux.verification(this.getB3X(), this.getB3Y() - 1) == 0
                        && joueur.carteBateaux.verification(this.getB4X(), this.getB4Y() - 1) == 0
                        && joueur.carteBateaux.verification(this.getB5X(), this.getB5Y() - 1) == 0){

                }*/
            }
            else if(directionDeRotation == "DROITE"){

            }
        }
        else if(directionDuBateau == "BAS"){
            if(directionDeRotation == "GAUCHE"){

            }
            else if(directionDeRotation == "DROITE"){

            }
        }
        else if(directionDuBateau == "DROITE"){
            if(directionDeRotation == "GAUCHE"){

            }
            else if(directionDeRotation == "DROITE"){

            }
        }
        else if(directionDuBateau == "GAUCHE"){
            if(directionDeRotation == "GAUCHE"){

            }
            else if(directionDeRotation == "DROITE"){

            }
        }
    }

}
