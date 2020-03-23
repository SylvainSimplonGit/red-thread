import { Component, OnInit } from '@angular/core';
import { DirectorService } from '../../service/director.service';
import { Movie } from '../../model/movie';

@Component({
  selector: 'app-director-sheet',
  templateUrl: './director-sheet.component.html',
  styleUrls: ['./director-sheet.component.css']
})
export class DirectorSheetComponent implements OnInit {

  movies;

  constructor(private directorService: DirectorService) { }

  ngOnInit() {
    this.movies = this.directorService.getMovies();
  }

}
