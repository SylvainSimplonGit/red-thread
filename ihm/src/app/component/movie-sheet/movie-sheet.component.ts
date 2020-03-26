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
  // public currentMovie: Movie;
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
    this.route.paramMap.subscribe(params =>
      this.movieService.getMovieById(params.get('movieId')).subscribe(
        movieServer => {
          console.log('Init');
          this.calculateRatingMovie(movieServer);
        }
      )
    );

    this.movieBuffService.getCurrentMovieBuff().subscribe(
      movieBuff => {
        this.currentMovieBuff = movieBuff;
        console.log('Vous êtes : ' + movieBuff.firstName + ' ' + movieBuff.lastName);
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

      this.currentMovie = movie;
      this.localGlobalRating = this.calculateNbStar(total);
      // this.localMyRating = this.calculateNbStar(this.opinionMine.rating);
      // this.movieBuffService.getOpinionByIdMovieFromCurrentMovieBuff(movie.idImdb);
      console.log('this.opinionsOfMovie : ' + JSON.stringify(this.opinionsOfMovie));
      console.log('Global Rating : ' + total);
    });
  }

  calculateNbStar(rating: number): number {
    return (rating / this.dividerRating);
  }

  getSomePropertiesOfOpinion(opinion: Opinion): any {
    if (opinion.movieBuff.idMovieBuff === this.currentMovieBuff.idMovieBuff) {
      this.opinionMine = opinion;
      console.log('Votre nom : ' + this.currentMovieBuff.lastName);
    }
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
    if (this.opinionsOfMovie.length > 0) {
      const dialogConfig = new MatDialogConfig();
      // dialogConfig.disableClose = true;
      dialogConfig.autoFocus = true;
      // dialogConfig.height = '400px';
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
      opinion: this.opinionMine.comment
    };

    const dialogMyOpinion = this.dialog.open(OpinionMineComponent, dialogConfig);

    dialogMyOpinion.afterClosed().subscribe( myNewOpinion => {
      if (this.opinionMine.comment !== myNewOpinion) {
        this.opinionMine.movie = this.currentMovie;
        this.opinionMine.movieBuff = this.currentMovieBuff;
        this.opinionMine.comment = myNewOpinion;
        console.log(this.opinionMine);
        this.movieBuffService.setMyOpinionOfMovieIdImdb(this.opinionMine).subscribe();
      }
    });
  }

  refreshMovieInfo(idImdb: string) {
    this.movieService.getMovieFromTMDBById(idImdb).subscribe(
      movieServer => {
        this.currentMovie = movieServer;
        console.log('Refresh : ' + idImdb);
      }
    );
  }

}
