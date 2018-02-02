package Bateaux;

import Noyau.Joueur;

public class ContreTorpilleur extends Bateau {


    public ContreTorpilleur(){
        taille = 3;
        id = 3;
    }

    // Méthode de déplacement
    public void deplacer(String directionDuDeplacement, Joueur joueur){
        String directionDuBateau = this.getDirection();
        if(directionDuBateau.equals("HAUT")){
            if(directionDuDeplacement.equals("HAUT") && joueur.carteBateaux.verification(this.getB1X(), this.getB1Y() - 1) == 0) {
                this.setB1Y(this.getB1Y()-1);
                this.setB2Y(this.getB2Y()-1);
                this.setB3Y(this.getB3Y()-1);
            }
            else if(directionDuDeplacement.equals("BAS") && joueur.carteBateaux.verification(this.getB3X(), this.getB3Y() + 1) == 0) {
                this.setB1Y(this.getB1Y()+1);
                this.setB2Y(this.getB2Y()+1);
                this.setB3Y(this.getB3Y()+1);
            }
            else if (directionDuDeplacement.equals("DROITE")
                    && joueur.carteBateaux.verification(this.getB1X()+1, this.getB1Y()) == 0
                    && joueur.carteBateaux.verification(this.getB2X()+1, this.getB2Y()) == 0
                    && joueur.carteBateaux.verification(this.getB3X()+1, this.getB3Y()) == 0) {
                this.setB1X(this.getB1X()+1);
                this.setB2X(this.getB2X()+1);
                this.setB3X(this.getB3X()+1);
            }
            else if (directionDuDeplacement.equals("GAUCHE")
                    && joueur.carteBateaux.verification(this.getB1X()-1, this.getB1Y()) == 0
                    && joueur.carteBateaux.verification(this.getB2X()-1, this.getB2Y()) == 0
                    && joueur.carteBateaux.verification(this.getB3X()-1, this.getB3Y()) == 0) {
                this.setB1X(this.getB1X()-1);
                this.setB2X(this.getB2X()-1);
                this.setB3X(this.getB3X()-1);
            }
        }
        else if(directionDuBateau.equals("BAS")){
            if(directionDuDeplacement.equals("HAUT") && joueur.carteBateaux.verification(this.getB3X(), this.getB3Y() - 1) == 0) {
                this.setB1Y(this.getB1Y()-1);
                this.setB2Y(this.getB2Y()-1);
                this.setB3Y(this.getB3Y()-1);
            }
            else if(directionDuDeplacement.equals("BAS") && joueur.carteBateaux.verification(this.getB1X(), this.getB1Y() + 1) == 0) {
                this.setB1Y(this.getB1Y()+1);
                this.setB2Y(this.getB2Y()+1);
                this.setB3Y(this.getB3Y()+1);
            }
            else if (directionDuDeplacement.equals("DROITE")
                    && joueur.carteBateaux.verification(this.getB1X()+1, this.getB1Y()) == 0
                    && joueur.carteBateaux.verification(this.getB2X()+1, this.getB2Y()) == 0
                    && joueur.carteBateaux.verification(this.getB3X()+1, this.getB3Y()) == 0) {
                this.setB1X(this.getB1X()+1);
                this.setB2X(this.getB2X()+1);
                this.setB3X(this.getB3X()+1);
            }
            else if (directionDuDeplacement.equals("GAUCHE")
                    && joueur.carteBateaux.verification(this.getB1X()-1, this.getB1Y()) == 0
                    && joueur.carteBateaux.verification(this.getB2X()-1, this.getB2Y()) == 0
                    && joueur.carteBateaux.verification(this.getB3X()-1, this.getB3Y()) == 0) {
                this.setB1X(this.getB1X()-1);
                this.setB2X(this.getB2X()-1);
                this.setB3X(this.getB3X()-1);
            }

        }
        else if(directionDuBateau.equals("DROITE")){
            if(directionDuDeplacement.equals("HAUT")
                    && joueur.carteBateaux.verification(this.getB1X(), this.getB1Y() - 1) == 0
                    && joueur.carteBateaux.verification(this.getB2X(), this.getB2Y() - 1) == 0
                    && joueur.carteBateaux.verification(this.getB3X(), this.getB3Y() - 1) == 0) {
                this.setB1Y(this.getB1Y()-1);
                this.setB2Y(this.getB2Y()-1);
                this.setB3Y(this.getB3Y()-1);
            }
            else if(directionDuDeplacement.equals("BAS")
                    && joueur.carteBateaux.verification(this.getB1X(), this.getB1Y() + 1) == 0
                    && joueur.carteBateaux.verification(this.getB2X(), this.getB2Y() + 1) == 0
                    && joueur.carteBateaux.verification(this.getB3X(), this.getB3Y() + 1) == 0) {
                this.setB1Y(this.getB1Y()+1);
                this.setB2Y(this.getB2Y()+1);
                this.setB3Y(this.getB3Y()+1);
            }
            else if (directionDuDeplacement.equals("DROITE")
                    && joueur.carteBateaux.verification(this.getB1X()+1, this.getB1Y()) == 0) {
                this.setB1X(this.getB1X()+1);
                this.setB2X(this.getB2X()+1);
                this.setB3X(this.getB3X()+1);
            }
            else if (directionDuDeplacement.equals("GAUCHE")
                    && joueur.carteBateaux.verification(this.getB3X()-1, this.getB3Y()) == 0) {
                this.setB1X(this.getB1X()-1);
                this.setB2X(this.getB2X()-1);
                this.setB3X(this.getB3X()-1);
            }
        }
        else if(directionDuBateau.equals("GAUCHE")){
            if(directionDuDeplacement.equals("HAUT")
                    && joueur.carteBateaux.verification(this.getB1X(), this.getB1Y() - 1) == 0
                    && joueur.carteBateaux.verification(this.getB2X(), this.getB2Y() - 1) == 0
                    && joueur.carteBateaux.verification(this.getB3X(), this.getB3Y() - 1) == 0) {
                this.setB1Y(this.getB1Y()-1);
                this.setB2Y(this.getB2Y()-1);
                this.setB3Y(this.getB3Y()-1);
            }
            else if(directionDuDeplacement.equals("BAS")
                    && joueur.carteBateaux.verification(this.getB1X(), this.getB1Y() + 1) == 0
                    && joueur.carteBateaux.verification(this.getB2X(), this.getB2Y() + 1) == 0
                    && joueur.carteBateaux.verification(this.getB3X(), this.getB3Y() + 1) == 0) {
                this.setB1Y(this.getB1Y()+1);
                this.setB2Y(this.getB2Y()+1);
                this.setB3Y(this.getB3Y()+1);
            }
            else if (directionDuDeplacement.equals("DROITE")
                    && joueur.carteBateaux.verification(this.getB3X()+1, this.getB3Y()) == 0) {
                this.setB1X(this.getB1X()+1);
                this.setB2X(this.getB2X()+1);
                this.setB3X(this.getB3X()+1);
            }
            else if (directionDuDeplacement.equals("GAUCHE")
                    && joueur.carteBateaux.verification(this.getB1X()-1, this.getB1Y()) == 0) {
                this.setB1X(this.getB1X()-1);
                this.setB2X(this.getB2X()-1);
                this.setB3X(this.getB3X()-1);
            }

        }
    }

    // Méthode de rotation TODO
    public void rotation(String directionDeRotation){

    }

}
