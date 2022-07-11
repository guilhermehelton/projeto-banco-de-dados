package br.com.frota.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.frota.model.Pneu;

public class PneuDAO extends ConexaoDB {
	
	private static final String INSERT_PNEU_SQL = "INSERT INTO pneu (raio, perfil,"
			+ "largura, indice_carga, indice_velocidade, id_marca_pneu) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String SELECT_PNEU_BY_ID = "SELECT * FROM pneu WHERE id = ?";
    private static final String SELECT_ALL_PNEU = "SELECT * FROM pneu;";
    private static final String DELETE_PNEU_SQL = "DELETE FROM pneu WHERE id = ?;";
    private static final String UPDATE_PNEU_SQL = "UPDATE pneu SET raio = ?, perfil = ?, "
    		+ "largura = ?,indice_carga = ?,indice_velocidade = ? WHERE id = ?;";
    
    public void insertPneu(Pneu entidade) {
        try (PreparedStatement preparedStatement = prapararSQL(INSERT_PNEU_SQL)) {
            preparedStatement.setInt(1, entidade.getRaio());
            preparedStatement.setString(2, entidade.getPerfil());
            preparedStatement.setString(3, entidade.getLargura());
            preparedStatement.setString(4, entidade.getIndiceCarga());
            preparedStatement.setString(5, entidade.getIndiceVelocidade());
            preparedStatement.setInt(6, entidade.getIdMarcaPneu());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Pneu selectPneu(int id) {
    	Pneu entidade = null;
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_PNEU_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
            	int raio = rs.getInt("raio");
                String perfil = rs.getString("perfil");
                String largura = rs.getString("largura");
                String indiceCarga = rs.getString("indice_carga");
                String indiceVelocidade = rs.getString("indice_velocidade");
                int idMarcaPneu = rs.getInt("id_marca_pneu");
                entidade = new Pneu(id, raio, perfil, largura, indiceCarga, indiceVelocidade, idMarcaPneu);
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidade;
    }

    public List<Pneu> selectAllPneus() {
        List<Pneu> entidades = new ArrayList<>();
        try (PreparedStatement preparedStatement = prapararSQL(SELECT_ALL_PNEU)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                int raio = rs.getInt("raio");
                String perfil = rs.getString("perfil");
                String largura = rs.getString("largura");
                String indiceCarga = rs.getString("indice_carga");
                String indiceVelocidade = rs.getString("indice_velocidade");
                int idMarcaPneu = rs.getInt("id_marca_pneu");
                entidades.add(new Pneu(id, raio, perfil, largura, indiceCarga, indiceVelocidade, idMarcaPneu));
            }
        } catch (SQLException e) {
            printSQLException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return entidades;
    }

    public boolean deletePneu(int id) throws SQLException {
        try (PreparedStatement statement = prapararSQL(DELETE_PNEU_SQL)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updatePneu(Pneu entidade) throws SQLException {
        try (PreparedStatement statement = prapararSQL(UPDATE_PNEU_SQL)) {
        	statement.setInt(1, entidade.getRaio());
        	statement.setString(2, entidade.getPerfil());
        	statement.setString(3, entidade.getLargura());
        	statement.setString(4, entidade.getIndiceCarga());
        	statement.setString(5, entidade.getIndiceVelocidade());
            statement.setInt(6, entidade.getId());

            return statement.executeUpdate() > 0;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
