/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import smartcall.java.Classes.Cliente;
import smartcall.java.Database.c_ConexaoDB;

/**
 *
 * @author Raissa do Valle
 */
public class DAOCliente {
    
     public List<Cliente> getList()
     {
        List<Cliente> listaCliente = new ArrayList<>();
        Connection con = c_ConexaoDB.getConnection();
        String sql = "SELECT c.cpfCnpj, c.nome, c.telefone, c.email from cliente c;";
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
        
            while(rs.next())
            {
                 Cliente c = new Cliente();
                 
                 c.setCpfCnpj(rs.getString("c.cpfCnpj"));  
                 c.setNome(rs.getString("c.nome"));
                 c.setTelefone(rs.getString("c.telefone"));
                 c.setEmail(rs.getString("c.email"));

                 listaCliente.add(c);
            }
            stmt.close();
            rs.close();
        }
        catch(SQLException ex)
        {
            System.out.println("Erro, lista não retornada");
            return null;
        }
        return listaCliente;               
    }

    public boolean AdicionarCliente(Cliente cliente) {
        Connection con = c_ConexaoDB.getConnection();
        
        String sql = "INSERT INTO cliente (cpfCnpj, nome, logradouro, numero, bairro, cidade, estado, cep, email, telefone, ie, representante, rg) "
                + "VALUES ('" + cliente.getCpfCnpj() + "', '" + cliente.getNome() + "', '" + cliente.getLogradouro() + "', " + cliente.getNumero() + ", '" + cliente.getBairro() + "', '" + cliente.getCidade() + "', "
                + "'" + cliente.getEstado() + "', '" + cliente.getCep() + "', '" + cliente.getEmail() + "', '" + cliente.getTelefone() + "', '" + cliente.getIe() + "', '" + cliente.getRg() + "', '" + cliente.getRg() + "')";
        
        try{
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.execute();
            return true;
        }
        catch(SQLException ex){
            System.out.println(ex);
            return false;            
        }
    }

    public boolean ExcluirCliente(String cpfCnpj) {
                Connection con = c_ConexaoDB.getConnection();
        
        String sql = "DELETE FROM cliente WHERE cpfCnpj = '" + cpfCnpj + "';";
        
        try{
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.execute();
            return true;
        }
        catch(SQLException ex){
            System.out.println(ex);
            return false;            
        }
    }
    
        public boolean AtualizarCliente(Cliente cliente, String cpfCnpj) {
        Connection con = c_ConexaoDB.getConnection();
        
        String sql = "UPDATE cliente SET cpfCnpj = '" + cliente.getCpfCnpj() + "', nome = '" + cliente.getNome() + "', endereco = '" + cliente.getLogradouro() + "', numero = " + cliente.getNumero() + ", bairro ='" + cliente.getBairro() + "', "
        +"cidade = '" + cliente.getCidade() + "', estado = '" + cliente.getEstado() + "', cep = '" + cliente.getCep() + "', email = '" + cliente.getEmail() + "', telefone = '" + cliente.getTelefone() + "', ie = '" + cliente.getIe() + "', representante = '" + cliente.getRepresentante() + "', rg ='" + cliente.getRg() + "' "
        +"WHERE cpfCnpj = '" + cpfCnpj + "';";
        
        try{
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.execute();
            return true;
        }
        catch(SQLException ex){
            System.out.println(ex);
            return false;            
        }
    }
    
}
