package com.bbva.models.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.bbva.model.Bill;
import com.bbva.utils.Conexion;

public class BillDAO {
	
	Conexion conexion;
	
	private static final String INSERT_BILL = "INSERT INTO bill (date, value, type, observation) VALUES (?, ?, ?, ?);";
	private static final String DELETE_BILL = "DELETE FROM bill WHERE id = ?;";
	private static final String SELECT_BILL_BY_ID = "SELECT * FROM bill WHERE id = ?;";
	private static final String SELECT_ALL_BILLS = "SELECT * FROM bill;";
	
	public boolean insert(Bill bill) throws SQLException{
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(INSERT_BILL);
			preparedStatement.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
			preparedStatement.setInt(2, bill.getValue());
			preparedStatement.setInt(3, bill.getType());
			preparedStatement.setString(4, bill.getObservation());
			conexion.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	} 
	
	public boolean delete(int id) {
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(DELETE_BILL);
			preparedStatement.setInt(1, id);
			conexion.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public Bill getOneBill(int id) {
		Bill bill = null; 
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_BILL_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet rs = conexion.query();
			while(rs.next()) {
				bill = new Bill(rs.getInt("id"), rs.getDate("date_bill"), null, rs.getInt("value"), rs.getInt("type"), rs.getString("observation"));
			}
			return bill;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Bill> getAllBills() {
		List<Bill> bills = new ArrayList();
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_ALL_BILLS);
			ResultSet rs = conexion.query();
			while(rs.next()) {
				bills.add(new Bill(rs.getInt("id"), rs.getDate("date_bill"), null, rs.getInt("value"), rs.getInt("type"), rs.getString("observation")));
			}
			return bills;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
