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
import { MovieService } from './movie.service';
import { DirectorService } from './director.service';
import { TopBarComponent } from './top-bar/top-bar.component';
import { WelcomePageComponent } from './welcome-page/welcome-page.component';
import { MovieListComponent } from './movie-list/movie-list.component';
import { MovieSheetComponent } from './movie-sheet/movie-sheet.component';
import { MovieSuggestionComponent } from './movie-suggestion/movie-suggestion.component';
import { GenreSuggestionComponent } from './genre-suggestion/genre-suggestion.component';
import { DirectorSheetComponent } from './director-sheet/director-sheet.component';
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
  providers: [MovieService, DirectorService],
  bootstrap: [AppComponent]
})

export class AppModule { }
