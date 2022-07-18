package com.example.demo.entity;

import java.util.Objects;

import javax.persistence.*;

import com.example.demo.enums.OnlineStatus;

@Entity
@Table(name="driver")
public class DriverEntity {

	
@Id
@GeneratedValue
private Long driverId;

private String userName;

private String password;

private Integer carIdSelect;

@Enumerated(EnumType.STRING)
private OnlineStatus onlineStatus;

@OneToOne(fetch=FetchType.LAZY)
@JoinColumn(name="id")
private CarEntity carEntity;



public CarEntity getCarEntity() {
	return carEntity;
}





public void setCarEntity(CarEntity carEntity) {
	this.carEntity = carEntity;
}





public DriverEntity() {
}





public DriverEntity(Long driverId, String userName, String password, Integer carIdSelect, OnlineStatus onlineStatus) {
	super();
	this.driverId = driverId;
	this.userName = userName;
	this.password = password;
	this.carIdSelect = carIdSelect;
	this.onlineStatus = onlineStatus;
}





public Long getDriverId() {
	return driverId;
}

public void setDriverId(Long driverId) {
	this.driverId = driverId;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public Integer getCarIdSelect() {
	return carIdSelect;
}

public void setCarIdSelect(Integer carIdSelect) {
	this.carIdSelect = carIdSelect;
}

public OnlineStatus getOnlineStatus() {
	return onlineStatus;
}

public void setOnlineStatus(OnlineStatus onlineStatus) {
	this.onlineStatus = onlineStatus;
}





@Override
public int hashCode() {
	return Objects.hash(carIdSelect, driverId, password, userName);
}





@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	DriverEntity other = (DriverEntity) obj;
	return Objects.equals(carIdSelect, other.carIdSelect) && Objects.equals(driverId, other.driverId)
			&& Objects.equals(password, other.password) && Objects.equals(userName, other.userName);
}




}
