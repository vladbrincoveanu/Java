package connection;

import com.zaxxer.hikari.HikariDataSource;
import sun.misc.IOUtils;

import javax.activation.DataSource;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.jar.Pack200.Packer.PASS;

/**
 * @Author: Technical University of Cluj-Napoca, Romania Distributed Systems
 *          Research Laboratory, http://dsrl.coned.utcluj.ro/
 * @Since: Apr 03, 2017
 * @Source: http://theopentutorials.com/tutorials/java/jdbc/jdbc-mysql-create-database-example/
 */
public class ConnectionFactory {

	private static final Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/warehousedb?autoReconnect=true&useSSL=false";

	private static ConnectionFactory singleInstance = new ConnectionFactory();

	private ConnectionFactory() {
//		try {
//		//	Class.forName(DRIVER);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
	}

	private Connection createConnection() {
		Connection connection = null;
		ArrayList<String> a=null;
        try {
            try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Vlad\\Desktop\\Vlad Brincoveanu@An2-Sem1\\JAVA WORK\\tema3\\password.txt"))) {
                String line;
                a= new ArrayList<>();
                try {
                    while ((line = br.readLine()) != null) {
                        a.add(line);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
			connection = DriverManager.getConnection(DBURL, a.get(0), a.get(1));
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "An error occured while trying to connect to the database");
			e.printStackTrace();
		}
		a.clear();
		return connection;
	}

	private Connection createConnection2(String user, String pass) throws SQLException {
		Connection connection = null;
		connection = DriverManager.getConnection(DBURL, user, pass);
		return connection;
	}

    public static HikariDataSource dataSource(String user, String pass) {
        HikariDataSource ds = new HikariDataSource();
        ds.setPoolName("springHikariCP");
        ds.setMaximumPoolSize(20);
        ds.setLeakDetectionThreshold(5000);
        ds.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
        ds.addDataSourceProperty("url", DBURL);
        ds.addDataSourceProperty("user", user);
        ds.addDataSourceProperty("password", pass);
        ds.addDataSourceProperty("cachePrepStmts", true);
        ds.addDataSourceProperty("prepStmtCacheSize", 250);
        ds.addDataSourceProperty("prepStmtCacheSqlLimit", 2048);
        ds.addDataSourceProperty("useServerPrepStmts", true);
        ds.addDataSourceProperty("verifyServerCertificate", false);
        ds.addDataSourceProperty("useSSL", true);
        ds.addDataSourceProperty("requireSSL", true);

        return ds;
    }

    public static void close(HikariDataSource connection){
	    connection.close();
    }

	public static Connection getConnection() {
		return singleInstance.createConnection();
	}

	public static Connection getConnection2(String user,String pass) throws SQLException {
		return singleInstance.createConnection2(user, pass);
	}

	public static void close(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "An error occured while trying to close the connection");
			}
		}
	}

	public static void close(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "An error occured while trying to close the statement");
			}
		}
	}

	public static void close(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "An error occured while trying to close the ResultSet");
			}
		}
	}

	public static boolean verifyLogInConditionsAsAdministrator(String email, String password) {
		if ((email.equals("admin@yahoo.com") && (password.equals("12345")))) {
			return true;
		}
		return false;
	}
}
