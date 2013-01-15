package com.soccer.entities;

import java.util.Date;

import com.soccer.entities.impl.DAOPosition;


/**
 * The persistent class for the players database table.
 * 
 */
public interface IDAOPlayer {
	public String getId();
	public void setId(String id);
	public boolean isActive();
	public void setActive(boolean active);
	public String getAddress1() ;
	public void setAddress1(String address1);
	public String getAddress2() ;
	public void setAddress2(String address2) ;
	public Date getBday() ;
	public void setBday(Date bday);
	public String getDescription();
	public void setDescription(String description);
	public String getEmail();
	public void setEmail(String email);
	public String getFbUser();
	public void setFbUser(String fbUser);
	public String getFname();
	public void setFname(String fname);
	public String getLname();
	public void setLname(String lname);
	public String getOccupation();
	public void setOccupation(String occupation);
	public String getP_img();
	public void setP_img(String p_img);
	public String getTel1(); 
	public void setTel1(String tel1);
    public String getTel2();
	public void setTel2(String tel2);
	public IDAOPosition getPositionBean();
	public void setPositionBean(DAOPosition positionBean);
	public boolean isAdmin();
	public boolean setAdmin(boolean val);
}