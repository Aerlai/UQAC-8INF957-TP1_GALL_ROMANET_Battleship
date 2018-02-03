package Noyau;

import Carte.Carte;
import Bateaux.*;

public interface Joueur {
    void attaquer(ImplementationJoueur joueur, Bateau bateauAttaquant, int x, int y);
    void deplacer(int id, String directionDuDeplacement);
    void tourner( Bateau ship);
    void placer(int id, int bloc, int x, int y);
}
