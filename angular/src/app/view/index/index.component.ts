import {Component, OnInit} from '@angular/core';
import {Article} from '../../models/Article';
import {ArticleService} from '../../services/ArticleService';

@Component({
  selector: 'app-index',
  templateUrl: './index.component.html',
  styleUrls: ['./index.component.css']
})
export class IndexComponent implements OnInit {
  articles: Article[];

  constructor(private articleService: ArticleService) {
  }

  ngOnInit() {
    this.articleService.get3RandArticles().then((list) => {
      this.articles = list;
    })
  }
}
