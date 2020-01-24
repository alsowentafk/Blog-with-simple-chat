import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {User} from '../models/User';
import {LoginDataDTO} from '../models/LoginDataDTO';

@Injectable()
export class UserService {
  constructor(private httpClient: HttpClient) {
  }

  async saveUser(user: User) {
    const endpoint = 'http://localhost:8080/api/user';
    return await this.httpClient.post(endpoint, user).toPromise();
  }

  async checkExistUserByEmail(email: string) {
    const endpoint = 'http://localhost:8080/api/user/checkUserExistByEmail';
    return await this.httpClient.get(endpoint, {params: {'email': email}}).toPromise();
  }

  async checkExistUserByLogin(login: string) {
    const endpoint = 'http://localhost:8080/api/user/checkUserExistByLogin';
    return await this.httpClient.get(endpoint, {params: {'login': login}}).toPromise();
  }

  async signIn(loginData: LoginDataDTO) {
    const endpoint = 'http://localhost:8080/api/user/signIn';
    return await this.httpClient.post(endpoint, loginData).toPromise();
  }

  async findUserById(id: number) {
    const endpoint = 'http://localhost:8080/api/user/getUserById';
    return await this.httpClient.get(endpoint, {params: {'id': String(id)}}).toPromise();
  }

  async findUserByLogin(login: string):Promise<User>{
    const endpoint = 'http://localhost:8080/api/user/getUserByLogin';
    return await this.httpClient.get<User>(endpoint, {params: {'login': String(login)}}).toPromise();
  }

  async updateUser(user: User, fileToUpload: File) {
    if (fileToUpload != null) {
      const endpoint = 'http://localhost:8080/api/user/updateUserWithPhoto';
      const formData: FormData = new FormData();
      formData.append('file', fileToUpload);
      formData.append('object', JSON.stringify(user));
      this.httpClient
        .put(endpoint, formData).subscribe((val) => {
        console.log(val);
      });
    } else {
      const endpoint = 'http://localhost:8080/api/user/updateUserWithOutPhoto';
      this.httpClient
        .put(endpoint, user).subscribe((val) => {
        console.log(val);
      });
    }
    return false;
  }
}
