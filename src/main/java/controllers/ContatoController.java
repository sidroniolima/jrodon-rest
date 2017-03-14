package controllers;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Marcacao;
import model.Mensagem;
import services.MailService;

@RestController
@RequestMapping("/contato")
@CrossOrigin(origins = "*")
public class ContatoController {

	Logger logger = Logger.getLogger(ContatoController.class.getSimpleName());
	
	@Autowired
	MailService mailSrvc;
	
	private final String from = "site@jrodontologia.com";
	private final String to = "site@jrodontologia.com";
	
	@RequestMapping(value="/mensagem/add/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> enviaContato(@RequestBody Mensagem contato) throws UnsupportedEncodingException{
		
		logger.log(Level.INFO, "Novo contato: " + contato.toString());
		
		try 
		{
			mailSrvc.enviaEmail(from, to, contato.getAssunto(), contato.toString());
			return new ResponseEntity<Mensagem>(contato, HttpStatus.CREATED);
			
		} catch (MailException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/marcacao/add/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> marca(@RequestBody Marcacao marcacao)
	{
		logger.log(Level.INFO, "Marcação: " + marcacao.toString());
		
		try 
		{
			mailSrvc.enviaEmail(from, to, marcacao.getAssunto(), marcacao.toString());
			return new ResponseEntity<Marcacao>(marcacao, HttpStatus.CREATED);
			
		} catch (MailException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	
	}
}
