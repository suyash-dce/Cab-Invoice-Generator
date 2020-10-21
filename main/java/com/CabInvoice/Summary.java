package com.capgemini.CabInvoice;

public class Summary {
	
	public int noOfRides;
	public double totalFare;
	public double averageFare;

	public Summary(int noOfRides, double totalFare) {
		this.noOfRides = noOfRides;
		this.totalFare = totalFare;
		this.averageFare = (this.totalFare) / (this.noOfRides);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Summary that = (Summary) o;
		return noOfRides == that.noOfRides && Double.compare(that.totalFare, totalFare) == 0 && Double.compare(that.averageFare, averageFare) == 0;
	}

}
