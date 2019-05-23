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
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import smartcall.java.Database.ClienteDB;

/**
 * FXML Controller class
 *
 * @author binho
 */
public class U_ClienteController implements Initializable {

    @FXML
    private Button btnVisualizar;
    @FXML
    private Button btnRemover;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnAdicionar;
    @FXML
    private HBox panelBotoesCliente;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        panelBotoesCliente.setSpacing(50);
        panelBotoesCliente.setAlignment(Pos.CENTER);
        
    }    
    
    @FXML
        private void AdicionarCliente(MouseEvent event) throws IOException {

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("w_CadastroCliente.fxml"));

        stage.setTitle("Cadastro de Clientes");
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

    }

    @FXML
    private void VisualizarCliente(MouseEvent event) throws IOException {
     
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("w_CadastroCliente.fxml"));

        stage.setTitle("Editar Cliente");
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();

    }

    @FXML
    public void DetalharCliente(MouseEvent event) throws IOException {
        
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("w_CadastroCliente.fxml"));

        stage.setTitle("Cadastro de Clientes");
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }

    public void ExcluirCliente() {

        ClienteDB chDB = new ClienteDB();

        if (chDB.ExcluirCliente()) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("SmartCall");
            alert.setHeaderText("Cliente Excluido com sucesso!");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });

        } else {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("SmartCall");
            alert.setHeaderText("O Cliente não foi excluido com sucesso");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });

        }
    }    
}
