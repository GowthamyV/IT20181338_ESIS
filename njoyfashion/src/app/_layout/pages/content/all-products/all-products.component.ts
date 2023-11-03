import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable, of } from 'rxjs';
import { ProductsService } from 'src/app/_services/products.service';

@Component({
  selector: 'app-all-products',
  templateUrl: './all-products.component.html',
  styleUrls: ['./all-products.component.scss'],
})
export class AllProductsComponent implements OnInit {
  $Products!: Observable<any>;
  constructor(private router: Router, public productService: ProductsService) {}
  ngOnInit(): void {
    if (this.productService.productList.length == 0) {
      this.router.navigateByUrl('/');
    }
  }
}
