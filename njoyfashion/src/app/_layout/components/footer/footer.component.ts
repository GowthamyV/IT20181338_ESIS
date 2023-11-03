import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-footer',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss'],
})
export class FooterComponent {
  constructor(private router: Router) {}

  aboutus() {
    this.router.navigateByUrl('/about-us');
  }
  contactus() {
    this.router.navigateByUrl('/contact-us');
  }
  home() {
    this.router.navigateByUrl('/');
  }
}
