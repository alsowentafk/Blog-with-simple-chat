import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Article} from '../models/Article';

@Injectable()
export class ArticleService {
  constructor(private httpClient: HttpClient) {
  }

  async saveArticle(article: Article, fileToUpload: File, idUser: string) {
    const endpoint = 'http://localhost:8080/api/article/';
    const formData: FormData = new FormData();
    formData.append('file', fileToUpload);
    formData.append('idUser', idUser);
    formData.append('object', JSON.stringify(article));
    this.httpClient
      .post(endpoint, formData).subscribe((val) => {
      console.log(val);
    });
    return false;
  }
  async update(article: Article) {
    const endpoint = 'http://localhost:8080/api/article/updateArticle';
    return await this.httpClient
      .put(endpoint,arguments).toPromise();
  }
  async getAllArticles(): Promise<Article[]> {
    const usersUrl = 'http://localhost:8080/api/article/getAll';
    return this.httpClient.get<Article[]>(usersUrl).toPromise();
  }

  async getAllArticlesByCategory(category: string): Promise<Article[]> {
    const usersUrl = 'http://localhost:8080/api/article/getAllByCategory';
    return this.httpClient.get<Article[]>(usersUrl, {params: {'category': category}}).toPromise();
  }

  async getArticleById(id: string): Promise<Article> {
    const usersUrl = 'http://localhost:8080/api/article/getArticleById';
    return this.httpClient.get<Article>(usersUrl, {params: {'id': id}}).toPromise();
  }

  async get3RandArticles(): Promise<Article[]> {
    const usersUrl = 'http://localhost:8080/api/article/get3RandomArticles';
    return this.httpClient.get<Article[]>(usersUrl).toPromise();
  }
}
