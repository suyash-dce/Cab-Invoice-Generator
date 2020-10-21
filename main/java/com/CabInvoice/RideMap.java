package com.capgemini.CabInvoice;

import java.util.HashMap;
import java.util.Map;

public class RideMap {

	private Map<Integer, Rides[]> USER_RIDES = new HashMap<Integer, Rides[]>();

	public RideMap(int userId, Rides[] rides) {
		USER_RIDES.put(userId, rides);
	}

	public Rides[] getRides(int userId) {
		return USER_RIDES.get(userId);
	}
}
