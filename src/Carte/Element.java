package Carte;

public class Element {
    // Si bateau sinon impact
    private boolean bateau;
    private boolean teteDeBateau;
    private int id; // porte-avion: 1 ; croisseur : 2 ; contreTorpilleur = 3 ; sous marin : 4 ; torpilleur : 5 ; impact : 6

    public Element(boolean bateau, boolean teteDeBateau, int id){
        this.bateau = bateau;
        this.teteDeBateau = teteDeBateau;
        this.id = id;
    }

    public int getID(){
        return id;
    }
}
