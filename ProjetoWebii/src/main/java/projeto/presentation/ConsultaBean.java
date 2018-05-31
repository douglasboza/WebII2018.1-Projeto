/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import projeto.data.ConsultaDAO;
import projeto.data.DefaultDAO;
import projeto.dominio.Consulta;

/**
 *
 * @author douglasboza
 */

@Named(value = "ConsultaBean")
@RequestScoped

public class ConsultaBean implements Serializable{
    @Inject ConsultaDAO consultadao;
    @Inject DefaultDAO defaultdao;
    
    private Consulta consulta = new Consulta();
    
    private Date horaFim;
    private Date horaInicio;
    private int status = 1;
    private int id_medico; //= 19; médico com id 2 que está logado no sistema
    private int id_pessoa;
    private String motivoCancelamento;
    private int teste_editar;
    private Long id_consulta;
    private List<Consulta> consultaList = new ArrayList<>();
    
    public Consulta getConsulta() {
        return consulta;
    }

    public void setConsulta(Consulta con_editar) {
        this.setId_consulta(con_editar.getId_consulta());
        this.setHoraFim(con_editar.getHoraFim());
        this.setHoraInicio(con_editar.getHoraInicio());
        this.setMotivoCancelamento(con_editar.getMotivoCancelamento());
        this.consulta = con_editar;
        System.out.println("teste="+this.consulta.getId_consulta());
    }

    public Date getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(Date horaFim) {
        this.consulta.setHoraFim(horaFim);
        this.horaFim = horaFim;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.consulta.setHoraInicio(horaInicio);
        this.horaInicio = horaInicio;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getMotivoCancelamento() {
        return motivoCancelamento;
    }

    public void setMotivoCancelamento(String motivoCancelamento) {
        this.consulta.setMotivoCancelamento(motivoCancelamento);
        this.motivoCancelamento = motivoCancelamento;
    }

    public int getTeste_editar() {
        return teste_editar;
    }

    public void setTeste_editar(int teste_editar) {
        this.teste_editar = teste_editar;
    }

    public Long getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(Long id_consulta) {
        this.consulta.setId_consulta(id_consulta);
        this.id_consulta = id_consulta;
    }

    public List<Consulta> getConsultaList() {
        this.consultaList = consultadao.findConsultas(null); //null
        return consultaList;
    }

    public void setConsultaList(Long id_pessoa) {
        System.out.println("passou aqui 123");
        this.consultaList = consultadao.findConsultas(id_pessoa);
    }
    
    public void addConsulta(int teste_editar) {
        System.out.println("igual nome="+this.getConsulta());
        
        if(teste_editar == 1){
            defaultdao.editarObjPessoa(this.consulta);
            System.out.println("igual iii "+this.consulta.getId_consulta());
        }else{
            this.consulta.setId_medico(this.id_medico);
            this.consulta.setStatus(this.status);
            defaultdao.addNewObjPessoa(this.consulta);
            System.out.println("igual uuu "+this.consulta.getId_consulta());
        }
      
    }
    
    public void excluirConsulta(int id_rem1){
        Long id_rem = Long.valueOf(id_rem1);
        System.out.println("igual aaaa " +id_rem);
        defaultdao.removerObj(id_rem,"Consulta", "id_consulta");
    }
    
    public void editarConsulta(Consulta con_editar){
        this.setConsulta(con_editar);
        this.setTeste_editar(1);
        System.out.println("igual bbbb " +this.getId_consulta());
    }     
    
    public void selecionarMedico(Long id_pessoa){
        this.setConsultaList(id_pessoa);
        System.out.println(id_pessoa);
    }
        
    /**
     * Mostra na tabela apenas as consultas de um medico em questao
     * @return 
     */
    public List<Consulta> pesquisarPorId() {
        Long id = Long.valueOf(id_medico);
        this.consultaList = consultadao.findConsultas(id); //null
        return consultaList;
    }
    
    /**
     * Determina o preenchimento da tabela, sendo ela completa ou filtrada por id_medico
     */
    public List<Consulta> mostraTabela(){
        if(this.consultaList.equals(null) || this.id_medico == 0) // Assumindo nunca que id_medico==0
            return getConsultaList();
        else
            return pesquisarPorId();
    }
    
    /**
     * Alterar status da consulta para 2 (marcada)
     */
    public void marcarConsulta(Consulta consulta){
        consulta.setStatus(2);
        defaultdao.editarObjPessoa(consulta);
//        this.id_pessoa = ; // TODO id_pessoa do paciente que solicitou
    }
    
    /**
     * Alterar status da consulta para 3 (cancelada)
     */
    public void cancelarConsulta(Consulta consulta){
        consulta.setStatus(3);
        defaultdao.editarObjPessoa(consulta);
    }
    
    /**
     * Alterar status da consulta para 1 (disponivel)
     * Apenas para TESTES
     */
    public void resetarConsulta(Consulta consulta){
        consulta.setStatus(1);
        defaultdao.editarObjPessoa(consulta);
    }
    
}