import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ProductsService {
  productList: any[] = [];
  constructor(private http: HttpClient) {}

  getProductDetailsByProductId(id: number) {
    const url = environment.baseUrl + environment.products + id;
    return this.http.get(url);
  }

  getProductDetails() {
    const url = environment.baseUrl + environment.products;
    return this.http.get(url);
  }

  getProductDetailsByCategoryId(id: number) {
    const url =
      environment.baseUrl + environment.products + environment.category + id;
    return this.http.get(url);
  }
}
