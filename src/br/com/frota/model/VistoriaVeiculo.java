package br.com.frota.model;

public class VistoriaVeiculo extends GenericModel{
	private String observacao;
	private String dataVistoria;
	private int idVeiculo;
	
	public VistoriaVeiculo(String observacao, String dataVistoria, int idVeiculo) {
		super();
		this.observacao = observacao;
		this.dataVistoria = dataVistoria;
		this.idVeiculo = idVeiculo;
	}
	
	public VistoriaVeiculo(int id, String observacao, String dataVistoria, int idVeiculo) {
		super.setId(id);
		this.observacao = observacao;
		this.dataVistoria = dataVistoria;
		this.idVeiculo = idVeiculo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getDataVistoria() {
		return dataVistoria;
	}

	public void setDataVistoria(String dataVistoria) {
		this.dataVistoria = dataVistoria;
	}

	public int getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(int idVeiculo) {
		this.idVeiculo = idVeiculo;
	}
	
	@Override
    public String toString() {
        return "Vistoria Veiculo {" +
                "id='" + this.getId() + "\'" +
                "observacao='" + observacao + "\'" +
                "data_vistoria='" + dataVistoria + "\'" +
                "veiculo_id='" + idVeiculo + "\'" +
                '}';
    }
}
