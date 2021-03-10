package com.cognizant.bootup.cartservice.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.bootup.cartservice.entity.Cart;

@Transactional
public interface CartDao extends JpaRepository<Cart, String>{
	
	public Cart findCartByloggedUserIgnoreCase(String loggedUser);
	
	@Modifying
	@Query(value = "DELETE FROM Cart WHERE logged_user = :loggedUser", nativeQuery = true)
	public int deleteCartByloggedUserIgnoreCase(@Param("loggedUser") String loggedUser);

}
