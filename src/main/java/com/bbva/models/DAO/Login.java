package com.bbva.models.DAO;
/**
 * User DAO
 */

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bbva.utils.Conexion;

public class Login {
	
	Conexion conexion;
	
	private static final String SELECT_USER_BY_username = "SELECT * FROM user WHERE username = ?;";
	
	public Login(){

		this.conexion=Conexion.getDb();
	}
	
	public boolean validateLogin(String username, String password) throws SQLException{
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_USER_BY_username);
			preparedStatement.setString(1, username);
			
			ResultSet rs = conexion.query();
			System.out.println(password);
			while(rs.next()) {
				if(rs.getString("pass").equals(password)) {
					return true;
				}else return false;
			}
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	
}
