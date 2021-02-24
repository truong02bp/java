package com.mypham.dao;

import java.util.List;

import com.mypham.model.ItemModel;
import com.mypham.paging.Pageble;

public interface IItemDao 
{
	List<ItemModel> findAll();
	Long insert(ItemModel Item);
	void update(ItemModel newitem);
	void delete(Long id);
	ItemModel findOne(Long id);
	List<ItemModel> findAll(Pageble pageble);
	Long count();
}
