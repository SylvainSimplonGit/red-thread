import { Component, OnInit } from '@angular/core';
import {FormBuilder} from '@angular/forms';

@Component({
  selector: 'app-add-amovie-page',
  templateUrl: './add-amovie-page.component.html',
  styleUrls: ['./add-amovie-page.component.css']
})

export class AddAMoviePageComponent implements OnInit {
  addAMovieForm;
  posterURI = 'https://image.tmdb.org/t/p/w1280';

  constructor(
    private formBuilder: FormBuilder,
  ) {
    // @ts-ignore
    this.addAMovieForm = this.formBuilder.group({
      movie_title: '',
      movie_released: '',
    });
  }

  ngOnInit() {
  }


  onSubmit(addAMovieForm) {

  }

}
