import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {AppComponent} from './app.component';
import {IndexComponent} from './view/index/index.component';
import {LoginComponent} from './view/login/login.component';
import {RegistrationComponent} from './view/registration/registration.component';
import {NavIndexComponent} from './view/index/nav-index/nav-index.component';
import {InfoComponent} from './view/index/info/info.component';
import {CardComponent} from './view/index/card/card.component';
import {FooterComponent} from './view/footer/footer.component';
import {FormBuilder, FormsModule, ReactiveFormsModule} from '@angular/forms';
import {UserService} from './services/UserService';
import {HttpClientModule} from '@angular/common/http';
import {SuccessfulRegistrationComponent} from './view/successful-registration/successful-registration.component';
import {InvalidConfirimRegistrationComponent} from './view/invalid-confirim-registration/invalid-confirim-registration.component';
import {CookieService} from 'ngx-cookie-service';
import {FormAfterRegComponent} from './view/registration/form-after-reg/form-after-reg.component';
import {NotFoundComponent} from './view/not-found/not-found.component';
import {AboutComponent} from './view/about/about.component';
import {NavComponent} from './view/nav/nav.component';
import {ProfileComponent} from './view/profile/profile.component';
import {PostsComponent} from './view/posts/posts.component';
import {AddPostComponent} from './view/add-post/add-post.component';
import {MatSelectModule} from '@angular/material';
import {NgxMatSelectSearchModule} from 'ngx-mat-select-search';
import {CategorySearchFilterPipe} from './pipes/category-search-filter-pipe';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {ArticleService} from './services/ArticleService';
import {PostComponent} from './view/post/post.component';
import {CommentService} from "./services/CommentService";
import {LikeService} from "./services/LikeService";
import { AccountComponent } from './view/account/account.component';
import { MessagesComponent } from './view/messages/messages.component';
import { ChatComponent } from './view/chat/chat.component';
import {ChatService} from "./services/ChatService";
import {MessageService} from "./services/MessageService";
import {RoomService} from "./services/RoomService";
import {RoomMessageService} from "./services/RoomMessageService";
import {MessageFilterPipe} from "./pipes/message-filter-pipe";
import { MessagePageComponent } from './view/message-page/message-page.component';
import { PrivateChatComponent } from './view/message-page/private-chat/private-chat.component';
import {RoomFilterPipe} from "./pipes/room-filter-pipe";
import {MatIconModule} from "@angular/material/icon";

const appRoutes: Routes = [
  {path: '', component: IndexComponent},
  {path: 'invalidConfirmRegistration', component: InvalidConfirimRegistrationComponent},
  {path: 'successfulRegistration', component: SuccessfulRegistrationComponent},
  {path: 'about', component: AboutComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'posts', component: PostsComponent},
  {path: 'addPost', component: AddPostComponent},
  {path: 'mesPage', component: MessagePageComponent},
  {path: 'post/:id', component: PostComponent},
  {path: 'account/:id', component: AccountComponent},
  {path: '**', component: NotFoundComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    IndexComponent,
    LoginComponent,
    RegistrationComponent,
    NavIndexComponent,
    InfoComponent,
    CardComponent,
    FooterComponent,
    SuccessfulRegistrationComponent,
    InvalidConfirimRegistrationComponent,
    FormAfterRegComponent,
    NotFoundComponent,
    AboutComponent,
    NavComponent,
    ProfileComponent,
    PostsComponent,
    AddPostComponent,
    CategorySearchFilterPipe,
    MessageFilterPipe,
    PostComponent,
    AccountComponent,
    MessagesComponent,
    ChatComponent,
    MessagePageComponent,
    PrivateChatComponent,
    RoomFilterPipe
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    NgxMatSelectSearchModule,
    MatSelectModule,
    BrowserAnimationsModule,
    RouterModule.forRoot(appRoutes),
    MatIconModule
  ],
  providers: [UserService, FormBuilder, CookieService, ArticleService
    , CommentService, LikeService, ChatService, MessageService, RoomService, RoomMessageService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
