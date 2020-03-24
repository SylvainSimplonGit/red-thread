import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import {MatPaginatorModule} from '@angular/material/paginator'; 

import { MovieService } from '../../service/movie.service';
import { Movie } from '../../model/movie';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  moviesColumns = ['Titre', 'Réalisateur', 'Acteurs', 'Genres'];//
  dataSource: MatTableDataSource<Movie[]>;
  movies;
  
  // Number of Actor displayed in the list
  public maxActor = 5;
  // Number of Genre displayed in the list
  public maxGenre = 3;

  constructor(private movieService: MovieService) { }

  @ViewChild(MatSort, {static: true}) sort: MatSort;
  
  ngOnInit() {
    this.movies = this.movieService.getMovies();
    this.dataSource = new MatTableDataSource(this.movies);
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

}
