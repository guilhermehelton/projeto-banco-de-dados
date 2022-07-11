package br.com.frota.model;

public class Veiculo extends GenericModel{
	private String descricao;
	private int idMarca;
	
	public Veiculo(String descricao, int idMarca) {
		super();
		this.descricao = descricao;
		this.idMarca = idMarca;
	}
	
	public Veiculo(int id, String descricao, int idMarca) {
		super.setId(id);
		this.descricao = descricao;
		this.idMarca = idMarca;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}
	
	@Override
    public String toString() {
        return "Veiculo {" +
                "id='" + this.getId() + "\'" +
                "descricao='" + descricao + "\'" +
                "id_marcar='" + idMarca + "\'" +
                '}';
    }
}
