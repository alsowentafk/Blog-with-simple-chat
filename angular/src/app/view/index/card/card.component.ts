import {Component, Input, OnInit} from '@angular/core';
import {Article} from '../../../models/Article';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

  @Input()
  article: Article;

  constructor() {
  }

  ngOnInit() {
  }

  getPicture(article: Article) {
    return 'http://localhost:8080/api/article/downloadFile/' + article.article_id;
  }
}
