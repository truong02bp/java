package com.mypham.filter;

import com.mypham.model.UserModel;
import com.mypham.ultis.SessionUlti;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class authorizationFilter implements Filter {
    private ServletContext servletContext;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.servletContext = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        String url = req.getRequestURI();
        if (url.startsWith("/admin"))
        {
            UserModel model = (UserModel) SessionUlti.getInstance().getValue(req,"UserModel");
            if (model!=null)
            {
                if (model.getRole().getName().equals("admin"))
                    filterChain.doFilter(servletRequest,servletResponse);
                else
                {
                    if (model.getRole().getName().equals("user"))
                        resp.sendRedirect(req.getContextPath()+"/dang-nhap?action=login&messenge=not_permission&alert=danger");
                }
            }
            else
            {
                resp.sendRedirect(req.getContextPath()+"/dang-nhap?action=login&messenge=not_login&alert=danger");
            }
        }
        else
            filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
