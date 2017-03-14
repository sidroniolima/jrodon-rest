package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Contato {

	private String nome;
	private String email;
	private String telefone;
	
	private LocalDateTime horario;
	
	public Contato() {
		this.horario = LocalDateTime.now();
	}
	
	public abstract String getAssunto();

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
	
	@Override
	public String toString() {
		return	"Nome: " + this.getNome() + "\n"
				+ "Email: " + this.getEmail() + "\n"
				+ "Assunto: " + this.getAssunto() + "\n"
				+ "Telefone: " + this.getTelefone() + "\n"
				+ "Horário de contato: " + this.getHorario().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));
	}
	
}
