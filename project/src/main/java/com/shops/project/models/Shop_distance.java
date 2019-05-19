package com.shops.project.models;

public class Shop_distance implements Comparable<Shop_distance>{

	private Shop shop;
	private Double distance_to_client;

	public Shop_distance() {

	}

	public Shop_distance(Shop shop, Double distance_to_client) {
		super();
		this.shop = shop;
		this.distance_to_client = distance_to_client;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Double getDistance_to_client() {
		return distance_to_client;
	}

	public void setDistance_to_client(Double distance_to_client) {
		this.distance_to_client = distance_to_client;
	}

	@Override
	public int compareTo(Shop_distance distance) {
		
		return this.getDistance_to_client().compareTo(distance.getDistance_to_client());
	}

}
