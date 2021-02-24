package com.mypham.service.implement;

import java.util.List;

import javax.inject.Inject;

import com.mypham.dao.IItemDao;
import com.mypham.model.ItemModel;
import com.mypham.paging.Pageble;
import com.mypham.service.IItemService;

public class ItemService implements IItemService
{
	@Inject
	private IItemDao itemDao;
	@Override
	public List<ItemModel> findAll() 
	{
		return itemDao.findAll();
	}
	@Override
	public Long insert(ItemModel item) {
		return itemDao.insert(item);
	}
	@Override
	public void update(ItemModel newItem) {
		itemDao.update(newItem);
	}
	@Override
	public void delete(Long[] id) {
		for (Long i : id)
			itemDao.delete(i);
	}
	@Override
	public ItemModel findOne(Long id) {
		return itemDao.findOne(id);
	}
	@Override
	public Long count() {
		return itemDao.count();
	}
	@Override
	public List<ItemModel> findAll(Pageble pageble) {
		return itemDao.findAll(pageble);
	}
}
