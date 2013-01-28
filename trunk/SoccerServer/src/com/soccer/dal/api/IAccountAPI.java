package com.soccer.dal.api;


public interface IAccountAPI {
	public boolean isUserInAccount(String uid, String acc);
	public void setUserInAccount(String uid);
}
