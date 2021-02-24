package com.mypham.controller.web;

import com.mypham.model.UserModel;
import com.mypham.service.IUserService;
import com.mypham.ultis.FormUlti;
import com.mypham.ultis.SessionUlti;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/trang-chu","/dang-nhap","/thoat"})
public class HomeController extends HttpServlet
{
	@Inject
	private IUserService userService;

	private ResourceBundle resourceBundle = ResourceBundle.getBundle("messenge");
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		if (action!=null)
		{
			if (action.equals("login"))
			{
				String messenge = req.getParameter("messenge");
				String alert = req.getParameter("alert");
				if (messenge!= null && alert!=null)
				{
					req.setAttribute("messenge",resourceBundle.getString(messenge));
					req.setAttribute("alert",alert);
				}
				RequestDispatcher rd = req.getRequestDispatcher("/view/login.jsp");
				rd.forward(req, resp);
			}
			else
				if (action.equals("logout"))
				{
					SessionUlti.getInstance().removeValue(req,"UserModel");
					resp.sendRedirect(req.getContextPath()+"/trang-chu");
				}
		}
		else
		{
			RequestDispatcher rd = req.getRequestDispatcher("/view/web/home.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");

		if (action!=null && action.equals("login"))
		{
			UserModel model = FormUlti.toModel(UserModel.class,req);
			model = userService.findByUsernameAndPassword(model.getUsername(),model.getPassword());
			if (model!=null )
			{
				SessionUlti.getInstance().putValue(req,"UserModel",model);
				if (model.getRole().getName().equals("admin"))
					resp.sendRedirect(req.getContextPath()+"/admin-home");
				else
					if (model.getRole().getName().equals("user"))
						resp.sendRedirect(req.getContextPath()+"/trang-chu");
			}
			else
				resp.sendRedirect(req.getContextPath()+"/dang-nhap?action=login&messenge=Username_password_invalid&alert=danger");
		}
	}
}
