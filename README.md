# TP1_GALL_ROMANET_Battleship

## UQAC - 8INF957 - Programmation orienté objet avancé

## DEVOIR I : BATTLESHIP+ (10%)

### EXIGENCES
Notre mission est d’implémenter le jeu Bataille Navale avec un plus (Battleship+). Pour ceux qui ne l’ont jamais joué, c’est un classique (Wikipédia).

Règles du jeu :
#### 1.Deux joueurs, et chaque joueur a une flotte composée de 5 bateaux (cases, champ de tir) :
1. Porte-avion (5, 2), 
2. battleship.Croiseur (4, 2)
3. Contre torpilleur (3, 2)
4. Sous-marin (3, 4)
5. battleship.Torpilleur (2, 5)

#### 2. Un tir est limité à un champ de tir vertical ou horizontal. (à définir pour chaque bateau)

#### 3. Après un tir raté, l’adversaire a le droit de déplacer un bateau jusqu’à deux positions.

#### 4. Un bateau touché plus que 2 fois, doit être détruit.

Votre programme doit permettre de jouer à Battleship+ suivant toutes les règles contre un adversaire (personne ou machine). Pendant la phase de configuration,  l'interface  devrait  permettre  aux  joueurs  de  visualiser  la 
carte et de sélectionner les emplacements pour placer chaque bateau. Le programme doit afficher les deux grilles, inviter les joueurs à choisir une 
position d’attaque, chacun à son tour, et annoncer le gagnant.
Toutes  les  entrées  invalides  lors  de  la  saisie  de  l'utilisateur  doivent  se traduire  en  un  message  d'erreur  et  ainsi  permettre  à  l'utilisateur  de 
réessayer. Le programme ne doit pas tomber en panne. 
Vous pouvez opter pour une application console. L’objectif est d’utiliser une approche   claire   suivant   le   paradigme   objet   (abstraction,   héritage, 
modularité).

### LIVRABLES
* Avant le 05 février 2018
* Par courriel: un lien vers un dépôt Github
