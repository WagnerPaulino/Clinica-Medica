import { PacienteModule } from './view/paciente/paciente.module';
import { MedicoModule } from './view/medico/medico.module';
import { ConsultaModule } from './view/consulta/consulta.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { SharedModule } from './shared/shared.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    SharedModule,
    BrowserAnimationsModule,
    ConsultaModule,
    MedicoModule,
    PacienteModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
