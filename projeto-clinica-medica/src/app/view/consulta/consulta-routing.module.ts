import { ConsultaListComponent } from './consulta-list/consulta-list.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {path: 'consulta-list', component: ConsultaListComponent, children: [

  ]}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class ConsultaRoutingModule { }
