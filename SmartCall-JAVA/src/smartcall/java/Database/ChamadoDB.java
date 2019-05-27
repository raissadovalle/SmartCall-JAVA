/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartcall.java.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import smartcall.java.Classes.Chamado;


public class ChamadoDB {

    public Chamado BuscarChamado() {
        
        Chamado Dados = new Chamado();

        return Dados;
    }    

    public void SalvarChamado(Chamado chamado) {
        
        Connection con = c_ConexaoDB.getConnection();
        
        if(VerificarChamado(chamado)){
        
            
        }      
    }

    public boolean ExcluirChamado() {
        return true;
    }

    private boolean VerificarChamado(Chamado chamado) {
        
        boolean hit = false;
        Connection conn = c_ConexaoDB.getConnection();
        String sql = "SELECT 1 FROM chamado WHERE chv_chamado = '" + chamado.getCodigo() + "'";
        
        try {
            
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs.first()) 
                hit = true;
            else 
                hit =  false;
            
        } catch (SQLException ex) {
            Logger.getLogger(ChamadoDB.class.getName()).log(Level.SEVERE, null, ex);
        }   
        return hit;     
    }
}
