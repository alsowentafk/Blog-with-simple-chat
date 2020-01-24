import {Component, OnInit} from '@angular/core';
import {UserService} from '../../services/UserService';
import {User} from '../../models/User';
import {Response} from '../../models/Response';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {MustMatch} from '../../validators/PasswordValidator';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  regExp = '(?:[a-z0-9!#$%&\'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&\'*+/=?^_`{|}~-]+)*|"(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21\x23-\x5b\x5d-\x7f]|\\\\[\x01-\x09\x0b\x0c\x0e-\x7f])*")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\x01-\x08\x0b\x0c\x0e-\x1f\x21-\x5a\x53-\x7f]|\\\\[\x01-\x09\x0b\x0c\x0e-\x7f])+)\\])';
  user: User = null;
  EmailExist = false;
  LoginExist = false;
  registerForm: FormGroup;
  submitted = false;

  constructor(private userService: UserService, private formBuilder: FormBuilder) {
  }

  get f() {
    return this.registerForm.controls;
  }

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      login: ['', [Validators.required, Validators.minLength(4)]],
      email: ['', [Validators.required, Validators.email, Validators.pattern(this.regExp)]],
      pass1: ['', [Validators.required, Validators.minLength(4)]],
      pass2: ['', [Validators.required]],
      acceptTerms: [false, Validators.requiredTrue]
    }, {
      validator: [MustMatch('pass1', 'pass2')]
    });
  }

  onSubmit() {
    this.submitted = true;
    if (this.registerForm.invalid || this.EmailExist === true || this.LoginExist === true) {
      return;
    }
    this.user = new User(this.registerForm.value.email, 'user', this.registerForm.value.pass1, this.registerForm.value.login);
    console.info(this.user);
    this.userService.saveUser(this.user).then((response: Response) => {
      if (response.status === 500 && response.message === 'User with this email already exist') {
        this.EmailExist = true;
      } else if (response.status === 500 && response.message === 'User with this login already exist') {
        this.LoginExist = true;
      } else if (response.status === 500 && response.message === 'User with this login and email already exist') {
        this.LoginExist = true;
        this.EmailExist = true;
      } else if (response.status === 200) {
        this.submitted = false;
        this.registerForm.reset();
        document.getElementById('window_r').style.display = 'none';
        document.getElementById('window_after_registration').style.display = 'block';
      }
    });
  }

  closeForm(event) {
    this.submitted = false;
    this.registerForm.reset();
    event.target.parentElement.style.display = 'none';
  }

  checkExistingEmail(event) {
    this.userService.checkExistUserByEmail(event.target.value).then((response: boolean) => {
        this.EmailExist = response === true;
      }
    );
  }

  checkExistingLogin(event) {
    this.userService.checkExistUserByLogin(event.target.value).then((response: boolean) => {
        this.LoginExist = response === true;
      }
    );
  }
}
