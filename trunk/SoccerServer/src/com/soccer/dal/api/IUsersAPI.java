package com.soccer.dal.api;

import com.soccer.entities.IDAOUser;

public interface IUsersAPI {

	IDAOUser getUser(String u, String p);
	int createUser(IDAOUser u, String salt);
	String getUserSalt(String u);
	String getUserPassword(String u);
}
