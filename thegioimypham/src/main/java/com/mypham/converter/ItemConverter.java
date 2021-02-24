package com.mypham.converter;

import com.mypham.dto.ItemDto;
import com.mypham.entity.ItemEntity;
import com.mypham.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemConverter
{
    @Autowired
    private ICategoryService iCategoryService;
    public ItemDto toDto(ItemEntity entity)
    {
        ItemDto rs = new ItemDto();
        rs.setName(entity.getName());
        rs.setCategoryId(entity.getCategoryId());
        rs.setCategoryName(iCategoryService.findOne(entity.getCategoryId()).getName());
        rs.setCode(entity.getCode());
        rs.setContent(entity.getContent());
        rs.setId(entity.getId());
        rs.setGiaTruoc(entity.getGiaTruoc());
        rs.setGiaSau(entity.getGiaSau());
        rs.setLink(entity.getLink());
        rs.setSale(entity.getSale());
        rs.setKhuyenMai(entity.getKhuyenMai());
        rs.setWeb(entity.getWeb());
        rs.setShortDescription(entity.getShortDescription());
        return rs;
    }
    public ItemEntity toEntity(ItemDto itemDto)
    {
        ItemEntity rs = new ItemEntity();
        rs.setCategoryId(itemDto.getCategoryId());
        rs.setCode(itemDto.getCode());
        rs.setContent(itemDto.getContent());
        rs.setName(itemDto.getName());
        rs.setGiaTruoc(itemDto.getGiaTruoc());
        rs.setGiaSau(itemDto.getGiaSau());
        rs.setLink(itemDto.getLink());
        rs.setSale(itemDto.getSale());
        rs.setKhuyenMai(itemDto.getKhuyenMai());
        rs.setWeb(itemDto.getWeb());
        rs.setShortDescription(itemDto.getShortDescription());
        return rs;
    }
}
