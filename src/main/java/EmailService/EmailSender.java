package EmailService;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class EmailSender {
    public EmailSender(String to, String text) throws MessagingException, UnsupportedEncodingException {

            String from = "bookitnow.app.kmitl@gmail.com";
            String password = "jvzg svvb wgfi kxgg";
            String senderName = "BookITNow App";

            Properties props = System.getProperties();
            String host = "smtp.gmail.com";
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");

            Session session = Session.getInstance(props,
                    new jakarta.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(from, password);
                        }
                    });


                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress(from, senderName));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                message.setSubject("BookITNow : Reset Password");
                message.setText(text);

                Transport.send(message);
        }

    }