import { Injectable } from '@angular/core';
import { Movie } from './movie';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private movies = [
  {
    idImdb: 'tt0000001',
    title: 'Vingt ans sur le pot, la vie d\'un constipé',
    director: 'Kevin Lachass',
    actors: [{ name: 'Paul Javel' }],
    genres: [{ genre: 'Art et essai' }]
  }];

  constructor() {  }

  getMovies() {
    return this.movies;
  }
}
