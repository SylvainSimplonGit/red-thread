import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { MovieBuff } from '../model/moviebuff';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MovieBuffService {

  private pathRootApi = 'http://localhost:8080/api/';

  private idCurrentMovieBuff = 1;

  public currentMovieBuff: Observable<MovieBuff>;

  constructor(
    private httpClient: HttpClient
  ) {
    this.setCurrentMovieBuff(this.idCurrentMovieBuff);
  }

  // getMovieBuffs() {
  //   const urlApi = this.pathRootApi + 'movie_buff';
  //   try {
  //     return this.httpClient.get<MovieBuff[]>(urlApi);
  //   } catch (e) {
  //     return e.message;
  //   }
  // }

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

}
