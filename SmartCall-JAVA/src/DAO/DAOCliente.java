package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import smartcall.java.Classes.Cliente;
import smartcall.java.Database.c_ConexaoDB;

public class DAOCliente {

    public List<Cliente> getList() {

        List<Cliente> listaCliente = new ArrayList<>();

        Connection con = c_ConexaoDB.getConnection();
        String sql = "SELECT cpfcnpj, nome, logradouro, numero, bairro, cidade, cep, estado, telefone, email, representante, rg, ie FROM cliente";

        try {
            ResultSet rs;
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                rs = stmt.executeQuery();
                while (rs.next()) {
                    Cliente c = new Cliente();

                    c.setCpfCnpj(rs.getString("cpfcnpj"));
                    c.setNome(rs.getString("nome"));
                    c.setTelefone(rs.getString("telefone"));
                    c.setEmail(rs.getString("email"));
                    c.setCidade(rs.getString("cidade"));

                    listaCliente.add(c);
                }
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Erro, lista não retornada");
        }

        return listaCliente;
    }

    public boolean AdicionarCliente(Cliente cliente) {
        Connection con = c_ConexaoDB.getConnection();
        
        String sql = "INSERT INTO cliente (cpfCnpj, nome, logradouro, numero, bairro, cidade, estado, cep, email, telefone, ie, representante, rg) "
                + "VALUES ('" + cliente.getCpfCnpj() + "', '" + cliente.getNome() + "', '" + cliente.getLogradouro() + "', " + cliente.getNumero() + ", '" + cliente.getBairro() + "', '" + cliente.getCidade() + "', "
                + "'" + cliente.getEstado() + "', '" + cliente.getCep() + "', '" + cliente.getEmail() + "', '" + cliente.getTelefone() + "', '" + cliente.getIe() + "', '" + cliente.getRepresentante() + "', '" + cliente.getRg() + "')";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    public boolean ExcluirCliente(String cpfCnpj) {

        Connection con = c_ConexaoDB.getConnection();

        String sql = "DELETE FROM cliente WHERE cpfCnpj = '" + cpfCnpj + "';";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    public boolean AtualizarCliente(Cliente cliente, String cpfCnpj) {
        Connection con = c_ConexaoDB.getConnection();

        String sql = "UPDATE cliente SET cpfcnpj = '" + cliente.getCpfCnpj() + "', nome = '" + cliente.getNome() + "', logradouro = '" + cliente.getLogradouro() + "', numero = " + cliente.getNumero() + ", bairro ='" + cliente.getBairro() + "', "
                + "cidade = '" + cliente.getCidade() + "', estado = '" + cliente.getEstado() + "', cep = '" + cliente.getCep() + "', email = '" + cliente.getEmail() + "', telefone = '" + cliente.getTelefone() + "', ie = '" + cliente.getIe() + "', representante = '" + cliente.getRepresentante() + "', rg ='" + cliente.getRg() + "' "
                + "WHERE cpfcnpj = '" + cpfCnpj + "';";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex);
            return false;
        }
    }

    public boolean VerificarExistenciaCliente(Cliente cliente) {

        Connection con = c_ConexaoDB.getConnection();
        String sql = "SELECT cpfcnpj, nome, logradouro, numero, bairro, cidade, cep, estado, telefone, email, representante, rg, ie FROM cliente WHERE cpfcnpj = '" + cliente.getCpfCnpj() + "'";
        List<Cliente> listaCliente = new ArrayList<>();
        try {
            ResultSet rs;
            try (PreparedStatement stmt = con.prepareStatement(sql)) {
                rs = stmt.executeQuery();
                while (rs.next()) {
                    Cliente c = new Cliente();

                    c.setCpfCnpj(rs.getString("cpfcnpj"));
                    c.setNome(rs.getString("nome"));
                    c.setTelefone(rs.getString("telefone"));
                    c.setEmail(rs.getString("email"));
                    c.setCidade(rs.getString("cidade"));

                    listaCliente.add(c);
                }
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Erro, lista não retornada");
        }
        
        if(listaCliente.size() > 0)
        {
            return true;
        }
        else
        {
            return false;
        }

    }

    public Cliente BuscarCliente(String cpfCnpj) {
        Connection con = c_ConexaoDB.getConnection();
        Cliente c = new Cliente();
        String sql = "SELECT cpfcnpj, nome, logradouro, numero, bairro, cidade, cep, estado, telefone, email, representante, rg, ie FROM cliente WHERE cpfcnpj = '" + cpfCnpj + "'";
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
                    c.setRepresentante(rs.getString("representante"));
                    c.setRg(rs.getString("rg"));
                    c.setIe(rs.getString("ie"));
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

}
