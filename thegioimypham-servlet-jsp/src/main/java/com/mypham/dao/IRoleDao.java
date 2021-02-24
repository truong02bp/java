package com.mypham.dao;

import java.util.List;

import com.mypham.model.RoleModel;

public interface IRoleDao 
{
	List<RoleModel> findAll();
}
