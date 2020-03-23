import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Movie } from '../model/movie';
import { Observable } from 'rxjs';
import { Opinion } from '../model/opinion';

@Injectable({
  providedIn: 'root'
})
export class MovieService {

  private pathRootApi = 'http://localhost:8080/api/';

  // Decommenter pour avoir les données depuis l'array movies du service
  // private movies = [
  // {
  //   idImdb: 'tt0000001',
  //   title: 'Vingt ans sur le pot, la vie d\'un constipé',
  //   director: 'Kevin Lachass',
  //   actors: [{ name: 'Paul Javel' }],
  //   genres: [{ genre: 'Art et essai' }]
  // }];

  constructor(
    private httpClient: HttpClient
  ) {  }

  getMovies() {
    // Decommenter pour avoir les données depuis la base PostgreSQL
    const urlApi = this.pathRootApi + 'movies';
    return this.httpClient.get<Movie[]>(urlApi);

    // Decommenter pour avoir les données depuis l'array movies du service
    // return this.movies;
  }

  getMovieById(idImdb: string): Observable<Movie> {
    const urlApi = this.pathRootApi + 'movies/' + idImdb;
    return this.httpClient.get<Movie>(urlApi);
  }

  getOpinionsMovieById(idImdb: string): Observable<Opinion[]> {
    const urlApi = this.pathRootApi + 'movies/' + idImdb + '/opinions';
    return this.httpClient.get<Opinion[]>(urlApi);
  }

  getMovieFromTMDBById(idImdb: string): Observable<Movie> {
    const urlApi = this.pathRootApi + 'movies/' + idImdb + '/tmdb';
    return this.httpClient.get<Movie>(urlApi);
  }

}
