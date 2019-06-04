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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import smartcall.java.Classes.Funcionario;

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
    private ListView<Funcionario> chamadoScene;
    @FXML
    private HBox panelBotoesFunc;

    @FXML
    private TableColumn<Funcionario, String> setor;

    @FXML
    private TableView<Funcionario> gridFuncionario;

    @FXML
    private TableColumn<Funcionario, String> nome;

    @FXML
    private TableColumn<Funcionario, String> cargo;

    @FXML
    private TableColumn<Funcionario, String> cpfcnpj;

    @FXML
    private TableColumn<Funcionario, String> email;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        panelBotoesFunc.setSpacing(50);
        panelBotoesFunc.setAlignment(Pos.CENTER);
        InitTable();
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

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("w_CadastroFuncionario.fxml"));

        stage.setTitle("Editar Funcionario");
        stage.setScene(new Scene(root));
        stage.show();

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

        if (gridFuncionario.getFocusModel().getFocusedItem() != null) {

            Funcionario dados = gridFuncionario.getFocusModel().getFocusedItem();
            DAOFuncionario chDB = new DAOFuncionario();

            if (chDB.ExcluirFuncionario(dados.getCpfCnpj())) {

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
        
        InitTable();
        
    }

    private void InitTable() {

        cpfcnpj.setCellValueFactory(new PropertyValueFactory("cpfCnpj"));
        nome.setCellValueFactory(new PropertyValueFactory("nome"));
        email.setCellValueFactory(new PropertyValueFactory("email"));
        cargo.setCellValueFactory(new PropertyValueFactory("cargo"));
        setor.setCellValueFactory(new PropertyValueFactory("nomeSetor"));

        gridFuncionario.setItems(AtualizaTabela());
    }

    private ObservableList<Funcionario> AtualizaTabela() {

        DAOFuncionario funcionario = new DAOFuncionario();
        return FXCollections.observableArrayList(funcionario.getList());
    }

}
