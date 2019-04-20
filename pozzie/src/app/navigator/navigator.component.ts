import { Component } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-navigator',
  templateUrl: './navigator.component.html',
  styleUrls: ['./navigator.component.css']
})
export class NavigatorComponent {

  // TODO There's probably a better way to do it
  userInfo = JSON.parse(localStorage['firebaseui::rememberedAccounts'])

  isHandset$: Observable<boolean> = this.breakpointObserver
    .observe(Breakpoints.Handset)
    .pipe(map(result => result.matches)
  );

  constructor(
    private breakpointObserver: BreakpointObserver,
    private authService: AuthService) {}

  signOut() {
    this.authService.signOut();
    // this
  }

  // ngOnInit() {
  //   const ;


  // }
}
