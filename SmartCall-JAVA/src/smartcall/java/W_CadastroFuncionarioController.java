package smartcall.java;

import DAO.DAOFuncionario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import smartcall.java.Classes.Funcionario;

public class W_CadastroFuncionarioController implements Initializable {

    @FXML
    private Button sairTela;
    @FXML
    private TextField cpfcnpj;
    @FXML
    private TextField nome;
    @FXML
    private TextField logradouro;
    @FXML
    private TextField numero;
    @FXML
    private TextField bairro;
    @FXML
    private TextField cidade;
    @FXML
    private TextField estado;
    @FXML
    private TextField cep;
    @FXML
    private TextField email;
    @FXML
    private TextField telefone;
    @FXML
    private TextField cargo;
    @FXML
    private ComboBox setores;

    public static W_CadastroFuncionarioController MeuController;
    Funcionario funcionario = new Funcionario();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void SalvarDados(MouseEvent event) {

        DAOFuncionario chDB = new DAOFuncionario();

        funcionario.setCpfCnpj(cpfcnpj.getText());
        funcionario.setNome(nome.getText());
        funcionario.setLogradouro(logradouro.getText());
        funcionario.setNumero(Integer.parseInt(numero.getText()));
        funcionario.setBairro(bairro.getText());
        funcionario.setCidade(cidade.getText());
        funcionario.setEstado(estado.getText());
        funcionario.setCep(cep.getText());
        funcionario.setEmail(email.getText());
        funcionario.setTelefone(telefone.getText());
        funcionario.setCargo(cargo.getText());
        funcionario.setIdSetor(setores.getPromptText());

        if (validaDados()) {
            if (chDB.AdicionarFuncionario(funcionario)) {
                Alert al = new Alert(AlertType.CONFIRMATION);
                al.setHeaderText("Funcionario cadastrado!");
                al.show();
                Stage stage = (Stage) sairTela.getScene().getWindow();
                stage.close();
            } else {
                Alert al = new Alert(AlertType.ERROR);
                al.setHeaderText("Funcionario não cadastrado, tente novamente mais tarde!");
                al.show();
            }
        } else {
            Alert al = new Alert(AlertType.ERROR);
            al.setHeaderText("Preencha os campos obrigatórios!");
            al.show();
        }
    }

    public void SairTela(MouseEvent event) {

        Stage stage = (Stage) sairTela.getScene().getWindow();
        stage.close();

    }

    public boolean validaDados() {
        boolean isValid = true;

        if (funcionario != null) {
            if (funcionario.getCpfCnpj().length() == 11) {
                if (funcionario.getNome() == null) {
                    isValid = false;
                }
                if (funcionario.getLogradouro() == null) {
                    isValid = false;
                }
                if (funcionario.getNumero() == 0) {
                    isValid = false;
                }
                if (funcionario.getBairro() == null) {
                    isValid = false;
                }
                if (funcionario.getCidade() == null) {
                    isValid = false;
                }
                if (funcionario.getEstado() == null) {
                    isValid = false;
                }
                if (funcionario.getCep() == null) {
                    isValid = false;
                }
                if (funcionario.getEmail() == null) {
                    isValid = false;
                }
                if (funcionario.getTelefone() == null) {
                    isValid = false;
                }
                if (funcionario.getCargo() == null) {
                    isValid = false;
                }
            } else {
                Alert al = new Alert(AlertType.ERROR);
                al.setHeaderText("CPF/CNPJ Inválido!");
                al.show();
            }
        } else {
            isValid = false;
        }
        return isValid;
    }

}
