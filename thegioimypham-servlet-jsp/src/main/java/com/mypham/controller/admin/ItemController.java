package com.mypham.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mypham.model.CategoryModel;
import com.mypham.model.ItemModel;
import com.mypham.paging.PageRequest;
import com.mypham.paging.Pageble;
import com.mypham.service.ICategoryService;
import com.mypham.service.IItemService;
import com.mypham.sorter.Sorter;
import com.mypham.ultis.FormUlti;

@WebServlet(urlPatterns = {"/admin-item"})
public class ItemController extends HttpServlet
{
	@Inject
	private IItemService itemService;
	@Inject
	private ICategoryService categoryService;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		ResourceBundle resourceBundle = ResourceBundle.getBundle("messenge");
		String action = req.getParameter("action");
		ItemModel item = FormUlti.toModel(ItemModel.class, req);
		String value="";
		List<CategoryModel> categories = categoryService.findAll();
		req.setAttribute("categories",categories);
		if (action.equals("list"))
		{
			Pageble pageble = new PageRequest(item.getPage(), item.getMaxPage() , new Sorter(item.getSortName(), item.getSortBy()));
			long soItem = itemService.count();
			item.setListResult(itemService.findAll(pageble));
			item.setTotalPage((long) Math.ceil((double)soItem/item.getMaxPage()));
			value = "/view/admin/item/list.jsp?action=list";
		}
		else
			if (action.equals("add"))
			{
				value="/view/admin/item/add.jsp?action=add";
			}
			else
				if(action.equals("edit"))
				{
					item = itemService.findOne(item.getId());
					item.setCategoryName(categoryService.findOne(item.getCategoryId()).getName());
					value="/view/admin/item/edit.jsp?action=edit";
				}
		String messenge = req.getParameter("messenge");
		String alert = req.getParameter("alert");
		if (messenge!=null)
		{
			String messengeResponse = "";
			String alertResponse = "";
			if (messenge.equals("Add_Success"))
			{
				messengeResponse = resourceBundle.getString("Add_Success");
				alertResponse = "success";
			}
			else
				if (messenge.equals("Add_Fail"))
				{
					messengeResponse = resourceBundle.getString("Add_Fail");
					alertResponse = "danger";
				}
				else
					if (messenge.equals("Update_Success"))
					{
							messengeResponse = resourceBundle.getString("Update_Success");
							alertResponse = "success";
					}
					else
						if (messenge.equals("Update_Fail"))
						{
							messengeResponse = resourceBundle.getString("Update_Fail");
							alertResponse = "danger";
						}
						else
							if (messenge.equals("Delete_Success"))
							{
								messengeResponse = resourceBundle.getString("Delete_Success");
								alertResponse = "success";
							}
							else
								if (messenge.equals("Delete_Fail"))
								{
									messengeResponse = resourceBundle.getString("Delete_Fail");
									alertResponse = "danger";
								}
			req.setAttribute("messengeResponse",messengeResponse);
			req.setAttribute("alertResponse",alertResponse);
		}
		req.setAttribute("model",item);
		RequestDispatcher rd = req.getRequestDispatcher(value);
		rd.forward(req, resp);
	}
}
