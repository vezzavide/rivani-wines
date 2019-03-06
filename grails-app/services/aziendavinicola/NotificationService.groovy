package aziendavinicola

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


class NotificationService {

    def sendNotification(Utente utente, String messaggio) {
        println("Invio questa notifica a " + utente.toString() + ": " + messaggio)

        final String username = "rivaniwines@gmail.com";
        final String password = "ingegneriadelsoftware";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session mailSession = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress("rivaniwines@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(utente.email));
            message.setSubject("Notifica da Rivaniwines");
            message.setText(messaggio);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}
