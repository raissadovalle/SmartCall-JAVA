package smartcall.java;

import DAO.DAOChamado;
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

/**
 * FXML Controller class
 *
 * @author wilians
 */
public class U_TelaPrincipalController implements Initializable {

    @FXML
    private HBox panelBotoes;
    @FXML
    private Button btnAdicionar;
    @FXML
    private TableView<Chamado> gridChamado;   
    @FXML
    private TableColumn<Chamado, String> codigo;  
    @FXML
    private TableColumn<Chamado, String> nomeCliente;
    @FXML
    private TableColumn<Chamado, String> nomeFuncionario;    
    @FXML
    private TableColumn<Chamado, String> assunto;
    @FXML
    private TableColumn<Chamado, String> dataInicial;
    @FXML
    private TableColumn<Chamado, String> dataFinal;
    @FXML
    private TableColumn<Chamado, String> status;
    @FXML
    private TableColumn<Chamado, String> nomeSetor;
    @FXML
    private Button btnVisualizar;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnRemover;
              
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        panelBotoes.setSpacing(50);
        panelBotoes.setAlignment(Pos.CENTER); 
        InitTable();
    }       

    @FXML
    private void AdicionarChamado(MouseEvent event) throws IOException {

        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("w_CadastroChamado.fxml"));

        stage.setTitle("Cadastro de chamados");
        stage.setScene(new Scene(root));
        stage.showAndWait();
        
        AtualizaTabela();

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
        
        DAOChamado chDB = new DAOChamado();

        if(gridChamado.getSelectionModel().getSelectedItem() != null){
            
            Chamado ch = new Chamado();
            ch = gridChamado.getSelectionModel().getSelectedItem();
            
            if (chDB.ExcluirChamado(ch.getCodigo())) {

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
    }
    
    private void InitTable(){
              
        codigo.setCellValueFactory(new PropertyValueFactory("codigo"));
        nomeCliente.setCellValueFactory(new PropertyValueFactory("nomeCliente"));
        nomeFuncionario.setCellValueFactory(new PropertyValueFactory("nomeFuncionario"));
        dataInicial.setCellValueFactory(new PropertyValueFactory("dataInicial"));
        dataFinal.setCellValueFactory(new PropertyValueFactory("dataFinal"));
        assunto.setCellValueFactory(new PropertyValueFactory("assunto"));
        status.setCellValueFactory(new PropertyValueFactory("status"));
        nomeSetor.setCellValueFactory(new PropertyValueFactory("nomeSetor"));
        
        gridChamado.setItems(AtualizaTabela());
    }
    
    private ObservableList<Chamado> AtualizaTabela(){
        
        DAOChamado chamado = new DAOChamado();    
        return FXCollections.observableArrayList(chamado.getList());
    }
}
