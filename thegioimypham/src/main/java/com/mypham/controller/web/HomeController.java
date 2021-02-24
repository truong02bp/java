package com.mypham.controller.web;

import com.mypham.dto.ItemDto;
import com.mypham.entity.RoleEntity;
import com.mypham.repository.ItemRepository;
import com.mypham.repository.UserRepository;
import com.mypham.service.IItemService;
import com.mypham.service.impl.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class HomeController
{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private IItemService iItemService;

    @RequestMapping(value = {"/trang-chu","/"} , method = RequestMethod.GET)
    public ModelAndView homePage()
    {
        ModelAndView mav = new ModelAndView("web/home");
        List<ItemDto> items = iItemService.findAllByWeb("adflex");
        mav.addObject("items",items);
        return mav;
    }
    @RequestMapping(value = "/dang-nhap" , method = RequestMethod.GET)
    public ModelAndView login()
    {
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }
    @RequestMapping(value = "/dang-xuat" , method = RequestMethod.GET)
    public ModelAndView logOut(HttpServletRequest req , HttpServletResponse resp)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication!=null)
            new SecurityContextLogoutHandler().logout(req,resp,authentication);
        return new ModelAndView("redirect:/trang-chu");
    }
    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public ModelAndView accessDenied()
    {
        return new ModelAndView("redirect:/dang-nhap?accessDenied");
    }
}
