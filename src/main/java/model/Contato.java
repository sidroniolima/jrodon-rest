package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Contato {

	private String nome;
	private String email;
	private String assunto;
	private String mensagem;
	
	private LocalDateTime horario;
	
	public Contato() 
	{
		this.horario = LocalDateTime.now();
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

	public LocalDateTime getHorario() {
		return horario;
	}
	public void setHorario(LocalDateTime horario) {
		this.horario = horario;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + "\n"
				+ "Email: " + email + "\n"
				+ "Assunto: " + assunto + "\n"
				+ "Mensagem: " + mensagem + "\n"
				+ "Horário: " + this.getHorario().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));
	}
}