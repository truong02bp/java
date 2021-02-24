package com.mypham.service;

import com.mypham.dto.ItemDto;
import com.mypham.entity.ItemEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IItemService
{
    List<ItemDto> findAll(Pageable pageable);
    ItemDto findOne(Long id);
    ItemDto save(ItemDto itemDto);
    List<ItemDto> findAllByWeb(String web);
    List<ItemDto> findAllByCategoryId(Long id);
    List<ItemDto> findAllByCategoryId(Long id , Pageable pageable , String sort);
    void delete(long[] ids);
    int getTotalItem();
    int getTotalItem(Long id);
}
