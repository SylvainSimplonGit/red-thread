import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MatDialog, MatDialogConfig  } from '@angular/material/dialog';

import { MovieService } from '../../service/movie.service';
import { MovieBuffService } from '../../service/movieBuff.service';

import { Movie } from '../../model/movie';
import { MovieBuff } from '../../model/moviebuff';
import { OpinionMineComponent } from '../opinion-mine/opinion-mine.component';

import { OpinionListComponent } from '../opinion-list/opinion-list.component';
import { Opinion } from '../../model/opinion';

@Component({
  selector: 'app-movie-sheet',
  templateUrl: './movie-sheet.component.html',
  styleUrls: ['./movie-sheet.component.css']
})
export class MovieSheetComponent implements OnInit {

  public currentMovieBuff: MovieBuff;
  public currentMovie: Movie = new Movie();
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
    this.route.paramMap.subscribe(params => {
      this.movieService.setCurrentMovie(params.get('movieId'));
      this.movieService.getCurrentMovie().subscribe(
      movieServer => {
        this.currentMovie = movieServer;
        this.calculateGlobalRatingOfMovie(movieServer);
        this.updateOpinionsListOfMovie(movieServer);
      });
    });

    this.movieBuffService.getCurrentMovieBuff().subscribe(
      movieBuff => {
        this.currentMovieBuff = movieBuff;
      }
    );
  }

  private calculateGlobalRatingOfMovie(movie: Movie) {
    this.movieService.getOpinionsMovieById(movie.idImdb).subscribe(opinions => {
      // Initialization of variable
      let total = 0;

      // Check if opinion exist
      if (opinions.length > 0) {
        opinions.forEach( (opinion) => {
          // increments total with all rating opinions
          total += opinion.rating;
        });
      }
      // calculate the average rating opinion
      total = (total > 0) ? total /= opinions.length : 0 ;
      // Get persistent the global rating movie
      this.localGlobalRating = this.calculateNbStar(total);
    });
  }

  private updateOpinionsListOfMovie(movie: Movie) {
    this.movieService.getOpinionsMovieById(movie.idImdb).subscribe(opinions => {
      // Initialization of variable
      this.opinionsOfMovie = [];

      // Check if opinion exist
      if (opinions.length > 0) {
        opinions.forEach( (opinion) => {

          let valueOpinion: {};
          valueOpinion = this.getSomePropertiesOfOpinion(opinion);
          this.opinionsOfMovie.push(valueOpinion);
        });
      }
      this.localMyRating = this.calculateNbStar(this.opinionMine.rating);
    });
  }

  calculateNbStar(rating: number): number {
    return (rating / this.dividerRating);
  }

  getSomePropertiesOfOpinion(opinion: Opinion): any {
    if (opinion.movieBuff.idMovieBuff === this.currentMovieBuff.idMovieBuff) {
      this.opinionMine = opinion;
    }
    // RAZ object
    const valueOp = {
      idOpinion: 0,
      movieBuffName: '',
      rating: 0,
      comment: ''
    };
    // Copying part of the Opinion object to avoid copying the Movie object
    valueOp.idOpinion = opinion.idOpinion;
    valueOp.movieBuffName = opinion.movieBuff.firstName + ' ' + opinion.movieBuff.lastName;
    valueOp.rating = opinion.rating;
    valueOp.comment = opinion.comment;

    return valueOp;
  }

  displayOpinionList(): void {
    if (this.opinionsOfMovie.length > 0) {
      const dialogConfig = new MatDialogConfig();
      dialogConfig.autoFocus = true;
      dialogConfig.width = '600px';
      dialogConfig.data = {
        id: 1,
        title: this.currentMovie.title,
        opinionList: this.opinionsOfMovie
      };
      this.dialog.open(OpinionListComponent, dialogConfig);
    }
  }

  displayMyOpinion(): void {
    const dialogConfig = new MatDialogConfig();
    dialogConfig.autoFocus = true;
    dialogConfig.width = '600px';
    dialogConfig.data = {
      title: 'Mon opinion sur le film',
      opinion: this.opinionMine.comment,
      rate: this.opinionMine.rating
    };

    const dialogMyOpinion = this.dialog.open(OpinionMineComponent, dialogConfig);

    dialogMyOpinion.afterClosed().subscribe( myNewOpinion => {
      if (
            this.opinionMine.comment !== myNewOpinion.newOpinion ||
            this.opinionMine.rating !== myNewOpinion.newRate
      ) {
        this.opinionMine.movie = this.currentMovie;
        this.opinionMine.movieBuff = this.currentMovieBuff;
        this.opinionMine.comment = myNewOpinion.newOpinion;
        this.opinionMine.rating = myNewOpinion.newRate;
        this.movieBuffService.setMyOpinionOfMovieIdImdb(this.opinionMine)
          .subscribe(
          () => {
            this.calculateGlobalRatingOfMovie(this.currentMovie);
            this.updateOpinionsListOfMovie(this.currentMovie);
          });
      }
    });
  }

  refreshMovieInfo(idImdb: string) {
    this.movieService.getMovieFromTMDBById(idImdb).subscribe(
      movieServer => {
        this.currentMovie = movieServer;
      }
    );
  }

}
