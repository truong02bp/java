package com.mypham.security;

import com.mypham.Utils.SecurityUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler
{
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    @Override
    public void handle(HttpServletRequest req , HttpServletResponse resp , Authentication authentication)
        throws IOException
    {
        String targetUrl = determineTargetUrl(authentication);
        if (resp.isCommitted())
            return;
        redirectStrategy.sendRedirect(req,resp,targetUrl);
    }
    private String determineTargetUrl(Authentication authentication)
    {
        String targetUrl = "";
        List<String> roles = SecurityUtil.getRoles();
        if (isUser(roles)==true)
            targetUrl="/trang-chu";
        else
            if (isAdmin(roles))
                targetUrl="/admin-home";
        return targetUrl;
    }

    @Override
    public RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

    @Override
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }

    private boolean isUser(List<String> roles)
    {
        if (roles.contains("user"))
            return true;
        return false;
    }
    private boolean isAdmin(List<String> roles)
    {
        if (roles.contains("admin"))
            return true;
        return false;
    }
}
