package Carte;

import Noyau.Joueur;

public class Carte {
    private Element matrice[][] = {{null,null,null,null,null,null,null,null,null,null},
                          {null,null,null,null,null,null,null,null,null,null},
                          {null,null,null,null,null,null,null,null,null,null},
                          {null,null,null,null,null,null,null,null,null,null},
                          {null,null,null,null,null,null,null,null,null,null},
                          {null,null,null,null,null,null,null,null,null,null},
                          {null,null,null,null,null,null,null,null,null,null},
                          {null,null,null,null,null,null,null,null,null,null},
                          {null,null,null,null,null,null,null,null,null,null},
                          {null,null,null,null,null,null,null,null,null,null}};

    public Carte(){

    }

    // méthode d'ajout d'impacts
    public void placerImpact(int x, int y){
        matrice[x][y]= new Element(false,false,6);
    }
    // méthode d'ajout de bateaux
    public void placerBateau(int x, int y, int id, boolean avant){
        matrice[x][y]= new Element(true, avant, id);
    }
    // méthode de vérification d'une position
    public int verification(int x, int y) {
        if (matrice[x][y] != null) return matrice[x][y].getID();
        return 0; // 0 = rien
    }
    // rafraichir la carte
    public void refresh(Joueur joueur){
        // on efface les données
        for(int i=0;i<10;i++){
            for (int j=0;j<10;j++ ){
                matrice[i][j]=null;
            }
        }
        // On place les données des bateaux
        // porte Avion
        placerBateau(joueur.porteAvion.getB1X(),joueur.porteAvion.getB1Y(), 1, true); // Avant du bateau
        placerBateau(joueur.porteAvion.getB2X(),joueur.porteAvion.getB2Y(), 1, false);
        placerBateau(joueur.porteAvion.getB3X(),joueur.porteAvion.getB3Y(), 1, false);
        placerBateau(joueur.porteAvion.getB4X(),joueur.porteAvion.getB4Y(), 1, false);
        placerBateau(joueur.porteAvion.getB5X(),joueur.porteAvion.getB5Y(), 1, false);
        // croiseur
        placerBateau(joueur.croiseur.getB1X(),joueur.croiseur.getB1Y(), 2, true); // Avant du bateau
        placerBateau(joueur.croiseur.getB2X(),joueur.croiseur.getB2Y(), 2, false);
        placerBateau(joueur.croiseur.getB3X(),joueur.croiseur.getB3Y(), 2, false);
        placerBateau(joueur.croiseur.getB4X(),joueur.croiseur.getB4Y(), 2, false);
        // Contre torpilleur
        placerBateau(joueur.contreTorpilleur.getB1X(),joueur.contreTorpilleur.getB1Y(), 3, true); // Avant du bateau
        placerBateau(joueur.contreTorpilleur.getB2X(),joueur.contreTorpilleur.getB2Y(), 3, false);
        placerBateau(joueur.contreTorpilleur.getB3X(),joueur.contreTorpilleur.getB3Y(), 3, false);
        // Sous marin
        placerBateau(joueur.sousMarin.getB1X(),joueur.sousMarin.getB1Y(), 4, true); // Avant du bateau
        placerBateau(joueur.sousMarin.getB2X(),joueur.sousMarin.getB2Y(), 4, false);
        placerBateau(joueur.sousMarin.getB3X(),joueur.sousMarin.getB3Y(), 4, false);
        // torpilleur
        placerBateau(joueur.torpilleur.getB1X(),joueur.torpilleur.getB1Y(), 5, true); // Avant du bateau
        placerBateau(joueur.torpilleur.getB2X(),joueur.torpilleur.getB2Y(), 5, false);
    }
}
