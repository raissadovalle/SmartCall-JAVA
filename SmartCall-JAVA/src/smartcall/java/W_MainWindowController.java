package smartcall.java;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class W_MainWindowController implements Initializable {

    @FXML
    private AnchorPane panelPrincipal;
    private AnchorPane panelLogo;
    private MenuItem menuChamado;
    private MenuItem menuFuncionario;
    private MenuItem menuCliente;
    private ImageView imageLogo;

    @FXML
    private Label lbHora;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            carregarTelaPrincipal();

        } catch (IOException ex) {
            Logger.getLogger(W_MainWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void carregarTelaPrincipal() throws IOException {

        StackPane pane = FXMLLoader.load(getClass().getResource("u_TelaPrincipal.fxml"));
        pane.setAlignment(Pos.CENTER);

        panelPrincipal.setLeftAnchor(pane, 0.0d);
        panelPrincipal.setTopAnchor(pane, 0.0d);
        panelPrincipal.setRightAnchor(pane, 0.0d);
        panelPrincipal.setBottomAnchor(pane, 0.0d);

        panelPrincipal.getChildren().setAll(pane);

    }

    public void carregarTelaCliente() throws IOException {

        StackPane pane = FXMLLoader.load(getClass().getResource("u_Cliente.fxml"));
        pane.setAlignment(Pos.CENTER);

        panelPrincipal.setLeftAnchor(pane, 0.0d);
        panelPrincipal.setTopAnchor(pane, 0.0d);
        panelPrincipal.setRightAnchor(pane, 0.0d);
        panelPrincipal.setBottomAnchor(pane, 0.0d);

        panelPrincipal.getChildren().setAll(pane);
    }

    @FXML
    public void carregarTelaFuncionario() throws IOException {

        StackPane pane = FXMLLoader.load(getClass().getResource("u_Funcionario.fxml"));
        pane.setAlignment(Pos.CENTER);

        panelPrincipal.setLeftAnchor(pane, 0.0d);
        panelPrincipal.setTopAnchor(pane, 0.0d);
        panelPrincipal.setRightAnchor(pane, 0.0d);
        panelPrincipal.setBottomAnchor(pane, 0.0d);

        panelPrincipal.getChildren().setAll(pane);
    }
}
