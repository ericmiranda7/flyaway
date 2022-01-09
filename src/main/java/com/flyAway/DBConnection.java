package com.flyAway;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private Connection conn;

	public DBConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flyaway", "root", "msqlpass");
	}

	public Connection getConnection() {
		return this.conn;
	}

	public void closeConnection() throws SQLException {
		this.conn.close();
	}
}
