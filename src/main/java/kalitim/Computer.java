package kalitim;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

// inheritance
// super class Entity table yazmadım
@MappedSuperclass
public class Computer implements Serializable {
	private static final long serialVersionUID = -802487873558411523L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "computer_id", nullable = false)
	private int computerId;
	
	@Column(name = "ram")
	private String ram;
	
	@Column(name = "cpu")
	private String cpu;
	
	@Temporal(value = TemporalType.TIME)
	@CreationTimestamp
	@Column(name = "created_date")
	private Date createdDate;
	
	public Computer() {
		
	}
	
	public Computer(String ram, String cpu) {
		this.ram = ram;
		this.cpu = cpu;
	}
	
	public int getComputerId() {
		return computerId;
	}
	
	public void setComputerId(int computerId) {
		this.computerId = computerId;
	}
	
	public String getRam() {
		return ram;
	}
	
	public void setRam(String ram) {
		this.ram = ram;
	}
	
	public String getCpu() {
		return cpu;
	}
	
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
}
