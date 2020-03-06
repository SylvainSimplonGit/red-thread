drop table if exists mv_actor cascade;
drop table if exists mv_connection cascade;
drop table if exists mv_movie cascade;
drop table if exists mv_moviebuff cascade;
drop table if exists mv_opinion cascade;
drop table if exists mv_genre cascade;
drop table if exists mv_movie_movie_buff cascade;

drop table if exists mv_actor_movies cascade;
drop table if exists mv_movie_actors cascade;
drop table if exists mv_movie_movie_buffs cascade;

drop sequence if exists actor_seq_id cascade;
drop sequence if exists connection_seq_id cascade;
drop sequence if exists movie_buff_seq_id cascade;
drop sequence if exists movie_seq_id cascade;
drop sequence if exists opinion_seq_id cascade;
