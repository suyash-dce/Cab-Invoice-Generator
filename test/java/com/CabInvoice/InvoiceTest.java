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
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(35, fare, 0.0);
	}

	@Test
	public void givenLessDistanceAndTimeShouldReturnMinimumFare() {
		double distance = 0.1;
		int time = 1;
		double fare = invoiceGenerator.calculateFare(distance, time);
		Assert.assertEquals(5, fare, 0.0);
	}

	@Test
	public void givenMultipleRidesShouldReturnAggregateTotalForAll() {
		Rides[] rides = { new Rides(2.0, 5), new Rides(0.1, 1) };
		double totalFare = invoiceGenerator.calculateFare(rides);
		Assert.assertEquals(30, totalFare, 0.0);
	}
}