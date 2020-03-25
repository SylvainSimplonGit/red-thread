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
import { AddAMoviePageComponent } from './component/add-amovie-page/add-amovie-page.component';
import { ReactiveFormsModule } from '@angular/forms';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatSortModule} from '@angular/material/sort';
import {MatFormFieldModule} from '@angular/material/form-field';

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
    OpinionListComponent,
    AddAMoviePageComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path: '', component: WelcomePageComponent },
      { path: 'movies', component: MovieListComponent },
      { path: 'movie/:movieId', component: MovieSheetComponent },
      { path: 'director/:directorId', component: DirectorSheetComponent },
      { path: 'addamovie', component: AddAMoviePageComponent }
    ]),
    MatIconModule,
    MatDialogModule,
    MatButtonModule,
    BrowserAnimationsModule,
    MatTableModule,
    ReactiveFormsModule,
    MatPaginatorModule,
    MatSortModule,
    MatFormFieldModule,
  ],
  entryComponents: [
    OpinionListComponent
  ],
  providers: [MovieService, DirectorService],
  bootstrap: [AppComponent]
})

export class AppModule { }
