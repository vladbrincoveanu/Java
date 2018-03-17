package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import connection.ConnectionFactory;
import model.Stoc;

public class StocDAO {

	private static ArrayList<Stoc> arrayStoc = new ArrayList<Stoc>();
	protected static final Logger LOGGER = Logger.getLogger(StocDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO stoc (idProdus,cantitate)"+ " VALUES (?,?)";
	private static final String deleteStatementString = "DELETE FROM stoc WHERE idProdus= ?";
	private static final String updateStatementString = "UPDATE stoc SET cantitate= ? WHERE idProdus = ?";
	private final static String findStatementString = "SELECT idProdus FROM produs WHERE produs.nume = ?";

	public static int findByName(String name) {
		int idProdus=-1;
		
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setString(1, name);
			rs = findStatement.executeQuery();
			rs.next();
 
			idProdus = rs.getInt("idProdus");
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"StocDAO:findByName " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return idProdus;
	}
	
	public static ArrayList<Stoc> showInfo() {
		String query = "select * from stoc";
		arrayStoc.clear();
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		Stoc st;
		try {
			findStatement = dbConnection.prepareStatement(query);
			rs = findStatement.executeQuery(query);
			while (rs.next()) {
				st = new Stoc(rs.getInt(1), rs.getInt(2));
				arrayStoc.add(st);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Show info about stoc query failed", null, JOptionPane.ERROR_MESSAGE);
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return arrayStoc;
	}
	
	public static int insert(Stoc stoc) {
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1, stoc.getIdProdus());
			insertStatement.setInt(2, stoc.getCantitate());
			insertStatement.executeUpdate();

			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "StocDAO:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return insertedId;
	}

	public static int delete(int id){
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement insertStatement = null;
		int deletedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(deleteStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1, id);
			insertStatement.executeUpdate();

			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				deletedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "CantitateDAO:delete " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return deletedId;
	}
	
	public static int update(Stoc stoc){
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement insertStatement = null;
		int updatedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1, stoc.getCantitate());
			insertStatement.setInt(2, stoc.getIdProdus());
			insertStatement.executeUpdate();

			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				updatedId = rs.getInt(2);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "StocDAO:update " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return updatedId;
	}
}
