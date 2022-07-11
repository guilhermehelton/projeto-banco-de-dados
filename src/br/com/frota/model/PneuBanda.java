package br.com.frota.model;

public class PneuBanda extends GenericModel{
	private String observacao;
	private int idPneu;
	private int ordem;
	private int idBanda;
	
	public PneuBanda(String observacao, int idPneu, int ordem, int idBanda) {
		super();
		this.observacao = observacao;
		this.idPneu = idPneu;
		this.ordem = ordem;
		this.idBanda = idBanda;
	}
	
	public PneuBanda(int id, String observacao, int idPneu, int ordem, int idBanda) {
		super.setId(id);
		this.observacao = observacao;
		this.idPneu = idPneu;
		this.ordem = ordem;
		this.idBanda = idBanda;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public int getIdPneu() {
		return idPneu;
	}

	public void setIdPneu(int idPneu) {
		this.idPneu = idPneu;
	}

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

	public int getIdBanda() {
		return idBanda;
	}

	public void setIdBanda(int idBanda) {
		this.idBanda = idBanda;
	}
	
	@Override
	public String toString() {
		return "Pneu Banda {" +
                "id='" + this.getId() + "\'" +
                "observação='" + observacao + "\'" +
                "id_pneu='" + idPneu + "\'" +
                "ordem='" + ordem + "\'" +
                "id_banda='" + idBanda + "\'" +
                '}';
	}
}
