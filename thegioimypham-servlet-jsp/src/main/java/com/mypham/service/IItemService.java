package com.mypham.service;

import java.util.List;

import com.mypham.model.ItemModel;
import com.mypham.paging.Pageble;

public interface IItemService 
{
	List<ItemModel> findAll();
	Long insert(ItemModel item);
	void update(ItemModel newItem);
	void delete(Long[] id);
	ItemModel findOne(Long id);
	List<ItemModel> findAll(Pageble pageble);
	Long count();
}
