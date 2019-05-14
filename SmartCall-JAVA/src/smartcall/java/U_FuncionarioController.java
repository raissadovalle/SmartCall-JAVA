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
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import smartcall.java.Database.FuncionarioDB;

/**
 * FXML Controller class
 *
 * @author binho
 */
public class U_FuncionarioController implements Initializable {

    @FXML
    private Button btnVisualizar;
    @FXML
    private Button btnRemover;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnAdicionar;
    @FXML
    private ListView<?> chamadoScene;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
        @FXML
        private void AdicionarFuncionario(MouseEvent event) throws IOException {

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("w_CadastroFuncionario.fxml"));

        stage.setTitle("Cadastro de Funcionarios");
        stage.setScene(new Scene(root));
        stage.show();

    }

    @FXML
    private void VisualizarFuncionario(MouseEvent event) throws IOException {

//        Funcionario Dados = new Funcionario();;
//        FuncionarioDB chDB = new FuncionarioDB();
//        Stage stage = new Stage();
//        FXMLLoader loader = new FXMLLoader();
//
//        Dados = chDB.BuscarFuncionario();
//        
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("w_CadastroFuncionario.fxml"));

        stage.setTitle("Editar Funcionario");
        stage.setScene(new Scene(root));
        stage.show();

//        if (Dados != null) {
//            loader = FXMLLoader.load(getClass().getResource("w_CadastroFuncionario.fxml"));
//            loader.setController(new W_CadastroFuncionarioController(Dados));
//            Parent root = loader.load();
//
//            stage.setTitle("Cadastro de Funcionarios");
//            stage.setScene(new Scene(root));
//            stage.show();
//        }
    }

    @FXML
    public void DetalharFuncionario(MouseEvent event) throws IOException {
        
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("w_CadastroFuncionario.fxml"));

        stage.setTitle("Cadastro de Funcionarios");
        stage.setScene(new Scene(root));
        stage.show();
    }
    @FXML
    public void ExcluirFuncionario() {

        FuncionarioDB chDB = new FuncionarioDB();

        if (chDB.ExcluirFuncionario()) {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("SmartCall");
            alert.setHeaderText("Funcionario Excluido com sucesso!");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });

        } else {

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("SmartCall");
            alert.setHeaderText("O Funcionario não foi excluido com sucesso");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });

        }
    }

//    @FXML
//    private void VisualizarChamado(MouseEvent event) {
//    }
//
//    @FXML
//    private void AdicionarChamado(MouseEvent event) {
//    }
    
}
