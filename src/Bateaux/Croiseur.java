package Bateaux;

import Noyau.ImplementationJoueur;

public class Croiseur extends Bateau {

    public Croiseur(){
        taille = 4;
        id = 2;
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
            }
            else if(directionDuDeplacement.equals("BAS") && joueur.carteBateaux.verification(this.getB3X(), this.getB3Y() + 1) == 0) {
                this.setB1Y(this.getB1Y()+1);
                this.setB2Y(this.getB2Y()+1);
                this.setB3Y(this.getB3Y()+1);
                this.setB4Y(this.getB4Y()+1);
            }
            else if (directionDuDeplacement.equals("DROITE")
                    && joueur.carteBateaux.verification(this.getB1X()+1, this.getB1Y()) == 0
                    && joueur.carteBateaux.verification(this.getB2X()+1, this.getB2Y()) == 0
                    && joueur.carteBateaux.verification(this.getB3X()+1, this.getB3Y()) == 0
                    && joueur.carteBateaux.verification(this.getB4X()+1, this.getB4Y()) == 0) {
                this.setB1X(this.getB1X()+1);
                this.setB2X(this.getB2X()+1);
                this.setB3X(this.getB3X()+1);
                this.setB4X(this.getB4X()+1);
            }
            else if (directionDuDeplacement.equals("GAUCHE")
                    && joueur.carteBateaux.verification(this.getB1X()-1, this.getB1Y()) == 0
                    && joueur.carteBateaux.verification(this.getB2X()-1, this.getB2Y()) == 0
                    && joueur.carteBateaux.verification(this.getB3X()-1, this.getB3Y()) == 0
                    && joueur.carteBateaux.verification(this.getB4X()-1, this.getB4Y()) == 0) {
                this.setB1X(this.getB1X()-1);
                this.setB2X(this.getB2X()-1);
                this.setB3X(this.getB3X()-1);
                this.setB4X(this.getB4X()-1);
            }
        }
        else if(directionDuBateau.equals("BAS")){
            if(directionDuDeplacement.equals("HAUT") && joueur.carteBateaux.verification(this.getB3X(), this.getB3Y() - 1) == 0) {
                this.setB1Y(this.getB1Y()-1);
                this.setB2Y(this.getB2Y()-1);
                this.setB3Y(this.getB3Y()-1);
                this.setB4Y(this.getB4Y()-1);
            }
            else if(directionDuDeplacement.equals("BAS") && joueur.carteBateaux.verification(this.getB1X(), this.getB1Y() + 1) == 0) {
                this.setB1Y(this.getB1Y()+1);
                this.setB2Y(this.getB2Y()+1);
                this.setB3Y(this.getB3Y()+1);
                this.setB4Y(this.getB4Y()+1);
            }
            else if (directionDuDeplacement.equals("DROITE")
                    && joueur.carteBateaux.verification(this.getB1X()+1, this.getB1Y()) == 0
                    && joueur.carteBateaux.verification(this.getB2X()+1, this.getB2Y()) == 0
                    && joueur.carteBateaux.verification(this.getB3X()+1, this.getB3Y()) == 0
                    && joueur.carteBateaux.verification(this.getB4X()+1, this.getB4Y()) == 0) {
                this.setB1X(this.getB1X()+1);
                this.setB2X(this.getB2X()+1);
                this.setB3X(this.getB3X()+1);
                this.setB4X(this.getB4X()+1);
            }
            else if (directionDuDeplacement.equals("GAUCHE")
                    && joueur.carteBateaux.verification(this.getB1X()-1, this.getB1Y()) == 0
                    && joueur.carteBateaux.verification(this.getB2X()-1, this.getB2Y()) == 0
                    && joueur.carteBateaux.verification(this.getB3X()-1, this.getB3Y()) == 0
                    && joueur.carteBateaux.verification(this.getB4X()-1, this.getB4Y()) == 0) {
                this.setB1X(this.getB1X()-1);
                this.setB2X(this.getB2X()-1);
                this.setB3X(this.getB3X()-1);
                this.setB4X(this.getB4X()-1);
            }

        }
        else if(directionDuBateau.equals("DROITE")){
            if(directionDuDeplacement.equals("HAUT")
                    && joueur.carteBateaux.verification(this.getB1X(), this.getB1Y() - 1) == 0
                    && joueur.carteBateaux.verification(this.getB2X(), this.getB2Y() - 1) == 0
                    && joueur.carteBateaux.verification(this.getB3X(), this.getB3Y() - 1) == 0
                    && joueur.carteBateaux.verification(this.getB4X(), this.getB4Y() - 1) == 0) {
                this.setB1Y(this.getB1Y()-1);
                this.setB2Y(this.getB2Y()-1);
                this.setB3Y(this.getB3Y()-1);
                this.setB4Y(this.getB4Y()-1);
            }
            else if(directionDuDeplacement.equals("BAS")
                    && joueur.carteBateaux.verification(this.getB1X(), this.getB1Y() + 1) == 0
                    && joueur.carteBateaux.verification(this.getB2X(), this.getB2Y() + 1) == 0
                    && joueur.carteBateaux.verification(this.getB3X(), this.getB3Y() + 1) == 0
                    && joueur.carteBateaux.verification(this.getB4X(), this.getB4Y() + 1) == 0) {
                this.setB1Y(this.getB1Y()+1);
                this.setB2Y(this.getB2Y()+1);
                this.setB3Y(this.getB3Y()+1);
                this.setB4Y(this.getB4Y()+1);
            }
            else if (directionDuDeplacement.equals("DROITE")
                    && joueur.carteBateaux.verification(this.getB1X()+1, this.getB1Y()) == 0) {
                this.setB1X(this.getB1X()+1);
                this.setB2X(this.getB2X()+1);
                this.setB3X(this.getB3X()+1);
                this.setB4X(this.getB4X()+1);
            }
            else if (directionDuDeplacement.equals("GAUCHE")
                    && joueur.carteBateaux.verification(this.getB3X()-1, this.getB3Y()) == 0) {
                this.setB1X(this.getB1X()-1);
                this.setB2X(this.getB2X()-1);
                this.setB3X(this.getB3X()-1);
                this.setB4X(this.getB4X()-1);
            }
        }
        else if(directionDuBateau.equals("GAUCHE")){
            if(directionDuDeplacement.equals("HAUT")
                    && joueur.carteBateaux.verification(this.getB1X(), this.getB1Y() - 1) == 0
                    && joueur.carteBateaux.verification(this.getB2X(), this.getB2Y() - 1) == 0
                    && joueur.carteBateaux.verification(this.getB3X(), this.getB3Y() - 1) == 0
                    && joueur.carteBateaux.verification(this.getB4X(), this.getB4Y() - 1) == 0) {
                this.setB1Y(this.getB1Y()-1);
                this.setB2Y(this.getB2Y()-1);
                this.setB3Y(this.getB3Y()-1);
                this.setB4Y(this.getB4Y()-1);
            }
            else if(directionDuDeplacement.equals("BAS")
                    && joueur.carteBateaux.verification(this.getB1X(), this.getB1Y() + 1) == 0
                    && joueur.carteBateaux.verification(this.getB2X(), this.getB2Y() + 1) == 0
                    && joueur.carteBateaux.verification(this.getB3X(), this.getB3Y() + 1) == 0
                    && joueur.carteBateaux.verification(this.getB4X(), this.getB4Y() + 1) == 0) {
                this.setB1Y(this.getB1Y()+1);
                this.setB2Y(this.getB2Y()+1);
                this.setB3Y(this.getB3Y()+1);
                this.setB4Y(this.getB4Y()+1);
            }
            else if (directionDuDeplacement.equals("DROITE")
                    && joueur.carteBateaux.verification(this.getB3X()+1, this.getB3Y()) == 0) {
                this.setB1X(this.getB1X()+1);
                this.setB2X(this.getB2X()+1);
                this.setB3X(this.getB3X()+1);
                this.setB4X(this.getB4X()+1);
            }
            else if (directionDuDeplacement.equals("GAUCHE")
                    && joueur.carteBateaux.verification(this.getB1X()-1, this.getB1Y()) == 0) {
                this.setB1X(this.getB1X()-1);
                this.setB2X(this.getB2X()-1);
                this.setB3X(this.getB3X()-1);
                this.setB4X(this.getB4X()-1);
            }

        }
    }

    // Méthode de rotation TODO
    public void rotation(String directionDeRotation){

    }

}
