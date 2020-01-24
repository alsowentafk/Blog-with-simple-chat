import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {UserService} from '../../services/UserService';
import {User} from '../../models/User';
import {LoginDataDTO} from '../../models/LoginDataDTO';
import {CookieService} from 'ngx-cookie-service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  submitted = false;
  invalidLogin = false;
  user: User = null;

  constructor(private userService: UserService, private formBuilder: FormBuilder, public cookieService: CookieService) {
  }

  get f1() {
    return this.loginForm.controls;
  }

  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      login_a: ['', [Validators.required]],
      pass_a: ['', [Validators.required]],
    });
  }

  onSubmit() {
    this.submitted = true;
    if (this.loginForm.invalid) {
      return;
    }

    this.userService.signIn(new LoginDataDTO(this.loginForm.value.login_a, this.loginForm.value.pass_a))
      .then((response: User) => {
        if (response == null) {
          this.invalidLogin = true;
        } else {
          this.invalidLogin = false;
          this.user = response;
          console.log(this.user);
          this.submitted = false;
          this.loginForm.reset();
          document.getElementById('window_a').style.display = 'none';
          this.cookieService.set('userAuthorization', 'true');
          this.cookieService.set('userIdAuthorization', String(this.user.user_id));
        }
      });
  }

  closeForm(event) {
    event.target.parentElement.style.display = 'none';
    this.submitted = false;
    this.loginForm.reset();
    this.invalidLogin = false;
  }
}
