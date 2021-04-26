import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { LoginComponent } from '../login/login.component';
// import { LoginComponent } from '../login/login.component';
import { User } from '../register/user';


@Component({
  selector: 'app-userinfo',
  templateUrl: './userinfo.component.html',
  styleUrls: ['./userinfo.component.css']
})
export class UserinfoComponent implements OnInit {

  // userData = new User();

  

  constructor(private _authService: AuthService) { }

  ngOnInit(): void {
  }

  userName = this._authService.userByUsername;
  email = this._authService.userByEmail;
  accountType = this._authService.userByAccountType;

  isTrainer(): Boolean {
    if(this.accountType == "Trainer"){
      return true;
    }else{
      return false;
    }
    
  }



  

}
