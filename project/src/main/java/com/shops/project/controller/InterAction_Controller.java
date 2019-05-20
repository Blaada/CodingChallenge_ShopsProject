package com.shops.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shops.project.models.Interaction;
import com.shops.project.repositories.InteractionRepositoty;
import com.shops.project.repositories.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/interaction")
public class InterAction_Controller {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	InteractionRepositoty interAction_repo;
	
	@RequestMapping("/liked")
	public void LikedShop(@RequestParam(value = "email") String email,
			@RequestParam(value = "shop_id") String shop_id) {
		
		Interaction interAct = new Interaction(getIdfromUsername(email), Long.valueOf(shop_id), "LIKED");
		interAction_repo.save(interAct);
	}
	
	@RequestMapping("/disliked")
	public void DisLikedShop(@RequestParam(value = "email") String email,
			@RequestParam(value = "shop_id") String shop_id) {
		
		Interaction interAct = new Interaction(getIdfromUsername(email), Long.valueOf(shop_id), "DISLIKED");
		interAction_repo.save(interAct);
	}
	
	@RequestMapping("/removeLike")
	public void removeLiked(@RequestParam(value = "email") String email,
			@RequestParam(value = "shop_id") String shop_id) {
		
		Interaction interAct = new Interaction(getIdfromUsername(email), Long.valueOf(shop_id), "LIKED");
		interAction_repo.delete(interAct);
	}
	
	public Long getIdfromUsername(String email) {
		
		// return the Id of the authenticated user 
		return userRepository.findByEmail(email).get().getId();

	}

}
