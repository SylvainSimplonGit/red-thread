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

  private movie: Movie = new Movie();
  private maxActor = 8;

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
          console.log(this.movie);
        }
      )
    );
  }

}
