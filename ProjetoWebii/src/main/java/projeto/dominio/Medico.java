/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.dominio;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author douglasboza
 */
@Entity
@NamedQuery(name = "findAllMedicos", query = "SELECT e FROM Medico e")
public class Medico{
    int registroProfi;
    long pessoaId;
    ArrayList<String> areaAtuacao;
    ArrayList<Endereco> enderecosAtendi;
    ArrayList<Plano> planosRecebibos;
    ArrayList<Consulta> listaConsultas;
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_MEDICO")
    @SequenceGenerator(name="SEQ_MEDICO", sequenceName="seq_medico", allocationSize =1)
    private Long id;
 
    public long getPessoaId() {
        return pessoaId;
    }

    public void setPessoaId(long pessoaId) {
        this.pessoaId = pessoaId;
    }
    
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
