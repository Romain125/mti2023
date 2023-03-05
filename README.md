# Sujet de projet MTI "JEE/Frameworks" 2023
# Projet : La salle sur demande

Poudlard est une école de magie, et elle cherche à se moderniser !

Les élèves ont maintenant tous un smartphone et trouvent beaucoup plus pratique le fait de pouvoir réserver des salles de classe (pour réviser par exemple) par téléphone plutôt que d'utiliser des sortilèges barbants.

Il s'agit de créer le backend d'une application web, et sa base de données pour permettre la gestion des salles de cours et de leurs réservations.

## Gestion des salles

Dans un premier temps, l'application sert à répertorier l'ensemble des salles :

Une salle possède :
- Un nom
- Un type (Potion, Sortilège, Botanique, Quidditch, Bureau, Commune)
- Une surface (en m²)
- Une date de création
- Le nom du créateur (le directeur de l'époque)

Seul le directeur actuel a le droit :
- D'afficher la liste des salles de classe
- De créer une salle de classe
- De créer une liste de salles en important un fichier CSV
- (La suppression et la modification ne sont pas demandées)

-------------------

## Gestion des réservations

Dans un second temps, l'application sert à gérer la réservation de ces salles sur certaines plages horaires.

Les élèves peuvent :
- Afficher la liste des salles avec un statut "Réservable" à Vrai/Faux (seules les salles de type Potion, Sortilège, Botanique, Quidditch sont réservables)
- Afficher pour une salle donnée, tous les futurs créneaux de réservation dans l'ordre chronologique
- Afficher l'ensemble de ses propres réservations pour toutes les salles
- Effectuer une réservation avec une date de début, ainsi qu'une date de fin
    - Il n'est pas possible de créer une réservation avec une date de début dans le passé
    - Il n'est pas possible de créer une réservation avec une date de fin inférieure à la date de début
    - Il n'est pas possible de créer une réservation plus d'un mois à l'avance
    - Il n'est pas possible de créer une réservation s'il y a une autre réservation sur la même salle chevauchant la plage horaire
    - La création d'une réservation déclenche également l'envoi d'un mail de confirmation (bouchonné par un system.out.println)

Les professeurs peuvent effectuer les mêmes actions que les élèves. En plus, ils peuvent :

- Supprimer une réservation
  - La supression est doublée d'un mail prévenant la personne ayant effectué la réservation (bouchonné par un system.out.println)

------

## Liste des utilisateurs

Voici la liste des utilisateurs devant avoir accès à l'application.

| Username     | Password        | Role       |
|--------------|-----------------|------------|
| h.potter     | quidditch       | étudiant   |
| h.granger    | devoirs         | étudiant   |
| r.weasley    | chocogrenouille | étudiant   |
| m.mcgonagall | chat            | professeur |
| s.rogue      | lily            | professeur |
| a.dumbledore | sorbet_citron   | directeur  |

------

## Technologies

L'application doit être faite avec les notions vues en cours. Cela comprend :
- Une application Java 17 + Spring-boot avec une version > 3.0
  - Spring-web
  - Spring-data-jpa
  - Spring-security
- L'utilisation de maven pour importer les librairies nécessaires
- Toute persistance doit se faire avec une base de données mémoire H2
- Une architecture monolithique en 4 couches distinctes

## Rendu

Voici la liste des éléments à rendre afin d'être corrigé :
- L'adresse d'un repo git contenant le code source de votre projet
  - Les repos seront clonés à date et heure du rendu. Tout commit effectué après ne sera pas pris en compte.
  - Pensez à ajouter votre professeur en lecture sur le repo...ça serait dommage pour vous qu'il ne puisse pas clôner votre projet à heure dite...
- La liste des personnes ayant participé à ce projet doit se trouver à l'endroit approprié dans le pom.xml
- Un *.jar *auto-exéutable* (type fat-jar) dans un dossier "jar" à la racine de votre projet. Le jar doit pouvoir s'exécuter sans autre configuration externe.
- Un *.csv dans un dossier "csv" pour tester l'API de création de salles en masse.
- L'adresse de votre swagger-ui (ou à défaut, une documentation d'API explicite pour tester votre projet)
- Indiquez également dans le fichier readme.md à la racine de votre projet les choses à savoir qui pourraient intéresser le correcteur

## Point d'attention

Le sujet n'a rien de techniquement complexe. Il est volontairement fonctionnellement simple pour vous permettre de mettre l'accent sur les bonnes pratiques et la maintenabilité. Une grosse partie des points sera attribué à cet effet.
Cela comprend :
- L'utilisation d'un nommage de classe/variable/méthode propre
- Des méthodes claires, petites et auto-portantes
- L'application des principes SOLID
- Peu de duplication (DRY)
- Pas de code mort (YAGNI)
- Des bonnes pratiques dans la conception de vos APIs HTTP

Il n'est pas nécessaire d'effectuer de documentation (type javadoc), et les tests automatisés sont facultatifs (car non abordés pendant ce cours), mais cela vous sera demandé dans le monde de l'entreprise.
Il n'est pas demandé de dossier et il ne sera demandé de soutenance. Le code doit être suffisamment propre et explicite pour ne pas avoir besoin d'explications.

Tout projet suspicieusement similaire sera sanctionné.

## Bon courage !

-----
*Tous droits réservés : J.K.Rowling*
