package com.soccer.entities.impl;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.soccer.entities.IDAOUser;

public class DAOUser implements IDAOUser, Serializable  {

	private static final long serialVersionUID = 1L;
	private String address1;
	private String address2;
	private Date bday;
	private String email;
	private String fbUser;
	private String fname;
	private String id;
	private String lname;
	private String occupation;
	private String p_img;
	private String tel1;
	private String tel2;
	private String password;
	Set<String> accounts = null;

	public DAOUser() {
		
	}
	
	public DAOUser(HashMap<String, Object> columns) {
		this.setId("" + columns.get("id"));
		this.setFname((String) columns.get("fname"));
		this.setLname((String) columns.get("lname"));
		this.setTel1("" + columns.get("tel1"));
		this.setTel2("" + columns.get("tel2"));
		this.setEmail("" + columns.get("email"));
		this.setBday((Date)columns.get("bday"));
		this.setFbUser((String) columns.get("fb_user"));
		this.setOccupation("" + columns.get("occupation"));
		this.setAddress1("" + columns.get("address1"));
		this.setAddress2("" + columns.get("address2"));
		this.setP_img(null);		
	}
	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public Date getBday() {
		return bday;
	}

    public String getBdayAsString(String format) {
    	String retStr = "";
    	if(this.getBday() != null) {
    		Calendar cal = Calendar.getInstance();
    		cal.setTime(this.getBday());
            int day = cal.get(Calendar.DAY_OF_MONTH);
            int month = cal.get(Calendar.MONTH) + 1;
            int year = cal.get(Calendar.YEAR);
    		retStr = day + "." + month + "." + year;
    	}
		return retStr;
	}
	public void setBday(Date bday) {
		this.bday = bday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFbUser() {
		return fbUser;
	}

	public void setFbUser(String fbUser) {
		this.fbUser = fbUser;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getP_img() {
		return p_img;
	}

	public void setP_img(String p_img) {
		this.p_img = p_img;
	}

	public String getTel1() {
		return tel1;
	}

	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	public String getTel2() {
		return tel2;
	}

	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pwd) {
		this.password = pwd;
	}

	public Set<String> getAccounts() {
		return accounts;
	}

	public void addAccount(String accs) {
		if (accounts == null)
			accounts = new HashSet<String>();
		accounts.add(accs);
	}
	
	public String getAccount(int pos) {
		String acc = "";
		if(accounts.size()>0) {
			acc = accounts.toArray()[0].toString();
		}
		
		return acc;
	}

}
