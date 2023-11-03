import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { CategoryService } from 'src/app/_services/category.service';
import { Observable, of } from 'rxjs';
import { ProductsService } from 'src/app/_services/products.service';

document.addEventListener('DOMContentLoaded', function () {
  window.addEventListener('scroll', function () {
    if (window.scrollY > 50) {
      document.getElementById('navbar_top')?.classList.add('fixed-top');
      // add padding top to show content behind navbar
      let navbar_height = (document.querySelector('.navbar') as HTMLElement)
        ?.offsetHeight;
      document.body.style.paddingTop = navbar_height + 'px';
    } else {
      document.getElementById('navbar_top')?.classList.remove('fixed-top');
      // remove padding top from body
      document.body.style.paddingTop = '0';
    }
  });
});

@Component({
  selector: 'app-nav',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss'],
})
export class NavComponent implements OnInit {
  $categories!: Observable<any>;

  categories: any = [
    {
      name: 'Mens Collection',
      subCategory: [
        {
          name: 'Jeans',
        },
        {
          name: 'T-Shirt',
        },
        {
          name: 'Shirt',
        },
      ],
    },
    {
      name: 'Womens Collection',
      subCategory: [
        {
          name: 'Jeans',
        },
        {
          name: 'T-Shirt',
        },
        {
          name: 'Shirt',
        },
      ],
    },
    {
      name: 'Kids Collection',
      subCategory: [
        {
          name: 'Jeans',
        },
        {
          name: 'T-Shirt',
        },
        {
          name: 'Shirt',
        },
      ],
    },
    {
      name: 'Toys',
      subCategory: [],
    },
  ];
  constructor(
    private router: Router,
    private categoryService: CategoryService,
    private productService: ProductsService
  ) {}
  ngOnInit(): void {
    this.getAllCategories();
  }

  subCatecoryArray(data: any) {
    return data;
  }

  login() {
    this.router.navigateByUrl('/login');
  }

  register() {
    this.router.navigateByUrl('/register');
  }

  home() {
    this.router.navigateByUrl('/');
  }

  getAllCategories() {
    this.$categories = this.categoryService.getAllCategories();
  }

  getProductDetailsByProductId(id: number) {
    this.productService.getProductDetailsByCategoryId(id).subscribe({
      next: (value: any) => {
        if (value.length != 0) {
          this.router.navigateByUrl('/products');
          this.productService.productList = value;
        } else {
          this.router.navigateByUrl('/404');
        }
      },
      error: () => {},
    });
  }
}
