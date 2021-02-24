package com.mypham.controller.web.api;

import java.io.IOException;
import java.sql.Timestamp;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mypham.model.ItemModel;
import com.mypham.model.UserModel;
import com.mypham.service.ICategoryService;
import com.mypham.service.IItemService;
import com.mypham.service.implement.ItemService;
import com.mypham.ultis.HttpUlti;
import com.mypham.ultis.SessionUlti;

@WebServlet(urlPatterns = {"/api-item"})
public class ItemAPI extends HttpServlet
{
	@Inject
	private IItemService itemService;
	@Inject
	private ICategoryService categoryService;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ItemModel item = new ItemModel();
		item = HttpUlti.of(req.getReader()).toModel(ItemModel.class);
		item.setCategoryId(categoryService.findByName(item.getCategoryName()).getId());
		item.setCreatedBy( ((UserModel) SessionUlti.getInstance().getValue(req,"UserModel")).getFullName());
		Long id = itemService.insert(item);
		item = itemService.findOne(id);
		mapper.writeValue(resp.getOutputStream(),item);
	}
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ItemModel item = new ItemModel();
		item = HttpUlti.of(req.getReader()).toModel(ItemModel.class);
		item.setCategoryId(categoryService.findByName(item.getCategoryName()).getId());
		item.setModifiedBy(((UserModel) SessionUlti.getInstance().getValue(req,"UserModel")).getFullName());
		itemService.update(item);
		item = itemService.findOne(item.getId());
		mapper.writeValue(resp.getOutputStream(), item);
	}
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		ItemModel item = HttpUlti.of(req.getReader()).toModel(ItemModel.class);
		itemService.delete(item.getIds());
	}
}
