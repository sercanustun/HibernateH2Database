package com.bilgeadam.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "login")
@EntityListeners(LoginEntity.class)

public class LoginEntity implements Serializable {
	private static final long serialVersionUID = -1669631692666926083L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "login_id", updatable = false)
	private int id;
	
	@Column(name = "email")
	private String userEmail;
	
	@Column(name = "password")
	private String userPassword;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "created_date")
	private Date date;
	
	// ekleme yaparken validation
	@PreUpdate
	@PreRemove
	@PrePersist
	public void loginNotNull() {
		if (userEmail.equals("") || (userEmail == null) || userPassword.equals("") || (userPassword == null)) {
			System.out.println("HATAAAAAA: ");
			this.userEmail = "email boş geçilemez";
			this.userPassword = "şifre boş geçilemez";
		}
	}
	
	public LoginEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public LoginEntity(String userEmail, String userPassword) {
		super();
		this.userEmail = userEmail;
		this.userPassword = userPassword;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}