package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public void enviaEmail(String from, String to, String subject, String text) throws MailException
	{
		SimpleMailMessage mail = new SimpleMailMessage();
		
		mail.setFrom("site@jrodontologia.com");
		mail.setTo("site@jrodontologia.com");
		mail.setSubject("Site, assunto: " + subject);
		mail.setText(text);
		
		javaMailSender.send(mail);
	}
}
