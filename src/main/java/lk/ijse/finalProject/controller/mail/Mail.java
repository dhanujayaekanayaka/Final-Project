package lk.ijse.finalProject.controller.mail;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class Mail {

    public static void main(String[] args) {
        final String userName = "adamnickolas123@gmail.com"; //same fromMail
        final String password = "9F0D42BBD7A8839795AE115336AE800E379Eq";
        final String toEmail = "sahandanujaya48@gmail.com";

        System.out.println("TLSEmail Start");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.elasticemail.com"); //SMTP Host
        props.put("mail.smtp.port", "2525"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
        //props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        // props.put("mail.smtp.ssl.enable", "true");
        // props.put("mail.smtp.socketFactory.port", "587"); //TLS Port

        //Session session = Session.getDefaultInstance(props);
        Session session = Session.getDefaultInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(userName, password);

            }
        });

        try{
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail, true));
            message.setSubject("Prueba");
            message.setText("Blablabla");
            System.out.println("sending...");
            Transport.send(message);
            System.out.println("Sent message successfully....");

        }catch (MessagingException me){
            System.out.println("Exception: "+me);

        }
    }
}