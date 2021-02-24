package com.mypham.dto;

import com.mypham.entity.BaseEntity;

public class CategoryDto extends BaseEntity
{
    private String name;
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
