/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

/**
 *
 * @author Alexsandra
 */
public class Consulta {
//    private Roupa roupa;
//    private Cliente cliente;
    private int codigo_Prontuario;
    private String especialidade;
    private String diagnostico;
    private String exame;
    private String tratamento;
    private String sintomas;
    private String descricao;
    private String dtConsulta;
    private String dtRetorno;
    private double valorConsulta;
    
   
    
    public Consulta() {
    }

    public Consulta(int codigo_Prontuario, String especialidade, String diagnostico, String exame, String tratamento, String sintomas, String descricao,String dtConsulta, String dtRetorno, double valorConsulta) {
        this.codigo_Prontuario = codigo_Prontuario;
        this.especialidade = especialidade;
        this.diagnostico = diagnostico;
        this.exame = exame;
        this.tratamento = tratamento;
        this.sintomas = sintomas;
        this.descricao = descricao;
        this.dtConsulta = dtConsulta;
        this.dtRetorno = dtRetorno;
        this.valorConsulta = valorConsulta;
    }

    public int getCodigo_Prontuario() {
        return codigo_Prontuario;
    }

    public void setCodigo_Prontuario(int codigo_Prontuario) {
        this.codigo_Prontuario = codigo_Prontuario;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getExame() {
        return exame;
    }

    public void setExame(String exame) {
        this.exame = exame;
    }

    public String getTratamento() {
        return tratamento;
    }

    public void setTratamento(String tratamento) {
        this.tratamento = tratamento;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

       public String getDtConsulta() {
        return dtConsulta;
    }

    public void setDtConsulta(String dtConsulta) {
        this.dtConsulta = dtConsulta;
    }

    public String getDtRetorno() {
        return dtRetorno;
    }

    public void setDtRetorno(String dtRetorno) {
        this.dtRetorno = dtRetorno;
    }

    public double getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(double valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

    public void setNome_Paciente(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
   

}


    