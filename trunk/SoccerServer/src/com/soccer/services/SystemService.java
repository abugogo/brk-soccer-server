package com.soccer.services;

import java.math.BigInteger;
import java.util.UUID;

import com.soccer.dal.api.IUsersAPI;
import com.soccer.dal.db.SqlDBDal;
import com.soccer.entities.IDAOUser;

public class SystemService implements IUsersAPI {
	private static SystemService instance = null;
	IUsersAPI usersApi = SqlDBDal.getInst();
	
	public static SystemService getInstance() {
		synchronized (SystemService.class) {
			if (instance == null) {
				instance = new SystemService();
			}
		}
		
		return instance;
	}
	
	private SystemService() {
	}
	
	
	@Override
	public IDAOUser getUser(String u, String p) {
		return this.usersApi.getUser(u, p);
	}
	
	@Override
	public int createUser(IDAOUser u, String s) {
		//anomaly - salt (business logic) should be generated here (API forces to send it by the caller)
		String salt = UUID.randomUUID().toString();
		return this.usersApi.createUser(u, salt);
	}

	@Override
	public String getUserSalt(String u) {
		return this.usersApi.getUserSalt(u);
	}

	@Override
	public String getUserPassword(String u) {
		return this.usersApi.getUserPassword(u);
	}

}
