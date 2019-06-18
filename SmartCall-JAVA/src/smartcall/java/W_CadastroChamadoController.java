package smartcall.java;

import DAO.DAOChamado;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import smartcall.java.Classes.Chamado;
import smartcall.java.Classes.Cliente;
import smartcall.java.Classes.Funcionario;
import smartcall.java.Classes.Setor;
import smartcall.java.Database.c_ConexaoDB;

public class W_CadastroChamadoController implements Initializable {

    @FXML
    private Button salvar;
    @FXML
    private Button sairTela;
    @FXML
    private Button btnPesquisaCliente;
    @FXML
    private Button btnPesquisaFuncionario;
    @FXML
    private TextField nomeCliente;
    @FXML
    private TextField nomeFuncionario;
    @FXML
    private ComboBox<Setor> setores;
    @FXML
    private TextField assunto;
    @FXML
    private TextArea descricao;
    @FXML
    private DatePicker dataFinal;
    
    @FXML
    public Label labelCentral;

    public Chamado chamado;
    public Cliente chamadoCliente;
    public Funcionario chamadoFuncionario;
    public Setor setorSelecionado;

    public W_CadastroChamadoController(Chamado chamado) {

        this.chamado = chamado;
    }

    public W_CadastroChamadoController() {

    }

    public void SairTela(MouseEvent event) {

        Stage stage = (Stage) sairTela.getScene().getWindow();
        stage.close();

    }

    public void SalvarDados(MouseEvent event) {

        DAOChamado chDB = new DAOChamado();
        Chamado chamado = new Chamado();

        chamado.setAssunto(assunto.getText());
        chamado.setDescricao(descricao.getText());
        chamado.setIdCliente(chamadoCliente.getCpfCnpj());
        chamado.setIdFuncionario(chamadoFuncionario.getCpfCnpj());
        chamado.setIdSetor(setorSelecionado.getIdSetor());
        chamado.setDataInicial(LocalDate.now().toString());
        chamado.setDataFinal(dataFinal.getValue().toString());
        
        if (validaDados()) {
            
            if (chDB.AdicionarChamado(chamado)) {
                Alert al = new Alert(Alert.AlertType.CONFIRMATION);
                al.setHeaderText("Chamado cadastrado!");
                al.show();
                Stage stage = (Stage) sairTela.getScene().getWindow();
                stage.close();
                
            } else {
                
                Alert al = new Alert(Alert.AlertType.ERROR);
                al.setHeaderText("Chamado não cadastrado, tente novamente mais tarde!");
                al.show();
            }

            Stage stage = (Stage) sairTela.getScene().getWindow();
            stage.close();
            
        } else {
            
            Alert al = new Alert(Alert.AlertType.ERROR);
            al.setHeaderText("Preencha os campos obrigatórios!");
            al.show();
        }

    }

    public void AbrirTelaPesquisaClientes(MouseEvent event) {

        try {

            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("w_TelaConsultaCliente.fxml"));

            stage.setTitle("Clientes");
            stage.setScene(new Scene(root));
            stage.showAndWait();

            chamadoCliente = W_TelaConsultaClienteController.MeuController.getCliente();
            setarCliente();

        } catch (IOException ex) {
            Logger.getLogger(W_TelaConsultaClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void AbrirTelaPesquisaFuncionario(MouseEvent event) {

        try {

            Stage stage = new Stage();
            Parent root;
            root = FXMLLoader.load(getClass().getResource("w_TelaConsultaFuncionario.fxml"));

            stage.setTitle("Funcionarios");
            stage.setScene(new Scene(root));
            stage.showAndWait();

            chamadoFuncionario = W_TelaConsultaFuncionarioController.MeuController.getFuncionario();
            setarFuncionario();

        } catch (IOException ex) {
            Logger.getLogger(W_TelaConsultaFuncionarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        populaComboBox();
    }

    public boolean validaDados() {
        boolean isValid = true;
        
        if (chamado.getAssunto() == null) {
            isValid = false;
        }
        if (chamado.getDescricao() == null) {
            isValid = false;
        }
        if (chamado.getIdCliente() == null) {
            isValid = false;
        }
        if (chamado.getIdSetor() == null) {
            isValid = false;
        }
        if (chamado.getIdFuncionario() == null) {
            isValid = false;
        }
        
        return isValid;
    }

    private void setarCliente() {

        nomeCliente.setText(chamadoCliente.getNome());

    }

    private void setarFuncionario() {

        nomeFuncionario.setText(chamadoFuncionario.getNome());
    }

    private void populaComboBox() {
        ObservableList<Setor> listaSetor = FXCollections.observableArrayList(getListSetor());

        setores.setItems(listaSetor);
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

    @FXML
    public void selecionarSetor() {
        setorSelecionado = setores.getSelectionModel().getSelectedItem();
    }

    public void AtribuirChamado() {
       
        nomeCliente.setText(chamado.getNomeCliente());
        nomeFuncionario.setText(chamado.getNomeFuncionario());
        assunto.setText(chamado.getAssunto());
        descricao.setText(chamado.getStatus());
        Setor s = new Setor();
        s.setIdSetor(chamado.getIdSetor());
        s.setNomeSetor(chamado.getNomeSetor());
        
        setores.setValue(s);
        
        dataFinal.setValue(LocalDate.parse(chamado.getDataFinal()));

    }

    public void DesativarCampos() {
        
        nomeCliente.setDisable(true);
        nomeFuncionario.setDisable(true);
        assunto.setDisable(true);
        descricao.setDisable(true);
        setores.setDisable(true);
        salvar.setDisable(true);
        dataFinal.setDisable(true);
        btnPesquisaCliente.setDisable(true);
        btnPesquisaFuncionario.setDisable(true);
    }
}
