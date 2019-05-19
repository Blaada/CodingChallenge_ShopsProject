package com.shops.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//Shop entity

@Entity
@Table(name = "shop", uniqueConstraints = { @UniqueConstraint(columnNames = { "shopname" }) })
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="shop_id")
	private Long Id;

	
	@Size(min = 3, max = 50)
	private String shopname;

	
	@NotNull
	private Double longShop_coordinates;

	
	@NotNull
	private Double latShop_coordinates;

	public Shop() {

	}
	
	// Fields constructor

	public Shop(String shopname,Double longShop_coordinates,
			Double latShop_coordinates) {
		super();
		
		this.shopname = shopname;
		this.longShop_coordinates = longShop_coordinates;
		this.latShop_coordinates = latShop_coordinates;
	}

	// Getters & Setters
	
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public Double getLongShop_coordinates() {
		return longShop_coordinates;
	}

	public void setLongShop_coordinates(Double longShop_coordinates) {
		this.longShop_coordinates = longShop_coordinates;
	}

	public Double getLatShop_coordinates() {
		return latShop_coordinates;
	}

	public void setLatShop_coordinates(Double latShop_coordinates) {
		this.latShop_coordinates = latShop_coordinates;
	}

	

}
