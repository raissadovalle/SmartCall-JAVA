/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartcall.java.Classes;

import java.sql.Connection;
import smartcall.java.Database.c_ConexaoDB;

/**
 *
 * @author Raissa do Valle
 */
public class TesteConexao {
    public static void main (String[] args){
        Connection con = c_ConexaoDB.getConnection();
                
    }
    
}
