package com.mypham.ultis;

import javax.servlet.http.HttpServletRequest;

public class SessionUlti
{
    private static SessionUlti sessionUlti = null;
    public static SessionUlti getInstance()
    {
        if (sessionUlti==null)
            sessionUlti = new SessionUlti();
        return sessionUlti;
    }
    public void putValue(HttpServletRequest req , String key , Object value)
    {
        req.getSession().setAttribute(key,value);
    }
    public Object getValue(HttpServletRequest req , String key)
    {
        return req.getSession().getAttribute(key);
    }
    public void removeValue(HttpServletRequest req , String key)
    {
        req.getSession().removeAttribute(key);
    }
}
