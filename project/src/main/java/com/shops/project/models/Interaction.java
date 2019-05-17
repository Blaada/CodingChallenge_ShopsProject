package com.shops.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import org.hibernate.annotations.NaturalId;

//Interaction entity : means if a user like or dislike a specific shop it will be saved in this table

@Entity
@Table(name = "interaction", uniqueConstraints = @UniqueConstraint(columnNames = { "user_id", "shop_ip" }))
public class Interaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "shop_ip")
	private Shop shop;

	@Enumerated(EnumType.STRING)
	@NaturalId
	@Column(length = 50)
	private InteractionType interActionType; // ( Liked shop ) OR ( DisLiked shop )

	public Interaction() {

	}

	// Fields constructor
	public Interaction(Long id, User user, Shop shop, InteractionType interActionType) {
		super();
		Id = id;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public InteractionType getInterActionType() {
		return interActionType;
	}

	public void setInterActionType(InteractionType interActionType) {
		this.interActionType = interActionType;
	}

}
