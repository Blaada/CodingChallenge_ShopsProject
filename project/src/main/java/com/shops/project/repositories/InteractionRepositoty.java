package com.shops.project.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shops.project.models.Interaction;
@Transactional(readOnly = true)
@Repository
public interface InteractionRepositoty extends JpaRepository<Interaction, Long> {

	@Modifying
    @Transactional
	@Query(value="DELETE FROM interaction WHERE shop_id=:shop_id AND user_id=:user_id AND inter_action_type='LIKED'",nativeQuery = true)
	void deleteInterActionByUserShopId(@Param("shop_id") Long shop_id,@Param("user_id") Long user_id);

}
