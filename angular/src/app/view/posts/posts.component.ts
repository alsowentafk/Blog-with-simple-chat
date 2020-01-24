import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {ArticleService} from '../../services/ArticleService';
import {Article} from '../../models/Article';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {
  articles: Article[];
  articlesLength = 0;

  constructor(private router: Router, private articleService: ArticleService) {
  }

  ngOnInit() {
    this.getAllArticles();
  }

  getPicture(article: Article) {
    return 'http://localhost:8080/api/article/downloadFile/' + article.article_id;
  }

  displayAddPost() {
    this.router.navigateByUrl('/addPost').then();
  }

  selectByCategory(category: string) {
    this.articleService.getAllArticlesByCategory(category).then((list) => {
      this.articles = list;
      this.articlesLength = this.articles.length;
    });
  }

  getAllArticles() {
    this.articleService.getAllArticles().then((list) => {
      this.articles = list;
      this.articlesLength = this.articles.length;
    });
  }
}
