package Noyau;

import Carte.Carte;
import InterfaceGraphique.InterfaceUtilisateur;

public class Jeu {

    public static void main(String[] args){
        // Création de 2 joueurs
        Joueur joueurA = new Joueur();
        Joueur joueurB = new Joueur();

        InterfaceUtilisateur.run();

    }
}
