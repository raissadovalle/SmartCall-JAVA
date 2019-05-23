/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartcall.java;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import smartcall.java.Classes.Chamado;
import smartcall.java.Database.ChamadoDB;
import smartcall.java.Database.c_ConexaoDB;

public class W_CadastroChamadoController implements Initializable {

    @FXML
    private Chamado chamado;
    @FXML
    private Button sairTela;
    
    public W_CadastroChamadoController(Chamado chamado){
        
        this.chamado = chamado;
    }
    
    public W_CadastroChamadoController(){  
        
        
    }
            
    public void SairTela(MouseEvent event){
        
       Stage stage = (Stage) sairTela.getScene().getWindow();
       stage.close();
       
    }
        
    public void SalvarDados(MouseEvent event){
        
        Stage stage = (Stage) sairTela.getScene().getWindow();        
        stage.close();
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
