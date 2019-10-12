## Nom du projet
EscapeGameOC

## Auteur et copyright
Elena Gebel

## Description

C’est un jeu numérique basé sur le concept des Escape Games. 
Dans ce projet il y a 3 modes de jeu différent.

Mode Challenger : l’utilisateur essaye de deviner la combinaison secrète de l’ordinateur (Intelligence Artificielle). 
L'intelligence artificielle de l’ordinateur indique pour chaque chiffre de la combinaison proposée si le 
chiffre de sa combinaison est plus grand (+), plus petit (-) ou si c’est le bon (=).
Mode Défenseur : l’ordinateur essaye de trouver la combinaison secrète de l’utilisateur.
Mode Duel : L’utilisateur et l’ordinateur jouent tour à tour. Le premier à trouver la combinaison secrète de l'autre a gagné.

## Réalisé avec
* JDK 13(https://jdk.java.net/13/) 
* IntelliJ IDEA environnement de développement intégré (https://www.jetbrains.com/idea/) 
* Maven un outil de gestion et d'automatisation de production des projets
(https://maven.apache.org/) 
* Log4j une API de journalisation (https://logging.apache.org/log4j/2.x/)
 
## Le code source de l’application
https://github.com/ElenaGebel/EscapeGameOC.git

## Fichier de configuration
EscapeGameOC/src/main/resources/config.properties
* combinationNum nombre de chiffres dans la combinaison
* tryNum nombre d’essais
* algorithmType  algorithme pour générer la proposition de l'intelligence artificielle 
  1 pour algorithme binaire et 2 pour algorithme random
* modeDeveloper mode "développeur" activé ou non

## Journalisation
EscapeGameOC/output/output.log

## JavaDoc
https://elenagebel.github.io/EscapeGameOC/JavaDoc/
