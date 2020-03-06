import { Injectable } from '@angular/core';
import { Movie } from './movie';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private movies = [];

  constructor() {  }

  getMovies(){
    return this.movies;
  }
}
