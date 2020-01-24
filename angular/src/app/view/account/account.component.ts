import {Component, OnDestroy, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {User} from "../../models/User";
import {ActivatedRoute} from "@angular/router";
import {ArticleService} from "../../services/ArticleService";
import {CookieService} from "ngx-cookie-service";
import {UserService} from "../../services/UserService";
import {ChatService} from "../../services/ChatService";
import {Chat} from "../../models/Chat";
import {MessageService} from "../../services/MessageService";
import {Message} from "../../models/Message";

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit, OnDestroy {
  id = '';
  user = new User('','','','');
  commentForm: FormGroup;
  submitted = false;
  chat:Chat = null;
  messages:Message[] = [];
  sendTextMessage = '';
  interval;
  constructor(private route: ActivatedRoute, private articleService: ArticleService,
              private cookieService: CookieService, private formBuilder: FormBuilder,
              private userService: UserService, private chatService: ChatService
              ,private messageService: MessageService) {
  }

  get f1() {
    return this.commentForm.controls;
  }

  ngOnInit() {
    this.interval = setInterval(()=>{this.checkChat();},2000);
    this.id = this.route.snapshot.paramMap.get('id');
    this.userService.findUserById(Number(this.id)).then( (data:User) => {
      this.user = data;
    });
    this.commentForm = this.formBuilder.group({
      text: ['', [Validators.required]],
    });
  }
  ngOnDestroy(){
    clearInterval(this.interval);
  }
  getUserPhoto(user: User) {
    if(user.user_id == undefined){
      return '//placehold.it/250';
    }
    return 'http://localhost:8080/api/user/downloadFile/' + user.user_id;
  }
  checkChat(){
    this.chatService.saveChat(this.cookieService.get('userIdAuthorization')
      ,this.user.user_id.toString()).then(chat=>{
      this.chat = chat;
      this.messageService.findMessagesFromChat(this.chat.id).then( messages => {
        this.messages = messages;
      });
    });
  }
  openChat() {
      document.getElementById('chat').style.display = 'block';
      document.getElementById('button_closed_chat').style.display = 'none';
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
}
