package com.mypham.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mypham.model.RoleModel;
import com.mypham.model.UserModel;

public class UserMapper implements RowMapper<UserModel>
{

	@Override
	public UserModel mapRow(ResultSet rs) 
	{
		UserModel user = new UserModel();
		try {
			user.setId(rs.getLong("id"));
			user.setPassword(rs.getNString("password"));
			user.setUsername(rs.getNString("username"));
			user.setRoleId(rs.getLong("roleid"));
			user.setFullName(rs.getNString("fullname"));
			user.setModifiedBy(rs.getNString("modifiedby"));
			user.setModifiedDate(rs.getTimestamp("modifieddate"));
			user.setCreatedBy(rs.getNString("createdby"));
			user.setCreatedDate(rs.getTimestamp("createddate"));
			RoleModel role = new RoleModel();
			role.setCode(rs.getNString("code"));
			role.setName(rs.getNString("name"));
			user.setRole(role);
			return user;
		} catch (SQLException e) {
			return null;
		}
	}
}
