export class Like {
  id;
  articleId;
  userId;
  amount;
  constructor(amount: number) {
    this.amount = amount;
  }
}
