package com.foodcoop.domain;

import java.util.ArrayList;
import java.util.Date;

public class Sale {

	private int id;
	private int idSeller;
	private int idMember;
	private Date saleDate;
	private double total;
	private double discount;
	private double net;

	//
	private ArrayList<SaleDetail> saleDetail;
	
	public ArrayList<SaleDetail> getSaleDetail() {
		return saleDetail;
	}
	
	public void setSaleDetail(ArrayList<SaleDetail> saleDetail){
		this.saleDetail = saleDetail;		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdSeller() {
		return idSeller;
	}

	public void setIdSeller(int idSeller) {
		this.idSeller = idSeller;
	}

	public int getIdMember() {
		return idMember;
	}

	public void setIdMember(int idMember) {
		this.idMember = idMember;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}
	
	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	
	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	public double getNet() {
		return net;
	}

	public void setNet(double net) {
		this.net = net;
	}
	
}
