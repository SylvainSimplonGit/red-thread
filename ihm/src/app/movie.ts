import { Actor } from './Actor';
import { Genre } from './Genre';

export class Movie {
    idImdb: string;
    title: string;
    // runtime: number;
    director: string;
    actors:Actor[];
    genres:Genre[];
}