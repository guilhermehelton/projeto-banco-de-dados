package br.com.frota.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.frota.model.PneuBanda;

public class PneuBandaDAO extends ConexaoDB{
	private static final String INSERT_PNEU_SQL = "INSERT INTO pneu_banda (observacao,"
			+ "pneu_id, ordem, banda) VALUES (?, ?, ?, ?);";
    private static final String SELECT_PNEU_BY_ID = "SELECT * FROM pneu_banda WHERE id = ?";
    private static final String SELECT_ALL_PNEU = "SELECT * FROM pneu_banda;";
    private static final String DELETE_PNEU_SQL = "DELETE FROM pneu_banda WHERE id = ?;";
    private static final String UPDATE_PNEU_SQL = "UPDATE pneu_banda SET observacao = ?,"
    		+ "pneu_id = ?, ordem = ?, banda = ? WHERE id = ?;";
    
    public void insertPneuBanda(PneuBanda entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_PNEU_SQL)) {
            preparedStatement.setString(1, entidade.getObservacao());
            preparedStatement.setInt(2, entidade.getIdPneu());
            preparedStatement.setInt(3, entidade.getOrdem());
            preparedStatement.setInt(4, entidade.getIdBanda());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public PneuBanda selectPneuBanda(int id) {
    	PneuBanda entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_PNEU_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
            	String observacao = rs.getString("observacao");
                int idPneu = rs.getInt("pneu_id");
                int ordem = rs.getInt("ordem");
                int idBanda = rs.getInt("banda");
                entidade = new PneuBanda(id, observacao, idPneu, ordem, idBanda);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<PneuBanda> selectAllPneuBanda() {
        List<PneuBanda> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_PNEU)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String observacao = rs.getString("observacao");
                int idPneu = rs.getInt("pneu_id");
                int ordem = rs.getInt("ordem");
                int idBanda = rs.getInt("banda");
                entidades.add(new PneuBanda(id, observacao, idPneu, ordem, idBanda));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deletePneuBanda(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_PNEU_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updatePneuBanda(PneuBanda entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_PNEU_SQL)) {
        	statement.setString(1, entidade.getObservacao());
        	statement.setInt(2, entidade.getIdPneu());
        	statement.setInt(3, entidade.getOrdem());
        	statement.setInt(4, entidade.getIdBanda());
            statement.setInt(5, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
