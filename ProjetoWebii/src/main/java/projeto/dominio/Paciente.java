/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.dominio;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 *
 * @author douglasboza
 */

@Entity
@PrimaryKeyJoinColumn(name="id_pessoa")
@NamedQuery(name = "findAllPacientes", query = "select e from Paciente e")

public class Paciente extends Pessoa{
//    Endereco enderecoPac;
    ArrayList<String> planosPac; // ArrayList<Plano> -> <String>; Empresa detectada pelos primeiros digitos, e.g. 00-unimed, 01-amil
    ArrayList<Consulta> consultasPac;

//    public Endereco getEnderecoPac() {
//        return enderecoPac;
//    }
//
//    public void setEnderecoPac(Endereco enderecoPac) {
//        this.enderecoPac = enderecoPac;
//    }

    public ArrayList<Consulta> getConsultasPac() {
        return consultasPac;
    }

    public void setConsultasPac(ArrayList<Consulta> consultasPac) {
        this.consultasPac = consultasPac;
    }

    public ArrayList<String> getPlanosPac() {
        return planosPac;
    }

    public void setPlanosPac(ArrayList<String> planosPac) {
        this.planosPac = planosPac;
    }
    
}