import { Component, OnInit } from '@angular/core';
import { ConsultaService } from '../../../services/consulta.service';

@Component({
  selector: 'app-consulta-list',
  templateUrl: './consulta-list.component.html',
  styleUrls: ['./consulta-list.component.css']
})
export class ConsultaListComponent implements OnInit {
  public consultas: Array<any> = [];


  constructor(private consultaService: ConsultaService) { }

  ngOnInit() {
    this.consultaService.findAll().subscribe((r: any) => {
      this.consultas = r.content;
      console.log(this.consultas);
    })
  }

}
