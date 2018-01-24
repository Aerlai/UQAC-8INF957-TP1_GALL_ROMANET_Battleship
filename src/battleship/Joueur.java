package battleship;

public class Joueur {
    // Nom du joueur
    String nom;

    // Création de 2 cartes :
    // - 1 Carte de placement des bateaux
    // - 1 Carte d'impacts
    Carte carteBateaux, carteImpacts;

    Joueur(){
        carteBateaux = new Carte();
        carteImpacts = new Carte();
    }
}
