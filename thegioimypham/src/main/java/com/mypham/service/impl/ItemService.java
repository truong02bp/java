package com.mypham.service.impl;

import com.mypham.converter.ItemConverter;
import com.mypham.dto.ItemDto;
import com.mypham.entity.CategoryEntity;
import com.mypham.entity.ItemEntity;
import com.mypham.repository.CategoryRepository;
import com.mypham.repository.ItemRepository;
import com.mypham.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService implements IItemService
{
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemConverter itemConverter;

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<ItemDto> findAll(Pageable pageable)
    {
        List<ItemDto> rs = new ArrayList<>();
        List<ItemEntity> entities = itemRepository.findAll(pageable).getContent();
        for (ItemEntity entity : entities)
            rs.add(itemConverter.toDto(entity));
        return rs;
    }

    @Override
    public ItemDto findOne(Long id)
    {
        return itemConverter.toDto(itemRepository.findOne(id));
    }

    @Override
    @Transactional
    public ItemDto save(ItemDto itemDto)
    {
        CategoryEntity categoryEntity = categoryRepository.findOneByName(itemDto.getCategoryName());
        ItemEntity entity = itemConverter.toEntity(itemDto);
        entity.setCategoryId(categoryEntity.getId());
        if (itemDto.getId()!=null)
        {
            entity.setId(itemDto.getId());
            return itemConverter.toDto(itemRepository.save(entity));
        }
        else
            return itemConverter.toDto(itemRepository.save(entity));
    }

    @Override
    public List<ItemDto> findAllByWeb(String web)
    {
        List<ItemEntity> list = itemRepository.findAllByWeb(web);
        List<ItemDto> rs = new ArrayList<>();
        for (ItemEntity entity : list)
            rs.add(itemConverter.toDto(entity));
        return rs;
    }

    @Override
    public List<ItemDto> findAllByCategoryId(Long id) {
        List<ItemEntity> list = itemRepository.findAllByCategoryId(id);
        List<ItemDto> rs = new ArrayList<>();
        for (ItemEntity entity : list)
            rs.add(itemConverter.toDto(entity));
        return rs;
    }

    @Override
    public List<ItemDto> findAllByCategoryId(Long id , Pageable pageable , String sort) {
        List<ItemEntity> list = new ArrayList<>();
        if (sort==null)
            list = itemRepository.findAllByCategoryId(id,pageable);
        else
        {
            if (sort.equals("asc"))
                list = itemRepository.findByCategoryIdOrderByGiaSauAsc(id,pageable);
            else
                list = itemRepository.findByCategoryIdOrderByGiaSauDesc(id,pageable);
        }
        List<ItemDto> rs = new ArrayList<>();
        for (ItemEntity entity : list)
            rs.add(itemConverter.toDto(entity));
        return rs;
    }
    @Override
    @Transactional
    public void delete(long[] ids)
    {
        for (long id : ids)
            itemRepository.delete(id);
    }

    @Override
    public int getTotalItem() {
        return (int) itemRepository.count();
    }

    @Override
    public int getTotalItem(Long id) {
        return itemRepository.countByCategoryId(id);
    }
}
