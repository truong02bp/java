package com.mypham.controller.web;

import com.mypham.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController
{
    @Autowired
    private IItemService iItemService;
    @RequestMapping(value = "/san-pham" , method = RequestMethod.GET)
    public ModelAndView productPage(@RequestParam Long id)
    {
        ModelAndView mav = new ModelAndView("web/product");
        mav.addObject("item",iItemService.findOne(id));
        return mav;
    }
}
