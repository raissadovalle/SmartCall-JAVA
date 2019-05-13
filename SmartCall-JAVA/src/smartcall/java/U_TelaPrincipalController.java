/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartcall.java;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import smartcall.java.Classes.Chamado;
import smartcall.java.Classes.Entidade;
import smartcall.java.Database.ChamadoDB;

/**
 * FXML Controller class
 *
 * @author wilians
 */
public class U_TelaPrincipalController implements Initializable {

    @FXML
    private Button btnAdicionar;
    @FXML
    private Button btnVisualizar;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnRemover;
    @FXML
    private ListView<Chamado> chamadoScene;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void AdicionarChamado(MouseEvent event) throws IOException {
        
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("w_CadastroChamado.fxml"));     
        
        stage.setTitle("Cadastro de chamados");
        stage.setScene(new Scene(root));
        stage.show();
          
    }
    
    @FXML 
    private void VisualizarChamado(MouseEvent event) throws IOException {
        
        Chamado Dados = new Chamado();
        ChamadoDB chDB = new ChamadoDB();
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader();
        
        loader.load(getClass().getResource("w_CadastroChamado.fxml"));
        
        Dados = chDB.BuscarChamado();
        
        if(Dados != null){
            loader.setController(new W_CadastroChamadoController(Dados));
        }
                
        Parent root = loader.load();
   
        stage.setTitle("Cadastro de chamados");
        stage.setScene(new Scene(root));
        stage.show();
        
    }
    
}
