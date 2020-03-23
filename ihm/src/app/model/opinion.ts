import { Movie } from './movie';
import { MovieBuff } from './moviebuff';

export class Opinion {
  idOpinion: number;
  movie: Movie;
  movieBuff: MovieBuff;
  rating: number;
  comment: string;
}
