package com.mypham.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mypham.model.ItemModel;

public class ItemMapper implements RowMapper<ItemModel>
{

	@Override
	public ItemModel mapRow(ResultSet rs) 
	{
		ItemModel item = new ItemModel();
		try {
			item.setId(rs.getLong("id"));
			item.setCategoryId(rs.getLong("categoryid"));
			item.setContent(rs.getNString("content"));
			item.setCreatedBy(rs.getNString("createdby"));
			item.setCreatedDate(rs.getTimestamp("createddate"));
			item.setGia(rs.getNString("gia"));
			item.setImage(rs.getNString("image"));
			item.setModifiedBy(rs.getNString("modifiedby"));
			item.setModifiedDate(rs.getTimestamp("modifieddate"));
			item.setName(rs.getNString("name"));
			item.setShortDescription(rs.getNString("shortdescription"));
			item.setTitle(rs.getNString("title"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return item;
	}

}
