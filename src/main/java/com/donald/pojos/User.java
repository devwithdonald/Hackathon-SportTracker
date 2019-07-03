package com.donald.pojos;

public class User {
	

	private Integer userId;
	private String username;
	private String password;
	private Boolean adminCheck;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer userId, String username, String password, Boolean adminCheck) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.adminCheck = adminCheck;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getAdminCheck() {
		return adminCheck;
	}

	public void setAdminCheck(Boolean adminCheck) {
		this.adminCheck = adminCheck;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adminCheck == null) ? 0 : adminCheck.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (adminCheck == null) {
			if (other.adminCheck != null)
				return false;
		} else if (!adminCheck.equals(other.adminCheck))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", adminCheck="
				+ adminCheck + "]";
	}
	
	
	

}
