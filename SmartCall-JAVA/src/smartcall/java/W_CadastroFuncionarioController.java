package smartcall.java;

import DAO.DAOFuncionario;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import smartcall.java.Classes.Funcionario;
import smartcall.java.Classes.Setor;
import smartcall.java.Database.c_ConexaoDB;

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
    private ComboBox<Setor> setores;
    
    @FXML
    private Button salvar;
    @FXML
    public Label labelCentral;

    public Setor setorSelecionado;

    public static W_CadastroFuncionarioController MeuController;
    Funcionario funcionario = new Funcionario();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        populaComboBox();
    }

    private void populaComboBox() {
        ObservableList<Setor> listaSetor = FXCollections.observableArrayList(getListSetor());

        setores.setItems(listaSetor);
    }

    @FXML
    public void selecionarSetor() {
        setorSelecionado = setores.getSelectionModel().getSelectedItem();
    }

    private List<Setor> getListSetor() {

        String sql = "SELECT idsetor, nomesetor FROM setor";
        List<Setor> listaSetor = new ArrayList<>();
        Connection con = c_ConexaoDB.getConnection();
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Setor c = new Setor();

                c.setIdSetor(rs.getString("idsetor"));
                c.setNomeSetor(rs.getString("nomesetor"));

                listaSetor.add(c);
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Erro, lista não retornada");
            return null;
        }
        return listaSetor;
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
        funcionario.setIdSetor(setorSelecionado.getIdSetor());


        if (validaDados(funcionario)) {
            if(!chDB.VerificarExistenciaFuncionario(funcionario))
            {        
                if (chDB.AdicionarFuncionario(funcionario)) {
                    Alert al = new Alert(Alert.AlertType.INFORMATION);
                    al.setHeaderText("Funcionário cadastrado!");
                    al.show();
                    Stage stage = (Stage) sairTela.getScene().getWindow();
                    stage.close();

                } else {
                    Alert al = new Alert(Alert.AlertType.INFORMATION);
                    al.setHeaderText("Funcionário não cadastrado, tente novamente mais tarde!");
                    al.show();
                }

                Stage stage = (Stage) sairTela.getScene().getWindow();
                stage.close();
            }
            else if(labelCentral.getText().equals("Editar Funcionário"))
            {
                if (chDB.AtualizarFuncionario(funcionario, funcionario.getCpfCnpj())) {
                    Alert al = new Alert(Alert.AlertType.INFORMATION);
                    al.setHeaderText("Funcionário atualizado!");
                    al.show();
                    Stage stage = (Stage) sairTela.getScene().getWindow();
                    stage.close();

                } else {
                    Alert al = new Alert(Alert.AlertType.INFORMATION);
                    al.setHeaderText("Funcionário não cadastrado, tente novamente mais tarde!");
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

    public void SairTela(MouseEvent event) {

        Stage stage = (Stage) sairTela.getScene().getWindow();
        stage.close();

    }

    public boolean validaDados(Funcionario funcionario) {
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
                al.setHeaderText("CPF Inválido!");
                al.show();
            }
        } else {
            isValid = false;
        }

        return isValid;
    }



    void AtribuirFuncionario() {
        
        nome.setText(funcionario.getNome());
        logradouro.setText(funcionario.getLogradouro());
        numero.setText(Integer.toString(funcionario.getNumero()));
        bairro.setText(funcionario.getBairro());
        cidade.setText(funcionario.getCidade());
        estado.setText(funcionario.getEstado());
        cep.setText(funcionario.getCep());
        telefone.setText(funcionario.getTelefone());
        email.setText(funcionario.getEmail());
        cargo.setText(funcionario.getCargo());
        cpfcnpj.setText(funcionario.getCpfCnpj());

        Setor s = new Setor();
        s.setIdSetor(funcionario.getIdSetor());
        s.setNomeSetor(funcionario.getNomeSetor());
        setores.setValue(s);
    }

    public void DesativarCampos() {
        
        nome.setDisable(true);
        logradouro.setDisable(true);
        numero.setDisable(true);
        bairro.setDisable(true);
        cidade.setDisable(true);
        estado.setDisable(true);
        cep.setDisable(true);
        telefone.setDisable(true);
        email.setDisable(true);
        cargo.setDisable(true);
        setores.setDisable(true);
        salvar.setDisable(true);
        cpfcnpj.setDisable(true);

    }

}
