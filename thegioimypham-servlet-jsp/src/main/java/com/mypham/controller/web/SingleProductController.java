package com.mypham.controller.web;

import com.mypham.model.ItemModel;
import com.mypham.service.implement.ItemService;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/single-product"})
public class SingleProductController extends HttpServlet
{
	@Inject
	private ItemService itemService;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		String action = req.getParameter("action");
		if (action.equals("22again"))
		{
			ItemModel item = itemService.findOne((long)56);
			req.setAttribute("item",item);
		}
		RequestDispatcher rd = req.getRequestDispatcher("/view/web/singleproduct.jsp");
		rd.forward(req, resp);
	}
}
