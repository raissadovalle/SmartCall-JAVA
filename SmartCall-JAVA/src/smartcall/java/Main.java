package smartcall.java;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage stage) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("w_MainWindow.fxml"));
        
        stage.setTitle("SmartCall");
        stage.setMaximized(true);
        stage.setScene(new Scene(root));
        stage.show();
    }    
}
