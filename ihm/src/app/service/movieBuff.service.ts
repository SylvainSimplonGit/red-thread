import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable } from 'rxjs';

import { MovieBuff } from '../model/moviebuff';
import { Opinion } from '../model/opinion';

@Injectable({
  providedIn: 'root'
})
export class MovieBuffService {

  private pathRootApi = 'http://localhost:8080/api/';

  public currentMovieBuff: Observable<MovieBuff>;
  public currentUser: MovieBuff;

  constructor(
    private httpClient: HttpClient
  ) {
    const idCurrentMovieBuff = 1;
    this.setCurrentMovieBuff(idCurrentMovieBuff);
  }

  public getMovieBuffs(): Observable<MovieBuff[]> {
    const urlApi = this.pathRootApi + 'movies/movie_buff';
    try {
      return this.httpClient.get<MovieBuff[]>(urlApi);
    } catch (e) {
      return e.message;
    }
  }

  public getMovieBuffById(id: number): Observable<MovieBuff> {
    const urlApi = this.pathRootApi + 'movies/movie_buff/' + id;
    try {
      return this.httpClient.get<MovieBuff>(urlApi);
    } catch (e) {
      return e.message;
    }
  }

  public setCurrentMovieBuff(id: number): void {
    this.currentMovieBuff = this.getMovieBuffById(id);
  }

  public getCurrentMovieBuff(): Observable<MovieBuff> {
    return this.currentMovieBuff;
  }

  public updateMovieBuff(movieBuff: MovieBuff): Observable<MovieBuff> {
    const urlApi = this.pathRootApi + 'movies/movie_buff/' + movieBuff.idMovieBuff;
    try {
      return this.httpClient.put<MovieBuff>(urlApi, movieBuff);
    } catch (e) {
      return e.message;
    }
  }

  private getOpinionById(idOpinion: number): Observable<Opinion> {
    const urlApi = this.pathRootApi + 'movies/opinion/' + idOpinion;
    try {
      return this.httpClient.get<Opinion>(urlApi);
    } catch (e) {
      return e.message;
    }
  }

  public setMyOpinionOfMovieIdImdb(opinion: Opinion): Observable<Opinion> {
    const urlApi = this.pathRootApi + 'movies/opinion';
    let headers = new HttpHeaders();
    headers = headers.set('Content-Type', 'application/json; charset=utf-8');
    // Si l'opinion existe
    if (this.getOpinionById(opinion.idOpinion) != null) {
      // alors faire un PUT
      try {
        return this.httpClient.put<Opinion>(urlApi, opinion, {headers});
      } catch (e) {
        return e.message;
      }
    } else {
      // Sinon faire un POST de l'opinion
      try {
        return this.httpClient.post<Opinion>(urlApi, opinion, {headers});
      } catch (e) {
        return e.message;
      }
    }
  }

}
