/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treinamentoauditivo_beta;


import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Humberto
 */
public class Email {
    private boolean enviado = false;
    public void enviar(String emailDest, String senha){
        
        String email = "tcchumbertoejonas@gmail.com";
        String senhaDoEmail = "TCC_TreinoAuditivo";
        String remetente = "noreply@gmail.com";
        
        
         Properties props = new Properties();
            /** Parâmetros de conexão com servidor Gmail */
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            Session session = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                             @Override
                             protected PasswordAuthentication getPasswordAuthentication() 
                             {
                                   return new PasswordAuthentication(email, senhaDoEmail);
                             }
                        });
            /** Ativa Debug para sessão */
            session.setDebug(true);
            try {

                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress(remetente)); //Remetente

                  Address[] toUser = InternetAddress //Destinatário(s)
                             .parse(emailDest);  
                  message.setRecipients(Message.RecipientType.TO, toUser);
                  message.setSubject("Recuperacao de senha do aplicativo Treino Auditivo");//Assunto
                  message.setText("A sua senha de login do aplicativo Treino Auditivo é: "+ senha);
                  /**Método para enviar a mensagem criada*/
                  Transport.send(message);
                  this.setEnviado(true);
                  System.out.println("Feito!!!");
             } catch (MessagingException e) {
                 
                  //throw new RuntimeException(e);
                  
            }
     
    }

    public boolean isEnviado() {
        return enviado;
    }

    public void setEnviado(boolean enviado) {
        this.enviado = enviado;
    }
    
    
    
    
}
