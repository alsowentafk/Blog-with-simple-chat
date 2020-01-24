import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Comment} from "../models/Comment";

@Injectable()
export class CommentService {
  constructor(private httpClient: HttpClient) {

  }

  async getAllCommentsFromArticle(idArticle: string): Promise<Comment[]> {
    const usersUrl = 'http://localhost:8080/api/comment/getArticleComments';
    let params = new HttpParams().set("id", String(idArticle));
    return await this.httpClient.get<Comment[]>(usersUrl, {params: params}).toPromise();
  }

  async saveComment(idUser: string, idArticle: number, text: string) {
    const endpoint = 'http://localhost:8080/api/comment/saveComment';
    let params = new HttpParams().set("idUser", String(idUser)).set("idArticle", String(idArticle));
    return await this.httpClient
      .post(endpoint, new Comment(text), {params: params}).toPromise();
  }
}
