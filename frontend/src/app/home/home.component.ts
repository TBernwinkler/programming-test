import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import { DataService } from '../data.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  messageForm: FormGroup;
  submitted = false;
  success = false;
  loginUserData: object;

  constructor(private formBuilder: FormBuilder, private data: DataService) { }

  ngOnInit() {
    this.messageForm = this.formBuilder.group({
      address: ['', Validators.email],
      password: ['', Validators.required]
    });
  }

  onSubmit() {
    this.submitted = true;

    if (this.messageForm.invalid) {
      return;
    }

    // password should be converted to a hash code here before sending it to the backend
    console.log(this.data.login(this.messageForm.controls.address.value, this.messageForm.controls.password.value));

    this.success = true;
  }


}
