package com.capgemini.CabInvoice;

import java.util.logging.Logger;

public class InvoiceGenerator {

	private static final double MINIMUM_COST_PER_KM = 10.0;
	private static final int COST_PER_TIME = 1;
	private static final double MINIMUM_FARE = 5.0;
	private final RideMap USER_RIDES;

	public InvoiceGenerator() {
		this.USER_RIDES = null;
	}

	public InvoiceGenerator(int userId, Rides[] rides) {
		USER_RIDES = new RideMap(userId, rides);
	}

	public static void main(String[] args) {
		Logger log = Logger.getLogger(InvoiceGenerator.class.getName());
		log.info("Welcome to the Cab Invoice Generator System.");
	}

	public double calculateFare(double distance, int time) {
		double totalFare = distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME;
		return Math.max(totalFare, MINIMUM_FARE);
	}

	public Summary calculateFare(int userId) {
		Rides[] rides = USER_RIDES.getRides(userId);
		double totalFare = 0.0;
		for (Rides ride : rides) {
			totalFare += this.calculateFare(ride.distance, ride.time);
		}
		return new Summary(rides.length, totalFare);
	}
}
