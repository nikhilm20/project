package com.nk.springproject.entity;

import java.util.Arrays;
import java.util.Base64;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contacts")
public class Contacts {

	public Contacts() {
	
	}

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idcontacts")
	private int id;
	
	@Column(name="image")
	private  byte[] image;
	
	@Column(name="firstname")
	private String firstName;
	
	@Column(name="lastname")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="phoneno")
	private String phoneno;
	
	@Column(name="stringphoto")
	public String stringPhoto;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	 public String getStringPhoto() {
	        return convertBinImageToString(image);
	    }

	    public static String convertBinImageToString(byte[] image) {
	    	if(image!=null && image.length>0) {
	            return Base64.getEncoder().encodeToString(image);
	        }
	        else
	            return "";
	    }
	

		public void setStringPhoto(String stringPhoto) {
	        this.stringPhoto = stringPhoto;
	    }

	@Override
	public String toString() {
		return "Contacts [id=" + id + ", image=" + Arrays.toString(image) + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", phoneno=" + phoneno + "]";
	}

	
		
}





