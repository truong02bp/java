package com.mypham.dao.implement;

import java.util.List;

import com.mypham.dao.ICategoryDao;
import com.mypham.mapper.CategoryMapper;
import com.mypham.model.CategoryModel;

public class CategoryDao extends AbstractDao implements ICategoryDao 
{

	@Override
	public List<CategoryModel> findAll() {
		String sql = "Select * from category";
		return query(sql,new CategoryMapper());
	}

	@Override
	public CategoryModel findOne(Long id) {
		String sql = "Select * from category where id = ? ";
		List<CategoryModel> list = query(sql, new CategoryMapper() , id);
		if (list.size()==0)
			return null;
		return list.get(0);
	}

	@Override
	public CategoryModel findByName(String name) {
		String sql = "Select * from category where name = ? ";
		List<CategoryModel> list = query(sql , new CategoryMapper() , name);
		if (list.size()==0)
			return null;
		return list.get(0);
	}
}
