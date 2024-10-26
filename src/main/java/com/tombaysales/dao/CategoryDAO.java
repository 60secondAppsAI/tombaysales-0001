package com.tombaysales.dao;

import java.util.List;

import com.tombaysales.dao.GenericDAO;
import com.tombaysales.domain.Category;





public interface CategoryDAO extends GenericDAO<Category, Integer> {
  
	List<Category> findAll();
	






}


