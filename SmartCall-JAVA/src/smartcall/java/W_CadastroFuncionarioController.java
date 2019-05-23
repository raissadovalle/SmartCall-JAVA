package smartcall.java;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


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
    
}
