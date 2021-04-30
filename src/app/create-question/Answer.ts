import { Question } from "./Question";




export class Answer
{
    public id?:number;
    public question?: Question;
    public answerText:string;
    public correctAnswer: boolean = false;

    constructor(id?:number, question?:Question, answerText?:string, isCorrectAnswer?: boolean) 
    {
        this.id = id;
        this.question = question;
        this.answerText = answerText;
        this.correctAnswer = isCorrectAnswer;
    }
    getId(): number {
        return this.id;
      }
}