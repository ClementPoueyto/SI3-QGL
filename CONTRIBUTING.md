# Contributing

## Plan
* [Introduction](#Introduction)
* [Gestion des branches](#Gestion-desBranches)
  * [Organisation des branches](#Organisation-des-branches)
  * [Créer une nouvelle branche pour développer une nouvelle fonctionnalité](#Ajouter-une-branche)
  * [Créer une pull Request](#Créer-une-pull-request)

## Introduction
Ce document indique comment participer à ce projet, comment soumettre ses contributions et effectuer des modifications.

## Gestion des Branches
  ### Organisation des branches
  Nos branches sont organisées de la façon suivante : 
  * une branche `master` pour les rendus
  * une branche `pre-prod` version stable et testée en vue du prochain rendu
  * une branche `newfeaturename` pour developper de nouvelles fonctionnalités
  
  ### Ajouter une branche
  Utiliser la commande suivante pour créer une nouvelle branche : 
  
  ```
  git checkout -b mynewbranchname
  ```
  
  Pour basculer sur une autre branche : 
  
  ```
  git checkout otherbranch
  ```
 
  
  ### Créer une pull request
  Aller sur Git et cliquer sur `Compare & pull request`.
  
  Ajouter un titre et une desciption à la pull request.
  
  Le code soumis doit être clair, commenté et testé pour que la pull request soit acceptée.
  
  Utiliser ensuite la commande `merge` pour fusionner les branches.
