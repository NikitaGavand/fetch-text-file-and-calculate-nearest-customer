package com.intercom.home.assignment.test;

import java.io.IOException;
import java.io.StringWriter;

import org.junit.Assert;
import org.junit.Test;

import com.intercom.home.assignment.exception.CustomerException;
import com.intercom.home.assignment.service.CustomerService;
/**
 * 
 * @author nikita gavand 
 * Tests the main class of customer
 *
 */
public class CustomerControllerTest {
	
	/**
	 * should get the writer with all the customer
	 * @throws CustomerException
	 * @throws IOException 
	 */
	@Test
	public void shouldGetCustomerInGivenRadius() throws CustomerException, IOException {
		CustomerService customerService = new CustomerService();
		String pathFile="https://s3.amazonaws.com/intercom-take-home-test/customers.txt";
		double latitude=53;
		double longitude=-6;
		StringWriter writer = customerService.getListOfCustomerInGivenRadius(pathFile, latitude, longitude);;
		Assert.assertNotNull(writer);
	}
	/**
	 * should not get the writer with all the customer
	 * @throws CustomerException
	 * @throws IOException 
	 */
	@Test
	public void shouldNotGetCustomerInGivenRadius() throws CustomerException, IOException {
		CustomerService customerService = new CustomerService();
		String pathFile="https://s3.amazonaws.com/intercom-take-home-test/customers.txt";
		double latitude=0;
		double longitude=0;
		StringWriter writer = customerService.getListOfCustomerInGivenRadius(pathFile, latitude, longitude);;
		Assert.assertNull(writer);
	}
/**
 * Should get customer exception when path is null or invalid
 * @throws CustomerException
 * @throws IOException 
 */
	@Test(expected = CustomerException.class)
	public void shouldGetCustomerException() throws CustomerException, IOException {
		CustomerService customerService = new CustomerService();
		String pathFile="";
		double latitude=0;
		double longitude=0;
		StringWriter writer = customerService.getListOfCustomerInGivenRadius(pathFile, latitude, longitude);
		Assert.assertNotNull(writer);
	}
	/**
	 * Should get exception whenvalues of latitude and logitude is NaN
	 * @throws CustomerException
	 * @throws IOException 
	 */
	@Test(expected = CustomerException.class)
	public void shouldGetNANException() throws CustomerException, IOException {
		CustomerService customerService = new CustomerService();
		String pathFile="";
		double latitude=Double.NaN;
		double longitude=Double.NaN;
		StringWriter writer = customerService.getListOfCustomerInGivenRadius(pathFile, latitude, longitude);
		Assert.assertNotNull(writer);
	}
	
}
