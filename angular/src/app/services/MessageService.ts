import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Message} from "../models/Message";

@Injectable()
export class MessageService {
  constructor(private httpClient: HttpClient){}
  async saveMessage(idFirstUser: string, idChat: string, message: Message) {
    const endpoint = 'http://localhost:8080/api/message/saveMessage';
    let params = new HttpParams().set("idFirstUser", String(idFirstUser)).set("idChat", String(idChat));
    return await this.httpClient
      .post(endpoint, message,{params: params}).toPromise();
  }
  async findMessagesFromChat(idChat: string):Promise<Message[]> {
    const endpoint = 'http://localhost:8080/api/message/findMessagesFromChat';
    let params = new HttpParams().set("idChat", String(idChat));
    return await this.httpClient
      .get<Message[]>(endpoint,{params: params}).toPromise();
  }
}
