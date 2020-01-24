import {User} from "./User";

export class Chat {
  constructor(first_user_id: User, second_user_id: User) {
    this.first_user_id = first_user_id;
    this.second_user_id = second_user_id;
  }
  id;
  first_user_id: User;
  second_user_id: User;
}
