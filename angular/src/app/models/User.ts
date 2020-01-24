export class User {
  user_id: number;
  email: string;
  is_confirmed: boolean = false;
  role = Object.freeze(['admin', 'user']);
  password: string;
  image: string;
  login: string;
  birthday: Date;
  about: string;
  phone: string;

  constructor(email: string, role, password: string, login: string) {
    this.email = email;
    this.role = role;
    this.password = password;
    this.login = login;
  }
}
