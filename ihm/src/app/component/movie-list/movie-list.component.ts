import { Component, OnInit } from '@angular/core';
import { MovieService } from '../../service/movie.service';
import { Movie } from '../../model/movie';


@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  movies;
  // Number of Actor displayed in the list
  private maxActor = 5;
  // Number of Genre displayed in the list
  private maxGenre = 3;

  constructor(private movieService: MovieService) { }

  ngOnInit() {
    this.movies = this.movieService.getMovies();
    console.log(this.movies);
  }

}
