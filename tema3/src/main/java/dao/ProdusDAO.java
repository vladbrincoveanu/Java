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
import model.Produs;


public class ProdusDAO {

	private static ArrayList<Produs> arrayProdus = new ArrayList<Produs>();
	protected static final Logger LOGGER = Logger.getLogger(ProdusDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO produs (nume)" + " VALUES (?)";
	private static final String deleteStatementString = "DELETE FROM produs WHERE idProdus= ?";
	private static final String updateStatementString = "UPDATE produs SET nume= ? WHERE idProdus = ?";
	private final static String findStatementString = "SELECT * FROM produs where idProdus = ?";

	public static Produs findById(int produsId) {
		Produs toReturn = null;

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setLong(1, produsId);
			rs = findStatement.executeQuery();
			rs.next();

			String name = rs.getString("nume");
			toReturn = new Produs(produsId, name);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ProdusDAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return toReturn;
	}

	public static ArrayList<Produs> showInfo() {
		String query = "select * from produs";
		arrayProdus.clear();
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		Produs st;
		try {
			findStatement = dbConnection.prepareStatement(query);
			rs = findStatement.executeQuery(query);
			while (rs.next()) {
				st = new Produs(rs.getInt(1), rs.getString(2));
				arrayProdus.add(st);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Show info about client query failed", null, JOptionPane.ERROR_MESSAGE);
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return arrayProdus;
	}

	public static int insert(Produs produs) {
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setString(1, produs.getName());
			insertStatement.executeUpdate();

			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ProdusDAO:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return insertedId;
	}

	public static int delete(int id) {
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
			LOGGER.log(Level.WARNING, "ProdusDAO:delete " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return deletedId;
	}

	public static int update(Produs student) {
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement insertStatement = null;
		int updatedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setString(1, student.getName());
			insertStatement.setInt(2, student.getId());
			insertStatement.executeUpdate();

			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				updatedId = rs.getInt(2);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ProdusDAO:update " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return updatedId;
	}

}
