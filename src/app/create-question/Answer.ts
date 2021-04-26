



export class Answer
{
   public id?:number;
    public answerText:string;
    public isCorrectAnswer: boolean = false;

    constructor(answerText?:string, isCorrectAnswer?: boolean, id?:number) 
    {
        this.answerText = answerText;
        this.isCorrectAnswer = isCorrectAnswer;
    }
    getId(): number {
        return this.id;
      }
}