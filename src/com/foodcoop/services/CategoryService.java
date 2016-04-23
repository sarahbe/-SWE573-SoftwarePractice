package com.foodcoop.services;

import java.util.List;

import com.foodcoop.domain.Category;
public interface CategoryService {
	 public void insertData(Category category);
	 public void updateData(Category category);
	 public List<Category> getCategoryList();
	 public void deleteData(String id);
	 public Category getCategory(String id);
}
