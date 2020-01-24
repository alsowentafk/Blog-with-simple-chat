import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Room} from "../models/Room";

@Injectable()
export class RoomService {
  constructor(private httpClient: HttpClient) {}
  async saveRoom(idFirstUser: string, room: Room):Promise<Room>{
    const endpoint = 'http://localhost:8080/api/room/saveRoom';
    let params = new HttpParams().set("idFirstUser", String(idFirstUser));
    return await this.httpClient
      .post<Room>(endpoint, room,{params: params}).toPromise();
  }
  async findAllRooms():Promise<Room[]> {
    const endpoint = 'http://localhost:8080/api/room/findAll';
    return await this.httpClient.get<Room[]>(endpoint).toPromise();
  }
  async findRoomByName(name: string):Promise<Room> {
    const endpoint = 'http://localhost:8080/api/room/findByName';
    return await this.httpClient.get<Room>(endpoint,{params:{'name': name}}).toPromise();
  }
}
