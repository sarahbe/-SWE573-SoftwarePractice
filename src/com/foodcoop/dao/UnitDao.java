package com.foodcoop.dao;

import java.util.List;

import com.foodcoop.domain.Unit;

public interface UnitDao {
	 public void insertData(Unit unit);
	 public List<Unit> getUnitList();
	 public void updateData(Unit unit);
	 public void deleteData(String id);
	 public Unit getUnit(String id);
}
