/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto.presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import projeto.data.ConsultaDAO;
import projeto.data.DefaultDAO;
import projeto.data.MedicoDAO;
import projeto.dominio.Consulta;
import projeto.dominio.Medico;
import projeto.dominio.Pessoa;

/**
 *
 * @author douglasboza
 */

@Named(value = "ConsultaBean")
@RequestScoped

public class ConsultaBean implements Serializable{
    @Inject ConsultaDAO consultadao;
    @Inject DefaultDAO defaultdao;
    
    Consulta consulta = new Consulta();
    
    private String horario;
    
        
    
}