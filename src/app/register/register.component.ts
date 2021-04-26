import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { User } from './user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerUserData = new User();

  buttonValue: any;

  constructor(private _auth: AuthService) { }

  ngOnInit(): void {
  }

  onItemChange(value: any){
    this.buttonValue = value;
 }

  registerUser() {
    if (this.buttonValue == 'Trainee'){
      //this.registerUserData.userType = "trainee";
      console.log(this.registerUserData);
      this._auth.registerUser(this.registerUserData).subscribe(response => console.log(response), error => console.log(error));
    }
  }


}
