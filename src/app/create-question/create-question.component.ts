import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { error } from 'selenium-webdriver';
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
  answer1: Answer = new Answer();
  answer2: Answer = new Answer();
  answer3: Answer = new Answer();
  answer4: Answer = new Answer();

  answers: [Answer, Answer, Answer, Answer];

  isTechnical:boolean;
  correctChoice:any;
  buttonValue: any;


  constructor( private qService: QuestionServiceService, public aService: AnswerService, private http: HttpClient, public sessionService:SessionService) { }

  ngOnInit(): void {
    // this.answer = new Answer();
    this.question = new Question();
  }

  public submitQuestion(questionForm: NgForm){
    this.answers = [this.answer1, this.answer2, this.answer3, this.answer4];
    this.question.answer = this.answers;
    
    console.log(this.question);

    this.qService.createQuestion(this.question).subscribe(response =>{
      this.sessionService.setQuestionSession(response);
      console.log("Response Body: ");
      console.log(response.body);
    },error => console.log(error)
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

 onChoiceChange(value: any){
  this.correctChoice = value;
  if(this.correctChoice == 'option1'){
    this.answer1.correctAnswer = true;
    this.answer2.correctAnswer = false;
    this.answer3.correctAnswer = false;
    this.answer4.correctAnswer = false;
  }
  else if(this.correctChoice == 'option2'){
    this.answer2.correctAnswer = true;
    this.answer1.correctAnswer = false;
    this.answer3.correctAnswer = false;
    this.answer4.correctAnswer = false;
  }
  else if(this.correctChoice == 'option3'){
    this.answer3.correctAnswer = true;
    this.answer1.correctAnswer = false;
    this.answer2.correctAnswer = false;
    this.answer4.correctAnswer = false;
  }
  else if(this.correctChoice == 'option4'){
    this.answer4.correctAnswer = true;
    this.answer1.correctAnswer = false;
    this.answer2.correctAnswer = false;
    this.answer3.correctAnswer = false;
  }
 }

}
