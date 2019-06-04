package smartcall.java.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class c_ConexaoDB {

    private static Connection connection;

    private static String url = "jdbc:postgresql://localhost:5432/SmartCall";
    private static String usuario = "postgres";
    private static String senha = "123456";
    
    private c_ConexaoDB(){}
    
    public static Connection getConnection() {
        
        if(connection == null){
            try{
                connection = DriverManager.getConnection(url, usuario, senha);
            }catch(SQLException ex){
                System.out.println("Houve um erro ao conectar com o Banco de Dados.");
                throw new RuntimeException(ex);
            }
        }
        return connection;
    }
}
