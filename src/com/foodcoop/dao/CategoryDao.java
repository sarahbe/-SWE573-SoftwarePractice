package com.foodcoop.dao;

import java.util.List;

import com.foodcoop.domain.Category;

public interface CategoryDao {
	 public void insertData(Category category);
	 public List<Category> getCategoryList();
	 public void updateData(Category category);
	 public void deleteData(String id);
	 public Category getCategory(String id);

}
