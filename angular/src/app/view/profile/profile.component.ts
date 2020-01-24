import {Component, OnInit} from '@angular/core';
import {User} from '../../models/User';
import {UserService} from '../../services/UserService';
import {CookieService} from 'ngx-cookie-service';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})

export class ProfileComponent implements OnInit {
  user: User = null;
  fileToUpload: File = null;
  previewUrl: any = '//placehold.it/250';
  updateForm: FormGroup;
  submitted = false;
  LoginExist = false;
  userDefault = {'login': "", birthday: null, 'phone': "", 'about': ""};

  constructor(private userService: UserService, private cookieService: CookieService, private formBuilder: FormBuilder) {
  }

  get f() {
    return this.updateForm.controls;
  }

  ngOnInit() {
    this.userService.findUserById(parseInt(this.cookieService.get('userIdAuthorization'))).then((data: User) => {
      this.user = data;
      this.userDefault.login = this.user.login;
      this.userDefault.birthday = this.user.birthday;
      this.userDefault.phone = this.user.phone;
      this.userDefault.about = this.user.about;
      if (this.user.image !== null) {
        this.previewUrl = 'http://localhost:8080/api/user/downloadFile/' + this.user.user_id;
      }
    });

    this.updateForm = this.formBuilder.group({
      updateLogin: ['', [Validators.minLength(4)]],
      birthday: ['', []],
      phone: ['', [Validators.minLength(10)]],
      about: ['', [Validators.minLength(100)]]
    });
  }

  fileProgress(fileInput: any) {
    this.fileToUpload = <File>fileInput.target.files[0];
    this.preview();
  }

  preview() {
    const mimeType = this.fileToUpload.type;
    if (mimeType.match(/image\/*/) == null) {
      return;
    }
    let reader = new FileReader();
    reader.readAsDataURL(this.fileToUpload);
    reader.onload = (_event) => {
      this.previewUrl = reader.result;
    };
  }

  checkExistingLogin(event) {
    this.userService.checkExistUserByLogin(event.target.value).then((response: boolean) => {
        this.LoginExist = response === true;
      }
    );
  }

  onSubmit() {
    this.submitted = true;
    if (this.updateForm.invalid || this.LoginExist === true) {
      return;
    }
    this.user.login = (this.updateForm.value.updateLogin != '') ? this.updateForm.value.updateLogin : this.user.login;
    this.user.birthday = (this.updateForm.value.birthday != '') ? this.updateForm.value.birthday : this.user.birthday;
    this.user.phone = (this.updateForm.value.phone != '') ? this.updateForm.value.phone : this.user.phone;
    this.user.about = (this.updateForm.value.about != '') ? this.updateForm.value.about : this.user.about;
    this.userService.updateUser(this.user, this.fileToUpload).then();
    console.log(this.user);
    this.submitted = false;
    this.updateForm.reset();
    window.location.reload();
  }
}
