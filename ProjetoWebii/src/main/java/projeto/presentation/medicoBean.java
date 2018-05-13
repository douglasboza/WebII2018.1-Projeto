/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.presentation;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import projeto.data.medicoDAO;
import projeto.data.pessoaDAO;
import projeto.dominio.Medico;
import projeto.dominio.Pessoa;

/**
 *
 * @author douglasboza
 */

@Named(value = "medicoBean")
@RequestScoped

public class medicoBean {
    @Inject medicoDAO medicodao;
    @Inject pessoaDAO pessoadao;
    
    Pessoa pessoa = new Pessoa();
    Medico medico = new Medico();
    
    private String nome;
    private int registroProfi;
    private List<Medico> medicoList = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
        pessoa.setNome(nome);
    }
    
      public int getRegistroProfi() {
        return registroProfi;
    }

    public void setRegistroProfi(int registroProfi) {
        medico.setRegistroProfi(registroProfi);
        this.registroProfi = registroProfi;
    }
    
    	
    public void addMedico() {
        pessoa = pessoadao.addNew(pessoa);
        medico.setPessoaId( pessoa.getId_pessoa() );
        medicodao.addNew(medico);
        
    }
    
    public List<Medico> getMedicoList() {
        this.medicoList = medicodao.findMedicos();
        return this.medicoList;
    }

    public void setMedicoList(List<Medico> medicoList) {
         this.medicoList = medicodao.findMedicos();
    }
    
}
