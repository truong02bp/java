package com.mypham.repository;

import com.mypham.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long>
{
    CategoryEntity findOneByName(String name);
    CategoryEntity findOneByCode(String code);
}
