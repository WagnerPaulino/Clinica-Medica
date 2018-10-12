import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { MedicoService } from '../../../services/medico.service';
import { Medico } from '../../../domain/medico';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-medico-edit',
  templateUrl: './medico-edit.component.html',
  styleUrls: ['./medico-edit.component.css']
})
export class MedicoEditComponent implements OnInit {
  public medico: Medico = new Medico();

  @Output()
  public salvouMedico = new EventEmitter();

  constructor(private medicoService: MedicoService,
      private route: ActivatedRoute,
      private router: ActivatedRoute) {
    this.route.queryParams.subscribe((params) => {
        const id = params['id'];
        if (id) {
          this.medicoService.findOne(id).subscribe((r: Medico) => {
            this.medico = r;
          });
        } else {
          this.medico = new Medico;
        }
    });
   }
  ngOnInit() {}
  salvar() {
    if (this.medico.id) {
      this.medicoService.alterar(this.medico).subscribe((r) => {
        this.medico = new Medico();
        this.salvouMedico.emit();
      });
    } else {
      this.medicoService.inserir(this.medico).subscribe((r) => {
        this.medico = new Medico();
        this.salvouMedico.emit();
      });
    }
  }
  excluir() {
    this.medicoService.deletar(this.medico).subscribe((r) => {
      this.medico = new Medico();
      this.salvouMedico.emit();
    });
  }

}
