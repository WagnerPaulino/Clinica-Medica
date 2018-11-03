
package modelo.bean;

/**
 *
 * @author Alexsandra e Gaby
 */
public class AgendaConsulta {
    private int Data;
    private int Hora;
    private String Nome_Paciente;
    private String Especialidade;
    private String Medico;

    public AgendaConsulta() {
    }

    public AgendaConsulta(int Data, int Hora, String Nome_Paciente, String Especialidade, String Medico) {
        this.Data = Data;
        this.Hora = Hora;
        this.Nome_Paciente = Nome_Paciente;
        this.Especialidade = Especialidade;
        this.Medico = Medico;
    }

    public int getDate() {
        return Data;
    }

    public void setDate(int Date) {
        this.Data = Date;
    }

    public int getHora() {
        return Hora;
    }

    public void setHora(int Hora) {
        this.Hora = Hora;
    }

    public String getNome_Paciente() {
        return Nome_Paciente;
    }

    public void setNome_Paciente(String Nome_Paciente) {
        this.Nome_Paciente = Nome_Paciente;
    }

    public String getEspecialidade() {
        return Especialidade;
    }

    public void setEspecialidade(String Especialidade) {
        this.Especialidade = Especialidade;
    }

    public String getMedico() {
        return Medico;
    }

    public void setMedico(String Medico) {
        this.Medico = Medico;
    }

    public Object getData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
 
}
