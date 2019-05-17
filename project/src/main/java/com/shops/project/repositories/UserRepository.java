package com.shops.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.shops.project.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
