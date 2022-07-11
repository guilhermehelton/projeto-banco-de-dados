package br.com.frota.model;

public class Banda extends GenericModel{
	private String descricao;
	private String lado;
	
	public Banda(String descricao, String lado) {
		super();
		this.descricao = descricao;
		this.lado = lado;
	}
	
	public Banda(int id, String descricao, String lado) {
		super.setId(id);
		this.descricao = descricao;
		this.lado = lado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getLado() {
		return lado;
	}

	public void setLado(String lado) {
		this.lado = lado;
	}
	
	@Override
	public String toString() {
		return "Banda {" +
                "id='" + this.getId() + "\'" +
                "descrição='" + descricao + "\'" +
                "lado='" + lado + "\'" +
                '}';
	}
	
}
