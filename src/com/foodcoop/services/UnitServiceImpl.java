package com.foodcoop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.foodcoop.dao.UnitDao;
import com.foodcoop.domain.Unit;

public class UnitServiceImpl implements UnitService{

	 @Autowired
	 UnitDao unitdao;

	 @Override
	 public void insertData(Unit unit) {
		 unitdao.insertData(unit);
	 }

	 @Override
	 public void deleteData(String id) {
		 unitdao.deleteData(id);
	  
	 }

	 @Override
	 public List<Unit> getUnitList() {
	  return unitdao.getUnitList();
	 }

	 
	 @Override
	 public Unit getUnit(String id) {
	  return unitdao.getUnit(id);
	 }

	 @Override
	 public void updateData(Unit unit) {
		 unitdao.updateData(unit);
	  
	 }
}
