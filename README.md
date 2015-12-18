# Chess-Project---M1-MIAGE
## Projet

Analyser des parties d'échecs :
- Affichage de l’évolution du score pour n’importe quelle partie : on peut jouer la partie avec un lecteur PGN classique et en-dessous l’évolution du score, pré-calculée et disponible dans la base, se visualise
- Classement des parties selon l’évolution du score globale (eg la somme des fluctuations de score)
- Possibilité de détecter les échecs et mat oubliés dans certaines parties
- Possibilité de trier par la force des joueurs impliqués dans la partie
- Possibilité de visualiser la position au moment où l’échec et mat est oublié
- Classement des plus grosses évolutions de score d’une position (avec possibilité de visualiser la position considérée)

##Analyses
###Global
* Classement des 5 meilleurs joueurs.

* Classement des 5 meilleures parties par score global.

* Statistiques base de données : 
    - Nombre de parties	
    - Nombre de joueurs	
    - Nombre d'evenements

###Joueurs

- Pourcentage de jeu gagné
- Nombre d'erreurs (echecs et mat oublié)


###Parties
Tableau avec 
- date du jeu
- Evenement
- White Player
- Black Player
- Opening
- Result 

Pour chaque partie
- Fluctuation du score
- Possibilité de rejouer la partie

###Ouvertures

Tableau avec 
- Nom de l'opening
- Moves associés
- Nombre de moves

Pour chaque ouverture
- Possibilité de rejouer à partir de l'ouverture
- Pourcentage des victoires (blanc, noir, ex aequo)

###Evolution du score à partir d'une position

- Meilleures évolutions de score à partir d'une position

##Technologies : 
- datatables.js : plug-in javascript pour gestion de tableau de données JSON en html
- highcharts.js : plug-in javascript pour faire des graphiques HTML à partir de données JSON 
- chessboard.js : is a standalone JavaScript Chess Board
- JSON : JavaScript Object Notation), open standard format to transmit data objects consisting of attribute–value pairs.
- JAVA : Programming language that is concurrent, class-based, object-oriented,
- HTML : HyperText Markup Language is the standard markup language used to create web pages
- CSS : Cascading Style Sheets (CSS) is a style sheet language used for describing the presentation of a document written in a markup language
- Javascript : is a high-level, dynamic, untyped, and interpreted programming language.
- mySQL : is an open-source relational database management system 
- JUnit 4 : is a unit testing framework for the Java programming language. 

##Architecture développement java :
Package
- objet : MODEL
- json : traitement JSON
- database : extraction des données de la base de données
- analysis : analyses des données
- run : point d'entrée
- tools : classes utiles
- unitTest : tests unitaires
