package services;

import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service
public class MailService {

	private JavaMailSender javaMailSender = new JavaMailSenderImpl();
	
	public void enviaEmail(String from, String to, String subject, String text) throws MailException
	{
		SimpleMailMessage mail = new SimpleMailMessage();
		
		mail.setFrom(from);
		mail.setTo(to);
		mail.setSubject("Site, assunto: " + subject);
		mail.setText(text);
		
		javaMailSender.send(mail);
	}
}
