import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http: HttpClient) { }

  login(email, password) {
    console.log(email);
    console.log(password)
    return this.http.post('localhost:8080/api/celum/user/login', {
      email : '{email}',
      password : '{password}'
    });
  }

  getFakeUsers() {
    return this.http.get('https://reqres.in/api/users');
  }

  getUsers() {
    return this.http.get('http://localhost:8080/api/celum/student');
  }

  getUserDetails(userId) {
    return this.http.get('http://localhost:8080/api/celum/student/' + userId);
  }

  getUserCourses(userId) {
    return this.http.get('http://localhost:8080/api/celum/course/student=' + userId);
  }

}
