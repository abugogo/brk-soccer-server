package com.soccer.dal.api;

import com.soccer.entities.IDAOUser;

public interface IUsersAPI {
	public IDAOUser getUser(String u, String p);
	public int createUser(IDAOUser u, String salt);
	public String getUserSalt(String u);
	public String getUserPassword(String u);
	public boolean isUserExists(String id);
}
