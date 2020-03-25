import { Actor } from './actor';
import { Genre } from './genre';

export class Movie {
    idImdb: string;
    title: string;
    posterUrl?: string;
    director?: string;
    released?: string;
    runtime?: number;
    plot?: string;
    imdbRating?: number;
    imdbVote?: number;
    genres?: Genre[];
    actors?: Actor[];

}
