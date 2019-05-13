/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartcall.java;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class W_MainWindowController implements Initializable {

    @FXML
    private AnchorPane panelPrincipal;    
    private MenuItem menuChamado;
    private MenuItem menuFuncionario;
    private MenuItem menuCliente;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {     
            carregarTelaPrincipal();
        } catch (IOException ex) {
            Logger.getLogger(W_MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void carregarTelaPrincipal() throws IOException{

        StackPane pane = FXMLLoader.load(getClass().getResource("u_Chamado.fxml"));
        pane.setAlignment(Pos.CENTER);
        panelPrincipal.getChildren().setAll(pane);        
    } 
    
    @FXML
    public void carregarTelaCliente() throws IOException{
                
        StackPane pane = FXMLLoader.load(getClass().getResource("u_Cliente.fxml"));
        pane.setAlignment(Pos.CENTER);
        panelPrincipal.getChildren().setAll(pane);
    }
    

    @FXML
    public void carregarTelaFuncionario() throws IOException{

        StackPane pane = FXMLLoader.load(getClass().getResource("u_Funcionario.fxml"));
        pane.setAlignment(Pos.CENTER);
        panelPrincipal.getChildren().setAll(pane);   
    }
}
