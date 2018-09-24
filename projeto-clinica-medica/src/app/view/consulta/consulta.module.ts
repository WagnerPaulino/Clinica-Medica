import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ConsultaListComponent } from './consulta-list/consulta-list.component';
import { ConsultaRoutingModule } from './consulta-routing.module';
import { SharedModule } from '../../shared/shared.module';

@NgModule({
  imports: [
    CommonModule,
    ConsultaRoutingModule,
    SharedModule
  ],
  declarations: [
    ConsultaListComponent
  ]
})
export class ConsultaModule { }
