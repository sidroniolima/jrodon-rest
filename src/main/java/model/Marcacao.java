package model;

public class Marcacao extends Contato {

	private String reclamacao;
	private final String assunto = "Marcação de consulta";
	private String melhorHorario;
	
	@Override
	public String getAssunto() {		
		return this.assunto;
	}

	public String getReclamacao() {
		return reclamacao;
	}
	public void setReclamacao(String reclamacao) {
		this.reclamacao = reclamacao;
	}

	public String getMelhorHorario() {
		return melhorHorario;
	}
	public void setMelhorHorario(String melhorHorario) {
		this.melhorHorario = melhorHorario;
	}

	@Override
	public String toString() {
		return "Marcacao de Consulta: \n " +
				super.toString() + 
				"Reclamação: " + reclamacao + "\n" + 
				"Melhor horário: " + melhorHorario;
	}
	
}
