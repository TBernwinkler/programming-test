import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.scss']
})
export class CoursesComponent implements OnInit {

  coursesTitle = 'Course Management';
  userId = '4ab764ca-9b5d-48d6-9e0b-3fcbfaeb0a29';
  loggedIn = true;
  admin = false;
  user: object;
  courses: object;

  constructor(private data: DataService) { }

  ngOnInit() {
    this.data.getUserDetails(this.userId).subscribe(data => {
      this.user = data;
      console.log(this.user);
    });

    this.data.getUserCourses(this.userId).subscribe(data => {
      this.courses = data;
      console.log(this.courses);
    });
  }

}
