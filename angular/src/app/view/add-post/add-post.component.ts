import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {CookieService} from 'ngx-cookie-service';
import {Article} from '../../models/Article';
import {ArticleService} from '../../services/ArticleService';

@Component({
  selector: 'app-add-post',
  templateUrl: './add-post.component.html',
  styleUrls: ['./add-post.component.css']
})
export class AddPostComponent implements OnInit {

  static categoryList = ['Спорт', 'Домашні улюбленці', 'Настільні ігри', 'Подорожі'];
  fileToUpload: File = null;
  previewUrl: any = '//placehold.it/250';
  addPostForm: FormGroup;
  submitted = false;

  constructor(private cookieService: CookieService, private formBuilder: FormBuilder, private articleService: ArticleService) {
  }

  get f() {
    return this.addPostForm.controls;
  }

  getCategoryList() {
    return AddPostComponent.categoryList;
  }

  ngOnInit() {
    this.addPostForm = this.formBuilder.group({
      name: ['', [Validators.required, Validators.minLength(2)]],
      image: ['', [Validators.required]],
      category: ['', [Validators.required]],
      text: ['', [Validators.required, Validators.minLength(5)]],
      contacts: ['', [Validators.required]],
      forSearch: ['']
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

  onSubmit() {
    this.submitted = true;
    if (this.addPostForm.invalid) {
      return;
    }
    let now = new Date();
    const article: Article = new Article(null,
      this.addPostForm.value.name, this.addPostForm.value.text
      , now, this.addPostForm.value.contacts, this.addPostForm.value.image, this.addPostForm.value.category);
    console.log(article);
    this.articleService.saveArticle(article, this.fileToUpload, this.cookieService.get('userIdAuthorization')).then();
    this.submitted = false;
    this.addPostForm.reset();
    window.location.reload();
  }
}
