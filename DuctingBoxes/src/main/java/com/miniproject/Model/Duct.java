package com.miniproject.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Duct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int dId;
	private String dName;
	private long dLatitude;
	private long dLongitude;
	public int getdId() {
		return dId;
	}
	public void setdId(int dId) {
		this.dId = dId;
	}
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public long getdLatitude() {
		return dLatitude;
	}
	public void setdLatitude(long dLatitude) {
		this.dLatitude = dLatitude;
	}
	public long getdLongitude() {
		return dLongitude;
	}
	public void setdLongitude(long dLongitude) {
		this.dLongitude = dLongitude;
	}
	@Override
	public String toString() {
		return "Duct [dId=" + dId + ", dName=" + dName + ", dLatitude=" + dLatitude + ", dLongitude=" + dLongitude
				+ "]";
	}
	
}
