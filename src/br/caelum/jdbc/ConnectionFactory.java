package br.caelum.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			// essa linha pode resolver o problema
			return DriverManager.getConnection("jdbc:mysql://localhost/fj28", "root", "");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
