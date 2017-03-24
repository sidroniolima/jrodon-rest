package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Contato {

	private String from;
	private String to;
	
	private String nome;
	private String email;
	private String telefone;
	private String assunto;
	private String mensagem;
	
	private LocalDateTime horario;
	
	public Contato() {
		this.horario = LocalDateTime.now();
	}

	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}

	public LocalDateTime getHorario() {
		return horario;
	}
	public void setHorario(LocalDateTime horario) {
		this.horario = horario;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	@Override
	public String toString() {
		return	"Nome: " + this.getNome() + "\n"
				+ "Email: " + this.getEmail() + "\n"
				+ "Assunto: " + this.getAssunto() + "\n"
				+ "Telefone: " + this.getTelefone() + "\n"
				+ "Horário de contato: " + this.getHorario().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss")) + "\n"
				+ "Mensagem: " + this.getMensagem();
	}
	
}
