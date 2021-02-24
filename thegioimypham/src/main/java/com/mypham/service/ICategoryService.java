package com.mypham.service;

import com.mypham.dto.CategoryDto;
import com.mypham.repository.CategoryRepository;

import java.util.Locale;
import java.util.Map;

public interface ICategoryService
{
    CategoryDto findOne(Long id);
    CategoryDto findOneByCode(String code);
    Map<String,String> findAll();
}
