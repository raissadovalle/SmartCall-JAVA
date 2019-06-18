/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartcall.java;

import DAO.DAOCliente;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import smartcall.java.Classes.Cliente;

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

    @FXML
    private TableColumn<Cliente, String> telefone;

    @FXML
    private TableColumn<Cliente, String> cidade;

    @FXML
    private TableColumn<Cliente, String> email;

    @FXML
    private TableView<Cliente> gridCliente;

    @FXML
    private TableColumn<Cliente, String> nome;

    @FXML
    private TableColumn<Cliente, String> cpfcnpj;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        panelBotoesCliente.setSpacing(50);
        panelBotoesCliente.setAlignment(Pos.CENTER);
        InitTable();
    }

    @FXML
    private void AdicionarCliente(MouseEvent event) throws IOException {

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("w_CadastroCliente.fxml"));

        stage.setTitle("Cadastro de Clientes");
        stage.setScene(new Scene(root));
        stage.showAndWait();

        InitTable();

    }

    @FXML
    private void VisualizarCliente(MouseEvent event) throws IOException {

        Cliente Dados = gridCliente.getFocusModel().getFocusedItem();
        DAOCliente cliDB = new DAOCliente();
        
        if (Dados != null) {

            Dados = cliDB.BuscarCliente(Dados.getCpfCnpj());
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("w_CadastroCliente.fxml"));
            Parent root = loader.load();

            W_CadastroClienteController controllercadastro = loader.getController();
            controllercadastro.cliente = Dados;
            controllercadastro.AtribuirCliente();
            controllercadastro.DesativarCampos();

            Stage stage = new Stage();
            stage.setTitle("SmartCall");
            controllercadastro.labelCentral.setText("Visualizar Cliente");
            stage.setScene(new Scene(root));

            stage.showAndWait();

        }

        InitTable();
    }

    @FXML
    private void EditarCliente(MouseEvent event) throws IOException {

        Cliente Dados = gridCliente.getFocusModel().getFocusedItem();
        DAOCliente cliDB = new DAOCliente();
        
        if (Dados != null) {

            Dados = cliDB.BuscarCliente(Dados.getCpfCnpj());
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("w_CadastroCliente.fxml"));
            Parent root = loader.load();

            W_CadastroClienteController controllercadastro = loader.getController();
            controllercadastro.cliente = Dados;
            controllercadastro.AtribuirCliente();
            

            Stage stage = new Stage();
            stage.setTitle("SmartCall");
            controllercadastro.labelCentral.setText("Editar Cliente");
            stage.setScene(new Scene(root));

            stage.showAndWait();

        }

        InitTable();
    }
    
    @FXML
    public void DetalharCliente(MouseEvent event) throws IOException {

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("w_CadastroCliente.fxml"));

        stage.setTitle("Cadastro de Clientes");
        stage.setScene(new Scene(root));
        stage.show();

        InitTable();
    }

    public void ExcluirCliente() {

        if (gridCliente.getFocusModel().getFocusedItem() != null) {

            DAOCliente chDB = new DAOCliente();
            Cliente dados = gridCliente.getFocusModel().getFocusedItem();

            if (chDB.ExcluirCliente(dados.getCpfCnpj())) {

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

            InitTable();
        }

    }

    private void InitTable() {

        cpfcnpj.setCellValueFactory(new PropertyValueFactory("cpfCnpj"));
        nome.setCellValueFactory(new PropertyValueFactory("nome"));
        email.setCellValueFactory(new PropertyValueFactory("email"));
        cidade.setCellValueFactory(new PropertyValueFactory("cidade"));
        telefone.setCellValueFactory(new PropertyValueFactory("telefone"));

        gridCliente.setItems(AtualizaTabela());
    }

    private ObservableList<Cliente> AtualizaTabela() {

        DAOCliente funcionario = new DAOCliente();
        return FXCollections.observableArrayList(funcionario.getList());
    }
}
