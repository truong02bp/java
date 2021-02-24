package com.mypham.dao;

import java.util.List;

import com.mypham.model.CategoryModel;

public interface ICategoryDao 
{
	List<CategoryModel> findAll();
	CategoryModel findOne(Long id);
	CategoryModel findByName(String name);
}
