# Recherches

## Qu'est-ce qu'un film

Un film est une oeuvre cinématographique ([*cf Défintion*](https://www.cnrtl.fr/definition/film)).

Un film peut être caractérisé par :

- Un Identifiant
  
  par exemple le code IMDB **tt0078346** (voir site IMDB <https://www.imdb.com/title/tt0078346/>)
  
  Il existe également le n° ISAN **ISAN0000-3BAB-9352-0000-G-0000-0000-Q** enregistré par l'agence ISAN (voir le site de l'ISAN) <https://www.france-isan.org/bienvenue-accueil-welcome.html>

- Un titre de film

  Ce titre peut-être identique pour plusieurs film, voilà pourquoi il est nécessaire d'ajouter un identifiant unique.

  Un exemple de 10 films qui ont le même titre et qui n'ont vraiment rien à voir <http://www.topito.com/top-films-meme-titre-mais-rien-a-voir>

- Un synopsis

C'est un résumé condensé du scénario du film

- Les infos pour les choix :
  - Un genre

  Une explication des genres cinématographiques sur [Wikipédia](https://fr.wikipedia.org/wiki/Genre_cin%C3%A9matographique#Les_genres_par_cat%C3%A9gories)

  - [une liste des genre est disponible ici](documentation/genre_list.md)

  - Un réalisateur
  - Les acteurs
  - la durée
  - ...

## Qu'est-ce qu'un cinéphile

Un cinéphile est une personne qui s'identifie avec un identifiant permettant de la reconnaitre ayant des goûts cinématographique.

Le cinéphile peut être caractérisé par :

- Un identifiant unique permettant de reconnaitre ce cinéphile
  - L'identifiant peut-être une connexion OAuth2 (Github, Amazon, Netflix, ...). La liste des providers OAuth2 est disponble [ici](https://en.wikipedia.org/wiki/List_of_OAuth_providers)
- Une liste de film déjà vu par ce cinéphile pouvant comporter ses avis pour cibler les goûts de ce cinéphile

## Comment classer un film

Un questionnnaire a été envoyé pour définir ce qu'un cinéphile aimerait voir dans l'application.

- par popularité (nombre d'avis positifs sur nombre de vues),
- par notes de film (note des cinéphiles),
- par durée

## Qu'est-ce qu'un goût cinématographique

- genre(s)
- réalisateur(s)
- les acteurs
- les durées de film

  **De manière générale on peut peut-être permettre à l'utilisateur de définir ses genres, réalisateurs, acteurs préférés**

- Le cinéphile pourrait choisir l'ordre de préférences des critères de tri :
  - en 1er les avis
  - en 2nd les acteurs
  - en 3ème le genre

Le cinéphile a choisi dans ces meilleurs films (vote par note) le genre Drama, l'algo lui fournit une liste de films Drama les mieux notés par d'autres cinéphiles.

Le cinéphile a vu plus de genre Thriller, l'algo lui propose une liste de Thriller les mieux notés.

Dans sa liste des films que le cinéphile a vu, je veux identifier un classement dans les genres pondérer par la note du cinéphile (J'ai vu beaucoup de Thriller mais je les ai noté de 1 à 3 alors que j'ai vu 3 comédie que j'ai noté 7 à 9).

## Comment ajouter des films dans la liste de référence des vidéos

- Depuis une base de données en ligne
  - <http://www.omdbapi.com/>
- Depuis un répertoire où sont stockées ces films
  - Prévoir une norme de nommage des fichiers vidéos
- Depuis un formulaire qui serait rempli par un cinéphile pour ajouter un film déjà vu par le cinéphile

## Qu'est-ce qu'une vidéo adaptée au goût cinématographique

- C'est une vidéo qui par ses infos correspond avec un degré suffisant aux critières extraits de la liste des vidéos/séries visionnées par l'utilisateur (genres, réalisateurs et acteurs des films visionnés)

## Qui aime quoi comme genre de film

Relié un cinéphile à une liste de films sur lesquels il aura fournit des avis.

- gestion de profil utilisateur via providers OAuth2
- gestion de profil utilisateur via formulaire de profil 

## Comment trouver la liste de film d'un cinéphile

- En fonction des films déjà vus par le cinéphile et ses avis.
- Chaque utilisateur a une liste de films vus liée à son compte/profil.

## Où trouver les infos d'un film

1. https://www.themoviedb.org/
  
   - contient des informations en plusieurs langues (FR, EN, DE, ...)
   - API beaucoup plus complète
   - API sans restrictions

1. http://www.omdbapi.com/ 

   - contient des informations que TMDB n'a pas comme :
     - la liste des acteurs
     - le Réalisateur
     - le "IMDB Rating"
     - le "IMDB votes"
   - a une restriction sur le nombre de requête par jour (1000 req / jr)

## Peut-on poster des avis et voter pour ses films préférés

- Oui, et c'est nécessaire pour connaitre les goûts du cinéphile

- Un avis peut être défini par:
  - Une note (de 0.0 à 10.0)
  - un commentaire

## Peut-on voir des liens vers des bandes annonces

- Oui on peut retrouver les liens vers les bandes-annonces et les mettre dans les attributs de chaque film
- Passer par Youtube pour voir la bande annonce :
  - Exemple pour retrouver la bande annonce de Superman en version française <https://www.youtube.com/results?search_query=bande+annonce+superman+vf>

## Toutes les vidéos sont elles adaptées à tout public

- Les vidéos sont toutes adaptées au public pour lequel elles sont destinées (en fonction des critères de filtre) lié à son profil.
- Récupérer les infos MPAA film ratings sur le site OMDB

## Les séries font-elles partie des goûts cinématographique

- les séries font partie des choix. Elles sont définis avec les mêmes informations que les films.

[Retour à la génèse](./genesis.md#recherches)