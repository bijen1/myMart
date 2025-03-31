package com.mymart.mymart.dao;

import java.util.List;

import com.mymart.mymart.entity.SampleProductEntity;

public interface SampleProductDao {

	public List<SampleProductEntity> findAll();
	
	public SampleProductEntity findById(int id);
	
	public String insert(String productName, String productCategory, int price, int discount);
	
	public String deleteById(int id);
	
}
