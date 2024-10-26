package com.tombaysales.dao;

import java.util.List;

import com.tombaysales.dao.GenericDAO;
import com.tombaysales.domain.Order;





public interface OrderDAO extends GenericDAO<Order, Integer> {
  
	List<Order> findAll();
	






}


