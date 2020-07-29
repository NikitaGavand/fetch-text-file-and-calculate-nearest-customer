package com.intercom.home.assignment.bean;

/**
 * 
 * @author nikita gavand 
 * Records all the list of customer in a bean format
 *
 */
public class Customer implements Comparable<Customer> {

	String name;
	int user_id;
	double longitude;
	double latitude;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public Customer() {
		super();
	}

	/**
	 * Parameterised constructor
	 * 
	 * @param name
	 * @param user_id
	 * @param longitude
	 * @param latitude
	 */
	public Customer(String name, int user_id, double longitude, double latitude) {
		super();
		this.name = name;
		this.user_id = user_id;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	/**
	 * toString method to understand if the objects has filled data
	 */
	@Override
	public String toString() {
		return "Customer [name=" + name + ", user_id=" + user_id + ", longitude=" + longitude + ", latitude=" + latitude
				+ "]";
	}

	/**
	 * Used to sort the list of customer according to the user_id
	 */
	@Override
	public int compareTo(Customer customer) {
		int user_id = ((Customer) customer).getUser_id();
		/* Ascending order */
		return this.user_id - user_id;
	}

}
