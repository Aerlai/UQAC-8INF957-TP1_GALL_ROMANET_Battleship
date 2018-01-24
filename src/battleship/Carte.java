package battleship;

public class Carte {
    Element matrice[][] = {{null,null,null,null,null,null,null,null,null,null},
                          {null,null,null,null,null,null,null,null,null,null},
                          {null,null,null,null,null,null,null,null,null,null},
                          {null,null,null,null,null,null,null,null,null,null},
                          {null,null,null,null,null,null,null,null,null,null},
                          {null,null,null,null,null,null,null,null,null,null},
                          {null,null,null,null,null,null,null,null,null,null},
                          {null,null,null,null,null,null,null,null,null,null},
                          {null,null,null,null,null,null,null,null,null,null},
                          {null,null,null,null,null,null,null,null,null,null}};

    Carte(){

    }

    // méthode d'ajout d'impacts
    void placerImpact(int x, int y){
        matrice[x][y]= new ElemImpact();
    }
    // méthode d'ajout de bateaux
    void placerBateau(int x, int y){
        matrice[x][y]= new ElemBateau();
    }
}
