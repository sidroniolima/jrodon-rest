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

import model.Contato;
import services.MailService;

@RestController
@RequestMapping("/contato")
@CrossOrigin(origins = "*")
public class ContatoController {

	Logger logger = Logger.getLogger(ContatoController.class.getSimpleName());
	
	@Autowired
	MailService mailSrvc;
	
	@RequestMapping(value="/mensagem/envia/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> enviaContato(@RequestBody Contato contato) throws UnsupportedEncodingException{
		
		logger.log(Level.INFO, "Novo contato: " + contato.toString());
		
		try 
		{
			mailSrvc.enviaEmail(contato.getFrom(), contato.getTo(), contato.getAssunto(), contato.toString());
			return new ResponseEntity<Contato>(contato, HttpStatus.CREATED);
			
		} catch (MailException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
}
