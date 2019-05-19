package com.shops.project.controller;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shops.project.models.Shop;
import com.shops.project.models.Shop_distance;

import com.shops.project.repositories.ShopRepository;
import com.shops.project.repositories.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/list/shop/")
public class Shops_Controller {

	@Autowired
	ShopRepository shop_repo;

	@Autowired
	UserRepository userRepository;

	@RequestMapping(value = "/all")
	public List<Shop_distance> getAllShops(@RequestParam(value = "longitude_Client") String longitude_Client,
			@RequestParam(value = "latitude_Client") String latitude_Client,
			@RequestParam(value = "email") String email, HttpServletRequest request) {
		LinkedList<Shop_distance> shops_by_distance = new LinkedList<Shop_distance>();
		Double latitude = Double.valueOf(latitude_Client);
		Double longitude = Double.valueOf(longitude_Client);
		for (Shop shop : shop_repo.findAllShops(getIdfromUsername(email))) {
			Double distance = distance(latitude, shop.getLatShop_coordinates(), longitude,
					shop.getLongShop_coordinates());
			Shop_distance shop_distance = new Shop_distance(shop, distance);
			shops_by_distance.add(shop_distance);
		}
		Collections.sort(shops_by_distance);
		for (Shop_distance shopd : shops_by_distance) {
			System.out.println(shopd.getDistance_to_client());
		}
		return shops_by_distance;

	}

	public static double distance(double lat1, double lat2, double lon1, double lon2) {

		final int R = 6371; // Radius of the earth

		double latDistance = Math.toRadians(lat2 - lat1);
		double lonDistance = Math.toRadians(lon2 - lon1);
		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(lat1))
				* Math.cos(Math.toRadians(lat2)) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double distance = R * c * 1000; // convert to meters

		return Math.sqrt(distance);
	}

	public Long getIdfromUsername(String email) {
		return userRepository.findByEmail(email).get().getId();

	}

}
