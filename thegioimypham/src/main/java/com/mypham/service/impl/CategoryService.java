package com.mypham.service.impl;

import com.mypham.converter.CategoryConverter;
import com.mypham.dto.CategoryDto;
import com.mypham.entity.CategoryEntity;
import com.mypham.repository.CategoryRepository;
import com.mypham.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService implements ICategoryService
{
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryConverter categoryConverter;

    @Override
    public CategoryDto findOne(Long id) {
        CategoryEntity entity = categoryRepository.findOne(id);
        return categoryConverter.toDto(entity);
    }

    @Override
    public CategoryDto findOneByCode(String code) {
        return categoryConverter.toDto(categoryRepository.findOneByCode(code));
    }

    @Override
    public Map<String, String> findAll()
    {
        Map<String,String> rs = new HashMap<>();
        List<CategoryEntity>  entities = categoryRepository.findAll();
        for (CategoryEntity entity : entities)
            rs.put(entity.getName(),entity.getName());
        return rs;
    }
}
