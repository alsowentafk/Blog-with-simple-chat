import {Component, OnInit} from '@angular/core';
import {Article} from '../../models/Article';
import {ActivatedRoute} from '@angular/router';
import {ArticleService} from '../../services/ArticleService';
import {CookieService} from "ngx-cookie-service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {CommentService} from "../../services/CommentService";
import {User} from "../../models/User";
import {LikeService} from "../../services/LikeService";

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {
  id = '';
  commentForm: FormGroup;
  submitted = false;
  comments = [];
  likes = 0;
  article: Article = new Article(new User('','','','')
    , '', '', null, '', '', '');

  constructor(private route: ActivatedRoute, private articleService: ArticleService,
              private cookieService: CookieService, private formBuilder: FormBuilder
    , private commentService: CommentService, private likeService: LikeService) {
  }

  get f1() {
    return this.commentForm.controls;
  }

  ngOnInit() {
    this.id = this.route.snapshot.paramMap.get('id');
    this.articleService.getArticleById(this.id).then((article) => {
      this.article = article;
      this.commentService.getAllCommentsFromArticle(this.article.article_id.toString()).then((data) => {
        this.comments = data;
      });
      this.likeService.getAllLikesFromArticle(this.article.article_id.toString()).then(amount=>{
        this.likes = amount;
      });
    });
    this.commentForm = this.formBuilder.group({
      text: ['', [Validators.required]],
    });
  }

  getPicture(article: Article) {
    if(article.article_id == undefined)
    {
      return '//placehold.it/250';
    }
    return 'http://localhost:8080/api/article/downloadFile/' + article.article_id;
  }

  getUserPhoto(article: Article) {
    if(article.user_id.user_id == undefined){
      return '//placehold.it/250';
    }
    return 'http://localhost:8080/api/user/downloadFile/' + article.user_id.user_id;
  }
  getUserPhotoComment(userId: User) {
    if(userId.user_id == undefined){
      return '//placehold.it/250';
    }
    return 'http://localhost:8080/api/user/downloadFile/' + userId.user_id;
  }

  onSubmit() {
    this.submitted = true;
    if (this.commentForm.invalid) {
      console.log('Invalid');
      return;
    }
    this.commentService.saveComment
    (this.cookieService.get('userIdAuthorization'),this.article.article_id,this.f1.text.value)
      .then(()=>{
        console.log('Valid');
        this.commentForm.reset();
        this.submitted = false;
        window.location.reload();
      });
  }

  likePost() {

    this.likeService.saveLike(this.cookieService.get('userIdAuthorization')
        ,this.article.article_id).then(()=>{
          this.likeService.getAllLikesFromArticle(this.article.article_id.toString()).then(amount=>{
             this.likes = amount;
          });
        }
    );
  }
}
