import { Component, OnInit } from '@angular/core';
import { MovieBuffService } from '../../service/movieBuff.service';
import { MovieBuff } from '../../model/moviebuff';

@Component({
  selector: 'app-welcome-page',
  templateUrl: './welcome-page.component.html',
  styleUrls: ['./welcome-page.component.css']
})
export class WelcomePageComponent implements OnInit {

  public movieBuffsList: MovieBuff[];
  public currentMovieBuff: MovieBuff;

  constructor(
    private movieBuffService: MovieBuffService,
    ) { }

  ngOnInit() {
    this.movieBuffService.getMovieBuffs().subscribe( movieBuffs => {
      this.movieBuffsList = movieBuffs;
      this.updateCurrentMovieBuff();
    });
  }

  selectMovieBuff(movieBuff: MovieBuff) {
    this.movieBuffService.setCurrentMovieBuff(movieBuff.idMovieBuff);
    this.updateCurrentMovieBuff();
  }

  updateCurrentMovieBuff() {
    return this.movieBuffService.getCurrentMovieBuff().subscribe(
      movieBuff => {
        this.currentMovieBuff = movieBuff;
      });
  }
}
