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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Humberto
 */
public class TelaDeLoginController implements Initializable {

   
    /**
     * Initializes the controller class.
     * 
    
     * @param url
     */
    @FXML
    private Pane telaDeLogin;
    @FXML
    private TextField email;
    @FXML
    private PasswordField senha;
    @FXML
    private Label avisoTelaDeLogin;
    @FXML
    private Button logar, irParacadastrar, recuperarSenha;
    
        @FXML
        private void logar(ActionEvent evento) throws ParseException, IOException{
        
        VerificadorDeDados validaLogin = new VerificadorDeDados();
        
        if(validaLogin.verificaLogin(email.getText(), senha.getText())){
            Cenario cenario = new Cenario();
            cenario.mudar("telaPreparacaoIniciar.fxml", evento);
        }else{
            avisoTelaDeLogin.setText("Erro nos dados de login!");
        }
        
    }

        @FXML
        private void irParaCadastrar(ActionEvent evento) throws IOException{
            
            Cenario cenario = new Cenario();
            cenario.mudar("telaDeCadastro.fxml", evento);
            
            
        }
        
        @FXML
        private void recuperarSenha(ActionEvent evento) throws IOException{
            
            Cenario cenario = new Cenario();
            cenario.mudar("telaDeRecuperacaoDeSenha.fxml", evento);
        }
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }
    
}
