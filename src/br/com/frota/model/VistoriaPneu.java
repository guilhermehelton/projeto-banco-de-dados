package br.com.frota.model;

public class VistoriaPneu extends GenericModel {
	private String dataCadastro;
	private String dataVistoria;
	private String username;
	private int idVistoriaVeiculo;
	private int idPneu;
	
	public VistoriaPneu(String dataCadastro, String dataVistoria, String username, int idVistoriaVeiculo, int idPneu) {
		super();
		this.dataCadastro = dataCadastro;
		this.dataVistoria = dataVistoria;
		this.username = username;
		this.idVistoriaVeiculo = idVistoriaVeiculo;
		this.idPneu = idPneu;
	}
	
	public VistoriaPneu(int id, String dataCadastro, String dataVistoria, String username, int idVistoriaVeiculo, int idPneu) {
		super.setId(id);
		this.dataCadastro = dataCadastro;
		this.dataVistoria = dataVistoria;
		this.username = username;
		this.idVistoriaVeiculo = idVistoriaVeiculo;
		this.idPneu = idPneu;
	}

	public String getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(String dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getDataVistoria() {
		return dataVistoria;
	}

	public void setDataVistoria(String dataVistoria) {
		this.dataVistoria = dataVistoria;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getIdVistoriaVeiculo() {
		return idVistoriaVeiculo;
	}

	public void setIdVistoriaVeiculo(int idVistoriaVeiculo) {
		this.idVistoriaVeiculo = idVistoriaVeiculo;
	}

	public int getIdPneu() {
		return idPneu;
	}

	public void setIdPneu(int idPneu) {
		this.idPneu = idPneu;
	}
	
	@Override
    public String toString() {
        return "Vistoria Pneu {" +
                "id='" + this.getId() + "\'" +
                "data_cadastro='" + dataCadastro + "\'" +
                "data_vistoria='" + dataVistoria + "\'" +
                "username='" + username + "\'" +
                "vistoria_veiculo_id='" + idVistoriaVeiculo + "\'" +
                "pneu_id='" + idPneu + "\'" +
                '}';
    }
}
