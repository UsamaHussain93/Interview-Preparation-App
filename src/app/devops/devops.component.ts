import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-devops',
  templateUrl: './devops.component.html',
  styleUrls: ['./devops.component.css']
})
export class DevopsComponent implements OnInit {

  startButton: Boolean = false;

  constructor() { }

  ngOnInit(): void {
  }

  showQuestion() {
    this.startButton = true;
  }
}
