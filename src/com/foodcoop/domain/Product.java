package com.foodcoop.domain;

import org.springframework.web.multipart.MultipartFile;

public class Product {
	 
	private int id;
	private String productName;
	private String description;
	private int idCategory;
	private int rate;
	private int idProducer;
	private String origin;
	private String image;
	private Boolean valid;	
	private int idUnit;
	private double price;
	private String unitName; 
	
	private String producerName;
	private MultipartFile file;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public int getRate() {
		return this.rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getIdProducer() {
		
		return this.idProducer;
	}

	public void setIdProducer(int idProducer) {
		this.idProducer = idProducer;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	
	public String getImage() {
		return this.image;
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

    public String getProducerName()
    { 	
    	return this.producerName ;
    }
    
    public void setProducerName(String producerName){
    	this.producerName = producerName;
    }

    public int getIdUnit() {	
		return this.idUnit;
	}

	public void setIdUnit(int idUnit) {
		this.idUnit = idUnit;
	}

    public String getUnitName() {	
		return this.unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	
	public double getPrice() {	
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
    public MultipartFile getFile()
    { 	
    	return this.file ;
    }
    
    public void setFile(MultipartFile file){
    	this.file = file;
    }

}
