/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import smartcall.java.Classes.Chamado;

/**
 *
 * @author Raissa do Valle
 */
public class DAOChamado {
     public List<Chamado> getList()
    {
        List<Chamado> PessoaF = new ArrayList<>();
        
        String sql = "SELECT * from chamado";
        
        try
        {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stm.ExecuteQuery();
        
            while(rs.next())
            {
                 Chamado c = new Chamado();
                 c.setCodigo(rs.getInt("c.codigo"));   //tem que ter o c. ou não?
                 c.setAssunto(rs.getString("c.assunto"));
                 c.setDescricao(rs.getString("c.descricao"));
                 c.setStatus(rs.getString("c.status"));
                 c.setIdSetor(rs.getString("c.setor"));  ///ver sobre o setor no banco
                 c.setNomeSetor(rs.getString("c.setor"));              ///ver sobre o setor no banco
                 c.setDataInicial(rs.getString(" c.data_inicio"));
                 c.setDataFinal(rs.getString("c.data_fim"));
                // c.setCodigo(rs.getString("cl.nome"));
                // c.setCodigo(rs.getString("f.nome"));
                 c.setChv_funcionario(rs.getString("c.id_funcionario"));
                 c.setChv_cliente(rs.getString("c.id_cliente"));
              
            }
        }
        catch(SQLException ex)
        {
            
        }
        
                
    }
}
