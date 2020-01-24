import {User} from "./User";

export class Room {
  constructor(name: string) {
    this.name = name;
  }
  id: number;
  name: string;
  user_id: User;
}
