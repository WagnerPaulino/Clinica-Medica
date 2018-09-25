/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.bean;

/**
 *
 * @author Diloan
 */
public class Consulta {
//    private Roupa roupa;
//    private Cliente cliente;
    private int codigo_Prontuario;
    private String especialidade;
    private String diagnostico;
    private String exame;
    private String tratamento;
    private double sintomas;
    private String descricao;
    private double peso;
    private double altura;
    private int pressao;
    private String dtConsulta;
    private String dtRetorno;
    private double valorConsulta;
    
   
    
    public Consulta() {
    }

    public Consulta(int codigo_Prontuario, String especialidade, String diagnostico, String exame, String tratamento, double sintomas, String descricao, double peso, double altura, int pressao, String dtConsulta, String dtRetorno, double valorConsulta) {
        this.codigo_Prontuario = codigo_Prontuario;
        this.especialidade = especialidade;
        this.diagnostico = diagnostico;
        this.exame = exame;
        this.tratamento = tratamento;
        this.sintomas = sintomas;
        this.descricao = descricao;
        this.peso = peso;
        this.altura = altura;
        this.pressao = pressao;
        this.dtConsulta = dtConsulta;
        this.dtRetorno = dtRetorno;
        this.valorConsulta = valorConsulta;
    }

    public Consulta(int codigo_Prontuario, String dtConsulta, String dtRetorno, double valor_Consulta, String descricao) {
        this.codigo_Prontuario = codigo_Prontuario;
        this.dtConsulta = dtConsulta;
        this.dtRetorno = dtRetorno;
        this.valorConsulta = valor_Consulta;
        this.descricao = descricao;
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

    public double getSintomas() {
        return sintomas;
    }

    public void setSintomas(double sintomas) {
        this.sintomas = sintomas;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getPressao() {
        return pressao;
    }

    public void setPressao(int pressao) {
        this.pressao = pressao;
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

   
   

}

//    public Roupa getRoupa() {
//        return roupa;
//    }
//
//    public void setRoupa(Roupa roupa) {
//        this.roupa = roupa;
//    }
//
//    public Cliente getCliente() {
//        return cliente;
//    }
//
//    public void setCliente(Cliente cliente) {
//        this.cliente = cliente;
//    }

    