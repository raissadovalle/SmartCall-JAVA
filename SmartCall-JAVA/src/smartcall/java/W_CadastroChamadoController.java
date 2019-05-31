package smartcall.java;

import DAO.DAOChamado;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import smartcall.java.Classes.Chamado;

public class W_CadastroChamadoController implements Initializable {

    private Chamado chamado;

    @FXML
    private Button sairTela;
    
    @FXML
    private TextField nomeCliente;
    private TextField nomeFuncionario;
    private ComboBox nomeSetor;
    private TextField assunto;
    private TextField descricao;
    
    
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
        
        DAOChamado chDB = new DAOChamado();
        Chamado chamado = new Chamado();
        
        if(validaDados())
        {
            chamado.setAssunto(assunto.getText());
            chamado.setDescricao(descricao.getText());
            //chamado.setIdCliente(Integer.parseInt(idCliente.getText()));
            //chamado.setIdFuncionario(Integer.parseInt(idFuncionario.getText()));
            //chamado.setIdSetor(Integer.parseInt(idSetor.Text()));
            chamado.setDataInicial(LocalDate.now().toString());
            chamado.setDataFinal(LocalDate.now().plusDays(3).toString());

            if(chDB.AdicionarChamado(chamado))
            {
                Alert al = new Alert(Alert.AlertType.CONFIRMATION);
                al.setHeaderText("Chamado cadastrado!");
                al.show();
                Stage stage = (Stage) sairTela.getScene().getWindow();        
                stage.close();
            }
            else
            {
                Alert al = new Alert(Alert.AlertType.ERROR);
                al.setHeaderText("Chamado não cadastrado, tente novamente mais tarde!");
                al.show();
            }

            Stage stage = (Stage) sairTela.getScene().getWindow();        
            stage.close();
        }
        else
        {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("Preencha os campos obrigatórios!");
            al.show();
        }

    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    public boolean validaDados()
    {
        boolean isValid = true;
        
        if(assunto.getText() == null)
        {
            isValid = false;
        }
        if(descricao.getText() == null)
        {
            isValid = false;
        }
        if(idCliente.getText() == null)
        {
            isValid = false;
        }
        if(idSetor.getText() == null)
        {
            isValid = false;
        }
        if(idFuncionario.getText() == null)
        {
            isValid = false;
        }

        return isValid;
    }
    
}
