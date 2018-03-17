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
import model.Comanda;

public class ComandaDAO {

	private static ArrayList<Comanda> arrayComanda = new ArrayList<Comanda>();
	protected static final Logger LOGGER = Logger.getLogger(ProdusDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO comanda (idStudent,idProdus,cantitate)"
			+ " VALUES (?,?,?)";
	private final static String findStatementString = "SELECT * FROM comanda where idComanda = ?";

	public static Comanda findById(int idComanda) {
		Comanda toReturn = null;

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setLong(1, idComanda);
			rs = findStatement.executeQuery();
			rs.next();

			Integer produs = rs.getInt("idProdus");
			Integer student = rs.getInt("idStudent");
			toReturn = new Comanda(idComanda, student, produs);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ProdusDAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return toReturn;
	}

	public static ArrayList<Comanda> showInfo() {
		String query = "select * from comanda";
		arrayComanda.clear();
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		Comanda st;
		try {
			findStatement = dbConnection.prepareStatement(query);
			rs = findStatement.executeQuery(query);
			while (rs.next()) {
				st = new Comanda(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4));
				arrayComanda.add(st);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Show info about comanda query failed", null,
					JOptionPane.ERROR_MESSAGE);
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return arrayComanda;
	}

	public static int insert(Comanda comanda) {
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1, comanda.getIdStudent());
			insertStatement.setInt(2, comanda.getIdProdus());
			insertStatement.setInt(3, comanda.getCantitate());
			insertStatement.executeUpdate();

			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ComandaDAO:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return insertedId;
	}

}
