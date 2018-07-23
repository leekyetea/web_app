package org.study.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.study.model.User;

public class UserDao {
	private Connection conn;
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "java_tester";
	private static final String PW = "1234";
	
	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(URL, USER, PW);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean addUser(User user) {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		int result;
		
		if (conn != null && user != null) {
			String sql = "insert into hd_user (id, pw, name, dob, email, country) " +
					" values (?, ?, ?, ?, ?, ?)";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, user.getId());
				ps.setString(2, user.getPw());
				ps.setString(3, user.getName());
				ps.setDate(4, user.getDob());
				ps.setString(5, user.getEmail());
				ps.setString(6, user.getCountry().name());
				
				result = ps.executeUpdate();
				
				if (result == 0) {
					return false;
				} else {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
	public User authenticateUser(String id, String pw) {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		if (conn != null) {
			String sql = "select id, pw, name from hd_user where id=? and pw=?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, id);
				ps.setString(2, pw);
				
				rs = ps.executeQuery();
				
				if (rs.next()) {
					String name = rs.getString(3);
					User user = new User();
					user.setId(id);
					user.setPw(pw);
					user.setName(name);
					
					return user;
				} else {
					return null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (rs != null) {
					try {
						rs.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if (ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
			
		return null;
	}
	
	public boolean existUserId(String id) {
		return false;
	}
}
