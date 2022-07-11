package br.com.frota.model;

public class Eixo extends GenericModel{
	private String descricao;
	private String posicao;
	private int idTipoEixo;
	
	public Eixo(String descricao, String posicao, int idTipoEixo) {
		super();
		this.descricao = descricao;
		this.posicao = posicao;
		this.idTipoEixo = idTipoEixo;
	}
	
	public Eixo(int id, String descricao, String posicao, int idTipoEixo) {
		super.setId(id);
		this.descricao = descricao;
		this.posicao = posicao;
		this.idTipoEixo = idTipoEixo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}

	public int getIdTipoEixo() {
		return idTipoEixo;
	}

	public void setIdTipoEixo(int idTipoEixo) {
		this.idTipoEixo = idTipoEixo;
	}
	
	@Override
	public String toString() {
		return "Eixo {" +
                "id='" + this.getId() + "\'" +
                "descrição='" + descricao + "\'" +
                "posição='" + posicao + "\'" +
                "id_tipo_eixo='" + idTipoEixo + "\'" +
                '}';
	}
}
