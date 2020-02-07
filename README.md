<!-- language: lang-none -->
Projet pour le cours CS107 de l'EPFL.

![Example](https://zupimages.net/up/20/06/j4mw.png)

## Lancement du jeu :
createDefaultLevel() de Level retourne deja Level1(), donc le simple fait d'executer la methode main vous mettra au Level1.
Si vous voulez changer le Level de debut, vous n'avez qu'a changer ce que createDefaultLevel() retourne.

## Controles :
	Bouton Haut : Saut
	Bouton Droite : Aller a droite
	Bouton Gauche : Aller a gauche
	Espace : Lancer une boule de feu
	'R' : Recommencer le niveau
	'P' : Lancer une bombe
	'S' : Switcher entre deux joueurs (Seulement au niveau 2)

## Niveaux :
###	Niveau1 (Level1) :
Commencez par aller tout a droite en evitant les fleches du haut et les spikes, vous arriverez devant un jumper, prenez le et allez a la plateforme du haut, aller maintenant tout a gauche en evitant les fleches, vous trouverez un jumper, mais l'issu est bloquée par une porte verte, allumez la torche a gauche, la porte disparaitra, sautez donc sur le jumper pour aller a la plateforme du haut, allez a nouveau a droite, prenez le jumper, et allez tout a gauche, il y a un levier, actionnez le, c'est l'un des levier responsable de l'ouverture de la porte de sortie (1).
Prenez le jumper pour aller a gauche, vous devrez tomber la ou il y a 9 torches et un signe d'explosion, vous pouvez allumer les trois torches du bas avec les boules de feu ou suivre l'indice de l'explosion et poser une bombe a cet endroit, cela devra mettre le mover en mouvement (attention, c'est un mover très rapide, assurez vous de bien vous placer a l'instant ou il commencera a bouger).
vous vous trouverez tout en haut, la, traversez les Spikes et prenez la clé jaune. (ATTENTION, n'activez pas le levier, sinon il fera apparaitre des portes qui vont vous deranger un peu plus loin)
Vous pouvez sauter et redescendre tout en haut de la partie ou vous avez commencer.
Allez maintenant tout a gauche, escaladez le mur pour vous trouvez pres du coeur, prenez le car vous aurez besoin de vie pour la partie a suivre.
prenez les deux jumper a la file pour atterir dans une plateforme ou il y'a un bouton dynamique et un bloc led, lié a un signal oscillateur de une seconde.
en appuyant sur le bouton, le premier mover se levera, vous deverez quitter le bouton et aller rapidement de l'autre coté, ou vous trouverez un levier, et ce levier est connecté au deuxieme mover avec l'oscillateur lié au bloc led, vous devrez donc activer le levier et attendre que l'oscillateur soit actif pour que ldeuxieme mover descende.
descendez vite pour prendre la clé, faites attention aux fleches qui vous n'arretes pas, ensuite montez et retournez la ou il y'avait des jumper dans l'air, laissez vous tomber cette fois, vous trouverez une entree soutairraine, mais ce n'est encore pas le moment d'y aller, dirigez vous a droite, vous trouverez des portes vertes et bleus, liées a un oscillateur, quand l'unes aparaissents, les autres disparaissent, faites attention, cette partie est legerement difficile, mais vous devez passer par la pour activer le deuxieme levier responsable de l'ouverture de la porte (2).
Retournez maintenant a l'entree souterraine dont on a parlé precedement, allez tout a gauche, vous trouverez le 3eme levier (3).
Descendez plus bas, au niveau de la porte, et allez tout a droite, vous trouverez le 4eme levier (4).
La porte est desormais ouverte.

Explications du levier ne servant a rien tout en haut + clé jaune + clé rouge :
La clé jaune et la clé rouge sont responsable a la disparition de deux porte pres de la porte Exit, sans elles, vous ne pourrez pas atteindre la porte Exit
Pour ce qui est du levier ne servant a rien mais qui vous bloque le passage une fois activé, en l'activant, vous ne pourrez plus atteindre la partie souterraine du niveau car des portes bleus vous bloqueront le passage.

###	Niveau2 (Level2) :
Ce niveau est assez special, vous devrez utilisez la touche S pour switchez entre les deux joueurs.

Vous commencez avec le player1 devant un bouton et des portes, mettez le player1 sur le bouton et switchez.
Le mover devant le player2 vous ouvre alors le passage vers 3 torches, la torche du bas est inutiles, allumez les 2 d'en haut, et switchez vers le player1.
Refaites la meme choses pour les deux torches d'en bas du player1, cela ouvrira le passage vers le player2, sautez par dessus les spikes et mettez vous pres du mover, ensuite switchez.
Avec le player2, vous devrez monter sur le bloc et activer le levier, switcher rapidement vers le player1, passer le mover et prendre la clé verte ensuite reswticher vers le player2 pour passer la porte verte qui vient de disparaitre avant que les fleches ne vous fassent trop de degats.
Vous voila dans la meme situation avec les deux players, vous avez une torche et un mover.
Le signal du mover du haut est : La torche du bas ET NON(La torche du haut)
Le signal du mover du bas est : La torche du haut ET NON(La torche du bas)
vous devrez ainsi allumer la torche du haut avec le player2, passer le mover avec le player1, lancer une boule de feu vers la torche du bas ensuite switcher vers le player2 et souffler sur la torche du haut pour que le mover vous ouvre le passage.
Avec le player2, allez au dessus du mover, tout a droite pour eviter les fleches une fois le mover ouvert, switchez vers le player 1, posez vous sur le bouton et attendez que le player2 tombe au niveau du dessous, maintenant, vous verrez un bouton a la gauche du player2, situé sous un arc, ce bouton est responsable du mover laissant le passage au player1, ouvrez le, sautez sur le jumper avec le player 1 et allez pres de la porte bleue, switchez vers le player2 et aller pres de l'autre porte bleue pour vous poser sur le bouton, ce dernier ouvre la voie au player 1, continuez avec le player 1 pour vous poser sur le bouton a sa droite, ce qui ouvrira la porte pres du player 2.
Voila vos deux players enfin reunis pres de la porte, posez les sur les boutons non dynamiques bleus, ce qui ouvrira la porte.

###	Niveau3 (WeirdLevel) :
Ce niveau est aussi assez special, la porte est deja ouverte, et vous avez deux choix, appuyer sur le bouton, puis entrer, ou entrer directement.

Si vous entrez directement sans appuyer, vous aurez l'ecran de fin avec The End (Vous passez a EndLevel)
Si vous appuyez puis entrer, vous passerez vers un autre niveau, le SecretLevel.

###	Niveau4 (SecretLevel) :
Ce niveau est inutile, vous vous trouverez sur une plateforme, si vous mourrez, vous recommencerez le meme niveau, si vous prenez l'etoile PUIS vous mourrez, vous aurez EndLevel encore une fois.

A noter : L'etoile vous permet de sauter a l'infini :).

###	Niveau5 (EndLevel) :
Ecran de fin ("The End" ecrit en noir sur un fond blanc).

