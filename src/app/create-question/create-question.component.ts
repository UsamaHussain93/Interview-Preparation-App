import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AnswerService } from '../answer.service';
import { QuestionServiceService } from '../question-service.service';
import { SessionService } from '../session.service';
import { Answer } from './Answer';
import { Question } from './Question';
import { QuestionType} from './QuestionType';


@Component({
  selector: 'app-create-question',
  templateUrl: './create-question.component.html',
  styleUrls: ['./create-question.component.css']
})
export class CreateQuestionComponent implements OnInit {
  private qId: number;
  private aId: number;

  topics = ['Java', 'SQL', 'Unix', 'Spring', 'Angular'];
  subject:any;

  question: Question;
  answer: Answer;

  isTechnical:boolean;
  numberOfChoices:number;
  

  buttonValue: any;
  constructor( private qService: QuestionServiceService, public aService: AnswerService, private http: HttpClient, public sessionService:SessionService) { }

  ngOnInit(): void {
    this.answer = new Answer();
    this.question = new Question();
  }

  public submitQuestion(questionForm: NgForm){
   
    
    

    console.log(this.question);

    this.qService.createQuestion(this.question).subscribe(response1 =>{ 
      this.sessionService.setQuestionSession(response1);

        this.qId = this.qService.questionId;
        
        console.log(this.qId);
        console.log("response:Body - ");
        console.log(response1.body);
    }, error => console.log(error));
    
    this.aService.createAnswer(this.answer).subscribe(
      response => {
        this.sessionService.setAnswerSession(response);
        this.qId = this.qService.questionId;
        this.aId = this.aService.answerId;
        console.log(this.aId);
        console.log("QID: " + this.qId + " | AID:" + this.aId);  
        this.qService.linkQuestionAndAnswer(this.qId, this.aId).subscribe(function(response1){
          console.log(response1);
        });
      }, error => console.log(error)
    );
    
    
     
  }

  onItemChange(value: any){
    this.buttonValue = value;
    if (value == 'Technical'){
      this.isTechnical = true;
      this.question.questionTopic = null;
    }
    else{
      this.isTechnical = false;
      this.question.questionTopic = null;
    }
 }
}
