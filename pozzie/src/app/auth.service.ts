import { Injectable } from '@angular/core';

import { AngularFireAuth } from '@angular/fire/auth';
import { Router } from '@angular/router';

@Injectable({
    providedIn: 'root'
})
export class AuthService {

    // public logged = false;

    // TODO Router should be used in AuthGuardService
    constructor(
        private router: Router,
        private afAuth: AngularFireAuth) { }

    signIn(response: any) {
        console.log(response);
        // TODO Send token to backend and redirect if successful
        this.router.navigate(['/navigator']);
    }

    signOut() {
        this.afAuth.auth.signOut();
        this.router.navigate(['/']);
    }
}
