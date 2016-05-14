package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	private static final String jdbcURL = "jdbs:mysql://localhost/dizionario?user=root";

	public static Connection getConnection(){
		Connection conn;
		try{
		conn = DriverManager.getConnection(jdbcURL);
		return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Errore nella connesiione",e);
		}
	}
	
}
