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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
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

    public ObservableList<Chamado> BuscarListaChamados() {
        
        String sql = "SELECT c.codigo, c.assunto, c.descricao, c.status, c.setor, c.data_inicio, c.data_fim, cl.nome, f.nome, c.id_funcionario, c.id_cliente FROM chamado c " +
                    "JOIN funcionario f on c.id_funcionario = f.cpfCnpj " +
                    "JOIN cliente cl on c.id_cliente = cl.cpfCnpj;";
        ObservableList<Chamado> listaChamados = new ObservableList<Chamado>();
            Chamado chamado;
            StringBuilder sb = new StringBuilder();

            try
            {
                sb.AppendLine("SELECT c.codigo, c.assunto, c.descricao, c.status, c.setor, c.data_inicio, c.data_fim, cl.nome, f.nome, c.id_funcionario, c.id_cliente FROM chamado c " +
                    "JOIN funcionario f on c.id_funcionario = f.cpfCnpj " +
                    "JOIN cliente cl on c.id_cliente = cl.cpfCnpj;");

                SQLiteDataReader dr = Banco.Instance().ExecuteQuery(sb.ToString());

                while (dr.Read())
                {
                    chamado = new ChamadosModel();

                    chamado.Codigo = dr.GetInt32(0);
                    chamado.Assunto = dr.GetString(1);
                    chamado.Descricao = dr.GetString(2);
                    chamado.Status = dr.GetString(3);
                    chamado.Setor = dr.GetString(4);
                    chamado.DataIni = DateTime.Parse(dr.GetString(5));
                    chamado.DataFim = DateTime.Parse(dr.GetString(6));
                    chamado.NomeCliente = dr.GetString(7);
                    chamado.NomeFuncionario = dr.GetString(8);
                    chamado.IdFuncionario = dr.GetString(9);
                    chamado.IdCliente = dr.GetString(10);

                    listaChamados.Add(chamado);
                }

                Banco.Instance().FecharConexao();
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message + "- Metodo ReadChamados");
            }

            return listaChamados;
        }
    }
}
