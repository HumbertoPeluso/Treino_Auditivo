/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treinamentoauditivo_beta;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Humberto
 */
public class TelaDeCadastroController implements Initializable {



    /**
     * Initializes the controller class.
     */
    
     @FXML
    private Button cadastrar;
    @FXML
    private Button voltar;
    @FXML
    private TextField cadastroNomeUsuario, cadastroEmail, cadastroSenha, repetirSenha;
    
    @FXML
    private void cadastrar(ActionEvent evento) throws ParseException{
        
        VerificadorDeDados gravaCadastro = new VerificadorDeDados();
        gravaCadastro.salvarCadastro(cadastroNomeUsuario.getText(), cadastroEmail.getText(), cadastroSenha.getText());
        
    }
    
    @FXML
    private void voltar(ActionEvent evento) throws IOException{
        
        Cenario cenario = new Cenario();
        cenario.mudar("telaDeLogin.fxml", evento);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
