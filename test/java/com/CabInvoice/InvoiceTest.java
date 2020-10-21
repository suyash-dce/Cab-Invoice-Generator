package com.capgemini.CabInvoice;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceTest {

	InvoiceGenerator invoiceGenerator = null;

	@Before
	public void setUp() throws Exception {
		invoiceGenerator = new InvoiceGenerator();
	}

	@Test
	public void givenDistanceAndTimeShouldReturnTotalFare() {
		double distance = 2.5;
		int time = 10;
		String rideType = "normal";
		double fare = invoiceGenerator.calculateFare(distance, time, rideType);
		Assert.assertEquals(35, fare, 0.0);
	}

	@Test
	public void givenLessDistanceAndTimeShouldReturnMinimumFare() {
		double distance = 0.1;
		int time = 1;
		String rideType = "normal";
		double fare = invoiceGenerator.calculateFare(distance, time, rideType);
		Assert.assertEquals(5, fare, 0.0);
	}

	@Test
	public void givenUserIdShouldReturnInvoiceSummary() {
		int userId = 123;
		Rides[] rides = { new Rides(2.0, 5, "normal"), new Rides(0.1, 1, "premium") };
		InvoiceGenerator cabInvoiceGenerator = new InvoiceGenerator(userId, rides);
		Summary actualInvoiceSummary = cabInvoiceGenerator.calculateFare(userId);
		Summary expectedInvoiceSummary = new Summary(2, 45.0);
		Assert.assertEquals(expectedInvoiceSummary, actualInvoiceSummary);
	}

	@Test
	public void givenMultipleRidesShouldReturnInvoiceSummary() {
		Rides[] rides = { new Rides(2.0, 5, "normal"), new Rides(0.1, 1, "premium") };
		Summary invoiceSummary = invoiceGenerator.calculateFare(rides);
		Summary expectedInvoiceSummary = new Summary(2, 45.0);
		Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
	}
}
