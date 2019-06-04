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
import smartcall.java.Classes.Chamado;
import smartcall.java.Database.c_ConexaoDB;

/**
 *
 * @author Raissa do Valle
 */
public class DAOChamado {
    
    
    public List<Chamado> getList()
    {
        List<Chamado> listaChamados = new ArrayList<>();
        Connection con = c_ConexaoDB.getConnection();
        String sql = "SELECT c.codigo as codigo, c.assunto as assunto, c.descricao as descricao, c.status as status,"
                + " c.datainicial as dataInicial, c.datafinal as dataFinal, c.idcliente as idCliente, cli.nome as nomeCliente,"
                + " c.idfuncionario as idFuncionario, func.nome as nomeFuncionario, c.idsetor as idSetor, s.nomesetor as nomeSetor"
                + " from chamado c "
                + "left join cliente cli on c.idcliente = cli.cpfcnpj "
                + "left join funcionario func on func.cpfcnpj = c.idfuncionario "
                + "join setor s on s.idsetor = c.idsetor;";
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
        
            while(rs.next())
            {
                 Chamado c = new Chamado();
                 c.setCodigo(rs.getInt("codigo"));  
                 c.setAssunto(rs.getString("assunto"));
                 c.setDescricao(rs.getString("descricao"));
                 c.setStatus(rs.getString("status"));
                                  
                 c.setDataInicial(rs.getString("dataInicial"));
                 c.setDataFinal(rs.getString("dataFinal"));
                 
                 c.setIdSetor(rs.getString("idSetor")); 
                 c.setNomeSetor(rs.getString("nomeSetor")); 

                 c.setIdCliente(rs.getString("idCliente"));
                 c.setNomeCliente(rs.getString("nomeCliente"));
                 
                 c.setNomeFuncionario(rs.getString("nomeFuncionario"));
                 c.setIdFuncionario(rs.getString("idFuncionario"));
                 
                 listaChamados.add(c);
            }
            stmt.close();
            rs.close();
        }
        catch(SQLException ex)
        {
            System.out.println("Erro, lista não retornada");
        }
        return listaChamados;               
    }
    
    public boolean AdicionarChamado(Chamado chamado) {
        Connection con = c_ConexaoDB.getConnection();
        
        String sql = "INSERT INTO chamado (assunto, descricao, status, idSetor, dataInicial, dataFinal, idCliente, idFuncionario) " 
                    + "VALUES ('" + chamado.getAssunto() + "', '" + chamado.getDescricao() + "', 'Pendente', " + chamado.getIdSetor() + ", '" 
                + chamado.getDataInicial() + "', '" + chamado.getDataFinal() + "', '" + chamado.getIdCliente() + "', '" + chamado.getIdFuncionario() + "')";
        
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

    public boolean ExcluirChamado(int codigo) {
        
        Connection con = c_ConexaoDB.getConnection();
        String sql = "DELETE FROM chamado WHERE codigo = " + codigo + ";";
        
        try{
            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.execute();
            return true;
        
        } catch(SQLException ex){
            System.out.println(ex);
            return false;            
        }
    }
    
        public boolean AtualizarChamado(Chamado chamado) {
        Connection con = c_ConexaoDB.getConnection();
        
        String sql = "UPDATE chamado SET assunto = '" + chamado.getAssunto() + "', descricao = '" + chamado.getDescricao() + "', status ='" + chamado.getStatus() + "', " +
                    "setor = " + chamado.getIdSetor() + ", dataFinal = '" + chamado.getDataFinal() + "', idCliente = '" + chamado.getIdCliente() + "', idFuncionario = '" + chamado.getIdFuncionario() + "'WHERE codigo = " + chamado.getCodigo() + ";";
        
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

    public void SalvarChamado(Chamado chamado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
