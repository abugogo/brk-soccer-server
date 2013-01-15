package com.soccer.entities;

import java.math.BigInteger;
import java.util.Date;
import java.util.Set;


/**
 * The persistent class for the players database table.
 * 
 */
public interface IDAOUser {
	public String getId();
	public void setId(String id);
	public String getPassword();
	public void setPassword(String pwd);
	public String getAddress1() ;
	public void setAddress1(String address1);
	public String getAddress2() ;
	public void setAddress2(String address2) ;
	public Date getBday() ;
	public void setBday(Date bday);
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
	public Set<String> getAccounts();
	public void addAccount(String accs);
}