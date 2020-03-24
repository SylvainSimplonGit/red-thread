import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MatDialog, MatDialogConfig  } from '@angular/material/dialog';

import { MovieService } from '../../service/movie.service';
import { Movie } from '../../model/movie';
import { OpinionListComponent } from '../opinion-list/opinion-list.component';
import { Opinion } from '../../model/opinion';
import { MovieBuffService } from '../../service/movieBuff.service';
import { MovieBuff } from '../../model/moviebuff';


@Component({
  selector: 'app-movie-sheet',
  templateUrl: './movie-sheet.component.html',
  styleUrls: ['./movie-sheet.component.css']
})
export class MovieSheetComponent implements OnInit {

  private idCurrentMovieBuff = 2;

  public currentMovieBuff: MovieBuff = new MovieBuff();
  public movie: Movie = new Movie();
  private opinionsOfMovie = [];
  public opinionMine: Opinion = new Opinion();

  public localGlobalRating = 0.0;
  public localMyRating = 0.0;
  public maxActor = 8;
  public maxGenre = 3;

  public starCount = 5;
  private dividerRating = 10 / this.starCount;

  constructor(
    private route: ActivatedRoute,
    private dialog: MatDialog,
    private movieService: MovieService,
    private movieBuffService: MovieBuffService
  ) {
  }

  ngOnInit() {
    this.route.paramMap.subscribe(params =>
      this.movieService.getMovieById(params.get('movieId')).subscribe(
        movieServer => {
          console.log('Init');
          this.calculateRatingMovie(movieServer);
        }
      )
    );
    this.movieBuffService.getMovieBuffById(this.idCurrentMovieBuff).subscribe(
      movieBuffServer => {
        this.currentMovieBuff = movieBuffServer;
        console.log('Vous êtes : ' + this.currentMovieBuff.firstName + ' ' + this.currentMovieBuff.lastName);
      }
    );
  }

  calculateRatingMovie(movie: Movie) {
    this.movieService.getOpinionsMovieById(movie.idImdb).subscribe(opinions => {
      let total = 0;

      if (opinions.length > 0) {
        opinions.forEach( (opinion) => {
          total += opinion.rating;
          let valueOp: {};
          valueOp = this.getSomePropertiesOfOpinion(opinion);
          this.opinionsOfMovie.push(valueOp);
        });
      }

      total = (total > 0) ? total /= opinions.length : 0 ;

      console.log('Total : ' + total);
      console.log('my rating : ' + this.opinionMine.rating);

      this.movie = movie;
      this.localGlobalRating = this.calculateNbStar(total);
      this.localMyRating = this.calculateNbStar(this.opinionMine.rating);

      console.log('this.opinionsOfMovie : ' + JSON.stringify(this.opinionsOfMovie));
      console.log('Global Rating : ' + total);
      console.log('My Rating : ' + this.opinionMine.rating);
    });
  }

  calculateNbStar(rating: number): number {
    return Math.round(rating / this.dividerRating);
  }

  getSomePropertiesOfOpinion(opinion: Opinion): any {
    if (opinion.movieBuff.idMovieBuff === this.currentMovieBuff.idMovieBuff) { this.opinionMine = opinion; }
    // RAZ object
    const valueOp = {
      idOpinion: 0,
      // movieBuff: {
      //   idMovieBuff: 0,
      //   firstName: '',
      //   lastName: ''
      // },
      movieBuffName: '',
      rating: 0,
      comment: ''
    };
    // Copying part of the Opinion object to avoid copying the Movie object
    valueOp.idOpinion = opinion.idOpinion;
    // valueOp.movieBuff.idMovieBuff = opinion.movieBuff.idMovieBuff;
    // valueOp.movieBuff.firstName = opinion.movieBuff.firstName;
    // valueOp.movieBuff.lastName = opinion.movieBuff.lastName;
    valueOp.movieBuffName = opinion.movieBuff.firstName + ' ' + opinion.movieBuff.lastName;
    valueOp.rating = opinion.rating;
    valueOp.comment = opinion.comment;

    return valueOp;
  }

  displayOpinionList(): void {
    const dialogConfig = new MatDialogConfig();
    // dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    // dialogConfig.height = '400px';
    dialogConfig.width = '600px';
    dialogConfig.data = {
      id: 1,
      title: this.movie.title,
      opinionList: this.opinionsOfMovie
    };

    this.dialog.open(OpinionListComponent, dialogConfig);
  }

  displayMyOpinion(): void {
    const dialogConfig = new MatDialogConfig();
    // dialogConfig.disableClose = true;
    dialogConfig.autoFocus = true;
    // dialogConfig.height = '400px';
    dialogConfig.width = '600px';
    dialogConfig.data = {
      id: 1,
      title: 'Mon opinion sur le film'
    };

    this.dialog.open(OpinionListComponent, dialogConfig);
  }

  refreshMovieInfo(idImdb: string) {
    this.movieService.getMovieFromTMDBById(idImdb).subscribe(
      movieServer => {
        this.movie = movieServer;
        console.log('Refresh : ' + idImdb);
      }
    );
  }

}
