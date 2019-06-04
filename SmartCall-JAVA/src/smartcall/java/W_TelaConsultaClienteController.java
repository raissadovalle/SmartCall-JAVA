package smartcall.java;

import DAO.DAOChamado;
import DAO.DAOCliente;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import smartcall.java.Classes.Cliente;
import smartcall.java.W_CadastroChamadoController;

public class W_TelaConsultaClienteController implements Initializable {

    @FXML
    private TableView<Cliente> gridCliente;
    @FXML
    private TableColumn<Cliente, String> clientecpfcnpj;
    @FXML
    private TableColumn<Cliente, String> clienteNome;
    @FXML
    private TableColumn<Cliente, String> clienteTelefone;
    
    public static W_TelaConsultaClienteController MeuController;
    
    Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MeuController = this;
        InitTable();

    }

    private void InitTable() {

        clientecpfcnpj.setCellValueFactory(new PropertyValueFactory("cpfCnpj"));
        clienteNome.setCellValueFactory(new PropertyValueFactory("nome"));
        clienteTelefone.setCellValueFactory(new PropertyValueFactory("telefone"));

        gridCliente.setItems(AtualizaTabela());

    }

    private ObservableList<Cliente> AtualizaTabela() {

        DAOCliente cliente = new DAOCliente();
        return FXCollections.observableArrayList(cliente.getList());
    }

    public void SelecionarCliente(MouseEvent event) {

        Cliente dados = gridCliente.getFocusModel().getFocusedItem();
       
        if (dados != null){
            cliente = dados;
            Stage stage = (Stage) gridCliente.getScene().getWindow();
            stage.close();
        } 
    }    
}
   
