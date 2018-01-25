package Noyau;

import Carte.Carte;
import Bateaux.*;

public class Joueur {
    // Nom du joueur
    String nom;

    // Création de 2 cartes :
    // - 1 Carte de placement des bateaux
    // - 1 Carte d'impacts
    Carte carteBateaux, carteImpacts;

    // Les bateaux du joueur
    PorteAvion porteAvion;
    Croiseur croiseur;
    ContreTorpilleur contreTorpilleur;
    SousMarin sousMarin;
    Torpilleur torpilleur;


    Joueur(){
        carteBateaux = new Carte();
        carteImpacts = new Carte();

        porteAvion = new PorteAvion();
        croiseur = new Croiseur();
        contreTorpilleur = new ContreTorpilleur();
        sousMarin = new SousMarin();
        torpilleur = new Torpilleur();
    }
}
