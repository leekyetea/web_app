package org.study.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.study.model.Member;

public class MemberDao {

	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "shop_admin";
	private static final String PW = "1234";
	
	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			return DriverManager.getConnection(URL, USER, PW);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	// 회원정보를 받아 Member table에 해당 정보를 저장
	public boolean insertMember(Member member) {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		
		if (conn != null && member != null) {
			String sql = "insert into member (id, name, dob, email)" + 
					" values (?, ?, ?, ?)";
			try {
				ps = conn.prepareStatement(sql);
				ps.setString(1, member.getId());
				ps.setString(2, member.getName());
				ps.setDate(3, member.getDob());
				ps.setString(4, member.getEmail());
				
				int result = ps.executeUpdate();
				
				if (result == 0) {
					return false;
				} else {
					return true;
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
				
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return false;
	}
}
