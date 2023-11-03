import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './_layout/pages/home/home.component';
import { LoginComponent } from './_layout/pages/login/login.component';
import { ResgisterComponent } from './_layout/pages/resgister/resgister.component';
import { config } from 'rxjs';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    children: [
      {
        path: '',
        loadChildren: () =>
          import('./_layout/pages/content/content.module').then(
            (m) => m.ContentModule
          ),
      },
    ],
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'register',
    component: ResgisterComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
