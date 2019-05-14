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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
        private void AdicionarCliente(MouseEvent event) throws IOException {

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("w_CadastroCliente.fxml"));

        stage.setTitle("Cadastro de Clientes");
        stage.setScene(new Scene(root));
        stage.show();

    }

    @FXML
    private void VisualizarCliente(MouseEvent event) throws IOException {

//        Cliente Dados = new Cliente();;
//        ClienteDB chDB = new ClienteDB();
//        Stage stage = new Stage();
//        FXMLLoader loader = new FXMLLoader();
//
//        Dados = chDB.BuscarCliente();
//        
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("w_CadastroCliente.fxml"));

        stage.setTitle("Editar Cliente");
        stage.setScene(new Scene(root));
        stage.show();

//        if (Dados != null) {
//            loader = FXMLLoader.load(getClass().getResource("w_CadastroCliente.fxml"));
//            loader.setController(new W_CadastroClienteController(Dados));
//            Parent root = loader.load();
//
//            stage.setTitle("Cadastro de Clientes");
//            stage.setScene(new Scene(root));
//            stage.show();
//        }
    }

    @FXML
    public void DetalharCliente(MouseEvent event) throws IOException {
        
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("w_CadastroCliente.fxml"));

        stage.setTitle("Cadastro de Clientes");
        stage.setScene(new Scene(root));
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

//    @FXML
//    private void DetalharCliente(MouseEvent event) {
//    }
//
//    @FXML
//    private void ExcluirCliente(MouseEvent event) {
//    }
//
//    @FXML
//    private void VisualizarCliente(MouseEvent event) {
//    }
    
}
