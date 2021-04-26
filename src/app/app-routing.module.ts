import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
//import { userInfo } from 'node:os';
import { AuthGuard } from './auth.guard';
import { BehaviouralComponent } from './behavioural/behavioural.component';
import { BusinessAnalystComponent } from './business-analyst/business-analyst.component';
import { CreateQuestionComponent } from './create-question/create-question.component';
import { DevopsComponent } from './devops/devops.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { SoftwareDevelopmentComponent } from './software-development/software-development.component';
import { UserinfoComponent } from './userinfo/userinfo.component';


const routes: Routes = [
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'home',
    component: HomeComponent,
    // canActivate: [AuthGuard]
  },
  {
    path: 'behavioural',
    component: BehaviouralComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'software-development',
    component: SoftwareDevelopmentComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'devops',
    component: DevopsComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'business-analyst',
    component: BusinessAnalystComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'userinfo',
    component: UserinfoComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'trainer-profile',
    component: CreateQuestionComponent,
    canActivate: [AuthGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
