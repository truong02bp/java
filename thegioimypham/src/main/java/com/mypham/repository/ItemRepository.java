package com.mypham.repository;

import com.mypham.dto.ItemDto;
import com.mypham.entity.ItemEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<ItemEntity , Long>
{
    List<ItemEntity> findAllByWeb(String web);
    List<ItemEntity> findAllByCategoryId(Long id);
    int countByCategoryId(Long id);
    List<ItemEntity> findAllByCategoryId(Long id, Pageable pageable);
    List<ItemEntity> findByCategoryIdOrderByGiaSauAsc(Long id, Pageable pageable);
    List<ItemEntity> findByCategoryIdOrderByGiaSauDesc(Long id, Pageable pageable);
}
