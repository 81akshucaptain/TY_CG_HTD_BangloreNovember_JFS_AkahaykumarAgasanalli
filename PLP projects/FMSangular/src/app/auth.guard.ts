import { CanActivate, ActivatedRouteSnapshot } from '@angular/router';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class AuthGaurd implements CanActivate {

    canActivate(routes: ActivatedRouteSnapshot): boolean {
        let expectedRolesArray = routes.data.expectedRoles;
        let userDetails = JSON.parse(localStorage.getItem('userDetails'));
        let expectedRole: string;
        console.log('imjack Value Set Before FORi.e,', expectedRolesArray);

        for (let index in expectedRolesArray) {
            if (userDetails && userDetails.user[0].user === expectedRolesArray[index]) {
                expectedRole = expectedRolesArray[index];
                console.log('imjack Value Set Before AFTER i.e,', expectedRole);
            }
        }
        if (userDetails && userDetails.user[0].user === expectedRole) {
            console.log('im jack and true');
            return true;
        } else {
            console.log('im jack and true');
            return false;
        }
    }
}