import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'app-invalid-confirim-registration',
  templateUrl: './invalid-confirim-registration.component.html',
  styleUrls: ['./invalid-confirim-registration.component.css']
})
export class InvalidConfirimRegistrationComponent implements OnInit {

  constructor(private router: Router) {
  }

  ngOnInit() {
    setTimeout(() => {
      this.router.navigateByUrl('/').then();
    }, 5000)
  }

}
