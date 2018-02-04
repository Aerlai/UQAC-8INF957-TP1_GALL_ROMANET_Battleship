package Noyau;

import Carte.Carte;
import Bateaux.*;

public interface Joueur {
    void attaquer(ImplementationJoueur joueur, Bateau bateauAttaquant, int x, int y);
    void deplacer(int id, String directionDuDeplacement);
    void tourner( Bateau ship);
    void placer(int id, int bloc, int x, int y);
    void placerhaut(int id, int x, int y);
    void placerbas(int id, int x, int y);
    void placergauche(int id, int x, int y);
    void placerdroite(int id, int x, int y);
    void tourFini();
    boolean estVivant();
    Bateau getBateauEnJeu();

    Carte getCarteBateaux();
    Carte getCarteImpacts();

    Bateau getPorteAvion();
}
