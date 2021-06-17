package co.edu.ufps.huelleritos.correo;
import java.util.Date;
	import java.util.Properties;
	 
	import javax.mail.Authenticator;
	import javax.mail.Message;
	import javax.mail.MessagingException;
	import javax.mail.PasswordAuthentication;
	import javax.mail.Session;
	import javax.mail.Transport;
	import javax.mail.internet.AddressException;
	import javax.mail.internet.InternetAddress;
	import javax.mail.internet.MimeMessage;
	
	public class Mail {
	
	

	public void enviarEmail(String toAddress, String asunto, String mensaje){
 
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
 
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("huelleritosfundacion@gmail.com", "Huelleritos3259");
            }
        };
 
        Session session = Session.getInstance(properties, auth);
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
      try {
    	  msg.setFrom(new InternetAddress("huelleritosfundacion@gmail.com"));
          InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
          msg.setRecipients(Message.RecipientType.TO, toAddresses);
          msg.setSubject(asunto);
          msg.setSentDate(new Date());
          msg.setText(mensaje);
   
          // sends the e-mail
          Transport.send(msg);
	} catch (Exception e) {
		e.printStackTrace();
	}
 
    }

	
}