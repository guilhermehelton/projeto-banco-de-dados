package br.com.frota.model;

public class TipoEixo extends GenericModel{
	private String descricao;

	public TipoEixo(String descricao) {
		super();
		this.descricao = descricao;
	}
	
	public TipoEixo(int id, String descricao) {
		super.setId(id);
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@Override
    public String toString() {
        return "Tipo Eixo {" +
                "id='" + this.getId() + "\'" +
                "descricao='" + descricao + "\'" +
                '}';
    }
}
