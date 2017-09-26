package com.tracktopell.testarch4.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alfredo.estrada
 */
public class Person implements Serializable{	
	private Integer id;
	private String name;
	private String surname;
	private Address address;
	private List<PhoneNumber> phoneList;

	/**
	 * 
	 */
	public Person(){
		this.id = (int)System.currentTimeMillis();
		this.name = null;
		this.surname = null;
		this.address = new Address();
		this.phoneList = new ArrayList<>();
	}
	/**
	 * 
	 * @param name
	 * @param surname
	 * @param address
	 * @param phoneList 
	 */
	public Person(String name, String surname, Address address, List<PhoneNumber> phoneList) {
		this.id = (int)System.currentTimeMillis();
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phoneList = phoneList;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * set the id
	 * @param id 
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the phoneList
	 */
	public List<PhoneNumber> getPhoneList() {
		return phoneList;
	}

	/**
	 * @param phoneList the phoneList to set
	 */
	public void setPhoneList(List<PhoneNumber> phoneList) {
		this.phoneList = phoneList;
	}	

	@Override
	public String toString() {
		return name+" "+surname+", Address:"+address+", PhoneList:"+phoneList;
	}
	
	
}
