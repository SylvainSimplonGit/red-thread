import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Movie} from '../model/movie';
import {Observable} from 'rxjs';
import {Opinion} from '../model/opinion';

@Injectable({
  providedIn: 'root'
})
export class AddAMovieService {

  private pathRootApi = 'http://localhost:8080/api/';

  constructor(
    private httpClient: HttpClient
  ) {  }

  getMoviesByKeyword(keyword: string) {
    // Decommenter pour avoir les données depuis la base PostgreSQL
    const urlApi = this.pathRootApi + 'movies/search/' + keyword;
    return this.httpClient.get<Movie[]>(urlApi);
  }

  addAMovie(movie: Movie) {
    const urlApi = this.pathRootApi + 'movies/movie_buff';
  }
}
