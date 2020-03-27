import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Movie } from '../../model/movie';
import { MatPaginator } from '@angular/material/paginator';
import { DomSanitizer } from '@angular/platform-browser';
import { MatIconRegistry } from '@angular/material/icon';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { MovieService } from '../../service/movie.service';
import {MovieBuffService} from '../../service/movieBuff.service';
import {MovieBuff} from '../../model/moviebuff';

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

  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: true }) sort: MatSort;

  constructor(
    private formBuilder: FormBuilder,
    private movieService: MovieService,
    private movieBuffService: MovieBuffService,
    // private iconRegistry: MatIconRegistry,
    // private sanitizer: DomSanitizer
  ) {
    // Décommenter si besoin -- exemple pour créer de nouvelle icones
    // iconRegistry.addSvgIcon(
    //   'add-movie',
    //   sanitizer.bypassSecurityTrustResourceUrl('/assets/add-24px.svg')
    // );

    this.addAMovieForm = this.formBuilder.group({
      movie_title: '',
      // movie_released: '',
    });
  }

  ngOnInit() {
    this.movieBuffService.getCurrentMovieBuff().subscribe(
      movieBuff => {
        this.currentMovieBuff = movieBuff;
        console.log('Utilisateur : Id n°' + movieBuff.idMovieBuff + '--> ' + movieBuff.firstName + ' ' + movieBuff.lastName);
        console.log(movieBuff.moviesSeen);
      }
    );
  }

  onSubmit(addAMovieForm) {
    if (addAMovieForm.movie_title === '') {
      alert('Veuillez entrer un titre de film');
    }
    this.movieService.getMoviesByKeyword(addAMovieForm.movie_title).subscribe(movieSearch => {
      console.log(movieSearch);
      // @ts-ignore
      this.dataSource.data = movieSearch;
      this.dataSource.sort = this.sort;
      this.dataSource.paginator = this.paginator;
    });
  }

  addAmovie(movie: Movie) {
    this.movieService.getMovieFromTMDBById(movie.idImdb).subscribe(movieRefreshed => {
      console.log(this.currentMovieBuff.moviesSeen);
      this.currentMovieBuff.moviesSeen.push(movieRefreshed);
      console.log(this.currentMovieBuff.moviesSeen);
      this.movieBuffService.updateMovieBuff(this.currentMovieBuff);
    });
    console.log('tentative d\'ajout à la liste du film: ' + movie.title);
    }
}
