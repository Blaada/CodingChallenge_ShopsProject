package com.shops.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




//Interaction entity : means if a user like or dislike a specific shop it will be saved in this table

@Entity
@Table(name = "interaction", uniqueConstraints = @UniqueConstraint(columnNames = { "user_id", "shop_id" }))
public class Interaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	
	@Column(name = "user_id")
	private Long user;

	
	@Column(name = "shop_id")
	private Long shop;

	@NotNull
	@Column(length = 50)
	private String interActionType; // ( Liked shop ) OR ( DisLiked shop )

	public Interaction() {

	}

	// Fields constructor
	public Interaction(Long user, Long shop, String interActionType) {
		super();
		
		this.user = user;
		this.shop = shop;
		this.interActionType = interActionType;
	}

	// Getters & Setters
	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public Long getShop() {
		return shop;
	}

	public void setShop(Long shop) {
		this.shop = shop;
	}

	public String getInterActionType() {
		return interActionType;
	}

	public void setInterActionType(String interActionType) {
		this.interActionType = interActionType;
	}

}
