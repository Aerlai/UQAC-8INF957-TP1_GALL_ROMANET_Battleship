package Carte;

import java.util.Observable;

public class Element extends Observable {
    // Si bateau sinon impact
    private boolean bateau;
    private boolean teteDeBateau;
    private int id; // porte-avion: 1 ; croisseur : 2 ; contreTorpilleur = 3 ; sous marin : 4 ; torpilleur : 5 ; vide : 6 ; impact : 7 ; impact bateau : 8

    public Element(boolean bateau, boolean teteDeBateau, int id){
        this.bateau = bateau;
        this.teteDeBateau = teteDeBateau;
        this.id = id;
    }

    public int getID(){
        return id;
    }
    public void setID(int id){
        this.id=id;
    }
}
