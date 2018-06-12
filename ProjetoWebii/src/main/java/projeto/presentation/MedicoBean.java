/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import projeto.data.DefaultDAO;
import projeto.data.MedicoDAO;
import projeto.data.PessoaDAO;
import projeto.dominio.Consulta;
import projeto.dominio.Medico;
import projeto.dominio.Pessoa;

/**
 *
 * @author douglasboza
 */

@Named(value = "medicoBean")
@RequestScoped

public class MedicoBean implements Serializable{
    @Inject MedicoDAO medicodao;
    @Inject DefaultDAO defaultdao;
    
    Pessoa pessoa = new Pessoa();
    Medico medico = new Medico();
    
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private int registroProfi;
    private ArrayList<String> areaAtuacao  = new ArrayList<String>();
    private ArrayList<String> areaAtuacao_aux  = new ArrayList<String>();
    private String stringAreaAtuacao;
    private int teste_editar;
    private Long id_pessoa=null;
//    private ArrayList<String> planosRecebidos = new ArrayList<String>();

//    private ArrayList<Endereco> enderecosAtendi;
//    private ArrayList<Plano> planosRecebibos;
    private ArrayList<Consulta> listaConsultas;
    
    private List<Medico> medicoList = new ArrayList<>();

    public Long getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(Long id_pessoa) {
        this.id_pessoa = id_pessoa;
        this.medico.setId_pessoa(id_pessoa);
        System.out.println("setou como"+ id_pessoa);
    }
    
    
    public MedicoBean(){
        
    }

    public int getTeste_editar() {
        return teste_editar;
    }

    public void setTeste_editar(int teste_editar) {
        this.teste_editar = teste_editar;
    }
    
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
        medico.setNome(nome);
    }
    
      public int getRegistroProfi() {
        return registroProfi;
    }

    public void setRegistroProfi(int registroProfi) {
        medico.setRegistroProfi(registroProfi);
        this.registroProfi = registroProfi;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
        medico.setCpf(cpf);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        medico.setEmail(email);
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
        medico.setTelefone(telefone);
    }

    public ArrayList<String> getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(ArrayList<String> itemAreaAtuacao) {
        medico.setAreaAtuacao(itemAreaAtuacao);
    }

    public String getStringAreaAtuacao() {
        return stringAreaAtuacao;
    }

    public void setStringAreaAtuacao(String stringAreaAtuacao) {
        this.stringAreaAtuacao = stringAreaAtuacao;
        String[] array_araAtuacao = stringAreaAtuacao.split(";", -1);
        for (int i = 0; i < array_araAtuacao.length; i++) {
           areaAtuacao_aux.add(array_araAtuacao[i]);
        }
        
        System.out.println("passou aqui");
        
        this.setAreaAtuacao(areaAtuacao_aux);
    }
    
    
//
//    public ArrayList<String> getPlanosRecebidos() {
//        return planosRecebidos;
//    }
//
//    public void setPlanosRecebidos(ArrayList<String> planosRecebidos) {
//        this.planosRecebidos = planosRecebidos;
//    }

    public ArrayList<Consulta> getListaConsultas() {
        return listaConsultas;
    }

    public void setListaConsultas(ArrayList<Consulta> listaConsultas) {
        this.listaConsultas = listaConsultas;
    }
    
    /* TODO Gerenciamento de consultas */
    public void marcarConsulta(Consulta e){
        listaConsultas.add(e);
    }
    
//  Retorna motivo de ter desmarcado
    public String desmarcarConsulta(){
        return null;
    }
    
    

    public List<Medico> getMedicoList() {
        this.medicoList = medicodao.findMedicos();
        return this.medicoList;
    }

    public void setMedicoList(List<Medico> medicoList) {
         this.medicoList = medicodao.findMedicos();
    }
    
    public void excluirMedico(int id_rem1){
        Long id_rem = Long.valueOf(id_rem1);
        System.out.println("igual aaaa " +id_rem);
        defaultdao.removerObj(id_rem, "Medico", "id_pessoa");
    }
        


    public void addMedico(int teste_editar) {
        System.out.println("igual nome="+this.getMedico());
        
        if(teste_editar == 1){
            defaultdao.editarObj(medico);
            System.out.println("igual iii "+medico.getId_pessoa());
        }else{
            defaultdao.addNewObj(this.medico);
            System.out.println("igual uuu "+this.medico.getId_pessoa());
        }
      
    }
    
    public Medico getMedico() {
        return this.medico;
    }

    
    public void setMedico(Medico med_editar) {
        this.setNome(med_editar.getNome());
        this.setAreaAtuacao(med_editar.getAreaAtuacao());
        this.setCpf(med_editar.getCpf());
        this.setEmail(med_editar.getEmail());
        this.setTelefone(med_editar.getTelefone());
//        this.setPlanosRecebidos(med_editar.getPlanosRecebibos());
        this.setRegistroProfi(med_editar.getRegistroProfi());
        this.setId_pessoa(med_editar.getId_pessoa());
        String auxArea = "";
        for (String s : med_editar.getAreaAtuacao()){
            auxArea += s+";";
        }
        System.out.println("Area de atuacao = "+auxArea);
        this.setStringAreaAtuacao(auxArea);
        this.medico = med_editar;
    }
        
    
}