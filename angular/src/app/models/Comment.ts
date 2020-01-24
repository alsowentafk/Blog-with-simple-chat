import {Article} from "./Article";
import {User} from "./User";

export class Comment {
  id: number;
  articleId: Article;
  userId: User;
  text: String;

  constructor(private string: string) {
    this.text = string;
  }
}
