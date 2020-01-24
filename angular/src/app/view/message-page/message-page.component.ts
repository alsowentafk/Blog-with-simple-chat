import {Component, OnDestroy, OnInit} from '@angular/core';
import {CookieService} from "ngx-cookie-service";
import {UserService} from "../../services/UserService";
import {MessageService} from "../../services/MessageService";
import {ChatService} from "../../services/ChatService";
import {User} from "../../models/User";
import {Chat} from "../../models/Chat";
import {Message} from "../../models/Message";

@Component({
  selector: 'app-message-page',
  templateUrl: './message-page.component.html',
  styleUrls: ['./message-page.component.css']
})
export class MessagePageComponent implements OnInit, OnDestroy{
  constructor(private cookieService: CookieService, private userService: UserService
                      ,private messageService: MessageService, private chatService: ChatService) { }
  searchString = '';
  searchedUser: User = new User('','','','');
  chat:Chat = null;
  messages:Message[] = [];
  interval;
  sendTextMessage = '';
  chatList: Chat[] = [];
  switcher = '';
  ngOnInit() {
    this.chatService.getChatsByUserId(this.cookieService.get('userIdAuthorization')).then((res)=>{
      this.chatList = res;
    });
  }
  ngOnDestroy(){
    clearInterval(this.interval);
  }
  searchUser(){
     this.userService.findUserByLogin(this.searchString).then((res: User)=>{
       this.searchedUser = res;
     });
  }
  getUserPhoto(user: User) {
    if(user.user_id == undefined){
      return '//placehold.it/250';
    }
    return 'http://localhost:8080/api/user/downloadFile/' + user.user_id;
  }
  checkChat(){
    this.messageService.findMessagesFromChat(this.chat.id).then( messages => {
      this.messages = messages;
    });
  }
  openChat(user: User) {
    document.getElementById('chat').style.display = 'block';
    //document.getElementById('button_closed_chat').style.display = 'none';
    this.chatService.saveChat(this.cookieService.get('userIdAuthorization')
      ,user.user_id.toString()).then(chat=>{
      this.chat = chat;
      this.interval = setInterval(()=>{this.checkChat();},2000);
    });
  }
  closeChat() {
    document.getElementById('chat').style.display = 'none';
    document.getElementById('button_closed_chat').style.display = 'block';
    this.chatService.deleteChat(this.chat.id).then(()=>{
      clearInterval(this.interval);
    });
    this.messages = [];
  }
  sendMessage() {
    if(this.sendTextMessage === ''){
      return;
    }
    this.messageService.saveMessage(
      this.cookieService.get('userIdAuthorization'),this.chat.id
      ,new Message(this.sendTextMessage)).then(()=>{
      this.sendTextMessage = '';
    });
  }

  hideChat() {
    document.getElementById('chat').style.display = 'none';
    document.getElementById('button_closed_chat').style.display = 'block';
  }
  checkDifferentUsers(){
    return this.chat.first_user_id.user_id != this.chat.second_user_id.user_id;
  }
  getRealSecondUserId(chat: Chat): User{
    let user;
    if(chat.second_user_id.user_id.toString() === this.cookieService.get('userIdAuthorization')){
       user = chat.first_user_id;
    }
    else {
       user = chat.second_user_id;
    }
    return user;
  }
  getRealFirstUserId(chat: Chat): User{
    let user;
    if(chat.second_user_id.user_id.toString() != this.cookieService.get('userIdAuthorization')){
      user = chat.first_user_id;
    }
    else {
      user = chat.second_user_id;
    }
    return user;
  }

  switchPage(mes: string) {
    this.switcher = mes;
  }
}
