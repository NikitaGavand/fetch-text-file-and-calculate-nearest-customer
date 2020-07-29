package com.intercom.home.assignment.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.intercom.home.assignment.exception.CustomerException;
import com.intercom.home.assignment.service.CustomerService;

/**
 * @author nikita gavand Servlet implementation class CustomerController It
 *         takes the request from the UI and give the output.txt file which
 *         gives the list of customer in 100 kms radius Problem: We have some
 *         customer records in a text file (customers.txt) -- one customer per
 *         line, JSON lines formatted. We want to invite any customer within
 *         100km of our Dublin office for some food and drinks on us. Write a
 *         program that will read the full list of customers and output the
 *         names and user ids of matching customers (within 100km), sorted by
 *         User ID (ascending). You must use the first formula from this
 *         Wikipedia article to calculate distance. Don't forget, you'll need to
 *         convert degrees to radians. The GPS coordinates for our Dublin office
 *         are 53.339428, -6.257664. You can find the Customer list from
 *         customer.txt. output.txt gives the list of users near to the Dublin
 *         office
 */
@WebServlet("/customerList")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Takes the input parameters
		String fileLink = request.getParameter("fileLink");
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");

		CustomerService nu = new CustomerService();
		StringWriter writer;
		try {
			writer = nu.getListOfCustomerInGivenRadius(fileLink, Double.parseDouble(latitude),
					Double.parseDouble(longitude));

			// set the values for text file to be created
			response.setContentType("text/plain");
			response.setHeader("Content-Disposition", "attachment; filename=\"output.txt\"");
			if(writer== null) {
				throw new CustomerException("There was no data Found");
			}
			else {
			OutputStream outputStream = response.getOutputStream();
			StringBuffer outputResult = writer.getBuffer();
			outputStream.write(outputResult.substring(0).toString().getBytes());
			outputStream.flush();
			outputStream.close();
			}
		} catch (NumberFormatException e1) {
			Logger.getLogger(e1.getMessage());
			RequestDispatcher dispatch = request.getRequestDispatcher("/error.jsp");
			dispatch.forward(request, response);
		} catch (CustomerException e1) {
			Logger.getLogger(e1.getMessage());
			RequestDispatcher dispatch = request.getRequestDispatcher("/error.jsp");
			dispatch.forward(request, response);
		} catch (Exception e) {
			RequestDispatcher dispatch = request.getRequestDispatcher("/error.jsp");
			dispatch.forward(request, response);
			Logger.getLogger(e.getMessage());
			}
	}
}
