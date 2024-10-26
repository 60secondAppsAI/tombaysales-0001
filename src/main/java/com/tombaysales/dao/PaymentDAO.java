package com.tombaysales.dao;

import java.util.List;

import com.tombaysales.dao.GenericDAO;
import com.tombaysales.domain.Payment;





public interface PaymentDAO extends GenericDAO<Payment, Integer> {
  
	List<Payment> findAll();
	






}


