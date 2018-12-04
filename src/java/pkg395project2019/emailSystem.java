
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
     * @param targetEmail target email
     * @param msg1 message title
     * @param msg2 message text
     * @return
     */
    public boolean sendUMsg(String targetEmail, String msg1, String msg2 ) {
                System.out.print("Step1" + targetEmail + msg1 + msg2);
		final String username = "group395cmptemail@gmail.com";
		final String password = "RunningOutOfTime1";
                System.out.print("Step2");
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
                System.out.print("Step3");
		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });
                System.out.print("Step4");
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("group395cmptemail@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(targetEmail)); 
			message.setSubject(msg1);
			message.setText(msg2);
                        System.out.print("Step5.1");
			Transport.send(message);
                        System.out.print("Step here?");
                        

		} catch (MessagingException e) {
                        System.out.print("Step5.2");
                        return false;
		}
                System.out.print("Step6");
                return true;
    }
    public  void main(){
       
    }

}   