package com.shops.project.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

//Shop entity

@Entity
@Table(name = "shop", uniqueConstraints = { @UniqueConstraint(columnNames = { "shopname" }) })
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@NotBlank
	@Size(min = 3, max = 50)
	private String shopname;

	@NotBlank
	@Size(min = 6, max = 9)
	private Float xShop_coordinates;

	@NotBlank
	@Size(min = 6, max = 9)
	private Float yShop_coordinates;

	public Shop() {

	}
	
	// Fields constructor

	public Shop(Long id, @NotBlank String shopname, @NotBlank Float xShop_coordinates,
			@NotBlank Float yShop_coordinates) {
		super();
		Id = id;
		this.shopname = shopname;
		this.xShop_coordinates = xShop_coordinates;
		this.yShop_coordinates = yShop_coordinates;
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

	public Float getxShop_coordinates() {
		return xShop_coordinates;
	}

	public void setxShop_coordinates(Float xShop_coordinates) {
		this.xShop_coordinates = xShop_coordinates;
	}

	public Float getyShop_coordinates() {
		return yShop_coordinates;
	}

	public void setyShop_coordinates(Float yShop_coordinates) {
		this.yShop_coordinates = yShop_coordinates;
	}

}
