/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartcall.java;

import DAO.DAOCliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import smartcall.java.Classes.Cliente;


public class W_CadastroClienteController implements Initializable {

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
            DAOCliente chDB = new DAOCliente();
            Cliente cliente = new Cliente();

            //cliente.setCpfCnpj(cpfCnpj.getText());
            //cliente.setNome(nome.getText());
            //cliente.setLogradouro(logradouro.getText());
            //cliente.setNumero(Integet.parseInt(numero.getText()));
            //cliente.setBairro(bairro.getText());
            //cliente.setCidade(cidade.getText());
            //cliente.setEstado(estado.getText());
            //cliente.setCep(cep.getText());
            //cliente.setEmail(email.getText());
            //cliente.setTelefone(telefone.getText());
            //cliente.setIe(ie.getText());
            //cliente.setRepresentante(representante.getText());
            //cliente.setRg(rg.getText());

            if(chDB.AdicionarCliente(cliente))
            {
                Alert al = new Alert(Alert.AlertType.CONFIRMATION);
                al.setHeaderText("Cliente cadastrado!");
                al.show();
                Stage stage = (Stage) sairTela.getScene().getWindow();        
                stage.close();
            }
            else
            {
                Alert al = new Alert(Alert.AlertType.ERROR);
                al.setHeaderText("Cliente não cadastrado, tente novamente mais tarde!");
                al.show();
            }
        }
        else
        {
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("Preencha os campos obrigatórios!");
            al.show();
        }
        
    }
    
    public boolean validaDados()
    {
        boolean isValid = true;
        if(cpfCnpj.getText() != null)
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
            
            if(cpfCnpj.getText().length() == 14)
            {              
                if(ie.getText() == null)
                {
                    isValid = false;
                }
                if(representante.getText() == null)
                {
                    isValid = false;
                }
            }
            else if(cpfCnpj.getText().length() == 11)
            {
                if(rg.getText() == null)
                {
                    isValid = false;
                }
            }
            else
            {
                Alert al = new Alert(Alert.AlertType.ERROR);
                al.setHeaderText("Documento Inválido!");
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
