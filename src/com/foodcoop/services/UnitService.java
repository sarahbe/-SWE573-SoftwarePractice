package com.foodcoop.services;

import java.util.List;

import com.foodcoop.domain.Unit;

public interface UnitService {
	 public void insertData(Unit unit);
	 public void updateData(Unit unit);
	 public List<Unit> getUnitList();
	 public void deleteData(String id);
	 public Unit getUnit(String id);
}
