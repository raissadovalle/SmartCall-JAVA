/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartcall.java;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import smartcall.java.Classes.Chamado;
import smartcall.java.Database.ChamadoDB;

/**
 * FXML Controller class
 *
 * @author wilians
 */
public class U_TelaPrincipalController implements Initializable {


    @FXML
    private ListView<?> chamadoScene;
    
    @FXML
    private HBox panelBotoes;

    @FXML
    private Button btnAdicionar;

    @FXML
    private TableView<Chamado> gridChamado;
    
    @FXML
    private TableColumn<Chamado, String> idChamado;
    
    @FXML
    private TableColumn<Chamado, String> nomeCliente;

    @FXML
    private TableColumn<Chamado, String> nomeFuncionario;
        
    @FXML
    private TableColumn<Chamado, String> assunto;

    @FXML
    private TableColumn<Chamado, String> dataIni;
    
        @FXML
    private TableColumn<Chamado, String> dataFim;

    @FXML
    private TableColumn<Chamado, String> status;

    @FXML
    private Button btnVisualizar;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnRemover;

    
    private ArrayList<Chamado> listaChamados = new ArrayList();
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        panelBotoes.setSpacing(50);
        panelBotoes.setAlignment(Pos.CENTER);
        BuscarListaChamados();
           
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

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("w_CadastroChamado.fxml"));

        stage.setTitle("Editar chamado");
        stage.setScene(new Scene(root));
        stage.show();

    }

    public void DetalharChamado(MouseEvent event) throws IOException {

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("w_CadastroChamado.fxml"));

        stage.setTitle("Cadastro de chamados");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void ExcluirChamado() {

        ChamadoDB chDB = new ChamadoDB();

        if (chDB.ExcluirChamado()) {

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("SmartCall");
            alert.setHeaderText("Chamado Excluido com sucesso!");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });

        } else {

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("SmartCall");
            alert.setHeaderText("O chamado não foi excluido com sucesso");
            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });

        }
    }
    
    private void InitTable(){
        idChamado.setCellValueFactory(new PropertyValueFactory("idChamado"));
        nomeCliente.setCellValueFactory(new PropertyValueFactory("nomeCliente"));
        nomeFuncionario.setCellValueFactory(new PropertyValueFactory("nomeFuncionario"));
        dataIni.setCellValueFactory(new PropertyValueFactory("dataIni"));
        dataFim.setCellValueFactory(new PropertyValueFactory("dataFim"));
        assunto.setCellValueFactory(new PropertyValueFactory("assunto"));
        status.setCellValueFactory(new PropertyValueFactory("status"));
        
        gridChamado.setItems(AtualizaTabela());
    }

    private void BuscarListaChamados() {
        ChamadoDB chDB = new ChamadoDB();
        
        listaChamados = chDB.BuscarListaChamados();
        gridChamado.getItems().addAll(listaChamados);
     
    }
    
    private ObservableList<Chamado> AtualizaTabela(){
        Chamado chamado = new Chamado();
        
        return FXCollections.observableArrayList(chamado.getList());
    }
}
