import {Routes} from '@angular/router';
import { HomePageComponent } from './home/home-page.component';
import {AddProductComponent} from "./pages/add-product/add-product.component";

export const routes: Routes = [
  {path: '', component: HomePageComponent},
  {path: 'add-product', component: AddProductComponent}
];