import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MatDialog, MatDialogConfig  } from '@angular/material/dialog';

import { MovieService } from '../../service/movie.service';
import { MovieBuffService } from '../../service/movieBuff.service';

import { Movie } from '../../model/movie';
import { OpinionListComponent } from '../opinion-list/opinion-list.component';


@Component({
  selector: 'app-movie-sheet',
  templateUrl: './movie-sheet.component.html',
  styleUrls: ['./movie-sheet.component.css']
})
export class MovieSheetComponent implements OnInit {

  // public currentMovieBuff: MovieBuff = new MovieBuff();
  public movie: Movie = new Movie();
  private opinionsOfMovie = [];

  public localRating = 0.0;
  public maxActor = 8;
  public maxGenre = 3;

  public starCount = 5;

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
        console.log('Vous êtes : ' + movieBuff.firstName + ' ' + movieBuff.lastName);
      }
    );
  }

  calculateRatingMovie(movie: Movie) {
    this.movieService.getOpinionsMovieById(movie.idImdb).subscribe(values => {
      let total = 0;

      if (values.length > 0) {
        values.forEach( (value) => {
          total += value.rating;

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
          valueOp.idOpinion = value.idOpinion;
          // valueOp.movieBuff.idMovieBuff = value.movieBuff.idMovieBuff;
          // valueOp.movieBuff.firstName = value.movieBuff.firstName;
          // valueOp.movieBuff.lastName = value.movieBuff.lastName;
          valueOp.movieBuffName = value.movieBuff.firstName + ' ' + value.movieBuff.lastName;
          valueOp.rating = value.rating;
          valueOp.comment = value.comment;
          this.opinionsOfMovie.push(valueOp);
        });
      }

      if (total > 0) {
        total /= values.length;
      } else {
        total = 0;
      }

      this.movie = movie;
      this.localRating = Math.round(total / 2);
      // console.log('Movie : ' + JSON.stringify(this.movie));
      console.log('this.opinionsOfMovie : ' + JSON.stringify(this.opinionsOfMovie));
      console.log('localRating : ' + this.localRating);
    });
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

  refreshMovieInfo(idImdb: string) {
    this.movieService.getMovieFromTMDBById(idImdb).subscribe(
      movieServer => {
        this.movie = movieServer;
        console.log('Refresh : ' + idImdb);
      }
    );
  }

}
