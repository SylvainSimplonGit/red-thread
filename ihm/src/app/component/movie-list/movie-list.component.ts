import { Component, OnInit, ViewChild } from '@angular/core';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';

import { MovieBuffService } from '../../service/movieBuff.service';
import { Movie } from '../../model/movie';

@Component({
  selector: 'app-movie-list',
  templateUrl: './movie-list.component.html',
  styleUrls: ['./movie-list.component.css']
})
export class MovieListComponent implements OnInit {

  public hasData = true;
  moviesColumns = ['title', 'director', 'actors', 'genres'];
  dataSource = new MatTableDataSource<Movie[]>();

  // Number of Actor displayed in the list
  public maxActor = 5;
  // Number of Genre displayed in the list
  public maxGenre = 3;

  constructor(private movieBuffService: MovieBuffService) { }

  @ViewChild(MatSort, { static: true }) sort: MatSort;
  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;

  ngOnInit() {
    this.movieBuffService.getCurrentMovieBuff().subscribe(
      movieBuff => {
        if (movieBuff.moviesSeen.length === 0) { this.hasData = false; }
        this.dataSource.data = movieBuff.moviesSeen;
        this.dataSource.paginator = this.paginator;
        this.dataSource.sort = this.sort;
      });
  }

  // applyFilter(event: Event) {
  //   const filterValue = (event.target as HTMLInputElement).value;
  //   this.dataSource.filter = filterValue.trim().toLowerCase();
  // }

}

function compare(a: string, b: string, isAsc: boolean) {
  return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
}

