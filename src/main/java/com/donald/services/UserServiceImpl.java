package com.donald.services;

import com.donald.dao.UserDAOImpl;
import com.donald.pojos.User;

public class UserServiceImpl implements UserServiceInt{
	
	private static UserDAOImpl udi = new UserDAOImpl();

	@Override
	public User loginUser(String username, String password) {
		User user = null;

		
		for(User userCheck : udi.getAllUsers()) {
			if(userCheck.getUsername().equals(username) && userCheck.getPassword().equals(password)) {
				user = userCheck;
				break;
			}
		}
		
		return user;
	}

}
