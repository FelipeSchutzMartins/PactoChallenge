import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { EmployerHomeComponent } from './employer-home/employer-home.component';
import { employerGuard, candidateGuard, notLoggedGuard } from './guards/auth.guard';
import { CandidateHomeComponent } from './candidate-home/candidate-home.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent, canActivate: [notLoggedGuard]},
  { path: 'register', component: RegisterComponent, canActivate: [notLoggedGuard]},
  { path: 'employerHome', component: EmployerHomeComponent, canActivate: [employerGuard] },
  { path: 'candidateHome', component: CandidateHomeComponent, canActivate: [candidateGuard] },
  { path: '', redirectTo: 'login', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
