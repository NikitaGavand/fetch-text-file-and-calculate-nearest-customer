package com.intercom.home.assignment.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Logger;

import com.google.gson.Gson;
import com.intercom.home.assignment.bean.Customer;
import com.intercom.home.assignment.exception.CustomerException;

/**
 * 
 * @author nikita gavand CustomerService gives Customer List which comes in 100
 *         kms radius and stores in the text file
 *
 */
public class CustomerService {
	/**
	 * 
	 * @param pathFile  is the file URL
	 * @param latitude  of Dublin Office
	 * @param longitude of Dublin Office
	 * @throws CustomerException
	 * @throws IOException
	 */
	public StringWriter getListOfCustomerInGivenRadius(String pathFile, double latitude, double longitude)
			throws CustomerException, IOException {

		if (pathFile == null || pathFile.equals("")) {
			throw new CustomerException("Path is invalid");
		}
		URL url = new URL(pathFile);

		BufferedReader read = new BufferedReader(new InputStreamReader(url.openStream()));

		ArrayList<Customer> customer = new ArrayList<Customer>();
		StringWriter stringWriter = readCustomerFiles(read, customer, latitude, longitude);
		read.close();
		return stringWriter;
	}

	/**
	 * Reads the customer details from the text file given
	 * 
	 * @param bufferedReader helps to read the json objects line by line
	 * @param bufferedWriter helps to write the json objects line by line
	 * @param customer       new array to be filled
	 * @throws IOException if there is a failure while reading or writing into text
	 *                     file
	 */
	public StringWriter readCustomerFiles(BufferedReader bufferedReader, ArrayList<Customer> customer, double latitude,
			double longitude) throws IOException {
		String line = null;
		while ((line = bufferedReader.readLine()) != null) {
			Gson gson = new Gson();

			// convert JSON string to User object
			Customer user = gson.fromJson(line, Customer.class);
			// print user object
			double distance = calculateDistance(user.getLatitude(), user.getLongitude(), latitude, longitude);

			// fetches the customer whose distance is less than 100 kms.
			if (distance < 100) {
				customer.add(user);
			}
		}
		return writeFile(customer);

	}

	/**
	 * Calculates the distance between the dublin office and the customer location
	 * 
	 * @param latitude   of the customer
	 * @param longitude  of the customer
	 * @param latitude2  of the Dublin Office
	 * @param longitude2 of the Dublin Office
	 * @return the distance between the two points
	 */
	public double calculateDistance(double latitude, double longitude, double latitude2, double longitude2) {
		// Radius of the Earth
		final double R = 6378.137;
		// Converting all the values into radians
		double lon1 = Math.toRadians(longitude2);
		double lon2 = Math.toRadians(longitude);
		double lat1 = Math.toRadians(latitude2);
		double lat2 = Math.toRadians(latitude);

		// formula to calculate the distance
		double dlon = lon2 - lon1;
		double dlat = lat2 - lat1;
		double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2), 2);

		double c = 2 * Math.asin(Math.sqrt(a));

		// calculate the result
		return (c * R);
	}

	/**
	 * This function writes the customers which are nearest to dublin in output.txt
	 * file
	 * 
	 * @param customers      lists
	 * @param bufferedWriter to write in the text file
	 * @throws IOException if there is a failure while writing into text file
	 */
	public StringWriter writeFile(ArrayList<Customer> customers) throws IOException {
		if (!(customers == null || customers.isEmpty())) {
			Collections.sort(customers);
			StringWriter str = new StringWriter();
			// writes the data to the stringwriter
			for (Customer customer : customers) {
				str.append("UserId: " + customer.getUser_id() + " ");
				str.append("Customer Name: " + customer.getName() + " ");
				str.append("\n");
			}
			return str;
		}
		return null;
	}
}