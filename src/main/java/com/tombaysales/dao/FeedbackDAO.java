package com.tombaysales.dao;

import java.util.List;

import com.tombaysales.dao.GenericDAO;
import com.tombaysales.domain.Feedback;





public interface FeedbackDAO extends GenericDAO<Feedback, Integer> {
  
	List<Feedback> findAll();
	






}


