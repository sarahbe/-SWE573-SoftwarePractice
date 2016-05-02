package com.foodcoop.domain;

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
	
	private String producerName;
	
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
		//this.getProducerName();
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
   

}
