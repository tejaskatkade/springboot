import { Component } from '@angular/core';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import {MatButtonModule} from '@angular/material/button';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { UserService } from '../../service/user.service';
import {MatSnackBar, MatSnackBarModule} from '@angular/material/snack-bar';


@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [MatSnackBarModule,HttpClientModule,FormsModule,MatFormFieldModule,MatToolbarModule,MatIconModule,MatInputModule,MatButtonModule],
  providers: [UserService],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent {
  constructor(private userService:UserService, private snack:MatSnackBar){}

  public user={
    userName:'',
    name:'',
    password:'',
    email:'',
    phone:''
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
    if(this.user.name == '' || this.user.name == null){
      this.snack.open("Name is requird ","okay");
      //alert("Name is requird");
      return;
    }
    if(this.user.email == '' || this.user.email == null){
      this.snack.open("Email is requird ","okay");
      alert("Email is requird");
      return;
    }

    //add user
    this.userService.addUser(this.user).subscribe(this.observer);
    this.snack.open("User added successfully ","okay");
    //alert("User added successfully");
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
      this.snack.open("User added successfully ","okay");
    }
  
  };

}
