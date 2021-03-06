import {Chat} from "./Chat";
import {User} from "./User";

export class RoomMessage {
  id: number;
  chat_id: Chat;
  user_id: User;
  text: string;
  date: Date;
  constructor(text: string) {
    this.text = text;
  }
}
