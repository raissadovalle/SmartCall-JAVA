package smartcall.java;

import DAO.DAOFuncionario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import smartcall.java.Classes.Funcionario;


public class W_CadastroFuncionarioController implements Initializable {
    
    @FXML
    private Button sairTela;

    public void SairTela(MouseEvent event){
        
        Stage stage = (Stage) sairTela.getScene().getWindow();
        stage.close();
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
    }   
    
    public void SalvarDados(MouseEvent event){
        
        if(validaDados())
        {  
            DAOFuncionario chDB = new DAOFuncionario();
            Funcionario funcionario = new Funcionario();

            //funcionario.setCpfCnpj(cpfCnpj.getText());
            //funcionario.setNome(nome.getText());
            //funcionario.setLogradouro(logradouro.getText());
            //funcionario.setNumero(Integet.parseInt(numero.getText()));
            //funcionario.setBairro(bairro.getText());
            //funcionario.setCidade(cidade.getText());
            //funcionario.setEstado(estado.getText());
            //funcionario.setCep(cep.getText());
            //funcionario.setEmail(email.getText());
            //funcionario.setTelefone(telefone.getText());
            //funcionario.setCargo(cargo.getText());
            //funcionario.setIdSetor(Integer.parseInt(idSetor.getText()));

            if(chDB.AdicionarFuncionario(funcionario))
            {
                Alert al = new Alert(AlertType.CONFIRMATION);
                al.setHeaderText("Funcionario cadastrado!");
                al.show();
                Stage stage = (Stage) sairTela.getScene().getWindow();        
                stage.close();
            }
            else
            {
                Alert al = new Alert(AlertType.ERROR);
                al.setHeaderText("Funcionario não cadastrado, tente novamente mais tarde!");
                al.show();
            }
        }
        else
        {
            Alert al = new Alert(AlertType.ERROR);
            al.setHeaderText("Preencha os campos obrigatórios!");
            al.show();
        }

    }
    
    public boolean validaDados()
    {
        boolean isValid = true;
        if(cpfCnpj.getText() != null)
        {
            if(cpfCnpj.getText().length() == 11)
            {
                if(nome.getText() == null)
                {
                    isValid = false;
                }
                if(logradouro.getText() == null)
                {
                    isValid = false;
                }
                if(numero.getText() == null)
                {
                    isValid = false;
                }
                if(bairro.getText() == null)
                {
                    isValid = false;
                }
                if(cidade.getText() == null)
                {
                    isValid = false;
                }
                if(estado.getText() == null)
                {
                    isValid = false;
                }
                if(cep.getText() == null)
                {
                    isValid = false;
                }
                if(email.getText() == null)
                {
                    isValid = false;
                }
                if(telefone.getText() == null)
                {
                    isValid = false;
                }
                if(cargo.getText() == null)
                {
                    isValid = false;
                }
                if(idSetor.getText() == null)
                {
                    isValid = false;
                }
            }
            else
            {
                Alert al = new Alert(AlertType.ERROR);
                al.setHeaderText("CPF/CNPJ Inválido!");
                al.show();
            }
        }
        else
        {
            isValid = false;
        }
        return isValid;
    }
    
}
