import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import { 
  MatToolbarModule,
   MatButtonModule, 
   MatSidenavModule, 
   MatIconModule, 
   MatListModule,
   MatCardModule,
   MatExpansionModule,
   MatProgressBarModule
} from '@angular/material';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { LayoutModule } from '@angular/cdk/layout';
import { UserMenuComponent } from './user-menu/user-menu.component';

import { ProfileComponent } from './profile/profile.component';
import { RouterModule, Routes } from '@angular/router';

const appRoutes: Routes = [
    {
        path: 'profile',
        component: ProfileComponent
    }
];

@NgModule({
  declarations: [
    AppComponent,
    UserMenuComponent,
    ProfileComponent
  ],
  imports: [
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: true }
    ),
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    LayoutModule,
    MatToolbarModule,
    MatButtonModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    MatCardModule,
    MatExpansionModule,
    MatProgressBarModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
