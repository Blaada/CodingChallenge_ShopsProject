package com.shops.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shops.project.models.Shop;


@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>{
	
	@Query(value = "SELECT * FROM shop WHERE shop.shop_id NOT IN (SELECT shop_id FROM interaction WHERE interaction.user_id=:USER)",nativeQuery = true)
	List<Shop> findAllShops(@Param("USER") Long user_id);

}
