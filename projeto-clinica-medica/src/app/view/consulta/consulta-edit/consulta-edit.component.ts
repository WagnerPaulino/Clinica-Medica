import { Component, OnInit } from '@angular/core';
import { ConsultaService } from '../../../services/consulta.service';
import { Consulta } from '../../../domain/consulta';
import { Route, ActivatedRoute, ParamMap } from '@angular/router';
import { switchMap, map } from 'rxjs/operators'

@Component({
  selector: 'app-consulta-edit',
  templateUrl: './consulta-edit.component.html',
  styleUrls: ['./consulta-edit.component.css']
})
export class ConsultaEditComponent implements OnInit {
  public consulta: Consulta = new Consulta();
  constructor(private consultaService: ConsultaService,
    private route: ActivatedRoute,
    private router: ActivatedRoute) {
    this.route.queryParams.subscribe((params) => {
        const id = params['id'];
        if (id) {
          this.consultaService.findOne(id).subscribe((r: Consulta) => {
            this.consulta = r;
            console.log(this.consulta);
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
        console.log(r);
      });
    } else {
      this.consultaService.inserir(this.consulta).subscribe((r) => {
        console.log(r);
      });
    }
    console.log(this.consulta);
  }
  excluir() {
    this.consultaService.deletar(this.consulta).subscribe((r) => {
      console.log(r);
      this.consulta = new Consulta();
    });
  }

}
