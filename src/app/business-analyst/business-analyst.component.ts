import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-business-analyst',
  templateUrl: './business-analyst.component.html',
  styleUrls: ['./business-analyst.component.css']
})
export class BusinessAnalystComponent implements OnInit {

  startButton: Boolean = false;

  constructor() { }

  ngOnInit(): void {
  }

  showQuestion() {
    this.startButton = true;
  }
}
