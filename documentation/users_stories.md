# Users Stories

Pour comprendre, voici un exemple détaillé :

**Rôle :**

- En tant que cinéphile,

**La fonctionnalité :**

- je veux pouvoir ajouter un film déjà vu

**Critères d'acceptation :**

- afin de garder un historique de mes films déjà vus.

## Liste des Users Stories

- En tant que cinéphile, je veux pouvoir m'identifier afin que l'application me reconnaisse
- En tant que cinéphile, je veux pouvoir ajouter un film déjà vu afin de garder un historique.
- En tant que cinéphile, je veux pouvoir afficher une liste des films que j'ai déjà vus afin de voir l'ensemble des films que j'ai vu.
- En tant que cinéphile, je veux pouvoir définir les critères de choix de films afin qu'on me propose une liste de films.
- En tant que cinéphile, je veux pouvoir afficher la fiche d'un film afin de voir les informations d'un film (Titre, Synopsis, Notes, Genre, Acteurs, Durée, Réalisateur).
- En tant que cinéphile, je veux pouvoir afficher la fiche d'un film afin de voir les informations d'un film (Poster).
- En tant que cinéphile, je veux avoir un lien pour chaque film que je choisis ou que l'application me propose afin de visionner la bande-annonce du film.
- En tant que cinéphile, je veux que l'application analyse mon/mes genres de films les plus regardés afin de me proposer une liste de films les mieux notés de même genres.
- En tant que cinéphile, je veux gérer mes critères de prédilection afin d'optimiser les choix de films proposés.
- En tant que cinéphile, je veux pouvoir récupérer des films proches de mes choix de prédilection afin de pouvoir avoir de nouvelles experiences cinématographiques. 
- En tant que cinéphile, je dois noter un film afin que l'application me propose des films qui me plairait.
- En tant que cinéphile, je peux mettre un commentaire afin de garder une trace de mon impression.
- En tant que concepteur de l'application, je dois analyser les notes (pondération) des films que le cinéphile a déjà vu afin de lui proposer une liste inédite de film adaptée à ses genres préférés.
- En tant que cinéphile, je veux mettre dans une whishlist des films à voir afin de m'aider pour un choix futur.
- En tant que cinéphile, je veux pouvoir modifier mes critères de choix de films afin de mettre à jour mes goûts cinématographique.

