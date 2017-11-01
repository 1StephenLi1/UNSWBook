package unswbook.beans;

import java.util.Calendar;

public class Student {
	private int id;
	private String unswid;
	private String username;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private String dateOfBirth;
	private boolean banned;
	private boolean verified;
	private String gender;
	private boolean admin;
	private Calendar applyTime;
	
	
	
	
	
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUnswid() {
		return unswid;
	}
	public void setUnswid(String unswid) {
		this.unswid = unswid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public boolean isBanned() {
		return banned;
	}
	public void setBanned(boolean banned) {
		this.banned = banned;
	}
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	public Calendar getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Calendar applyTime) {
		this.applyTime = applyTime;
	}
	
	
}
