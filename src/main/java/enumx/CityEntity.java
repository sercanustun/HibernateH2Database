package enumx;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.bilgeadam.util.EColor;

@Entity
@Table(name = "city")
public class CityEntity implements Serializable {
	private static final long serialVersionUID = -1668131692666926083L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "city_id", updatable = false)
	private int id;
	
	@Column(name = "city_name", nullable = false, unique = true)
	private String cityName;
	
	@Column(name = "city_logo")
	private String cityLogo;
	// kırmızı,mavi,yeşil,turuncu : Enum
	
	@Enumerated(value = EnumType.STRING)
	private EColor color;
	
	@Temporal(value = TemporalType.TIMESTAMP)
	@CreationTimestamp
	@Column(name = "created_date", updatable = false)
	private Date date;
	
	// parametresiz constructor
	public CityEntity() {
		
	}
	
	// parametreli constructor
	public CityEntity(String cityName, String cityLogo, EColor color) {
		this.cityName = cityName;
		this.cityLogo = cityLogo;
		this.color = color;
	}
	
	// toString
	@Override
	public String toString() {
		return "City [id=" + id + ", cityName=" + cityName + ", cityLogo=" + cityLogo + ", date=" + date + "]";
	}
	
	// hashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cityLogo == null) ? 0 : cityLogo.hashCode());
		result = prime * result + ((cityName == null) ? 0 : cityName.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CityEntity other = (CityEntity) obj;
		if (cityLogo == null) {
			if (other.cityLogo != null)
				return false;
		} else if (!cityLogo.equals(other.cityLogo))
			return false;
		if (cityName == null) {
			if (other.cityName != null)
				return false;
		} else if (!cityName.equals(other.cityName))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	// getter and setter
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
	
	public EColor getColor() {
		return color;
	}
	
	public void setColor(EColor color) {
		this.color = color;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
