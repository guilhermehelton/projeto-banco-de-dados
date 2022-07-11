package br.com.frota.model;

public class Pneu extends GenericModel {
	private int raio;
	private String perfil;
	private String largura;
	private String indiceCarga;
	private String indiceVelocidade;
	private int idMarcaPneu;
	
	public Pneu(int raio, String perfil, String largura, String indiceCarga,
			String indiceVelocidade, int idMarcaPneu) {
		super();
		this.raio = raio;
		this.perfil = perfil;
		this.largura = largura;
		this.indiceCarga = indiceCarga;
		this.indiceVelocidade = indiceVelocidade;
		this.idMarcaPneu = idMarcaPneu;
	}
	
	public Pneu(int id,int raio, String perfil, String largura, String indiceCarga,
			String indiceVelocidade, int idMarcaPneu) {
		super.setId(id);
		this.raio = raio;
		this.perfil = perfil;
		this.largura = largura;
		this.indiceCarga = indiceCarga;
		this.indiceVelocidade = indiceVelocidade;
		this.idMarcaPneu = idMarcaPneu;
	}

	public int getRaio() {
		return raio;
	}

	public void setRaio(int raio) {
		this.raio = raio;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getLargura() {
		return largura;
	}

	public void setLargura(String largura) {
		this.largura = largura;
	}

	public String getIndiceCarga() {
		return indiceCarga;
	}

	public void setIndiceCarga(String indiceCarga) {
		this.indiceCarga = indiceCarga;
	}

	public String getIndiceVelocidade() {
		return indiceVelocidade;
	}

	public void setIndiceVelocidade(String indiceVelocidade) {
		this.indiceVelocidade = indiceVelocidade;
	}

	public int getIdMarcaPneu() {
		return idMarcaPneu;
	}

	public void setIdMarcaPneu(int idMarcaPneu) {
		this.idMarcaPneu = idMarcaPneu;
	}

	@Override
	public String toString() {
		return "Pneu {" +
                "id='" + this.getId() + "\'" +
                "raio='" + raio + "\'" +
                "perfil='" + perfil + "\'" +
                "largura='" + largura + "\'" +
                "indiceCarga='" + indiceCarga + "\'" +
                "indiceVelocidade='" + indiceVelocidade + "\'" +
                "idMarcaPneu='" + idMarcaPneu + "\'" +
                '}';
	}
	
	
	
}
