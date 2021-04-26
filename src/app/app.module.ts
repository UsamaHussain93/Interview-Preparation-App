import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule} from '@angular/forms';
import { HttpClientModule} from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RegisterComponent } from './register/register.component';

import { HomeComponent } from './home/home.component';
import { SoftwareDevelopmentComponent } from './software-development/software-development.component';
import { DevopsComponent } from './devops/devops.component';
import { BusinessAnalystComponent } from './business-analyst/business-analyst.component';
import { BehaviouralComponent } from './behavioural/behavioural.component';
import { AuthService } from './auth.service';
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './auth.guard';
import { UserinfoComponent } from './userinfo/userinfo.component';
import { QuestionServiceService } from './question-service.service';
import { CreateQuestionComponent } from './create-question/create-question.component';

// import { UserinfoComponent } from './userinfo/userinfo.component';


@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    HomeComponent,
    SoftwareDevelopmentComponent,
    DevopsComponent,
    BusinessAnalystComponent,
    BehaviouralComponent,
    UserinfoComponent,
    CreateQuestionComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [AuthService, AuthGuard, LoginComponent, QuestionServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
