package controllers;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Contato;

@RestController
@RequestMapping("/contato")
@CrossOrigin(origins = "*")
public class ContatoController {

	Logger logger = Logger.getLogger(ContatoController.class.getSimpleName());
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@RequestMapping(method = RequestMethod.GET)
	public String get()
	{
		return "Teste";
	}
	
	@RequestMapping(value="/add/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> enviaContato(@RequestBody Contato contato) throws UnsupportedEncodingException{
		
		logger.log(Level.INFO, "Novo contato: " + contato.toString());
		
		SimpleMailMessage mail = new SimpleMailMessage();
		
		mail.setFrom("site@jrodontologia.com");
		mail.setTo("site@jrodontologia.com");
		mail.setSubject("Mensagem do site, assunto: " + contato.getAssunto());
		mail.setText(contato.toString());
		
		javaMailSender.send(mail);
		
		return new ResponseEntity<Contato>(contato, HttpStatus.CREATED);
	}
}
