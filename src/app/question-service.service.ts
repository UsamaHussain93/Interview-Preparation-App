import { HttpClient, JsonpClientBackend } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AnswerService } from './answer.service';
import { Answer } from './create-question/Answer';
import { LinkQA } from './create-question/LinkQA';
import { Question } from './create-question/Question';

@Injectable({
  providedIn: 'root'
})
export class QuestionServiceService {
 
  response:any;
  private _questionUrl = "http://localhost:8088/delve/add-question";
  private _linkUrl = "http://localhost:8088/delve/link";

  constructor(private http: HttpClient,private aService:AnswerService) { }

  createQuestion(question: Question ){
    this.response=this.http.post<any>(this._questionUrl, question);
    return this.response;
  }

  linkQuestionAndAnswer(qId:number, aId: number ){
    var headers = {'content-type': 'application/json'};
    qId=this.questionId;
    aId=this.aService.answerId;
    console.log("LINKING " + aId+" | "+qId);
    
    let qa = new LinkQA(qId, aId);
    console.log(qa);
    return this.http.post<any>(this._linkUrl, qa);
  }

  get questionId(){
    return JSON.parse(localStorage.getItem('question')).id;

  }
  
  get question(){

    return JSON.parse(localStorage.getItem('question'));
  }
}
