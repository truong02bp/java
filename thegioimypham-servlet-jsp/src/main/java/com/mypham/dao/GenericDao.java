package com.mypham.dao;

import java.util.List;

import com.mypham.mapper.RowMapper;

public interface GenericDao<T> 
{
	List<T> query(String sql , RowMapper<T> rowMapper , Object...parameters);
	Long insert(String sql , Object...parameters);
	void update(String sql , Object...parameters);
	void delete(String sql, Object[] parameters);
}
