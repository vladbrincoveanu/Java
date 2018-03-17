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
import model.Student;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 */
public class StudentDAO {
	
	private static ArrayList<Student> arrayStudent = new ArrayList<Student>();
	protected static final Logger LOGGER = Logger.getLogger(StudentDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO student (name,address,email,age)"
			+ " VALUES (?,?,?,?)";
	private static final String deleteStatementString = "DELETE FROM student WHERE id= ?";
	private static final String updateStatementString = "UPDATE student SET name= ?,address=?,email=?,age=? WHERE id= ?";
	private final static String findStatementString = "SELECT * FROM student where id = ?";

	public static Student findById(int studentId) {
		Student toReturn = null;

		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setLong(1, studentId);
			rs = findStatement.executeQuery();
			rs.next();

			String name = rs.getString("name");
			String address = rs.getString("address");
			String email = rs.getString("email");
			int age = rs.getInt("age");
			toReturn = new Student(studentId, name, address, email, age);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "StudentDAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return toReturn;
	}
	
	public static ArrayList<Student> showInfo() {
		String query = "select * from student";
		arrayStudent.clear();
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		Student st;
		try {
			findStatement = dbConnection.prepareStatement(query);
			rs = findStatement.executeQuery(query);
			while (rs.next()) {
				st = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
				arrayStudent.add(st);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Show info about client query failed", null, JOptionPane.ERROR_MESSAGE);
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return arrayStudent;
	}

	public static int insert(Student student) {
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setString(1, student.getName());
			insertStatement.setString(2, student.getAddress());
			insertStatement.setString(3, student.getEmail());
			insertStatement.setInt(4, student.getAge());
			insertStatement.executeUpdate();

			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "StudentDAO:insert " + e.getMessage());
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
			LOGGER.log(Level.WARNING, "StudentDAO:delete " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return deletedId;
	}

	// UPDATE student SET name= ?,address=?,email=?,age=?, WHERE id= ?"
	public static int update(Student student) {
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement insertStatement = null;
		int updatedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(updateStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setString(1, student.getName());
			insertStatement.setString(2, student.getAddress());
			insertStatement.setString(3, student.getEmail());
			insertStatement.setInt(4, student.getAge());
			insertStatement.setInt(5, student.getId());
			insertStatement.executeUpdate();

			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				updatedId = rs.getInt(5);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "StudentDAO:update " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return updatedId;
	}
	
}
