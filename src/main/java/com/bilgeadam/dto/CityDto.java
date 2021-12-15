package com.bilgeadam.dto;

import java.util.Date;

// pojo
public class CityDto {
	
	private int id;
	private String cityName;
	private String cityLogo;
	private Date date;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCityName() {
		return cityName;
	}
	
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	public String getCityLogo() {
		return cityLogo;
	}
	
	public void setCityLogo(String cityLogo) {
		this.cityLogo = cityLogo;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
}
