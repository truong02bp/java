package com.mypham.service.implement;

import com.mypham.dao.ICategoryDao;
import com.mypham.model.CategoryModel;
import com.mypham.service.ICategoryService;

import javax.inject.Inject;
import java.util.List;

public class CategoryService implements ICategoryService
{
    @Inject
    private ICategoryDao categoryDao;
    @Override
    public List<CategoryModel> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public CategoryModel findOne(Long id) {
        return categoryDao.findOne(id);
    }

    @Override
    public CategoryModel findByName(String name) {
        return categoryDao.findByName(name);
    }
}
