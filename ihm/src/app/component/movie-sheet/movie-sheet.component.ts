import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { MovieService } from '../../service/movie.service';
import { Movie } from '../../model/movie';


@Component({
  selector: 'app-movie-sheet',
  templateUrl: './movie-sheet.component.html',
  styleUrls: ['./movie-sheet.component.css']
})
export class MovieSheetComponent implements OnInit {

  public movie: Movie = new Movie();

  public localRating = 0.0;
  public maxActor = 8;
  public maxGenre = 3;

  public starCount = 5;

  constructor(
    private route: ActivatedRoute,
    private movieService: MovieService
  ) {
  }

  ngOnInit() {
    this.route.paramMap.subscribe(params =>
      this.movieService.getMovieById(params.get('movieId')).subscribe(
        movieServer => {
          this.movie = movieServer;
          console.log('Init');
          this.calculateRatingMovie(movieServer);
        }
      )
    );
  }

  calculateRatingMovie(movie: Movie) {
    this.movieService.getOpinionsMovieById(movie.idImdb).subscribe(values => {
      let total = 0;

      if (values.length > 0) {
        values.forEach( (value) => {
          total += value.rating;
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
      console.log('localRating : ' + this.localRating);
    });
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
