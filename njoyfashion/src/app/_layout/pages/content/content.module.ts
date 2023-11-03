import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ContentRoutingModule } from './content-routing.module';
import { ContentComponent } from './content/content.component';
import { CarouselComponent } from '../../components/carousel/carousel.component';
import { ProductsComponent } from '../../components/products/products.component';
import { FullBannerComponent } from '../../components/full-banner/full-banner.component';
import { AllProductsComponent } from './all-products/all-products.component';
import { NoProductsComponent } from './no-products/no-products.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { AboutUsComponent } from './about-us/about-us.component';

@NgModule({
  declarations: [
    ContentComponent,
    AllProductsComponent,
    NoProductsComponent,
    ContactUsComponent,
    AboutUsComponent,
  ],
  imports: [
    CommonModule,
    ContentRoutingModule,
    CarouselComponent,
    ProductsComponent,
    FullBannerComponent,
  ],
})
export class ContentModule {}
