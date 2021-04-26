import { Answer } from "./Answer";
import { QuestionTopic } from "./QuestionTopic";
import { QuestionType } from "./QuestionType";


export class Question
{
    id?:number;
    description?: string;
    questionType?: QuestionType;
    questionTopic?: QuestionTopic;
    answerList?: Answer[];

    constructor(id?:number, description? :string, questionType?: QuestionType, questionTopic?: QuestionTopic, answerList?: Answer[])
    {
        this.id=id;
        this.description = description;
        this.questionType = questionType;
        this.questionTopic = questionTopic;
        this.answerList = answerList;
    }
    getId(): number {
        return this.id;
       }
}