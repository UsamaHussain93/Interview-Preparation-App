import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-behavioural',
  templateUrl: './behavioural.component.html',
  styleUrls: ['./behavioural.component.css']
})
export class BehaviouralComponent implements OnInit {

  startButton: Boolean = false;

  constructor() { }

  ngOnInit(): void {
  }

  showQuestion() {
    this.startButton = true;
  }
}
