package com.mypham.controller.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mypham.model.ItemModel;
import com.mypham.service.IItemService;
@WebServlet(urlPatterns = {"/shop"})
public class ShopController extends HttpServlet
{
	@Inject
	private IItemService itemService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		
		RequestDispatcher rd = req.getRequestDispatcher("/view/web/shop.jsp");
		rd.forward(req, resp);
	}
}
