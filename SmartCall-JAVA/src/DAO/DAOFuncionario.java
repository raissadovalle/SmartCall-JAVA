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
import smartcall.java.Classes.Funcionario;
import smartcall.java.Database.c_ConexaoDB;

/**
 *
 * @author Raissa do Valle
 */
public class DAOFuncionario {
    
     public List<Funcionario> getList()
     {
        List<Funcionario> listaFuncionario = new ArrayList<>();
        Connection con = c_ConexaoDB.getConnection();
        
        String sql = "SELECT f.cpfcnpj, f.nome, f.email, s.idsetor, s.nomesetor, f.cargo from funcionario f "
                + "JOIN setor s on s.idsetor = f.idsetor;";
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
        
            while(rs.next())
            {
                 Funcionario c = new Funcionario();
                 
                 c.setCpfCnpj(rs.getString("cpfcnpj"));  
                 c.setNome(rs.getString("nome"));
                 c.setEmail(rs.getString("email"));
                 c.setIdSetor(rs.getString("idsetor"));
                 c.setNomeSetor(rs.getString("nomesetor"));
                 c.setCargo(rs.getString("cargo"));

                 listaFuncionario.add(c);
            }
            stmt.close();
            rs.close();
        }
        catch(SQLException ex)
        {
            System.out.println("Erro, lista não retornada");
            return null;
        }
        return listaFuncionario;               
    }

    public boolean AdicionarFuncionario(Funcionario funcionario) {
        Connection con = c_ConexaoDB.getConnection();
        
        String sql = "INSERT INTO funcionario (cpfCnpj, nome, logradouro, numero, bairro, cidade, estado, cep, email, telefone, idSetor, cargo) "
                + "VALUES ('" + funcionario.getCpfCnpj() + "', '" + funcionario.getNome() + "', '" + funcionario.getLogradouro() + "', " + funcionario.getNumero() + ", '" + funcionario.getBairro() + "', '" + funcionario.getCidade() + "', "
                + "'" + funcionario.getEstado() + "', '" + funcionario.getCep() + "', '" + funcionario.getEmail() + "', '" + funcionario.getTelefone() + "', " + funcionario.getIdSetor() + ", '" + funcionario.getCargo() + "');";
        
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

    public boolean ExcluirFuncionario(String cpfCnpj) {
                Connection con = c_ConexaoDB.getConnection();
        
        String sql = "DELETE FROM funcionario WHERE cpfCnpj = '" + cpfCnpj + "';";
        
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
    
    public boolean AtualizarFuncionario(Funcionario funcionario, String cpfCnpj) {
        Connection con = c_ConexaoDB.getConnection();

        String sql = "UPDATE funcionario SET cpfcnpj = '" + funcionario.getCpfCnpj() + "', nome = '" + funcionario.getNome() + "', logradouro = '" + funcionario.getLogradouro() + "', numero = " + funcionario.getNumero() + ", bairro ='" + funcionario.getBairro() + "', "
        +"cidade = '" + funcionario.getCidade() + "', estado = '" + funcionario.getEstado() + "', cep = '" + funcionario.getCep() + "', email = '" + funcionario.getEmail() + "', telefone = '" + funcionario.getTelefone() + "', idsetor = " + funcionario.getIdSetor()+ ", cargo = '" + funcionario.getCargo() 
        +"' WHERE cpfcnpj = '" + cpfCnpj + "';";

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

    public Funcionario BuscarFuncionario(String cpfCnpj) {
        Connection con = c_ConexaoDB.getConnection();
        Funcionario c = new Funcionario();
        String sql = "SELECT func.cpfcnpj, func.nome, func.logradouro, func.numero, func.bairro, func.cidade, func.cep, func.estado, func.telefone, func.email, func.cargo, set.nomesetor, set.idsetor FROM funcionario func JOIN setor set ON set.idsetor = func.idsetor WHERE func.cpfcnpj = '" + cpfCnpj + "'";
        try {
            ResultSet rs;
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                rs = stmt.executeQuery();
                while (rs.next()) {
                    

                    c.setCpfCnpj(rs.getString("cpfcnpj"));
                    c.setNome(rs.getString("nome"));
                    c.setLogradouro(rs.getString("logradouro"));
                    c.setNumero(rs.getInt("numero"));
                    c.setBairro(rs.getString("bairro"));
                    c.setCep(rs.getString("cep"));
                    c.setEstado(rs.getString("estado"));
                    c.setCargo(rs.getString("cargo"));
                    c.setNomeSetor(rs.getString("nomesetor"));
                    c.setIdSetor(rs.getString("idsetor"));
                    c.setTelefone(rs.getString("telefone"));
                    c.setEmail(rs.getString("email"));
                    c.setCidade(rs.getString("cidade"));

                    
                }
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Erro, lista não retornada");
        }
        
        return c;
    }
    
     public boolean VerificarExistenciaFuncionario(Funcionario funcionario) {

        Connection con = c_ConexaoDB.getConnection();
        String sql = "SELECT cpfcnpj, nome, logradouro, numero, bairro, cidade, cep, estado, telefone, email, cargo FROM funcionario WHERE cpfcnpj = '" + funcionario.getCpfCnpj() + "'";
        List<Funcionario> listaFuncionario = new ArrayList<>();
        try {
            ResultSet rs;
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                rs = stmt.executeQuery();
                while (rs.next()) {
                    Funcionario c = new Funcionario();

                    c.setCpfCnpj(rs.getString("cpfcnpj"));
                    c.setNome(rs.getString("nome"));
                    c.setTelefone(rs.getString("telefone"));
                    c.setEmail(rs.getString("email"));
                    c.setCidade(rs.getString("cidade"));

                    listaFuncionario.add(c);
                }
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Erro, lista não retornada");
        }
        
        if(listaFuncionario.size() > 0)
        {
            return true;
        }
        else
        {
            return false;
        }

    }
    
}
