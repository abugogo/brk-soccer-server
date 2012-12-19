package com.soccer.entities.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import com.soccer.entities.IDAOPlayer;
import com.soccer.entities.IDAOPosition;


/**
 * The persistent class for the players database table.
 * 
 */
public class DAOPlayer implements Serializable, IDAOPlayer {
	private static final long serialVersionUID = 1L;
	private DAOUser user;
	private byte[] active;
	private String description;
	private DAOPosition positionBean;

    public DAOPlayer() {
    	user = new DAOUser();
    }

    public DAOPlayer(HashMap<String, Object> columns) {
    	user = new DAOUser();
    	setPlayer(columns);
    }

	private void setPlayer(HashMap<String, Object> columns) {
		this.setId("" + columns.get("id"));
		this.setFname((String) columns.get("fname"));
		this.setLname((String) columns.get("lname"));
		this.setPositionBean(new DAOPosition());
		this.setTel1("" + columns.get("tel1"));
		this.setTel2("" + columns.get("tel2"));
		this.setEmail("" + columns.get("email"));
		this.setBday((Date)columns.get("bday"));
		this.setFbUser((String) columns.get("fb_user"));
		this.setOccupation("" + columns.get("occupation"));
		this.setAddress1("" + columns.get("address1"));
		this.setAddress2("" + columns.get("address2"));
		this.setDescription("" + columns.get("description"));
		this.setP_img(null);
		this.setActive(null);
	}

	public String getId() {
		return this.user.getId().toString();
	}

	public void setId(String id) {
		this.user.setId(new BigInteger(id));
	}


	public byte[] getActive() {
		return this.active;
	}

	public void setActive(byte[] active) {
		this.active = active;
	}


    public String getAddress1() {
		return this.user.getAddress1();
	}

	public void setAddress1(String address1) {
		this.user.setAddress1(address1);
	}


    public String getAddress2() {
		return this.user.getAddress2();
	}

	public void setAddress2(String address2) {
		this.user.setAddress2(address2);
	}


    public Date getBday() {
		return this.user.getBday();
	}

    public String getBdayAsString(String format) {
    	String retStr = "";
    	if(this.user.getBday() != null) {
    		Calendar cal = Calendar.getInstance();
    		cal.setTime(this.user.getBday());
            int day = cal.get(Calendar.DAY_OF_MONTH);
            int month = cal.get(Calendar.MONTH) + 1;
            int year = cal.get(Calendar.YEAR);
    		retStr = day + "." + month + "." + year;
    	}
		return retStr;
	}
    
	public void setBday(Date bday) {
		this.user.setBday(bday);
	}


    public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


    public String getEmail() {
		return this.user.getEmail();
	}

	public void setEmail(String email) {
		this.user.setEmail(email);
	}


	public String getFbUser() {
		return this.user.getFbUser();
	}

	public void setFbUser(String fbUser) {
		this.user.setFbUser(fbUser);
	}


    public String getFname() {
		return this.user.getFname();
	}

	public void setFname(String fname) {
		this.user.setFname(fname);
	}

    public String getLname() {
		return this.user.getLname();
	}

	public void setLname(String lname) {
		this.user.setLname(lname);
	}


    public String getOccupation() {
		return this.user.getOccupation();
	}

	public void setOccupation(String occupation) {
		this.user.setOccupation(occupation);
	}


    public String getP_img() {
		return this.user.getP_img();
	}

	public void setP_img(String p_img) {
		this.user.setP_img(p_img);
	}


    public String getTel1() {
		return this.user.getTel1();
	}

	public void setTel1(String tel1) {
		this.user.setTel1(tel1);
	}


    public String getTel2() {
		return this.user.getTel2();
	}

	public void setTel2(String tel2) {
		this.user.setTel2(tel2);
	}

	public IDAOPosition getPositionBean() {
		return this.positionBean;
	}

	public void setPositionBean(DAOPosition positionBean) {
		this.positionBean = positionBean;
	}
}