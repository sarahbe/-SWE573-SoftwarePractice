package com.foodcoop.domain;

import org.springframework.web.multipart.MultipartFile;

public class Producer {
 private int id; 
 private String producerName; 
 private String description;
 private String image; 
 private Boolean valid;
 
 private MultipartFile file;
 
 public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getProducerName() {
		return producerName;
	}

	public void setProducerName(String producerName) {
		this.producerName = producerName;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public Boolean getValid() {
		return this.valid;
	}

	public void setValid(Boolean valid) {
		this.valid = valid;
	}

	
	   public MultipartFile getFile()
	    { 	
	    	return this.file ;
	    }
	    
	    public void setFile(MultipartFile file){
	    	this.file = file;
	    }

}
