package com.mypham.service;

import com.mypham.model.CategoryModel;

import java.util.List;

public interface ICategoryService
{
    List<CategoryModel> findAll();
    CategoryModel findOne(Long id);
    CategoryModel findByName(String name);
}
