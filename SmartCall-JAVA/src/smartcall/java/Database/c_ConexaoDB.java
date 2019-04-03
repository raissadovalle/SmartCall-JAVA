package smartcall.java.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class c_ConexaoDB {
    
    public Connection ConexaoAvulsa(){
        String url = "jdbc:postgresql://localhost:5432/SmartCall";
        String usuario = "postgres";
        String senha = "123456";

        try{
            Class.forName("org.postgresql.Driver").newInstance();
            Connection conn = DriverManager.getConnection(url, usuario, senha);
            return conn;
          
        }catch(ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e){
            System.out.println("Problemas ao tentar conectar com o banco de dados: " + e);
            return null;
        }
    }
}

