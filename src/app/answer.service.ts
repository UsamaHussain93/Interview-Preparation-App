import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Answer } from './create-question/Answer';

@Injectable({
  providedIn: 'root'
})
export class AnswerService {
  response:any;
  private _questionUrl = "http://localhost:8088/delve/add-answer";

  constructor(private http: HttpClient) { }

  createAnswer(answer: Answer){
    
    this.response = this.http.post<any>(this._questionUrl, answer);
    console.log(">>>>>>> RESPONSE:");
    console.log(JSON.stringify(this.response));
    return this.response;

  }
 
 get answerId(){
   return JSON.parse(localStorage.getItem('answer')).id;
 }
}
