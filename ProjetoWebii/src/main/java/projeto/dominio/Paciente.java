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
public class Paciente extends Pessoa{
    Endereco enderecoPac;
    ArrayList<Plano> planosPac;
    ArrayList<Consulta> consultasPac;

    public Endereco getEnderecoPac() {
        return enderecoPac;
    }

    public void setEnderecoPac(Endereco enderecoPac) {
        this.enderecoPac = enderecoPac;
    }

    public ArrayList<Plano> getPlanosPac() {
        return planosPac;
    }

    public void setPlanosPac(ArrayList<Plano> planosPac) {
        this.planosPac = planosPac;
    }

    public ArrayList<Consulta> getConsultasPac() {
        return consultasPac;
    }

    public void setConsultasPac(ArrayList<Consulta> consultasPac) {
        this.consultasPac = consultasPac;
    }
    
    
    
    
}
