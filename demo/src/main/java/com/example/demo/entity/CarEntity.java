package com.example.demo.entity;

import java.util.Objects;
//import java.time.Zone
import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.enums.EngineType;

@Entity
@Table(name="Cars")
public class CarEntity {

	
	@Id
	@GeneratedValue
	private Long id;
	
	@DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME)
//	private ZoneDateTime date_Created=ZoneDateTime.now();
	
	
  private String license_plate;
  
  private Integer seat_count;
  
  private Boolean convertible;
  
  private Integer rating;
  
  @Enumerated(EnumType.STRING)
  private Enum<EngineType> engineType;
  
  private String manufacturer;
  
  @OneToOne(mappedBy= "car",fetch=FetchType.LAZY)
  private DriverEntity driverEntity;
  

public DriverEntity getDriverEntity() {
	return driverEntity;
}

public void setDriverEntity(DriverEntity driverEntity) {
	this.driverEntity = driverEntity;
}

public CarEntity() {
}

public CarEntity(String license_plate, Integer seat_count, Boolean convertible, Integer rating,
		Enum<EngineType> engineType, String manufacturer) {
	super();
	this.license_plate = license_plate;
	this.seat_count = seat_count;
	this.convertible = convertible;
	this.rating = rating;
	this.engineType = engineType;
	this.manufacturer = manufacturer;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getLicense_plate() {
	return license_plate;
}

public void setLicense_plate(String license_plate) {
	this.license_plate = license_plate;
}

public Integer getSeat_count() {
	return seat_count;
}

public void setSeat_count(Integer seat_count) {
	this.seat_count = seat_count;
}

public Boolean getConvertible() {
	return convertible;
}

public void setConvertible(Boolean convertible) {
	this.convertible = convertible;
}

public Integer getRating() {
	return rating;
}

public void setRating(Integer rating) {
	this.rating = rating;
}

public Enum<EngineType> getEngineType() {
	return engineType;
}

public void setEngineType(Enum<EngineType> engineType) {
	this.engineType = engineType;
}

public String getManufacturer() {
	return manufacturer;
}

public void setManufacturer(String manufacturer) {
	this.manufacturer = manufacturer;
}

@Override
public int hashCode() {
	return Objects.hash(convertible, id, license_plate, manufacturer, rating, seat_count);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	CarEntity other = (CarEntity) obj;
	return Objects.equals(convertible, other.convertible) && Objects.equals(id, other.id)
			&& Objects.equals(license_plate, other.license_plate) && Objects.equals(manufacturer, other.manufacturer)
			&& Objects.equals(rating, other.rating) && Objects.equals(seat_count, other.seat_count);
}
  
  
	
}
