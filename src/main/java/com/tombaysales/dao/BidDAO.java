package com.tombaysales.dao;

import java.util.List;

import com.tombaysales.dao.GenericDAO;
import com.tombaysales.domain.Bid;





public interface BidDAO extends GenericDAO<Bid, Integer> {
  
	List<Bid> findAll();
	






}


