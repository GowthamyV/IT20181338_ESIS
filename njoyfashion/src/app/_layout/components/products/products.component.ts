import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProductsService } from 'src/app/_services/products.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-products',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.scss'],
})
export class ProductsComponent implements OnInit {
  $Products!: Observable<any>;
  constructor(private productService: ProductsService) {}
  ngOnInit(): void {
    this.getAllProducts();
  }
  products: any = [
    {
      id: 1,
    },
    {
      id: 1,
    },
    ,
    {
      id: 1,
    },
    {
      id: 1,
    },
    {
      id: 1,
    },
    {
      id: 1,
    },
    {
      id: 1,
    },
    {
      id: 1,
    },
  ];

  getAllProducts() {
    this.$Products = this.productService.getProductDetails();
  }
}
