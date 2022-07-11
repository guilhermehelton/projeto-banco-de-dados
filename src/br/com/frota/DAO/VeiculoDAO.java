package br.com.frota.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.frota.model.Veiculo;

public class VeiculoDAO extends ConexaoDB {
	
	private static final String INSERT_VEICULO_SQL = "INSERT INTO veiculo (descricao,"
			+ "id_marca) VALUES (?, ?);";
    private static final String SELECT_VEICULO_BY_ID = "SELECT * FROM veiculo WHERE id = ?";
    private static final String SELECT_ALL_VEICULO = "SELECT * FROM veiculo;";
    private static final String DELETE_VEICULO_SQL = "DELETE FROM veiculo WHERE id = ?;";
    private static final String UPDATE_VEICULO_SQL = "UPDATE veiculo SET descricao = ? WHERE id = ?;";
    
    public void insertVeiculo(Veiculo entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_VEICULO_SQL)) {
            preparedStatement.setString(1, entidade.getDescricao());
            preparedStatement.setInt(2, entidade.getIdMarca());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Veiculo selectVeiculo(int id) {
    	Veiculo entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_VEICULO_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String descricao = rs.getString("descricao");
                int idMarca = rs.getInt("id_marca");
                entidade = new Veiculo(id, descricao, idMarca);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Veiculo> selectAllVeiculo() {
        List<Veiculo> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_VEICULO)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                int idMarca = rs.getInt("id_marca");
                entidades.add(new Veiculo(id, descricao, idMarca));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deleteVeiculo(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_VEICULO_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateVeiculo(Veiculo entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_VEICULO_SQL)) {
            statement.setString(1, entidade.getDescricao());
            statement.setInt(2, entidade.getIdMarca());
            statement.setInt(3, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
