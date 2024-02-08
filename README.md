# Frogger
Le travail doit être effectué en binôme, au sein d'un même groupe de travaux pratiques. Vos codes doivent être envoyés à vos chargés de TP au plus tard le 11 décembre, accompagnés d'un bref rapport résumant le travail réalisé, les difficultés rencontrées, les solutions envisagées et/ou mises en œuvre (d'une demi-page à deux pages). Les soutenances auront lieu pendant vos créneaux de TP, les 13 et 14 décembre. Vous serez évalués principalement sur votre réalisation, ainsi que sur le travail d'équipe, l'organisation, l'auto-analyse et la présentation. 

La partie 1 est relativement simple et devrait être achevée dès la première séance encadrée. La partie 2 est plus conséquente ; il est attendu qu'elle soit opérationnelle pour la soutenance. La partie 3 ne sera abordée qu'une fois la partie 2 terminée. Ensuite, vous traiterez un sujet au choix parmi ceux présentés en partie 4. Divers bonus sont proposés ; si vous avez terminé les quatre parties requises, vous pouvez vous attaquer à ceux qui vous intéressent. Ceux-ci représentent des projets de très bonne qualité, mais ils ne présentent pas tous la même difficulté. Prenez le temps de réfléchir à la conception avant de vous lancer. N'oubliez pas de préciser ce que vous avez traité ou abordé dans votre rapport et lors de votre soutenance.

## Le sujet : Frogger
Frogger, un jeu d'arcade des années 80, a connu diverses adaptations depuis sa création. Le concept est simple : faire traverser une rue à une grenouille en évitant les voitures qui circulent. Ce projet vous invite à coder un petit jeu basique similaire. L'objectif est d'amener une "grenouille" du bas de la fenêtre de jeu jusqu'au sommet de celle-ci. L'écran est composé d'une série de lignes. La première ligne représente la ligne de départ, ne contenant rien d'autre que la grenouille (au début de la partie et lorsqu'elle revient). La dernière ligne est également vide, atteindre celle-ci signifie gagner la partie. Entre les deux, chaque ligne représente une voie de la route, avec des voitures de taille variant de 1 à 3 blocs contigus, se déplaçant de gauche à droite ou de droite à gauche. Toutes les voitures d'une même voie se déplacent à la même vitesse. De nouvelles voitures apparaissent de manière aléatoire au début de chaque ligne. Le joueur contrôle la grenouille à l'aide des quatre flèches du clavier. Une collision avec une voiture entraîne la défaite.

### La grenouille
Pour commencer, vous devrez coder la classe Frog, chargée de gérer la grenouille, en utilisant un environnement déjà fourni.

Tout d'abord, téléchargez le squelette fourni (squelPartie1.zip, à extraire) ainsi que la bibliothèque pour l'environnement (givenEnvironment.jar, qui ne doit pas être extrait). Créez un nouveau projet et importez-y le squelette fourni, puis liez la bibliothèque (reportez-vous à l'annexe d'aide au lancement du projet si nécessaire).

Le squelette est organisé en plusieurs packages :

- frog : ce package devra contenir la classe ou les classes gérant la grenouille. Vous y trouverez la classe Frog que vous devez compléter.
- graphicalElements : contient la gestion de l'interface graphique. L'interface IFroggerGraphics vous fournit les méthodes disponibles pour l'utilisateur. La classe Element permet de définir une case et une couleur, ce qui est utile pour demander l'affichage d'un carré de cette couleur à ces coordonnées (via les méthodes fournies dans IFroggerGraphics). Vous n'avez pas besoin de lire FroggerGraphic, la classe concrète qui gère l'affichage de base proposé, vous l'utiliserez à travers son interface.
- gameCommons : contient les entités permettant de gérer la partie de manière générale. Les interfaces IFrog et IEnvironment décrivent les actions qui doivent être disponibles pour le contrôle de la grenouille et de l'environnement respectivement. La classe Game gère une partie de jeu, que vous devrez compléter ; elle ne dépend que des interfaces pour l'environnement et la grenouille et ne doit pas dépendre directement des classes concrètes que vous implémentez. La classe Main permet de lancer le jeu, et vous n'avez normalement pas besoin d'y toucher, sauf pour modifier les classes concrètes de grenouille et d'environnement utilisées.
- util : contient les définitions des types Case et Direction, utiles à travers tout le projet.

Dans cette première partie, vous devrez coder Frog, ainsi que compléter certaines méthodes de Game (les tests de victoire et de défaite). Vous devez respecter l'interface donnée et être compatible avec les éléments fournis. Les interfaces (IFrog, IEnvironment) ainsi que le package graphicalElements ne doivent pas être modifiés.

À la fin de cette étape, vous devez obtenir un jeu fonctionnel, similaire à celui donné en exemple (FroggerExample.jar).

Une entité de type enum, Direction, vous est donnée : il s'agit d'un type énuméré. Un objet de type Direction a uniquement quatre valeurs possibles : up, down, right et left, désignées par Direction.up, Direction.down, Direction.right et Direction.left. C'est un type, donc des objets de ce type peuvent être passés en argument, stockés dans des variables ou retournés par des méthodes. Il est également possible de les comparer : if (myDirection == Direction.up).

Sauvegardez une version stable de votre projet une fois cette étape terminée.

### L’environnement : Suite de routes

L'objectif de cette partie est de recoder votre propre environnement, constitué de plusieurs classes, idéalement dans son propre package, sans modifier le reste du code. Un squelette vous est proposé : squelPartie2.zip.

