import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { MatIconModule } from '@angular/material/icon';
import { MatDialogModule } from '@angular/material/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatButtonModule } from '@angular/material/button';
import { MatTableModule } from '@angular/material/table';

import { AppComponent } from './app.component';
import { MovieService } from './service/movie.service';
import { MovieBuffService } from './service/movieBuff.service';
import { DirectorService } from './service/director.service';
import { TopBarComponent } from './component/top-bar/top-bar.component';
import { WelcomePageComponent } from './component/welcome-page/welcome-page.component';
import { MovieListComponent } from './component/movie-list/movie-list.component';
import { MovieSheetComponent } from './component/movie-sheet/movie-sheet.component';
import { MovieSuggestionComponent } from './component/movie-suggestion/movie-suggestion.component';
import { GenreSuggestionComponent } from './component/genre-suggestion/genre-suggestion.component';
import { DirectorSheetComponent } from './component/director-sheet/director-sheet.component';
import { StarRatingComponent } from './component/star-rating/star-rating.component';
import { OpinionListComponent } from './component/opinion-list/opinion-list.component';

@NgModule({
  declarations: [
    AppComponent,
    TopBarComponent,
    WelcomePageComponent,
    MovieListComponent,
    MovieSheetComponent,
    MovieSuggestionComponent,
    GenreSuggestionComponent,
    DirectorSheetComponent,
    StarRatingComponent,
    OpinionListComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path: '', component: WelcomePageComponent },
      { path: 'movies', component: MovieListComponent },
      { path: 'movie/:movieId', component: MovieSheetComponent },
      { path: 'director/:directorId', component: DirectorSheetComponent },
    ]),
    MatIconModule,
    MatDialogModule,
    MatButtonModule,
    BrowserAnimationsModule,
    MatTableModule,
  ],
  entryComponents: [
    OpinionListComponent
  ],
  providers: [MovieService, MovieBuffService, DirectorService],
  bootstrap: [AppComponent]
})

export class AppModule { }
