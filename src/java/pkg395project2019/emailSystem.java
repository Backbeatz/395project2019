/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg395project2019;



import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class emailSystem {

    /**
     * Send email to target
     * Code parts and inspiration taken from: 
     * https://www.javatpoint.com/example-of-sending-email-using-java-mail-api
     * https://stackoverflow.com/questions/21029418/trying-to-send-an-email-using-the-java-mail-but-its-not-working
     * https://www.tutorialspoint.com/javamail_api/javamail_api_smtp_servers.htm
     * https://www.tutorialspoint.com/javamail_api/javamail_api_send_html_in_email.htm
     * https://www.mkyong.com/java/javamail-api-sending-email-via-gmail-smtp-example/
     * @param targetEmail target email
     * @param msg1 message title
     * @param msg2 message text
     * @return
     */
    public boolean sendUMsg(String targetEmail, String msg1, String msg2 ) {
                
		final String username = "group395cmptemail@gmail.com";
		final String password = "RunningOutOfTime1";
                
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
                
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
                
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("group395cmptemail@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(targetEmail)); 
			message.setSubject(msg1);
			message.setText(msg2);
                        
			Transport.send(message);
                        
                        

		} catch (MessagingException e) {
                        
                        return false;
		}
                
                return true;
    }
    public  void main(){
       
    }

}   
