package com.mypham.dao.implement;

import java.sql.Timestamp;
import java.util.List;

import com.mypham.dao.IItemDao;
import com.mypham.mapper.ItemMapper;
import com.mypham.model.ItemModel;
import com.mypham.paging.Pageble;

public class ItemDao extends AbstractDao<ItemModel> implements IItemDao
{
	@Override
	public List<ItemModel> findAll() {
		String sql = "Select * from item";
		return query(sql, new ItemMapper());
	}

	@Override
	public Long insert(ItemModel item)
	{
		item.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		StringBuilder sql = new StringBuilder("insert into item (name,title,shortdescription,content,categoryid,gia,image,");
		sql.append("createddate,createdby) values(?,?,?,?,?,?,?,?,?)");
		return insert(sql.toString(), item.getName() , item.getTitle() , item.getShortDescription() ,
				item.getContent(), item.getCategoryId(), item.getGia() , item.getImage() , item.getCreatedDate() , item.getCreatedBy());
	}

	@Override
	public void update(ItemModel newItem)
	{
		ItemModel oldItem = findOne(newItem.getId());
		newItem.setCreatedBy(oldItem.getCreatedBy());
		newItem.setCreatedDate(oldItem.getCreatedDate());
		newItem.setModifiedDate(new Timestamp(System.currentTimeMillis()));

		StringBuilder sql = new StringBuilder("update item set name=? , title=? , shortdescription=? , ");
		sql.append("content=? , categoryid =? , gia=? , image = ? , modifieddate = ? , modifiedby = ? where id = ?");
		update(sql.toString(), newItem.getName() , newItem.getTitle() , newItem.getShortDescription() ,
				newItem.getContent() , newItem.getCategoryId() , newItem.getGia() , newItem.getImage() , newItem.getModifiedDate() 
				, newItem.getModifiedBy() , newItem.getId());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from item where id = ?";
		delete(sql,id);
	}

	@Override
	public ItemModel findOne(Long id) {
		String sql ="Select * from item where id = ?";
		List<ItemModel> list = query(sql,new ItemMapper(),id);
		if (list.size()==0)
			return null;
		return list.get(0);
	}
	
	@Override
	public Long count() {
		String sql = "select count(*) from item";
		return count(sql);
	}

	@Override
	public List<ItemModel> findAll(Pageble pageble) {
		StringBuilder sb = new StringBuilder("select * from item");
		if (pageble.getSorter()!=null)
			sb.append(" order by " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy()+"");
		if (pageble.getOffset()!=null)
			sb.append(" limit " + pageble.getLimit() +" offset "+pageble.getOffset());
		return query(sb.toString() , new ItemMapper());
	}
}
