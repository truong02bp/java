package com.mypham.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mypham.model.RoleModel;

public class RoleMapper implements RowMapper<RoleModel>
{

	@Override
	public RoleModel mapRow(ResultSet rs) 
	{
		RoleModel role = new RoleModel();
		try {
			role.setCode(rs.getNString("code"));
			role.setId(rs.getLong("id"));
			role.setName(rs.getNString("name"));
			role.setModifiedBy(rs.getNString("modifiedby"));
			role.setModifiedDate(rs.getTimestamp("modifieddate"));
			role.setCreatedBy(rs.getNString("createdby"));
			role.setCreatedDate(rs.getTimestamp("createddate"));
			return role;
		} catch (SQLException e) {
			return null;
		}
	}
}
