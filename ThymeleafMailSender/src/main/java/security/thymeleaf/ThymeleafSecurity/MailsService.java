package security.thymeleaf.ThymeleafSecurity;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailsService 
{
	@Autowired
	RepoMail repo;
	
	public List<Mails> gatherAll()
	{
		return repo.findAll();
	}
	
	public Mails receive(int id)
	{
		return repo.findById(id).get();
	}
	
	public void sendMail(Mails mails)
	{
		String frm="$$$$$$$@gmail.com",pss="$$$$$$$$";
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		  props.put("mail.smtp.socketFactory.port", "465");
		  props.put("mail.smtp.socketFactory.class",
		        	"javax.net.ssl.SSLSocketFactory");
		  props.put("mail.smtp.auth", "true");
		  props.put("mail.smtp.port", "465");
		 
		  Session session = Session.getDefaultInstance(props,
		   new javax.mail.Authenticator() {
		   protected PasswordAuthentication getPasswordAuthentication() {
		   return new PasswordAuthentication(frm,pss);//change accordingly
		   }
		  });
		 
		//compose message
		  try {
		   MimeMessage message = new MimeMessage(session);
		   message.setFrom(new InternetAddress(frm));//change accordingly
		   message.addRecipient(Message.RecipientType.TO,new InternetAddress(mails.getEmail()));
		   message.setSubject("Test mail from zealous tech corp");
		   message.setText("Hello this is test mail");
		   //jp.showMessageDialog(this, "Message sent successfully", "Sending mail", 1, null);
		   //send message
		   //System.out.println(message+" "+addr.toString());
		   
			/*
			 * MimeBodyPart messageBodyPart = new MimeBodyPart();
			 * messageBodyPart.setContent("Zealous email", "text/html");
			 * 
			 * Multipart multipart = new MimeMultipart();
			 * multipart.addBodyPart(messageBodyPart); MimeBodyPart attachPart = new
			 * MimeBodyPart();
			 * 
			 * attachPart.attachFile("/var/tmp/image19.png");
			 * multipart.addBodyPart(attachPart); message.setContent(multipart);
			 */
		   
		   Transport.send(message);
		   System.out.println("Mail has sent");
		  } 
		  catch (javax.mail.MessagingException e) 
		  {
			  //throw new RuntimeException(e);
		} /*
			 * catch (IOException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
	}
}
