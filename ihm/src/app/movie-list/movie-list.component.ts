import { Component, OnInit } from '@angular/core';
import { MovieService } from '../movie.service';
import { Movie } from '../movie';


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
  private displayedColumns: string[];

  constructor(private movieService: MovieService) { }

  ngOnInit() {
    this.movies = this.movieService.getMovies();
    this.displayedColumns = ['title', 'director', 'actors', 'genres'];
    // dataSource = this.movies;
    console.log(this.movies);
  }

}
