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
    public void attaquer(Joueur joueur, int x, int y){

    }

    // Déplacement durant la partie
    public void deplacer(Bateau ship){

    }

    // Rotation de bateau
    public void tourner( Bateau ship){

    }

    // Placement initial des bateaux par le joueur
    public void placer(){

    }
}
