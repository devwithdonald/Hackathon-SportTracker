package com.donald.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.donald.pojos.User;
import com.donald.util.ConnectionFactory;

public class UserDAOImpl implements UserDAOInt{
	
	private static Connection conn = ConnectionFactory.getConnection();

	@Override
	public List<User> getAllUsers() {
		List<User> userList = new ArrayList<>();
		User user = null;
		
		String sql = "select * from sporttracker_users;";
		
		PreparedStatement pstmt;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setAdminCheck(rs.getBoolean("admin_check"));
				userList.add(user);
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return userList;
	}

	
}
