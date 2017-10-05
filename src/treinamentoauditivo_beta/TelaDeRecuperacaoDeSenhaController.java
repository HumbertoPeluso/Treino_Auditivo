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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Humberto
 */
public class TelaDeRecuperacaoDeSenhaController implements Initializable {

    

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TextField txtEmail;
    @FXML
    private Button voltar;
    @FXML
    private Label msgRecuperacaoSenha;
    
   
    
    @FXML
    private void enviarEmail(ActionEvent event) throws ParseException {
        
        VerificadorDeDados verificarEmail = new VerificadorDeDados();
        
        if(verificarEmail.existeEmail(txtEmail.getText())){
            
            String senha = verificarEmail.getSenhaValida();
            
            //msgRecuperacaoSenha.setText("Sua Senha é: "+ senha);
            Email email = new Email();
            email.enviar(txtEmail.getText(), senha);
            
            if(email.isEnviado())
            msgRecuperacaoSenha.setText("Sua senha foi enviada");
            else
                msgRecuperacaoSenha.setText("Naõ foi possivel enviar no momento, tente mais tarde.");
            
        }else {
            msgRecuperacaoSenha.setText("Email não cadastrado.");
        }
        
    }

    @FXML
    private void voltar(ActionEvent event) throws IOException {
        
        Cenario cenario = new Cenario();
        cenario.mudar("telaDeLogin.fxml", event);
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
}
