import { Injectable } from '@angular/core';
import { Answer } from './create-question/Answer';
import { Question } from './create-question/Question';
import { User } from './register/user';

@Injectable({
  providedIn: 'root'
})
export class SessionService {
 

  isSetUserSession(): boolean {
    return !!localStorage.getItem('user');
  }

  clearUserSession() {
    localStorage.removeItem('user');
  }

  setUserSession(user: User) {
    localStorage.setItem('user', JSON.stringify(user));
  }
  setAnswerSession(answer: Answer) {
    localStorage.setItem('answer', JSON.stringify(answer));
  }
  setQuestionSession(question: Question) {
    localStorage.setItem('question', JSON.stringify(question));
  }


}
