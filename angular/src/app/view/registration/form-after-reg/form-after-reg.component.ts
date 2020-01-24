import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-form-after-reg',
  templateUrl: './form-after-reg.component.html',
  styleUrls: ['./form-after-reg.component.css']
})
export class FormAfterRegComponent implements OnInit {

  constructor() {
  }

  closeForm(event) {
    event.target.parentElement.style.display = 'none';
  }

  ngOnInit() {
  }

}
