package com.intercom.home.assignment.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import com.intercom.home.assignment.bean.Customer;
import com.intercom.home.assignment.service.CustomerService;

/**
 * 
 * @author nikita gavand Test the CustomerListServiceTest Class
 */
public class CustomerListServiceTest {

	/**
	 * Test to get the file not found exception if the file does not exist in the
	 * given location.
	 */
	@Test(expected = FileNotFoundException.class)
	public void shouldgetCustomerInGiven() throws IOException {
		String pathFile = "customer.txt";
		FileReader fileReader;
		fileReader = new FileReader(pathFile);

		CustomerService customerService = new CustomerService();
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		ArrayList<Customer> customer = new ArrayList<Customer>();

		double longitude = 53.26;
		double latitude = -6.32;
		StringWriter writer = customerService.readCustomerFiles(bufferedReader, customer, latitude, longitude);
		assertNotNull(writer);
	}

	/**
	 * Test to get the distance between the given Dublin location and the customer
	 * location
	 */
	@Test
	public void shouldGetDistance() throws IOException {
		CustomerService customerService = new CustomerService();
		double latitude = 0;
		double longitude = 0;
		double longitude1 = 53.26;
		double latitude1 = -6.32;
		double distance = customerService.calculateDistance(latitude, longitude, latitude1, longitude1);
		Assert.assertNotNull(distance);
		Assert.assertFalse("Should not be NaN", Double.isNaN(distance));
	}

	/**
	 * Test to get the Nan when the corrupted data is passed.
	 */
	@Test
	public void shouldGetNANDistance() throws IOException {
		CustomerService customerService = new CustomerService();
		double latitude = Double.NaN;
		double longitude = Double.NaN;
		double longitude1 = 53.26;
		double latitude1 = -6.32;
		double distance = customerService.calculateDistance(latitude, longitude, latitude1, longitude1);
		Assert.assertNotNull(distance);
		Assert.assertTrue("Should not be NaN", Double.isNaN(distance));
	}
	
	@Test
	public void shouldwriteFile() throws IOException {
		CustomerService customerService = new CustomerService();
		ArrayList<Customer> customers = new ArrayList<Customer>();
		Customer customer = new Customer();
		customer.setLatitude(56);
		customer.setLongitude(-6);
		customer.setName("Nikita");
		customers.add(customer );
		StringWriter writer = customerService.writeFile(customers);
		assertNotNull(writer);
	}

	@Test
	public void shouldNotWriteFile() throws IOException {
		CustomerService customerService = new CustomerService();
		ArrayList<Customer> customers= null;
		StringWriter writer = customerService.writeFile(customers);
		assertNull(writer);
	}

}
