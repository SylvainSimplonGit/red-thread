import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSortModule } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';

import { MovieService } from '../../service/movie.service';
import { Movie } from '../../model/movie';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  moviesColumns = ['Titre', 'Réalisateur', 'Acteurs', 'Genres'];//
  dataSource = new MatTableDataSource<Movie>();

  // Number of Actor displayed in the list
  public maxActor = 5;
  // Number of Genre displayed in the list
  public maxGenre = 3;

  constructor(private movieService: MovieService) { }

  @ViewChild(MatSortModule, { static: true }) sort: MatSortModule;

  ngOnInit() {
    this.movieService.getMovies().subscribe(
      movies => {
        this.dataSource.data = movies;
        this.dataSource.sort = this.sort;
      });
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

}
