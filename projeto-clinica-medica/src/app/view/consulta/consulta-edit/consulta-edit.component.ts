import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { ConsultaService } from '../../../services/consulta.service';
import { Consulta } from '../../../domain/consulta';
import { Route, ActivatedRoute, ParamMap } from '@angular/router';
import { switchMap, map } from 'rxjs/operators';

@Component({
  selector: 'app-consulta-edit',
  templateUrl: './consulta-edit.component.html',
  styleUrls: ['./consulta-edit.component.css']
})
export class ConsultaEditComponent implements OnInit {
  public consulta: Consulta = new Consulta();

  @Output()
  public salvouConsulta = new EventEmitter();

  constructor(private consultaService: ConsultaService,
      private route: ActivatedRoute,
      private router: ActivatedRoute) {
    this.route.queryParams.subscribe((params) => {
        const id = params['id'];
        if (id) {
          this.consultaService.findOne(id).subscribe((r: Consulta) => {
            this.consulta = r;
          });
        } else {
          this.consulta = new Consulta;
        }
    });
   }
  ngOnInit() {}
  salvar() {
    if (this.consulta.id) {
      this.consultaService.alterar(this.consulta).subscribe((r) => {
        this.consulta = new Consulta();
        this.salvouConsulta.emit();
      });
    } else {
      this.consultaService.inserir(this.consulta).subscribe((r) => {
        this.consulta = new Consulta();
        this.salvouConsulta.emit();
      });
    }
  }
  excluir() {
    this.consultaService.deletar(this.consulta).subscribe((r) => {
      this.consulta = new Consulta();
      this.salvouConsulta.emit();
    });
  }

}
