package br.com.frota.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.frota.model.VistoriaVeiculo;

public class VistoriaVeiculoDAO extends ConexaoDB{
    private static final String INSERT_VISTORIA_SQL = "INSERT INTO vistoria_veiculo (observacao,"
    		+ "data_vistoria, veiculo_id) VALUES (?, ?, ?);";
    private static final String SELECT_VISTORIA_BY_ID = "SELECT * FROM vistoria_veiculo WHERE id = ?";
    private static final String SELECT_ALL_VISTORIA = "SELECT * FROM vistoria_veiculo;";
    private static final String DELETE_VISTORIA_SQL = "DELETE FROM vistoria_veiculo WHERE id = ?;";
    private static final String UPDATE_VISTORIA_SQL = "UPDATE vistoria_veiculo SET observacao = ?,"
    		+ "data_vistoria = ? WHERE id = ?;";
    
    public void insertVistoriaVeiculo(VistoriaVeiculo entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_VISTORIA_SQL)) {
            preparedStatement.setString(1, entidade.getObservacao());
            preparedStatement.setString(2, entidade.getDataVistoria());
            preparedStatement.setInt(3, entidade.getIdVeiculo());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public VistoriaVeiculo selectVistoriaVeiculo(int id) {
    	VistoriaVeiculo entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_VISTORIA_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String observacao = rs.getString("observacao");
                String dataVistoria = rs.getString("data_vistoria");
                int idVeiculo = rs.getInt("veiculo_id");
                entidade = new VistoriaVeiculo(id, observacao, dataVistoria, idVeiculo);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<VistoriaVeiculo> selectAllVistoriaVeiculo() {
        List<VistoriaVeiculo> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_VISTORIA)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String observacao = rs.getString("observacao");
                String dataVistoria = rs.getString("data_vistoria");
                int idVeiculo = rs.getInt("veiculo_id");
                entidades.add(new VistoriaVeiculo(id, observacao, dataVistoria, idVeiculo));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteVistoriaVeiculo(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_VISTORIA_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateVistoriaVeiculo(VistoriaVeiculo entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_VISTORIA_SQL)) {
            statement.setString(1, entidade.getObservacao());
            statement.setString(2, entidade.getDataVistoria());
            statement.setInt(3, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
