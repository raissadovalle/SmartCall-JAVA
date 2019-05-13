/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartcall.java;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import smartcall.java.Classes.Chamado;
import smartcall.java.Database.ChamadoDB;

public class W_CadastroChamadoController implements Initializable {

    private Chamado chamado;
    private Button sairTela;
    
    public W_CadastroChamadoController(Chamado chamado){
        
        this.chamado = chamado;
    }
    
        public W_CadastroChamadoController(){  
    }
            
    public void SairTela(MouseEvent event){
        Window tela = ((Node)(event.getSource())).getScene().getWindow();
        tela.hide();
    }
        
    public void SalvarDados(MouseEvent event){
        
        Window tela = ((Node)(event.getSource())).getScene().getWindow();
        
        ChamadoDB chDB = new ChamadoDB();
        chDB.SalvarChamado(chamado);
        tela.hide();
        
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
