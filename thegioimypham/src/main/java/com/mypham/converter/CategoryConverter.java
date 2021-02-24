package com.mypham.converter;

import com.mypham.dto.CategoryDto;
import com.mypham.entity.CategoryEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter
{
    public CategoryDto toDto(CategoryEntity entity)
    {
        CategoryDto rs = new CategoryDto();
        rs.setId(entity.getId());
        rs.setName(entity.getName());
        rs.setCode(entity.getCode());
        return rs;
    }
}
