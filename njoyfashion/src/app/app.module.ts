import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './_layout/pages/home/home.component';
import { FooterComponent } from './_layout/components/footer/footer.component';
import { NavComponent } from './_layout/components/nav/nav.component';
import { NavContactComponent } from './_layout/components/nav-contact/nav-contact.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ResgisterComponent } from './_layout/pages/resgister/resgister.component';
import { NZ_I18N } from 'ng-zorro-antd/i18n';
import { en_US } from 'ng-zorro-antd/i18n';
import { registerLocaleData } from '@angular/common';
import en from '@angular/common/locales/en';
import { SharedModule } from './_shared/shared.module';
import { SuccessModalComponent } from './_layout/pages/success-modal/success-modal.component';

registerLocaleData(en);
@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ResgisterComponent,
    SuccessModalComponent,
  ],
  imports: [
    FooterComponent,
    NavComponent,
    NavContactComponent,
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    SharedModule,
  ],
  providers: [{ provide: NZ_I18N, useValue: en_US }],
  bootstrap: [AppComponent],
})
export class AppModule {}
