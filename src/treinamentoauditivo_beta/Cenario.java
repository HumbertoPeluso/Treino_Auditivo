/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treinamentoauditivo_beta;

//import java.awt.event.ActionEvent;
import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Humberto
 */
public class Cenario {
    
     public void mudar(String caminho, ActionEvent event) throws IOException{
        
        Parent raizScene2 = FXMLLoader.load(getClass().getResource(caminho));
        Scene scene2 = new Scene(raizScene2);
        Stage stageScene2 = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stageScene2.setScene(scene2);
        stageScene2.show();
    }
    
}
