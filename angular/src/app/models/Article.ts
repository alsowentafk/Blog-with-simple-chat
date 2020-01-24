import {User} from './User';

export class Article {
  article_id: number;
  user_id: User;
  name: string;
  text: string;
  created_at: Date;
  contacts: string;
  image: string;
  category: string;

  constructor(user_id: User, name: string, text: string, created_at: Date, contacts: string, image: string, category: string) {
    this.user_id = user_id;
    this.name = name;
    this.text = text;
    this.created_at = created_at;
    this.contacts = contacts;
    this.image = image;
    this.category = category;
  }
}
