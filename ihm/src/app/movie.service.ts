import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Movie } from './movie';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private pathRootApi = 'http://localhost:8080/';

  private movies = [
  {
    idImdb: 'tt0000001',
    title: 'Vingt ans sur le pot, la vie d\'un constipé',
    director: 'Kevin Lachass',
    actors: [{ name: 'Paul Javel' }],
    genres: [{ genre: 'Art et essai' }]
  }];

  constructor(
    private httpClient: HttpClient
  ) {  }

  getMovies() {
    // Activer pour avoir les données depuis la base PostgreSQL
    const urlApi = this.pathRootApi + 'api/movies';
    return this.httpClient.get(urlApi);

    // Activer pour avoir les données depuis l'array movies du service
    // return this.movies;
  }
}
