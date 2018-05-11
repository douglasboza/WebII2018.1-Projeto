/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.dominio;

import java.util.ArrayList;

/**
 *
 * @author douglasboza
 */
public class Medico extends Pessoa{
    int registroProfi;
    ArrayList<String> areaAtuacao;
    ArrayList<Endereco> enderecosAtendi;
    ArrayList<Plano> planosRecebibos;
    ArrayList<Consulta> listaConsultas;

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
