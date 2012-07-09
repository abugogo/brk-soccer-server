package com.soccer.entities;

import java.net.URL;


//import android.graphics.Bitmap;

public class Player {

	private String id;
	private String firstName;
	private String lastName;
	private String occupation;
	private String facebookPage;

	public Player() {
		
	}

	public Player(String id, String firstName, String lastName, String occupation, String facebookPage) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setOccupation(occupation); 
		setFacebookPage(facebookPage);
	}

	public void setId(String newId) {
		// TODO Auto-generated method stub
		id = newId;
	}

	public String getId() {
		return "" + id;
	}

	public void setFirstName(String newName) {
		// TODO Auto-generated method stub
		firstName = newName;
	}

	public String getFirstName() {
		return "" + firstName;
	}

	public void setLastName(String newName) {
		// TODO Auto-generated method stub
		lastName = newName;
	}

	public String getLastName() {
		return "" + lastName;
	}

	public void setOccupation(String newOccupation) {
		// TODO Auto-generated method stub
		occupation = newOccupation;
	}

	public String getOccupation() {
		return "" + occupation;
	}

/*	public void SetContacts(List<String> newContacts) {
		// TODO Auto-generated method stub
		contacts = newContacts;
	}

	public List<String> GetContacts() {
		return contacts;
	}*/

	public void setFacebookPage(String newFacebookPage) {
		// TODO Auto-generated method stub
		facebookPage = newFacebookPage;
	}

	public String getFacebookPage() {
		return "" + facebookPage;
	}

	/*
	 * public void SetProfilePic(Bitmap newProfilePic) { // TODO Auto-generated
	 * method stub profilePic = newProfilePic; }
	 * 
	 * public Bitmap GetProfilePic(){ return profilePic; }
	 */

	public void AddPicture(URL newPpicture) {
		// TODO Auto-generated method stub
		//pictures.add(newPpicture);
	}

	// public URL RemovePicture( URL picture ){
	// }
}
