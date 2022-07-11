package br.com.frota.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.frota.model.VistoriaPneu;

public class VistoriaPneuDAO extends ConexaoDB{
	
	private static final String INSERT_VISTORIA_SQL = "INSERT INTO vistoria_pneu (data_cadastro,"
    		+ "data_vistoria, username, vistoria_veiculo_id, pneu_id) VALUES (?, ?, ?, ?, ?);";
    private static final String SELECT_VISTORIA_BY_ID = "SELECT * FROM vistoria_pneu WHERE id = ?";
    private static final String SELECT_ALL_VISTORIA = "SELECT * FROM vistoria_pneu;";
    private static final String DELETE_VISTORIA_SQL = "DELETE FROM vistoria_pneu WHERE id = ?;";
    private static final String UPDATE_VISTORIA_SQL = "UPDATE vistoria_pneu SET data_cadastro = ?,"
    		+ "data_vistoria = ?, username = ?, vistoria_veiculo_id = ?, pneu_id = ? WHERE id = ?;";
    
    public void insertVistoriaPneu(VistoriaPneu entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_VISTORIA_SQL)) {
            preparedStatement.setString(1, entidade.getDataCadastro());
            preparedStatement.setString(2, entidade.getDataVistoria());
            preparedStatement.setString(3, entidade.getUsername());
            preparedStatement.setInt(4, entidade.getIdVistoriaVeiculo());
            preparedStatement.setInt(5, entidade.getIdPneu());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public VistoriaPneu selectVistoriaPneu(int id) {
    	VistoriaPneu entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_VISTORIA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String dataCadastro = rs.getString("data_cadastro");
                String dataVistoria = rs.getString("data_vistoria");
                String username = rs.getString("username");
                int idVistoriaVeiculo = rs.getInt("vistoria_veiculo_id");
                int idPneu = rs.getInt("pneu_id");
                entidade = new VistoriaPneu(id, dataCadastro, dataVistoria, username, idVistoriaVeiculo, idPneu);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<VistoriaPneu> selectAllVistoriaPneu() {
        List<VistoriaPneu> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_VISTORIA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String dataCadastro = rs.getString("data_cadastro");
                String dataVistoria = rs.getString("data_vistoria");
                String username = rs.getString("username");
                int idVistoriaVeiculo = rs.getInt("vistoria_veiculo_id");
                int idPneu = rs.getInt("pneu_id");
                entidades.add(new VistoriaPneu(id, dataCadastro, dataVistoria, username, idVistoriaVeiculo, idPneu));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteVistoriaPneu(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_VISTORIA_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateVistoriaPneu(VistoriaPneu entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_VISTORIA_SQL)) {
            statement.setString(1, entidade.getDataCadastro());
            statement.setString(2, entidade.getDataVistoria());
            statement.setString(3, entidade.getUsername());
            statement.setInt(4, entidade.getIdVistoriaVeiculo());
            statement.setInt(5, entidade.getIdPneu());
            statement.setInt(6, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
