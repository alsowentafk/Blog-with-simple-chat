import {Component, OnInit} from '@angular/core';
import {CookieService} from 'ngx-cookie-service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  constructor(public cookieService: CookieService) {
  }

  ngOnInit() {
  }

  buttonOnChangeCss(event) {
    event.target.style.color = 'green';
  }

  buttonOnMouseOver(event) {
    event.target.style.color = 'white';
  }

  displayForm(id: string) {
    document.getElementById(id).style.margin = '1% auto';
    document.getElementById(id).style.display = 'block';
  }

  unDisplayForm(id: string) {
    document.getElementById(id).style.display = 'none';
  }

  logOut() {
    this.cookieService.delete('userAuthorization');
    this.cookieService.delete('userIdAuthorization');
  }
}
