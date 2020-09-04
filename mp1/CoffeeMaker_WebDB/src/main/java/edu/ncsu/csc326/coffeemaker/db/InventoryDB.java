package edu.ncsu.csc326.coffeemaker.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.ncsu.csc326.coffeemaker.Inventory;
import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;

public class InventoryDB {
	
	public static void setInventory(int uCoffee, int uMilk, int uSugar, int uChocolate) {
		DBConnection db = new DBConnection();
		Connection conn = null;
		PreparedStatement stmt1 = null;
		PreparedStatement stmt2 = null;
		try {
			conn = db.getConnection();
			stmt1 = conn.prepareStatement("DELETE FROM inventory");
			stmt2 = conn.prepareStatement("INSERT IGNORE INTO inventory VALUES(?,?,?,?)");
			stmt2.setInt(1, uCoffee);
			stmt2.setInt(2, uMilk);
			stmt2.setInt(3, uSugar);
			stmt2.setInt(4, uChocolate);
			stmt1.executeUpdate();
			stmt2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn, stmt1);
			DBConnection.closeConnection(conn, stmt2);
		}
	}

	public static int getChocolate() {
		DBConnection db = new DBConnection();
		Connection conn = null;
		PreparedStatement stmt = null;
		int a = 0;
		try {
			conn = db.getConnection();
			stmt = conn.prepareStatement("SELECT chocolate FROM inventory");
			ResultSet rs = stmt.executeQuery();
			rs.next();
			a = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn, stmt);
		}
		return a;
	}

	public static int getCoffee() {
		DBConnection db = new DBConnection();
		Connection conn = null;
		PreparedStatement stmt = null;
		int a = 0;
		try {
			conn = db.getConnection();
			stmt = conn.prepareStatement("SELECT coffee FROM inventory");
			ResultSet rs = stmt.executeQuery();
			rs.next();
			a = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn, stmt);
		}
		return a;
	}

	public static int getMilk() {
		DBConnection db = new DBConnection();
		Connection conn = null;
		PreparedStatement stmt = null;
		int a = 0;
		try {
			conn = db.getConnection();
			stmt = conn.prepareStatement("SELECT milk FROM inventory");
			ResultSet rs = stmt.executeQuery();
			rs.next();
			a = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn, stmt);
		}
		return a;
	}

	public static int getSugar() {
		DBConnection db = new DBConnection();
		Connection conn = null;
		PreparedStatement stmt = null;
		int a = 1;
		try {
			conn = db.getConnection();
			stmt = conn.prepareStatement("SELECT sugar FROM inventory");
			ResultSet rs = stmt.executeQuery();
			rs.next();
			a = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn, stmt);
		}
		return a;
	}

	public static void setChocolate(int uChocolate) {
		DBConnection db = new DBConnection();
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = db.getConnection();
			stmt = conn.prepareStatement("UPDATE inventory SET chocolate=?");
			stmt.setInt(1, uChocolate);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn, stmt);
		}
	}	

	public static void setCoffee(int uCoffee) {
		DBConnection db = new DBConnection();
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = db.getConnection();
			stmt = conn.prepareStatement("UPDATE inventory SET coffee=?");
			stmt.setInt(1, uCoffee);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn, stmt);
		}
	}	

	public static void setSugar(int uSugar) {
		DBConnection db = new DBConnection();
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = db.getConnection();
			stmt = conn.prepareStatement("UPDATE inventory SET sugar=?");
			stmt.setInt(1, uSugar);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn, stmt);
		}
	}	

	public static void setMilk(int uMilk) {
		DBConnection db = new DBConnection();
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = db.getConnection();
			stmt = conn.prepareStatement("UPDATE inventory SET milk=?");
			stmt.setInt(1, uMilk);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn, stmt);
		}
	}	

	public static void addInventory(String uCoffee, String uMilk, String uSugar, String uChocolate) {
		DBConnection db = new DBConnection();
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = db.getConnection();
			String query = "SELECT * FROM inventory";
			ResultSet rs = stmt.executeQuery(query);
			int a = Integer.valueOf(uCoffee) + rs.getInt("coffee");
			int b = Integer.valueOf(uMilk) + rs.getInt("milk");
			int c = Integer.valueOf(uSugar) + rs.getInt("sugar");
			int d = Integer.valueOf(uChocolate) + rs.getInt("chocolate");

			stmt = conn.prepareStatement("UPDATE inventory SET coffee=?, milk=?, sugar=?, chocolate=?");
			stmt.setInt(1, a);
			stmt.setInt(2, b);
			stmt.setInt(3, c);
			stmt.setInt(4, d);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn, stmt);
		}
	}

	public static void useInventory(String uCoffee, String uMilk, String uSugar, String uChocolate) {
		DBConnection db = new DBConnection();
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = db.getConnection();
			String query = "SELECT * FROM inventory";
			ResultSet rs = stmt.executeQuery(query);
			int a = rs.getInt("coffee") - Integer.valueOf(uCoffee);
			int b = rs.getInt("milk") - Integer.valueOf(uMilk);
			int c = rs.getInt("sugar") - Integer.valueOf(uSugar);
			int d = rs.getInt("chocolate") - Integer.valueOf(uChocolate);

			stmt = conn.prepareStatement("UPDATE inventory SET coffee=?, milk=?, sugar=?, chocolate=?");
			stmt.setInt(1, a);
			stmt.setInt(2, b);
			stmt.setInt(3, c);
			stmt.setInt(4, d);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.closeConnection(conn, stmt);
		}
	}

	public static void checkInventory() {
		PreparedStatement stmt = null;
		try {
			String query = "SELECT * FROM inventory";
			ResultSet rs = stmt.executeQuery(query);
			int a = rs.getInt(1);
			int b = rs.getInt(2);
			int c = rs.getInt(3);
			int d = rs.getInt(4);
			System.out.println("Coffee: " + a + "Milk: " + b + "Sugar: " + c + "Chocolate: " + d);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DBConnection.closeConnection(conn, stmt);
		}
	}

}
