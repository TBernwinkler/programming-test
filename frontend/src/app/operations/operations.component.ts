import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';


@Component({
  selector: 'app-operations',
  templateUrl: './operations.component.html',
  styleUrls: ['./operations.component.scss']
})
export class OperationsComponent implements OnInit {

  h1Style: boolean = false;
  users: object;
  logs: object;

  constructor(private data: DataService) { }

  ngOnInit() {
    this.data.getFakeUsers().subscribe(data => {
      this.users = data;
      console.log(this.users);
    });

    this.data.getLogs('admin@celum.at').subscribe(data => {
      this.logs = data;
      console.log(this.logs);
    });
  }

  firstClick() {
    this.h1Style = true;
    this.data.getUsers();
  }


}
