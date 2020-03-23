import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { MovieService } from './service/movie.service';
import { DirectorService } from './service/director.service';
import { TopBarComponent } from './component/top-bar/top-bar.component';
import { WelcomePageComponent } from './component/welcome-page/welcome-page.component';
import { MovieListComponent } from './component/movie-list/movie-list.component';
import { MovieSheetComponent } from './component/movie-sheet/movie-sheet.component';
import { MovieSuggestionComponent } from './component/movie-suggestion/movie-suggestion.component';
import { GenreSuggestionComponent } from './component/genre-suggestion/genre-suggestion.component';
import { DirectorSheetComponent } from './component/director-sheet/director-sheet.component';

@NgModule({
  declarations: [
    AppComponent,
    TopBarComponent,
    WelcomePageComponent,
    MovieListComponent,
    MovieSheetComponent,
    MovieSuggestionComponent,
    GenreSuggestionComponent,
    DirectorSheetComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path: '', component: WelcomePageComponent },
      { path: 'movies', component: MovieListComponent },
      { path: 'movie/:movieId', component: MovieSheetComponent },
      { path: 'director/:directorId', component: DirectorSheetComponent },
    ])
  ],
  providers: [MovieService, DirectorService],
  bootstrap: [AppComponent]
})

export class AppModule { }
