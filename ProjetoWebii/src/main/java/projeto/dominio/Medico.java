/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.dominio;

import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author douglasboza
 */
//select * from medico as m inner join pessoa on pessoa.id = m.pessoaid;
@Entity
@PrimaryKeyJoinColumn(name="id_pessoa")
@NamedQuery(name = "findAllMedicos", query = "select e from Medico e")


public class Medico extends Pessoa{
    
    int registroProfi;
    ArrayList<String> areaAtuacao;
    ArrayList<Endereco> enderecosAtendi;
    ArrayList<Plano> planosRecebibos;
    ArrayList<Consulta> listaConsultas;
    
//    @Id
//    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_MEDICO")
//    @SequenceGenerator(name="SEQ_MEDICO", sequenceName="seq_medico", allocationSize =1)
    
//    @PrimaryKeyJoinColumn(name="id_pessoa")
    
//    private Long id;
 
//    public long getPessoaId() {
//        return pessoaId;
//    }
//
//    public void setPessoaId(long pessoaId) {
//        this.pessoaId = pessoaId;
//    }
    
    public int getRegistroProfi() {
        return registroProfi;
    }

    public void setRegistroProfi(int registroProfi) {
        this.registroProfi = registroProfi;
    }

    public ArrayList<String> getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(ArrayList<String> areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public ArrayList<Endereco> getEnderecosAtendi() {
        return enderecosAtendi;
    }

    public void setEnderecosAtendi(ArrayList<Endereco> enderecosAtendi) {
        this.enderecosAtendi = enderecosAtendi;
    }

    public ArrayList<Plano> getPlanosRecebibos() {
        return planosRecebibos;
    }

    public void setPlanosRecebibos(ArrayList<Plano> planosRecebibos) {
        this.planosRecebibos = planosRecebibos;
    }

    public ArrayList<Consulta> getListaConsultas() {
        return listaConsultas;
    }

    public void setListaConsultas(ArrayList<Consulta> listaConsultas) {
        this.listaConsultas = listaConsultas;
    }
    
    
}
