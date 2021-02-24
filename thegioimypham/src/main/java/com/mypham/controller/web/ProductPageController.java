package com.mypham.controller.web;

import com.mypham.dto.CategoryDto;
import com.mypham.dto.ItemDto;
import com.mypham.service.ICategoryService;
import com.mypham.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductPageController
{
    @Autowired
    private IItemService iItemService;
    @Autowired
    private ICategoryService categoryService;
    @RequestMapping(value = "/page-san-pham" , method = RequestMethod.GET)
    public ModelAndView productPage(@RequestParam("name") String name , @RequestParam("page") int page , @RequestParam("limit")
                                    int limit , @RequestParam(value = "sort" , required = false) String sort)
    {
        ModelAndView mav = new ModelAndView("web/pageProduct");
        CategoryDto category = categoryService.findOneByCode(name);
        Long id = category.getId();
        ItemDto model = new ItemDto();
        model.setCategoryName(category.getName());
        model.setPage(page);
        model.setLimit(limit);
        model.setCategoryCode(name);
        Pageable pageable = new PageRequest(model.getPage()-1,limit);
        model.setList(iItemService.findAllByCategoryId(id,pageable,sort));
        model.setTotalPage((int) Math.ceil( (double) iItemService.getTotalItem(id) / limit));
        mav.addObject("model",model);
        mav.addObject("sort",sort);
        return mav;
    }
}
