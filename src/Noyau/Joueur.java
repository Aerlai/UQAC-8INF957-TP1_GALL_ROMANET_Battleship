package Noyau;

import Carte.Carte;
import Bateaux.*;

public class Joueur {
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
    Joueur(){
        carteBateaux = new Carte();
        carteImpacts = new Carte();

        porteAvion = new PorteAvion();
        croiseur = new Croiseur();
        contreTorpilleur = new ContreTorpilleur();
        sousMarin = new SousMarin();
        torpilleur = new Torpilleur();
    }

    // attaque d'une position de l'adversaire
    public void attaquer(Joueur joueur, Bateau bateauAttaquant,  int x, int y){
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
    public void deplacer(Bateau ship){

    }

    // Rotation de bateau TODO
    public void tourner( Bateau ship){

    }

    // Placement initial des bateaux par le joueur TODO
    public void placer(){

    }
}
