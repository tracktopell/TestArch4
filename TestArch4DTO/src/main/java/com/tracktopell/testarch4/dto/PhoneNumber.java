package com.tracktopell.testarch4.dto;

import java.io.Serializable;

/**
 *
 * @author alfredo.estrada
 */
public class PhoneNumber  implements Serializable{

	private String type;
	private String number;

	/**
	 * 
	 */
	public PhoneNumber() {
		type	= null;
		number  = null;
	}
	
	/**
	 * 
	 * @param type
	 * @param number 
	 */
	public PhoneNumber(String type, String number) {
		this.type = type;
		this.number = number;
	}
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "["+type+"]"+number;
	}
	
	
}