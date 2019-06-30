import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './home/home.component';
import {CoursesComponent} from './courses/courses.component';
import {OperationsComponent} from './operations/operations.component';

const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'courses', component: CoursesComponent},
  { path: 'operations', component: OperationsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
