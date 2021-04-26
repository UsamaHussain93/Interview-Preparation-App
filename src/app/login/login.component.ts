import { Component, OnInit } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

import { AuthService } from '../auth.service';
import { User } from '../register/user';
import { SessionService } from '../session.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public loginErrorMessage = false;
  
  public loggedIn = new BehaviorSubject<boolean>(false);

  public loginUserData = new User();

  buttonValue: any;

  constructor(private _auth: AuthService, private _sessionService: SessionService) { }

  ngOnInit(): void {
  }

  onItemChange(value: any){
    this.buttonValue = value;
 }

 
  loginUser() {
    console.log(this.loginUserData);
    this._auth.loginUser(this.loginUserData).subscribe(response => 
      {
        // if (response == true){
        if (response != null){
          console.log(response)
          this._sessionService.setUserSession(response);
          this.loggedIn.next(this._sessionService.isSetUserSession());
          this.loginErrorMessage = false;
          return true;
        }
        else {
          // console.log(response)
          // this._sessionService.setUserSession(response);
          // this.loggedIn.next(this._sessionService.isSetUserSession());
          this.loginErrorMessage = true;
        }
      },
      error => {
    console.log(error);});

  }

  get LoginUserData() {
    return this.loginUserData;
  }

}
