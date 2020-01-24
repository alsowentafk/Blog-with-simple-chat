import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Message} from "../models/Message";
import {RoomMessage} from "../models/RoomMessage";

@Injectable()
export class RoomMessageService {
  constructor(private httpClient: HttpClient){}
  async saveMessage(idFirstUser: string, idChat: string, roomMessage: RoomMessage) {
    const endpoint = 'http://localhost:8080/api/roomMessage/saveRoomMessage';
    let params = new HttpParams().set("idFirstUser", String(idFirstUser))
      .set("idChat", String(idChat));
    return await this.httpClient
      .post(endpoint, roomMessage,{params: params}).toPromise();
  }
  async findMessagesFromRoom(idRoom: string):Promise<RoomMessage[]> {
    const endpoint = 'http://localhost:8080/api/roomMessage/findMessagesFromRoom';
    let params = new HttpParams().set("idRoom", String(idRoom));
    return await this.httpClient
      .get<RoomMessage[]>(endpoint,{params: params}).toPromise();
  }
}
