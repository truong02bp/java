package com.mypham.dao.implement;

import java.util.List;

import com.mypham.dao.IRoleDao;
import com.mypham.mapper.RoleMapper;
import com.mypham.model.RoleModel;

public class RoleDao extends AbstractDao<RoleModel> implements IRoleDao
{

	@Override
	public List<RoleModel> findAll() {
		String sql = "Select * from role";
		return query(sql,new RoleMapper());
	}
}
