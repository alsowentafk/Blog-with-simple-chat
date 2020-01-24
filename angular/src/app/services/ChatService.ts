import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Chat} from "../models/Chat";

@Injectable()
export class ChatService {
  constructor(private httpClient: HttpClient){}
  async saveChat(idFirstUser: string, idSecondUser: string):Promise<Chat> {
    const endpoint = 'http://localhost:8080/api/chat/saveChat';
    let params = new HttpParams().set("idFirstUser", String(idFirstUser))
      .set("idSecondUser", String(idSecondUser));
    return await this.httpClient
      .post<Chat>(endpoint, {},{params: params}).toPromise();
  }
  async deleteChat(idUser: string){
    const endpoint = 'http://localhost:8080/api/chat/deleteChat';
    let params = new HttpParams().set("id", String(idUser));
    return await this.httpClient
      .delete(endpoint, {params: params}).toPromise();
  }
  async getChatsByUserId(idUser: string):Promise<Chat[]>{
    const endpoint = 'http://localhost:8080/api/chat/getChatByUserId';
    let params = new HttpParams().set("userId", String(idUser));
    return await this.httpClient
      .get<Chat[]>(endpoint,{params: params}).toPromise();
  }
}
