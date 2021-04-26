import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from './register/user';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private _registerUrl = "http://localhost:8088/delve/adduser";
  private _loginUrl = "http://localhost:8088/delve/loginuser";

  // public user2: User;

  constructor(private http: HttpClient) { }

  registerUser(user: User) {
    return this.http.post<any>(this._registerUrl, user);
  }

  loginUser(user: User) {
    return this.http.post<any>(this._loginUrl, user);
  }

  loggedIn() {
    return !!localStorage.getItem('user');
  }

  logoutUser() {
    localStorage.removeItem('user');
  }

  get userByUsername() {
    // this.user2 = localStorage.getItem('user');
    return JSON.parse(localStorage.getItem('user')).username;
  }

  get userByEmail() {
    // this.user2 = localStorage.getItem('user');
    return JSON.parse(localStorage.getItem('user')).email;
  }

  get userByAccountType() {
    // this.user2 = localStorage.getItem('user');
    return JSON.parse(localStorage.getItem('user')).accountType;
  }

}
