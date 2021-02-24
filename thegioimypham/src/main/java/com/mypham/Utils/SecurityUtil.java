package com.mypham.Utils;

import com.mypham.dto.UserDto;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.List;

public class SecurityUtil
{
    public static UserDto getPrincical()
    {
        UserDto user = (UserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user;
    }
    @SuppressWarnings("unchecked")
    public static List<String> getRoles()
    {
        List<String> rs = new ArrayList<>();
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        for (GrantedAuthority grantedAuthority : authorities)
            rs.add(grantedAuthority.getAuthority());
        return rs;
    }
}
