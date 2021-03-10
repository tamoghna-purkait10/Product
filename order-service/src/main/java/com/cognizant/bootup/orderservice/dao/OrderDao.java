package com.cognizant.bootup.orderservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.bootup.orderservice.entity.Orders;

public interface OrderDao extends JpaRepository<Orders, Integer> {

}
