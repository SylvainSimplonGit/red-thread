INSERT INTO mv_movie (id_imdb, title) VALUES
('tt999998', 'The Best FIlm !'),
('tt999999', 'The Greatest FIlm !');
INSERT INTO mv_movie (director, id_imdb, imdb_rating, imdb_vote, plot, released, runtime, title) VALUES
(
    'David Fincher',
    'tt0137523',
    8.8,
    1748300,
    'Le narrateur, sans identité précise, vit seul, travaille seul, dort seul, mange seul ses plateaux-repas pour une personne comme beaucoup d''autres personnes seules qui connaissent la misère humaine, morale et sexuelle. C''est pourquoi il va devenir membre du Fight club, un lieu clandestin où il va pouvoir retrouver sa virilité, l''échange et la communication. Ce club est dirigé par Tyler Durden, une sorte d''anarchiste entre gourou et philosophe qui prêche l''amour de son prochain.',
    '1999-10-15',
    139,
    'Fight Club'
),
(
     'Bryan Singer',
     'tt0114814',
     8.5,
     940372,
     'Une légende du crime contraint 5 malfrats à aller s''acquitter d''une tâche très périlleuse. Ceux qui survivent pourront se partager un butin de 91 millions de dollars.',
     '1995-07-19',
     106,
     'Usual Suspects'
),
(
    'Alain Berbérian',
    'tt0109440',
    7.7,
    7807,
    'Odile Deray, attachée de presse, vient au Festival de Cannes pour présenter le film "Red is Dead". Malheureusement, celui-ci est d''une telle faiblesse que personne ne souhaite en faire l''écho. Mais lorsque les projectionnistes du long-métrage en question meurent chacun leur tour dans d''étranges circonstances, "Red is dead" bénéficie d''une incroyable publicité. Serge Karamazov est alors chargé de protéger le nouveau projectionniste du film.',
    '1994-03-09',
    99,
    'La Cité de la Peur'
),
(
    'Richard Donner',
    'tt0093409',
    7.6,
    226186,
    'Deux excellents policiers de Los Angeles, Martin Riggs et Roger Murtaugh, se retrouvent coéquipers sur une même affaire. Les deux hommes, de caractère franchement opposé, finissent par s''apprécier et demontrent leur amitié et leurs capacités quand la fille de l''un d''eux est enlevée par d''anciens agents des forces spéciales devenus trafiquants de drogue.',
    '1987-03-06',
    110,
    'L''Arme fatale'
),
(
    'Patrice Leconte',
    'tt0078907',
    7.5,
    6671,
    'Après le Club Méditerranée, la joyeuse troupe d''amis (plus connue sous le nom des Bronzés) se retrouvent aux sports d''hiver. Ils vivront encore d''autres problèmes sentimentaux et mésaventures. L''équipe ira même se perdre en montagne.',
    '1979-11-22',
    83,
    'Les Bronzés font du ski'
)
;


INSERT INTO mv_moviebuff (id_movie_buff, first_name, last_name) VALUES
    (nextval('movie_buff_seq_id'), 'Tête', 'Denoeud'),
    (nextval('movie_buff_seq_id'), 'Gérard', 'Menltant'),
    (nextval('movie_buff_seq_id'), 'Al', 'Kollyck'),
    (nextval('movie_buff_seq_id'), 'Corine', 'Titgoute');

INSERT INTO mv_movie_movie_buffs (movies_seen_id_imdb, movie_buffs_id_movie_buff) VALUES
('tt0078907',1),
('tt0109440',1);

INSERT INTO mv_opinion (id_opinion, comment, id_movie_buff, rating, movie_id_imdb) VALUES
(nextval('opinion_seq_id'), 'Pas ouf !', 1, 0.5, 'tt999998'),
(nextval('opinion_seq_id'), 'Film culte !', 1, 10, 'tt0078907')
;

INSERT INTO mv_actor (id_actor, name) VALUES
-- (nextval('actor_seq_id'), 'Kevin Spacey'),
-- (nextval('actor_seq_id'), 'Stephen Baldwin'),
-- (nextval('actor_seq_id'), 'Chantal Lauby'),
-- (nextval('actor_seq_id'), 'Alain Chabat'),
-- (nextval('actor_seq_id'), 'Dominique Farrugia'),
-- (nextval('actor_seq_id'), 'Mel Gibson'),
-- (nextval('actor_seq_id'), 'Danny Glover'),
(21177, 'Thierry Lhermitte'),
(64913, 'Marie-Anne Chazel'),
(21175, 'Michel Blanc'),
(35137, 'Josiane Balasko'),
(28781, 'Christian Clavier'),
(21171, 'Gérard Jugnot'),
(1972, 'Dominique Lavanant'),
(82792, 'Bruno Moynot'),
(68722, 'Maurice Chevit')
;

INSERT INTO mv_actor_movies (movies_id_imdb, actors_id_actor) VALUES
-- ('tt0114814', 1),
-- ('tt0114814', 2),
-- ('tt0109440', 3),
-- ('tt0109440', 4),
-- ('tt0109440', 5),
-- ('tt0093409', 6),
-- ('tt0093409', 7),
('tt0078907', 21177),
('tt0078907', 64913),
('tt0078907', 21175),
('tt0078907', 35137),
('tt0078907', 28781),
('tt0078907', 21171),
('tt0078907', 1972),
('tt0078907', 82792),
('tt0078907', 68722)
;