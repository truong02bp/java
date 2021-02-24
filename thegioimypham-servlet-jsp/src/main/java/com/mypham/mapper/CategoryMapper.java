package com.mypham.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mypham.model.CategoryModel;

public class CategoryMapper implements RowMapper<CategoryModel>
{

	@Override
	public CategoryModel mapRow(ResultSet rs) 
	{
		CategoryModel cate = new CategoryModel();
		try {
			cate.setId(rs.getLong("id"));
			cate.setCode(rs.getNString("code"));
			cate.setModifiedBy(rs.getNString("modifiedby"));
			cate.setModifiedDate(rs.getTimestamp("modifieddate"));
			cate.setCreatedBy(rs.getNString("createdby"));
			cate.setCreatedDate(rs.getTimestamp("createddate"));
			cate.setName(rs.getNString("name"));
			return cate;
		} catch (SQLException e) {
			return null;
		}
	}
}
