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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import smartcall.java.Classes.Cliente;

public class W_CadastroClienteController implements Initializable {

    @FXML
    private TextField enderecoCliente;

    @FXML
    private TextField emailCliente;

    @FXML
    private TextField estadoCliente;

    @FXML
    private TextField cepCliente;

    @FXML
    private Button sairTela;

    @FXML
    private TextField cnpjCpfCliente;

    @FXML
    private TextField numeroCliente;

    @FXML
    private TextField representanteCliente;

    @FXML
    private TextField bairroCliente;

    @FXML
    private RadioButton rbPessoaJuridica;

    @FXML
    private TextField ieCliente;

    @FXML
    private TextField telefoneCliente;

    @FXML
    private TextField rgCliente;

    @FXML
    private ToggleGroup rbCliente;

    @FXML
    private TextField nomeCliente;

    @FXML
    private RadioButton rbPessoaFisica;

    @FXML
    private TextField cidadeCliente;
    
    @FXML
    private Button salvar;
    
    @FXML
    public Label labelCentral;

    public Cliente cliente;

    public void SairTela(MouseEvent event) {

        Stage stage = (Stage) sairTela.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void rbPf() {
        rbPessoaFisica.fire();
        representanteCliente.setDisable(true);
        ieCliente.setDisable(true);
        rgCliente.setDisable(false);
        
        representanteCliente.setText("");
        ieCliente.setText("");
    }

    public void rbPj() {
        rbPessoaJuridica.fire();
        representanteCliente.setDisable(false);
        ieCliente.setDisable(false);
        rgCliente.setDisable(true);
        rgCliente.setText("");
    }

    public void SalvarDados(MouseEvent event) {

        DAOCliente chDB = new DAOCliente();
        Cliente cliente = new Cliente();

        cliente.setCpfCnpj(cnpjCpfCliente.getText());
        cliente.setNome(nomeCliente.getText());
        cliente.setLogradouro(enderecoCliente.getText());
        cliente.setNumero(Integer.parseInt(numeroCliente.getText()));
        cliente.setBairro(bairroCliente.getText());
        cliente.setCidade(cidadeCliente.getText());
        cliente.setEstado(estadoCliente.getText());
        cliente.setCep(cepCliente.getText());
        cliente.setEmail(emailCliente.getText());
        cliente.setTelefone(telefoneCliente.getText());
        cliente.setIe(ieCliente.getText());
        cliente.setRepresentante(representanteCliente.getText());
        cliente.setRg(rgCliente.getText());

        if (validaDados(cliente)) {
            if(!chDB.VerificarExistenciaCliente(cliente))
            {        
                if (chDB.AdicionarCliente(cliente)) {
                    Alert al = new Alert(Alert.AlertType.INFORMATION);
                    al.setHeaderText("Cliente cadastrado!");
                    al.show();
                    Stage stage = (Stage) sairTela.getScene().getWindow();
                    stage.close();

                } else {
                    Alert al = new Alert(Alert.AlertType.INFORMATION);
                    al.setHeaderText("Cliente não cadastrado, tente novamente mais tarde!");
                    al.show();
                }

                Stage stage = (Stage) sairTela.getScene().getWindow();
                stage.close();
            }
            else if(labelCentral.getText().equals("Editar Cliente"))
            {
                if (chDB.AtualizarCliente(cliente, cliente.getCpfCnpj())) {
                    Alert al = new Alert(Alert.AlertType.INFORMATION);
                    al.setHeaderText("Cliente atualizado!");
                    al.show();
                    Stage stage = (Stage) sairTela.getScene().getWindow();
                    stage.close();

                } else {
                    Alert al = new Alert(Alert.AlertType.INFORMATION);
                    al.setHeaderText("Cliente não cadastrado, tente novamente mais tarde!");
                    al.show();
                }

                Stage stage = (Stage) sairTela.getScene().getWindow();
                stage.close();
            } 
            else
            {
                Alert al = new Alert(Alert.AlertType.INFORMATION);
                al.setHeaderText("Documento já cadastrado!");
                al.show();
            }
            
        } else {
            Alert al = new Alert(Alert.AlertType.INFORMATION);
            al.setHeaderText("Preencha os campos obrigatórios!");
            al.show();
        }
    }

    public boolean validaDados(Cliente cliente) {
        boolean isValid = true;

        if (nomeCliente.getText() == null) {
            isValid = false;
        }
        if (enderecoCliente.getText() == null) {
            isValid = false;
        }
        if (numeroCliente.getText() == null) {
            isValid = false;
        }
        if (bairroCliente.getText() == null) {
            isValid = false;
        }
        if (cidadeCliente.getText() == null) {
            isValid = false;
        }
        if (estadoCliente.getText() == null) {
            isValid = false;
        }
        if (cepCliente.getText() == null) {
            isValid = false;
        }
        if (emailCliente.getText() == null) {
            isValid = false;
        }
        if (telefoneCliente.getText() == null) {
            isValid = false;
        }

        if (cnpjCpfCliente.getText().length() == 14) {
            if (ieCliente.getText().equals("")) {
                isValid = false;
            }
            if (representanteCliente.getText().equals("")) {
                isValid = false;
            }
        } else if (cnpjCpfCliente.getText().length() == 11) {
            if (rgCliente.getText().equals("")) {
                isValid = false;
            }
        } else {
            isValid = false;
            Alert al = new Alert(Alert.AlertType.INFORMATION);
            al.setHeaderText("Documento Inválido!");
            al.show();
        }
        
        return isValid ;
    } 

    public void AtribuirCliente() {
        
        nomeCliente.setText(cliente.getNome());
        enderecoCliente.setText(cliente.getLogradouro());
        numeroCliente.setText(Integer.toString(cliente.getNumero()));
        bairroCliente.setText(cliente.getBairro());
        cidadeCliente.setText(cliente.getCidade());
        estadoCliente.setText(cliente.getEstado());
        cepCliente.setText(cliente.getCep());
        telefoneCliente.setText(cliente.getTelefone());
        emailCliente.setText(cliente.getEmail());
        representanteCliente.setText(cliente.getRepresentante());
        rgCliente.setText(cliente.getRg());
        ieCliente.setText(cliente.getIe());
        
        
        
        cnpjCpfCliente.setText(cliente.getCpfCnpj());
        
        if(cliente.getCpfCnpj().length() == 14){
            
            rbPj();
            
        }else{
            
            
            rbPf();
        }
        
        cnpjCpfCliente.setText(cliente.getCpfCnpj());
        
    }
    
    
    public void DesativarCampos() {

        nomeCliente.setDisable(true);
        enderecoCliente.setDisable(true);
        numeroCliente.setDisable(true);
        bairroCliente.setDisable(true);
        cidadeCliente.setDisable(true);
        estadoCliente.setDisable(true);
        cepCliente.setDisable(true);
        telefoneCliente.setDisable(true);
        emailCliente.setDisable(true);
        representanteCliente.setDisable(true);
        rgCliente.setDisable(true);
        ieCliente.setDisable(true);
        salvar.setDisable(true);
        cnpjCpfCliente.setDisable(true);
        rbPessoaFisica.setDisable(true);
        rbPessoaJuridica.setDisable(true);
        
    }    
}

    

