import { Routes } from '@angular/router';
import { SignupComponent } from './pages/signup/signup.component';
import { LoginComponent } from './pages/login/login.component';
import { AppComponent } from './app.component';
import { HomeComponent } from './component/home/home.component';

export const routes: Routes = [
    {
        path:'',
        component:HomeComponent,
        pathMatch:'full'
    },
    {
        path:'signup',
        component:SignupComponent,
        pathMatch:'full'
    },
    {
        path:'login',
        component:LoginComponent,
        pathMatch:'full'
    }
];