[Retour à la génèse](./genesis.md#users-stories)

## Priorisation des Users Stories

1. En tant que cinéphile, je veux pouvoir m'identifier afin que l'application me reconnaisse
1. En tant que cinéphile, je veux pouvoir afficher une liste des films que j'ai déjà vus afin de voir l'ensemble des films que j'ai vu.
1. En tant que cinéphile, je veux pouvoir ajouter un film déjà vu afin de garder un historique.
1. En tant que cinéphile, je veux pouvoir afficher la fiche d'un film afin de voir les informations d'un film (Titre, Synopsis, Notes, Genre, Acteurs, Durée, Réalisateur).
1. En tant que cinéphile je veux avoir un lien pour chaque film que je choisis ou que l'application me propose afin de visionner la bande-annonce du film.
1. En tant que cinéphile, je dois noter un film afin que l'application me propose des films qui me plairait.
1. En tant que cinéphile, je peux mettre un commentaire afin de garder une trace de mon impression.
1. En tant que cinéphile, je veux pouvoir définir les critères de choix de films afin qu'on me propose une liste de films.
1. En tant que cinéphile, je veux pouvoir modifier mes critères de choix de films afin de mettre à jour mes goûts cinématographique.
1. En tant que cinéphile, je veux gérer mes critères de prédilection afin d'optimiser les choix de films proposés.
1. En tant que cinéphile, je veux mettre dans une whishlist des films à voir afin de m'aider pour un choix futur.
1. En tant que cinéphile, je veux que l'application analyse mon/mes genres de films les plus regardés afin de me proposer une liste de films les mieux notés de même genres.
1. En tant que concepteur de l'application, je dois analyser les notes (pondération) des films que le cinéphile a déjà vu afin de lui proposer une liste inédite de film adaptée à ses genres préférés.
1. En tant que cinéphile, je veux pouvoir récupérer des films proches de mes choix de prédilection afin de pouvoir avoir de nouvelles experiences cinématographiques. 
1. En tant que cinéphile, je veux pouvoir afficher la fiche d'un film afin de voir les informations d'un film (Poster).

[Retour à la génèse](./genesis.md#priorisation-des-users-stories)

## Nommage des Users Stories

1. En tant que concepteur de l'application, je dois ajouter des films depuis OmDB afin de remplir la base local

   - **[US-00-001]** Create a Film Buff Object
   - **[US-00-002]** Create a Genre Enum
   - **[US-00-003]** Create a Rate Enum
   - **[US-00-004]** Create a Actor Object
   - **[US-00-005]** Get a list of years since 1960
   - **[US-00-006]** Get list of Movies from OmDB for a year
   - **[US-00-007]** Add or Update Movie in local DB by imdbId
   - **[US-00-008]** Get a random list of Movie in local DB
   - **[US-00-009]** Update Movie in local DB by imdbId
   - **[US-00-010]** Launch Update list of Movie in local DB at a set time
   - **[US-00-011]** Launch Update Movies in local DB at a set time
   - **[US-00-012]** Create Film Object

1. En tant que cinéphile, je veux pouvoir m'identifier afin que l'application me reconnaisse

   - **[US-01-001]** Film Buff Identification with local account
   - **[US-01-002]** Create a local account
   - **[US-01-003]** Film Buff Identification with GitHub
   - **[US-01-004]** Film Buff Identification with Facebook
   - **[US-01-005]** Film Buff Identification with Amazon
   - **[US-01-006]** Film Buff Identification with Google
   - **[US-01-007]** Delete a local account
   - **[US-01-008]** Create a Connection Object

1. En tant que cinéphile, je veux pouvoir afficher une liste des films que j'ai déjà vus afin de voir l'ensemble des films que j'ai vu.

   - **[US-02-002]** Display Film Buff "already-seen" movie personal list

1. En tant que cinéphile, je veux pouvoir ajouter un film déjà vu afin de garder un historique.

   - **[US-03-001]** Add a movie to "already-seen" movie personal list

1. En tant que cinéphile, je veux pouvoir afficher la fiche d'un film afin de voir les informations d'un film (Titre, Synopsis, Notes, Genre, Acteurs, Durée, Réalisateur).

   - **[US-04-001]** Display movie information

1. En tant que cinéphile je veux avoir un lien pour chaque film que je choisis ou que l'application me propose afin de visionner la bande-annonce du film.

   - **[US-05-001]** Create watchable movie trailer link for each movie

1. En tant que cinéphile, je dois noter un film afin que l'application me propose des films qui me plairait.

   - **[US-06-001]** Create the Opinion Object
   - **[US-06-002]** Create an opinion to a movie
   - **[US-06-003]** Read the opinion of a movie
   - **[US-06-004]** Update the opinion of a movie
   - **[US-06-005]** Display the opinion of a movie

1. En tant que cinéphile, je peux mettre un commentaire afin de garder une trace de mon impression.

   - **[US-07-001]** Create a comment to a movie already seen
   - **[US-07-002]** Read a comment of a movie already seen
   - **[US-07-003]** Update a comment of a movie already seen
   - **[US-07-004]** Delete a comment of a movie already seen
   - **[US-07-005]** Display a comment of a movie already seen

1. En tant que cinéphile, je veux pouvoir définir les critères de choix de films afin qu'on me propose une liste de films.

   - **[US-08-001]** Create criteria for choosing films
   - **[US-08-002]** Read criteria for choosing films
   - **[US-08-003]** Display criteria for choosing films

1. En tant que cinéphile, je veux pouvoir modifier mes critères de choix de films afin de mettre à jour mes goûts cinématographique.

   - **[US-09-001]** Update criteria for choosing films
   - **[US-09-002]** Delete criteria for choosing films

1. En tant que cinéphile, je veux gérer mes critères de prédilection afin d'optimiser les choix de films proposés.

   - **[US-10-001]** Get film bluff criteria of movies proposition
   - **[US-10-002]** Read film bluff criteria of movies proposition
   - **[US-10-003]** Update film bluff criteria of movies proposition
   - **[US-10-004]** Delete film bluff criteria of movies proposition

1. En tant que cinéphile, je veux mettre dans une whishlist des films à voir afin de m'aider pour un choix futur.

   - **[US-11-001]** Create Film Buff's personal wishlist
   - **[US-11-002]** Display Film Buff's personal wishlist
   - **[US-11-003]** Update Film Buff's personal wishlist
   - **[US-11-004]** Delete Film Buff's personal wishlist

1. En tant que cinéphile, je veux que l'application analyse mon/mes genres de films les plus regardés afin de me proposer une liste de films les mieux notés de même genres.

   - **[US-12-001]** Get a sorted list of types from "most-seen" movies
   - **[US-12-002]** Get a sorted list of best ranked movies of a movie type
   - **[US-12-003]** Get a sorted list of best ranked movies of a sorted list of movie type

1. En tant que concepteur de l'application, je dois analyser les notes (pondération) des films que le cinéphile a déjà vu afin de lui proposer une liste inédite de film adaptée à ses genres préférés.

   - **[US-13-001]** Calculate the note of film with the film Bluff's criterias
   - **[US-13-002]** Sort the list films with the notes calculated
   - **[US-13-003]** Get the list films with the notes calculated

1. En tant que cinéphile, je veux pouvoir récupérer des films proches de mes choix de prédilection afin de pouvoir avoir de nouvelles experiences cinématographiques. 

   - **[US-14-001]** Display sorted list of best ranked movies adapted to types of "most-seen" movies

1. En tant que cinéphile, je veux pouvoir afficher la fiche d'un film afin de voir les informations d'un film (Poster).

   - **[US-15-001]** Display movie poster

[Retour à la génèse](./genesis.md#dispatching)