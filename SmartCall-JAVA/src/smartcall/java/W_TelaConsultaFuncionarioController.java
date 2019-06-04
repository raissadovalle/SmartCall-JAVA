package smartcall.java;

import DAO.DAOFuncionario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import smartcall.java.Classes.Funcionario;

public class W_TelaConsultaFuncionarioController implements Initializable {

    @FXML
    private TableView<Funcionario> gridFuncionario;
    @FXML
    private TableColumn<Funcionario, String> funcionarioCpf; 
    @FXML
    private TableColumn<Funcionario, String> funcionarioNome;
    @FXML
    private TableColumn<Funcionario, String> funcionarioSetor;
    @FXML
    private TableColumn<Funcionario, String> funcionarioEmail;
    
    public static W_TelaConsultaFuncionarioController MeuController;
    
    Funcionario funcionario;

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        MeuController = this;
        InitTable();
        
    }        
        
    private void InitTable(){
    
        funcionarioCpf.setCellValueFactory(new PropertyValueFactory("cpfCnpj"));
        funcionarioNome.setCellValueFactory(new PropertyValueFactory("nome"));
        funcionarioSetor.setCellValueFactory(new PropertyValueFactory("nomeSetor"));
        funcionarioEmail.setCellValueFactory(new PropertyValueFactory("email"));

        gridFuncionario.setItems(AtualizaTabela());
    
    }
    
  
    private ObservableList<Funcionario> AtualizaTabela() {
                   
        DAOFuncionario funcionario = new DAOFuncionario();    
        return FXCollections.observableArrayList(funcionario.getList());
    }
    
    public void SelecionarFuncionario(){
        
        Funcionario dados = gridFuncionario.getFocusModel().getFocusedItem();
       
        if (dados != null){
            funcionario = dados;
            Stage stage = (Stage) gridFuncionario.getScene().getWindow();
            stage.close();
        } 
        
    }
}

