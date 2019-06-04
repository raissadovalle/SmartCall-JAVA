/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartcall.java;

import DAO.DAOFuncionario;
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
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

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
    @FXML
    private HBox panelBotoesFunc;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        panelBotoesFunc.setSpacing(50);
        panelBotoesFunc.setAlignment(Pos.CENTER);
    }
    
    @FXML
    private void AdicionarFuncionario(MouseEvent event) throws IOException {

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("w_CadastroFuncionario.fxml"));

        stage.setTitle("Cadastro de Funcionarios");
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        
    }

    @FXML
    private void VisualizarFuncionario(MouseEvent event) throws IOException {
      
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("w_CadastroFuncionario.fxml"));

        stage.setTitle("Editar Funcionario");
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
        
    }

    @FXML
    public void DetalharFuncionario(MouseEvent event) throws IOException {
        
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("w_CadastroFuncionario.fxml"));

        stage.setTitle("Cadastro de Funcionarios");
        stage.setScene(new Scene(root));
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
    
    @FXML
    public void ExcluirFuncionario() {

        DAOFuncionario chDB = new DAOFuncionario();
        String test = "";
        
        if (chDB.ExcluirFuncionario(test)) {

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
}
