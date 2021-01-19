package edu.Itaca.Practica1AD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	static Connection connection;
	private ConnectionFactory() {
		
	}
	public Connection getConnection() throws SQLException{
		if(connection==null) {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jardineria?serverTimezone=UTC", "root",
					"admin");
		}
		return connection;
	}
}
