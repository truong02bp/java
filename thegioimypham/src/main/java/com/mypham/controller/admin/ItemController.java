package com.mypham.controller.admin;

import com.mypham.Utils.MessengeUtil;
import com.mypham.dto.ItemDto;
import com.mypham.service.ICategoryService;
import com.mypham.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ItemController {
    @Autowired
    private IItemService iItemService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private MessengeUtil messengeUtil;
    @RequestMapping(value = "/admin-list", method = RequestMethod.GET)
    public ModelAndView listItem(@RequestParam("page") int page, @RequestParam("limit") int limit , HttpServletRequest
                                 req) {
        ModelAndView mav = new ModelAndView("admin/list");
        ItemDto model = new ItemDto();
        model.setPage(page);
        model.setLimit(limit);
        String messenge = req.getParameter("messenge");
        if (messenge!=null)
        {
            mav.addObject("messenge",messengeUtil.getMessenge(messenge));
            mav.addObject("alert",messengeUtil.getAlert(messenge));

        }
        Pageable pageable = new PageRequest(page - 1, limit);
        model.setList(iItemService.findAll(pageable));
        model.setTotalPage((int) Math.ceil((double) iItemService.getTotalItem() / limit));
        mav.addObject("model", model);
        return mav;
    }

    @RequestMapping(value = "/admin-chinh-sua", method = RequestMethod.GET)
    public ModelAndView createUpdate(@RequestParam(value = "id", required = false) Long id, HttpServletRequest req) {
        ItemDto model = new ItemDto();
        if (id != null) {
            model = iItemService.findOne(id);
            model.setCategoryName(categoryService.findOne(model.getCategoryId()).getName());
        }
        ModelAndView mav = new ModelAndView("admin/createUpdate");
        String messenge = req.getParameter("messenge");
        if (messenge != null)
        {
            mav.addObject("messenge",messengeUtil.getMessenge(messenge));
            mav.addObject("alert",messengeUtil.getAlert(messenge));
        }
        mav.addObject("categories", categoryService.findAll());
        mav.addObject("model", model);
        return mav;
    }
}
