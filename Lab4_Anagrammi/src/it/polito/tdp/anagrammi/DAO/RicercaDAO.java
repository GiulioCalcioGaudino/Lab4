package it.polito.tdp.anagrammi.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;



import it.polito.tdp.anagrammi.model.Parola;

public class RicercaDAO {

	public List<Parola> cerca (List<String> parole){
		List<Parola> paroleCercate= new ArrayList<Parola>();
		
		try{
		String jdbcURL = "jdbc:mysql://localhost/dizionario?user=root";

		for(String s: parole){
			//Connection conn = DBConnect.getConnection();
			Connection conn = DriverManager.getConnection(jdbcURL);
			String sql= "select nome from parola where nome = ?";
			PreparedStatement st = conn.prepareStatement(sql);
				
				st.setString(1, s);
				
				ResultSet rs = st.executeQuery();
				
				if(rs.next()){
					conn.close();
					rs.close();
					paroleCercate.add(new Parola(s,true));
				}
				else{
					conn.close();
					rs.close();
					paroleCercate.add(new Parola(s,false));
				}}
			}catch (SQLException e){
				e.printStackTrace();
			
			
		}
		return paroleCercate;
	}
	
}
