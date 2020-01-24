import {Component, OnDestroy, OnInit} from '@angular/core';
import {Room} from "../../../models/Room";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {UserService} from "../../../services/UserService";
import {CookieService} from "ngx-cookie-service";
import {RoomService} from "../../../services/RoomService";
import {Message} from "../../../models/Message";
import {RoomMessage} from "../../../models/RoomMessage";
import {User} from "../../../models/User";
import {RoomMessageService} from "../../../services/RoomMessageService";

@Component({
  selector: 'app-private-chat',
  templateUrl: './private-chat.component.html',
  styleUrls: ['./private-chat.component.css']
})
export class PrivateChatComponent implements OnInit, OnDestroy {
  filterRoom = '';
  roomList: Room[] = [];
  roomMessages: RoomMessage[] = [];
  room: Room = new Room('');
  sendMessageText = '';
  interval;
  constructor(private userService: UserService, private formBuilder: FormBuilder
              , public cookieService: CookieService, private roomMessageService: RoomMessageService,
              private roomService: RoomService) { }
  get f1() {
    return this.roomForm.controls;
  }
  roomForm: FormGroup;
  submitted = false;
  ngOnInit() {
    this.roomForm = this.formBuilder.group({
      name: ['', [Validators.required]]
    });
    this.roomService.findAllRooms().then(res=>{
      this.roomList = res;
    })
  }
  ngOnDestroy(){
    clearInterval(this.interval);
  }
  closeForm(event) {
    event.target.parentElement.style.display = 'none';
    this.submitted = false;
    this.roomForm.reset();
  }
  onSubmit(){
    this.submitted = true;
    if (this.roomForm.invalid) {
      return;
    }
    document.getElementById('saveRoom').style.display = 'none';
    this.roomService.saveRoom(this.cookieService.get('userIdAuthorization')
      ,new Room((this.f1.name.value))).then();
  }

  saveRoom() {
    document.getElementById('saveRoom').style.display = 'block';
  }

  openRoom(name: string) {
    this.roomService.saveRoom(this.cookieService.get('userIdAuthorization'),new Room((name))).then(res=>{
      this.roomService.findRoomByName(name).then(res=>{
        this.room = res;
        document.getElementById('messageRoom').style.display = 'block';
        this.interval = setInterval(()=>{this.checkRoom()}, 2000);
      })
    });
  }
  checkRoom(){
    this.roomMessageService.findMessagesFromRoom(this.room.id.toString()).then(res=>{
      this.roomMessages = res;
    })
  }
  getUserPhoto(user: User) {
    if(user.user_id == undefined){
      return '//placehold.it/250';
    }
    return 'http://localhost:8080/api/user/downloadFile/' + user.user_id;
  }
  sendMessage() {
    if(this.sendMessageText === ''){
      return;
    }
    this.roomMessageService.saveMessage(
      this.cookieService.get('userIdAuthorization'),this.room.id.toString()
      ,new RoomMessage(this.sendMessageText)).then(()=>{
      this.sendMessageText = '';
    });
  }
}
