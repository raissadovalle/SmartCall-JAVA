package smartcall.java;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import smartcall.java.Classes.Chamado;
import smartcall.java.Database.ChamadoDB;

public class W_CadastroChamadoController implements Initializable {

    private Chamado chamado;

    @FXML
    private Button sairTela;
    
    @FXML
    private TextField nomeCliente;
    private TextField nomeFuncionario;
    private ComboBox nomeSetor;
    private TextField nomeAssunto;
    private TextField nomeDescricao;
    
    
    public W_CadastroChamadoController(Chamado chamado){
        
        this.chamado = chamado;
    }
    
    public W_CadastroChamadoController(){  
        
        
    }
            
    public void SairTela(MouseEvent event){
        
       Stage stage = (Stage) sairTela.getScene().getWindow();
       stage.close();
       
    }
        
    public void SalvarDados(MouseEvent event){
        
        ChamadoDB chDB = new ChamadoDB();
        Chamado chamado = new Chamado();
        
        
        chDB.SalvarChamado(chamado);
        
        Stage stage = (Stage) sairTela.getScene().getWindow();        
        stage.close();
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
