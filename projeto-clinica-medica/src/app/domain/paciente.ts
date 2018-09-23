import { Recepcionista } from './recepcionista';
import { Usuario } from './usuario';

export class Paciente extends Usuario {
    idPaciente: Number;
    recepcionista: Recepcionista[] = [];
}
