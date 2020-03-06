import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { TopBarComponent } from './top-bar/top-bar.component';
import { WelcomePageComponent } from './welcome-page/welcome-page.component';
import { MovieListComponent } from './movie-list/movie-list.component';

@NgModule({
  declarations: [
    AppComponent,
    TopBarComponent,
    WelcomePageComponent,
    MovieListComponent
  ],
  imports: [
    BrowserModule,
    // HttpClientModule,
    RouterModule.forRoot([
      {path: '', component: WelcomePageComponent},
      {path: 'movies', component: MovieListComponent},
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }
