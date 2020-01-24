import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Like} from "../models/Like";

@Injectable()
export class LikeService {
  constructor(private httpClient: HttpClient){}
  async getAllLikesFromArticle(idArticle: string): Promise<number> {
    const usersUrl = 'http://localhost:8080/api/like/getArticleLikes';
    let params = new HttpParams().set("id", String(idArticle));
    return await this.httpClient.get<number>(usersUrl, {params: params}).toPromise();
  }

  async saveLike(idUser: string, idArticle: number) {
    const endpoint = 'http://localhost:8080/api/like/saveLike';
    let params = new HttpParams().set("idUser", String(idUser)).set("idArticle", String(idArticle));
    return await this.httpClient
      .post(endpoint, {},{params: params}).toPromise();
  }
}
