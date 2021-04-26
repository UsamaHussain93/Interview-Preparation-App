import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-software-development',
  templateUrl: './software-development.component.html',
  styleUrls: ['./software-development.component.css']
})
export class SoftwareDevelopmentComponent implements OnInit {

  startButton: Boolean = false;
  answer: any;

  constructor() { }

  ngOnInit(): void {
  }

  showQuestion() {
    this.startButton = true;
  }
}
