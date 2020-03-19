import { Actor } from './actor';
import { Genre } from './genre';

export class Movie {
    idImdb: string;
    title: string;
    posterUrl?: string;
    runtime?: number;
    released?: string;
    director?: string;
    actors?: Actor[];
    genres?: Genre[];
    plot?: string;
    imdbRating?: number;
    imdbVote?: number;
}
