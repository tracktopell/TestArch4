package com.tracktopell.testarch4.dto;

import java.io.Serializable;

/**
 *
 * @author alfredo.estrada
 */
public class Address  implements Serializable{
	private String address;
	private String city;
	private String state;

	/**
	 * 
	 */
	public Address() {
	}

	/**
	 * 
	 * @param address
	 * @param city
	 * @param state 
	 */
	public Address(String address, String city, String state) {
		this.address = address;
		this.city = city;
		this.state = state;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}	

	@Override
	public String toString() {
		return address+", "+city+", "+state;
	}
	
	
}