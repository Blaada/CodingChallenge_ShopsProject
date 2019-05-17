package com.shops.project.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import org.hibernate.annotations.NaturalId;

//Interaction entity : means if a user like or dislike a specific shop it will be saved in this table

@Entity
@Table(name = "interaction")
public class Interaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	@Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 50)
    private InteractionType interActionType;  // ( Liked shop ) OR ( DisLiked shop )

}
