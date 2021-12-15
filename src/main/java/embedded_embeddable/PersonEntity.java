package embedded_embeddable;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "person")
public class PersonEntity implements Serializable {
	private static final long serialVersionUID = -6500045511947748635L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "person_id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "middle_name")
	private String middleName;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "tc_number")
	private String tcNumber;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name = "email_address")
	private String emailAddres;
	
	@Column(name = "created_date")
	@Temporal(value = TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createdDate;
	
	// Embedded
	@Embedded
	private Address address;
	
	// getter and setter
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public String getTcNumber() {
		return tcNumber;
	}
	
	public void setTcNumber(String tcNumber) {
		this.tcNumber = tcNumber;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmailAddres() {
		return emailAddres;
	}
	
	public void setEmailAddres(String emailAddres) {
		this.emailAddres = emailAddres;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
