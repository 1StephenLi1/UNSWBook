package unswbook.servlet;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmail {
    final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
    private String to;
    private String from = "comp9321UNSWBookServer@gmail.com";
    private String host = "localhost";

    // Get system properties object
    private Properties props = System.getProperties();

    public SendEmail(String to){
        this.to = to;
    }


    public void sendConfirmationEmail(String code){

        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.store.protocol", "pop3");
        props.put("mail.transport.protocol", "smtp");
        final String password = "lfm97415";
        Session session = Session.getDefaultInstance(props,
                new Authenticator(){
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }});
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Activate your account");

            // Now set the actual message
            message.setContent("<h1>Hi! Welcome to UNSWBook! Please click the link below to activate your account." +
            "</h1><h3><a href='http://localhost:8080/comp9321ass2/login?action=activate&&code="+code+"'>http://localhost:8080/activate_account</a></h3>","text/html");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    public void sendAcceptRequestEmail(String code){
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "true");
        props.put("mail.store.protocol", "pop3");
        props.put("mail.transport.protocol", "smtp");
        final String password = "lfm97415";
        Session session = Session.getDefaultInstance(props,
                new Authenticator(){
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }});
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("You have a friend request");

            // Now set the actual message
            message.setContent("<h1>Hi! You have a friend request. Click the link below to accept ...." +
                    "</h1><h3><a href='http://localhost:8080/comp9321ass2/login?action=activate&&code="+code+"'>http://localhost:8080/accept_request</a></h3>","text/html");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}


/*
    SendEmail se = new SendEmail(To_email);
    // activate the account:
    //code: unique string 
    se.sendConfirmationEmail(code);

    //accept friend request
    // code : current username + friend user
    se.sendAcceptRequestEmail(code);
*/