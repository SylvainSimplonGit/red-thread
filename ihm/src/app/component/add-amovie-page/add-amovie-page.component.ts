import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Movie } from '../../model/movie';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { MovieService } from '../../service/movie.service';
import { MovieBuffService } from '../../service/movieBuff.service';
import { MovieBuff } from '../../model/moviebuff';
import {Router} from '@angular/router';

@Component({
  selector: 'app-add-amovie-page',
  templateUrl: './add-amovie-page.component.html',
  styleUrls: ['./add-amovie-page.component.css']
})

export class AddAMoviePageComponent implements OnInit {
  addAMovieForm;
  displayedColumns: any[] = ['add', 'title', 'released', 'idImdb', 'posterUrl'];
  dataSource = new MatTableDataSource<Movie>();

  public currentMovieBuff: MovieBuff;
  public searchLaunch = 'no';
  public hasData = false;

  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: true }) sort: MatSort;

  constructor(
    private formBuilder: FormBuilder,
    private movieService: MovieService,
    private movieBuffService: MovieBuffService,
    private router: Router
  ) {
    this.addAMovieForm = this.formBuilder.group({
      movie_title: '',
      // movie_released: '',
    });
  }

  ngOnInit() {
    this.movieBuffService.getCurrentMovieBuff().subscribe(
      movieBuff => {
        this.currentMovieBuff = movieBuff;
      }
    );
  }

  onSubmit(addAMovieForm) {
    if (addAMovieForm.movie_title === '') {
      alert('Veuillez entrer un titre de film');
    }
    this.searchLaunch = 'inProgress';
    this.movieService.getMoviesByKeyword(addAMovieForm.movie_title).subscribe(movieSearch => {
      this.dataSource.data = movieSearch;
      this.hasData = (movieSearch.length > 0);
      this.dataSource.sort = this.sort;
      this.dataSource.paginator = this.paginator;
      this.searchLaunch = 'finished';
    });
  }

  addAmovie(movie: Movie) {
    this.movieService.getMovieFromTMDBById(movie.idImdb).subscribe(movieRefreshed => {
      this.currentMovieBuff.moviesSeen.push(movieRefreshed);
      this.movieBuffService.updateMovieBuff(this.currentMovieBuff).subscribe(
        movieBuffUpdated => {
          this.currentMovieBuff = movieBuffUpdated;
          this.router.navigate(['/movies']);
        }
      );
    });
  }
}
