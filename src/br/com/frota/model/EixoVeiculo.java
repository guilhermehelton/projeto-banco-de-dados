package br.com.frota.model;

public class EixoVeiculo extends GenericModel{
	private int idVeiculo;
	private int idEixo;
	private int idPneu;
	
	public EixoVeiculo(int idVeiculo, int idEixo, int idPneu) {
		super();
		this.idVeiculo = idVeiculo;
		this.idEixo = idEixo;
		this.idPneu = idPneu;
	}
	
	public EixoVeiculo(int id, int idVeiculo, int idEixo, int idPneu) {
		super.setId(id);
		this.idVeiculo = idVeiculo;
		this.idEixo = idEixo;
		this.idPneu = idPneu;
	}

	public int getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public int getIdEixo() {
		return idEixo;
	}

	public void setIdEixo(int idEixo) {
		this.idEixo = idEixo;
	}

	public int getIdPneu() {
		return idPneu;
	}

	public void setIdPneu(int idPneu) {
		this.idPneu = idPneu;
	}
	
	@Override
	public String toString() {
		return "Eixo Veiculo {" +
                "id='" + this.getId() + "\'" +
                "id_veiculo='" + idVeiculo + "\'" +
                "id_eixo='" + idEixo + "\'" +
                "id_pneu='" + idPneu + "\'" +
                '}';
	}
}
