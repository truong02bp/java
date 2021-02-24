package com.mypham.api;

import com.mypham.dto.ItemDto;
import com.mypham.repository.ItemRepository;
import com.mypham.repository.UserRepository;
import com.mypham.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "ItemApi")
public class ItemAPI
{
    @Autowired
    private IItemService iItemService;
    @PostMapping("/api-item")
    public ItemDto addItem(@RequestBody ItemDto itemDto)
    {
        return iItemService.save(itemDto);
    }
    @PutMapping("/api-item")
    public ItemDto updateItem(@RequestBody ItemDto itemDto)
    {
        return iItemService.save(itemDto);
    }
    @DeleteMapping("/api-item")
    public void deleteItem(@RequestBody long[] ids)
    {
        System.out.println("ok");
        iItemService.delete(ids);
    }
}
