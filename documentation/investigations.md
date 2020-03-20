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

Un cinéphile est une personne ayant des goûts cinématographique qui s'identifie avec un identifiant permettant de la reconnaitre .

Le cinéphile peut être caractérisé par :

- Un identifiant unique permettant de reconnaitre ce cinéphile
  - L'identifiant peut-être une connexion OAuth2 (Github, Amazon, Netflix, ...).
    - La liste des providers OAuth2 est disponble [ici](https://en.wikipedia.org/wiki/List_of_OAuth_providers)
- Une liste de film déjà vu par ce cinéphile.
- Un avis sur chaque film déjà vu pour cibler les goûts de ce cinéphile.

## Comment classer un film

Un questionnnaire a été envoyé pour définir ce qu'un cinéphile aimerait voir dans l'application.

- par popularité (nombre d'avis positifs sur nombre de vues),
- par notes de film (note des cinéphiles),
- par durée

<details>
  <summary>L'analyse de ce questionnaire :</summary>
  A la question :
  <ul>
    <li>
      Pour choisir un film, quelle importance accordez vous aux critères suivants ?
      (Classez par ordre d'importance les critères suivants) :<br>
      L'histoire, Le genre, Le réalisateur, Les acteurs, La durée, Les avis<br>
      Sur 14 réponses :
      <ul>
        <li>
          <strong>l'histoire</strong> a été choisie en 1er critère pour 6 personnes, 4 l'ont choisie en 2nd choix et 4 autres en 3ème choix
        </li>
        <li>
          <strong>le genre</strong> a été choisi en 1er par 4 personnes, 3 l'ont choisi en 2nd choix, 3 en 3ème choix, 3 en 4ème choix et 1 personne en 5ème choix
        </li>
        <li>
          <strong>les avis</strong> ont été choisis en 1er par 1 personne, en 2nd choix par 3 personnes, en 3ème par 4 personnes en 4ème par 2 personnes, en 5ème choix par 2 personnes et en dernier par 2 autres personnes
        </li>
        <li>
          <strong>Les acteurs</strong> ont été choisis en 1er par 1 personne, en 2nd choix par 2 personnes, en 3ème par 1 personnes en 4ème par 4 personnes, et en 5ème choix par 5 personnes
        </li>
        <li>
          <strong>le réalisateur</strong> a été choisi en 1er par 2 personnes, en 4ème choix par 4 personnes, en 5ème choix par 4 personnes et en dernier par 4 autres personnes
        </li>
        <li>
          <strong>la durée</strong> a été choisi en 1er choix par 2 personnes en 2nd choix par 1 personne, en 3ème choix par 1 personne, en 4ème chois par 2 personnes et en dernier choix par 8 personnes
        </li>
      </ul>
    </li>
    <li>
        Avez-vous d'autres critères de choix ?<br>
        Les réponses ont été :
        <ul>
          <li>"Adaptation d'un livre ou d'une histoire réelle"</li>
          <li>"Selon le choix de la personne avec qui j'y vais"</li>
          <li>"Le lieu de diffusion"</li>
          <li>"langue"</li>
        </ul>
    </li>
    <li>
      Comment souhaiteriez-vous qu'une liste de film soit affichée ?<br>
      Sur 14 personnes :
      <ul>
        <li>64.3% souhaite par ordre alphabétique</li>
        <li>50% par note avis des sites spécialisés</li>
        <li>42.9% à égalité par réalisateur, acteurs, année de sortie, note de cinéphile</li>
        <li>35.7% par nombre de vues</li>
        <li>14.3% par durée</li>
      </ul>
    </li>
    <li>
      Quelle(s) fonctionnalités voudriez-vous voir dans une application Films & Séries ?<br>
      Les réponses ont été :
      <ul>
        <li>"Le streaming de mes films et séries préférées"</li>
        <li>"Des propositions aléatoires régulièrement renouvelées en fonction des films que j'apprécie"</li>
        <li>"Savoir si un film fait partie d'une saga (Star Wars, Indiana Jones...)"</li>
        <li>"qu'elle me donne les films qui vont commencer près de chez moi dans l'heure"</li>
        <li>"Proposition de liste de films personnalisés"</li>
        <li>"Recommandations de films/séries aimés par les gens qui aiment les mêmes films/séries que moi."</li>
        <li>"Pouvoir lire un résumé de l’histoire"</li>
      </ul>
    </li>
  </ul>
</details>

## Qu'est-ce qu'un goût cinématographique

- des genre(s)
- un/des réalisateur(s)
- des acteurs
- des durées de film

De manière générale on peut peut-être permettre à l'utilisateur de définir ses genres, réalisateurs, acteurs préférés

- Le cinéphile pourrait choisir l'ordre de préférences des critères de tri :
  - en 1er les avis
  - en 2nd les acteurs
  - en 3ème le genre

Le cinéphile a choisi dans ces meilleurs films (vote par note) le genre Drama, l'algo lui fournit une liste de films Drama les mieux notés par d'autres cinéphiles.

Le cinéphile a vu plus de genre Thriller, l'algoritme lui propose une liste de Thriller les mieux notés.

Dans la liste des films que le cinéphile a vu, il faudrait identifier un classement dans les genres pondérer par la note du cinéphile (J'ai vu beaucoup de Thriller mais je les ai noté de 1 à 3 alors que j'ai vu 3 comédie que j'ai noté 7 à 9).

## Comment ajouter des films dans la liste de référence des vidéos

- Depuis une base de données en ligne
  - <http://www.omdbapi.com/>
  - <https://www.themoviedb.org/>
- Depuis un répertoire où sont stockées ces films
  - Prévoir une norme de nommage des fichiers vidéos
- Depuis un formulaire qui serait rempli par le cinéphile pour ajouter un film déjà vu par le cinéphile qui existerait dans les bases

## Qu'est-ce qu'une vidéo adaptée au goût cinématographique

- C'est une vidéo qui par ses informations correspond avec un degré suffisant aux critières extraits de la liste des vidéos/séries visionnées par l'utilisateur (genres, réalisateurs et acteurs des films visionnés)

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
     - le "IMDB Rating"
     - le "IMDB votes"
   - a une restriction sur le nombre de requête par jour (1000 req / jr)

## Peut-on poster des avis et voter pour ses films préférés

- Oui, et c'est nécessaire pour connaitre les goûts du cinéphile

- Un avis peut être défini par:
  - un film sur lequel l'avis est mis
  - une note (de 0.0 à 10.0)
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
