package com.bilgeadam.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "msi")
public class MsiEntity extends Computer {
	private static final long serialVersionUID = 6425716224908810585L;
	
	private String msiSupport;
	
	// parametreli constrctor
	public MsiEntity() {
		
	}
	
	// parametreli constructor
	public MsiEntity(String ram, String cpu, String msiSupport) {
		super(ram, cpu);
		this.msiSupport = msiSupport;
	}
	
	// getter and setter
	public String getMsiSupport() {
		return msiSupport;
	}
	
	public void setMsiSupport(String msiSupport) {
		this.msiSupport = msiSupport;
	}
	
}