Commencez par remplacer, dans la classe Main, cette ligne :
```java
//Création et liaison de l’environnement
IEnvironment env = new GivenEnvironment(game);
```
par celle-ci :
```java
//Création et liaison de l’environnement
IEnvironment env = new Environment(game);
```

Le schéma proposé se compose des éléments suivants :

- un environnement global, composé d’une route de plusieurs voies
- une voie a un sens (de gauche à droite ou de droite à gauche), une densité (qui détermine la probabilité qu’une voiture entre sur la voie) et une vitesse. Elle contient un ensemble de voitures.
- une voiture a une taille, une position, un sens et une vitesse (ces derniers correspondant à ceux de la voie sur laquelle elle est).

Le squelette fourni contient ces éléments à compléter, tout en respectant l’interface IEnvironment qui ne doit pas être modifiée. Il n’est pas nécessaire de modifier Game, Main ou la partie Frog codée précédemment.

Vous avez plusieurs méthodes à ajouter et pouvez en créer autant que nécessaire pour l’exécution et la lisibilité de votre programme. Vous pouvez parfaitement ajouter, supprimer ou modifier des attributs.

La méthode mayAddCar() de Lane (voie) vous est fournie : elle permet de tirer aléatoirement, selon la densité de la voie, l’apparition d’une voiture "juste avant" la première case de la voie. Vous pouvez l’utiliser pour faire apparaître des voitures lors de l’actualisation du modèle (après le déplacement des voitures déjà en place).

Sauvegardez une version stable de votre projet une fois cette étape terminée. Vous devrez présenter une version fonctionnelle de cette partie en soutenance, et exposer vos choix et difficultés.

### Jeu infini

Vous allez maintenant écrire des variantes des classes précédentes pour jouer à un jeu légèrement différent : il n’y a maintenant plus de ligne d’arrivée, le monde est infini et chaque déplacement vers le haut fait apparaître une nouvelle voie à l’écran. Pour que la fenêtre reste de taille fixe, votre grenouille sera toujours affichée à la même hauteur et les anciennes lignes (celles trop loin sous la grenouille) ne seront plus affichées. Un exemple de résultat vous est donné sur la page du cours, en tant que fichier jar exécutable : InfiniteFroggerExample.jar.

Après avoir réfléchi à comment l’implémenter, créez de nouvelles classes FrogInf et EnvInf pour gérer ce nouveau mode de jeu. Vous pouvez modifier d’autres classes. Vous êtes ici autorisés à modifier les interfaces, à bon escient et en assurant la compatibilité avec les modules précédemment développés ! Il n’est pas nécessaire de modifier le package graphicalElements.

De plus, vous pouvez ajouter un score, affiché à la fin de la partie, correspondant à la ligne la plus haute jamais atteinte.

Sauvegardez une version stable de votre projet une fois cette étape terminée, vous devrez la présenter en soutenance.

Assurez-vous que vous pouvez inclure les différents modules développés dans le même projet et lancer les différentes versions en modifiant minimalement le Main.

### Éléments complémentaires

Choisissez de traiter un ou plusieurs éléments parmi les trois suivants. Si les développements sont incomplets, veuillez présenter brièvement vos idées, démarches et ce qui vous a empêché d'aller jusqu'au bout dans votre rapport. Ajoutez des commentaires pour expliquer les codes incomplets ou buggués. Vous serez évalués sur votre capacité à vous auto-analyser.


## Objectif et travaille
On veut coder le célèbre jeu Frogger de 1981 pour cela on a découper le cahier des charge en plusieurs partie en allant de 1 à 5
Nous avions jusqu’au 3 décembre pour rendre un projet en groupe de 2.
Nous avons travaillé au SIF et chez nous avec l’aide de discord/Codimd et du github. 

## Repartition du travail (Codimd)
Cheima :
Normal - Partie 2
*** (2.2) Lane***
*** (2.3) Envionnement***
Infini - Partie 3
*** (3.1) FrogInf ***
*** (3.3) EnvInf ***
*** (3.5) Game.java ***
Infini + piège - Partie 4
*** (5.1) Timer ***
*** Case Bonus (score) ***

Chloé
Normal - Partie 1
***(1.1) la partie fonctionnel de la grenouille***
***(1.2) Game avec un GivenEnvironment***
Normal - Partie 2
***(2.1) Car***
Infini - Partie 3
***(3.1) FrogInf ***
***(3.3) EnvInf ***
***(3.5) Game.java ***
Infini + piège - Partie 4
*** piege perte de point (piege) ***

## GivenEnvironment
Github ( Commit, premier pas vers le git)
Infini ( EnvInf )
piege perte de point (piege) 

## Ce qu’on aurait voulu faire de plus (Partie 5)
Multijoueurs
Ajouter un nouveau graphisme
Menu avec choix
FroggerInfinity à difficulté croissante

## Conclusion
Dans l’ensemble, nous pensons avoir mené à bien notre projet malgré les difficultés de compréhension du sujet ( Tout n’était pas bien expliqué il fallait poser des questions afin de parvenir à un résultat convenable et qui fonctionne) 

Nous aimerions pour une potentielle prochaine fois, avoir plus de temps (notamment pendant les créneaux de TP) pour faire notre projet afin de pouvoir poser plus de question directement au chargé de TD ainsi que plus d’indication sur les élements/Methode à faire.

codimd : https://codimd.math.cnrs.fr/qbEVpm9YQKaj8ypRo3zG6Q?edit
