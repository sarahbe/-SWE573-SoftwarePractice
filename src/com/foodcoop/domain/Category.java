package com.foodcoop.domain;

import java.io.Serializable;

public class Category implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String category;
	private boolean valid;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean getValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

}
