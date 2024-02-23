import { Component } from '@angular/core';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import { FormsModule } from '@angular/forms';
import {MatSnackBar, MatSnackBarModule} from '@angular/material/snack-bar';
import { UserService } from '../../service/user.service';
import { HttpClientModule } from '@angular/common/http';
import { LoginService } from '../../service/login.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [HttpClientModule,MatFormFieldModule,MatToolbarModule,MatIconModule,MatInputModule,MatButtonModule,FormsModule, MatSnackBarModule],
  providers: [UserService],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  constructor(private userService:UserService, private snack:MatSnackBar,private login:LoginService){}

  public user={
    userName:'',
    password:''
  };

  formSubmit(){
    if(this.user.userName == '' || this.user.userName == null){
      this.snack.open("Username is required ","okay");
      //alert("User is requird");
      return;
    }
    if(this.user.password == '' || this.user.password == null){
      this.snack.open("Password is requird ","okay");
      //alert("Password is requird");
      return;
    }

    //request server
    console.log("login button submitted");
    this.login.generateToken(this.user).subscribe(this.observer);


  }

  private observer = {
    // next: (value: Object) => {
    //   // Handle next value
    // },
    error: (error: any) => {
      // Handle error
      this.snack.open("Something went wrong ","okay");
    },
    complete: () => {
      // Handle completion
      this.snack.open("Login successfully ","okay");
    }
  
  }; 

}
