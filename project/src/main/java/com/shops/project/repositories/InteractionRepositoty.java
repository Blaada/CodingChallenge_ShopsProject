package com.shops.project.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shops.project.models.Interaction;

@Repository
public interface InteractionRepositoty extends JpaRepository<Interaction, Long> {

	

}
