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

  public currentMovie: Observable<Movie>;

  constructor(
    private httpClient: HttpClient,
  ) {  }

  getCurrentMovie(): Observable<Movie> {
    return this.currentMovie;
  }

  setCurrentMovie(idImdb: string): void {
    this.currentMovie = this.getMovieById(idImdb);
  }

  getMovies() {
    const urlApi = this.pathRootApi + 'movies';
    return this.httpClient.get<Movie[]>(urlApi);
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

  getMoviesByKeyword(keyword: string): Observable<Movie[]> {
    const urlApi = this.pathRootApi + 'movies/search/' + keyword;
    return this.httpClient.get<Movie[]>(urlApi);
  }

}
