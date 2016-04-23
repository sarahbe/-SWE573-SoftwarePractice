package com.foodcoop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.foodcoop.dao.CategoryDao;
import com.foodcoop.domain.Category;

public class CategoryServiceImpl implements CategoryService {


	 @Autowired
	 CategoryDao categorydao;

	 @Override
	 public void insertData(Category category) {
		 categorydao.insertData(category);
	 }

	 @Override
	 public void deleteData(String id) {
		 categorydao.deleteData(id);
	  
	 }

	 @Override
	 public List<Category> getCategoryList() {
	  return categorydao.getCategoryList();
	 }

	 
	 @Override
	 public Category getCategory(String id) {
	  return categorydao.getCategory(id);
	 }

	 @Override
	 public void updateData(Category category) {
		 categorydao.updateData(category);
	  
	 }
	 
}
