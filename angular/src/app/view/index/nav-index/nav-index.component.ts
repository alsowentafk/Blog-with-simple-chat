import {Component, OnInit} from '@angular/core';
import {CookieService} from 'ngx-cookie-service';

@Component({
  selector: 'app-nav-index',
  templateUrl: './nav-index.component.html',
  styleUrls: ['./nav-index.component.css']
})
export class NavIndexComponent implements OnInit {

  constructor(public cookieService: CookieService) {
  }

  ngOnInit() {
  }

  buttonOnChangeCss(event) {
    event.target.style.backgroundColor = 'white';
    event.target.style.color = 'black';
  }

  buttonOnMouseOver(event) {
    event.target.style.backgroundColor = '';
    event.target.style.color = 'white';
  }

  displayForm(id: string) {
    document.getElementById(id).style.display = 'block';
  }

  logOut() {
    this.cookieService.delete('userAuthorization');
    this.cookieService.delete('userIdAuthorization');
  }
}
