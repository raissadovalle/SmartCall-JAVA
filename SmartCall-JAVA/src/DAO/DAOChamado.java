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
        String sql = "SELECT c*, cli.cpfCnpj, cli.nome, func.cpfCnpj, func.nome from chamado c "
                + "join cliente cli on c.idCliente = cli.cpjCnpj "
                + "join funcionario func on func.cpjCnpj = c.idFuncionario "
                + "join setor s on s.idSetor = c.idSetor;";
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
        
            while(rs.next())
            {
                 Chamado c = new Chamado();
                 c.setCodigo(rs.getInt("c.codigo"));  
                 c.setAssunto(rs.getString("c.assunto"));
                 c.setDescricao(rs.getString("c.descricao"));
                 c.setStatus(rs.getString("c.status"));
                                  
                 c.setDataInicial(rs.getString(" c.dataInicial"));
                 c.setDataFinal(rs.getString("c.dataFinal"));
                 
                 c.setIdSetor(rs.getString("c.idSetor")); 
                 c.setNomeSetor(rs.getString("c.nomeSetor")); 

                 c.setIdCliente(rs.getString("cl.idCliente"));
                 c.setNomeCliente(rs.getString("cl.nomeCliente"));
                 
                 c.setNomeFuncionario(rs.getString("f.nomeFuncionario"));
                 c.setIdFuncionario(rs.getString("c.idFuncionario"));
                 
                 listaChamados.add(c);
            }
            stmt.close();
            rs.close();
        }
        catch(SQLException ex)
        {
            System.out.println("Erro, lista não retornada");
            return null;
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
        }
        catch(SQLException ex){
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
