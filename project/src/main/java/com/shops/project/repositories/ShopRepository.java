package com.shops.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shops.project.models.Shop;


@Repository
public interface ShopRepository extends JpaRepository<Shop, Long>{

}
