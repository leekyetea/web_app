package org.study.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.study.model.Application;
import org.study.model.Semester;

public class ApplyDao {

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
	
	
	/*
	 * 1 --> success
	 * -1 --> general failure
	 * -99 --> 이미 지원을 한 상황
	 * 
	 */
	public int submitApplication(Application application) {
		Connection conn = getConnection();
		PreparedStatement ps0 = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result;
		
		if (conn != null && application != null) {
			String preSql = "select * from hd_application " + 
					" where userId=? and major=? and semester=?";
			
			String sql = "insert into hd_application (userId, major, semester, applyDesc) " + 
					"values (?, ?, ?, ?)";
			try {
				ps0 = conn.prepareStatement(preSql);
				ps0.setString(1, application.getUserId());
				ps0.setString(2, application.getMajor());
				ps0.setString(3,application.getSemester().name());
				
				rs = ps0.executeQuery();
				
				if (rs.next()) {
					return -99;
				}
				
				ps = conn.prepareStatement(sql);
				ps.setString(1, application.getUserId());
				ps.setString(2, application.getMajor());
				ps.setString(3, application.getSemester().name());
				ps.setString(4, application.getApplyDesc().trim());
				
				result = ps.executeUpdate();
				
				if (result == 0) {
					return -1;
				} else {
					return 1;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {		
				if (ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if (ps0 != null) {
					try {
						ps0.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if (rs != null) {
					try {
						rs.close();
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
			
		return -1;
	}
	
	public Application[] getApplications(String userId) {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		if (conn != null) {			
			String sql = "select * from hd_application" + 
					" where userid=?";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, userId);
				
				rs = ps.executeQuery();
				
				List<Application> list = new ArrayList<>();
				while (rs.next()) {
					Application application = new Application(userId);
					
					application.setMajor(rs.getString(2));
					application.setSemester(Semester.getSemester(rs.getString(3)));
					application.setApplyDesc(rs.getString(4));
					
					list.add(application);
				}
				
				return list.toArray(new Application[0]);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {		
				if (ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				if (rs != null) {
					try {
						rs.close();
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
}
