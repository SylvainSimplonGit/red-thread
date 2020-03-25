import { Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { Movie } from '../../model/movie';
import { MatPaginator } from '@angular/material/paginator';
import { AddAMovieService } from '../../service/add-amovie.service';
import { DomSanitizer } from '@angular/platform-browser';
import { MatIconRegistry } from '@angular/material/icon';
import {MatSort} from '@angular/material/sort';

@Component({
  selector: 'app-add-amovie-page',
  templateUrl: './add-amovie-page.component.html',
  styleUrls: ['./add-amovie-page.component.css']
})

export class AddAMoviePageComponent implements OnInit {
  addAMovieForm;
  moviesByKeyword: Movie[];
  displayedColumns: string[] = ['Titre', 'Année', 'idImdb', 'posterUrl'];

  @ViewChild(MatPaginator, { static: true }) paginator: MatPaginator;
  @ViewChild(MatSort, { static: true }) sort: MatSort;

  constructor(
    private formBuilder: FormBuilder,
    private addAMovieService: AddAMovieService,
    private iconRegistry: MatIconRegistry,
    private sanitizer: DomSanitizer
  ) {
    iconRegistry.addSvgIcon(
      'add-movie',
      sanitizer.bypassSecurityTrustResourceUrl('/assets/add-24px.svg')
    );

    this.addAMovieForm = this.formBuilder.group({
      movie_title: '',
      movie_released: '',
    });
  }

  ngOnInit() {
  }


  onSubmit(addAMovieForm) {
    if (addAMovieForm.movie_title == '') {
      alert('Veuillez entrer un titre de film');
    }
    this.moviesByKeyword = [];
    this.addAMovieService.getMoviesByKeyword(addAMovieForm.movie_title).subscribe(movieSearch => {
      this.moviesByKeyword = movieSearch;
    });
  }

  applyFilter($event: KeyboardEvent) {

  }

  addAMovie(movie: Movie) {
    this.addAMovieService.addAMovie(movie);

  }
}
