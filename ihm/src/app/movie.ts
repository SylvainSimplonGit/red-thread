import { Actor } from './actor';
import { Genre } from './genre';

export class Movie {
    idImdb: string;
    title: string;
    // runtime: number;
    director: string;
    actors:Actor[];
    genres:Genre[];
}