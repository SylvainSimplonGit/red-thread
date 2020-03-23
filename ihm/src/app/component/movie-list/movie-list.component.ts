import { Component, OnInit } from '@angular/core';
import { Sort } from '@angular/material/sort';

import { MovieService } from '../../service/movie.service';
import { Movie } from '../../model/movie';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  movies;
  moviesColumns;
  // Number of Actor displayed in the list
  public maxActor = 5;
  // Number of Genre displayed in the list
  public maxGenre = 3;

  constructor(private movieService: MovieService) { }

  ngOnInit() {
    // Set displayable columns of the movies table 
    this.moviesColumns = ['Titre', 'Réalisateur', 'Acteurs', 'Genres'];

    this.movies = this.movieService.getMovies();
    console.log(this.movies);
  }

  sortMovie(sort: Sort){
console.log("Movie sort");
  }
}
