package com.mypham.service.impl;

import com.mypham.dto.UserDto;
import com.mypham.entity.RoleEntity;
import com.mypham.entity.UserEntity;
import com.mypham.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        UserEntity userEntity = userRepository.findOneByUserName(username);
        if (userEntity == null)
            throw new UsernameNotFoundException("User not found");
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (RoleEntity role : userEntity.getRoles())
            authorities.add(new SimpleGrantedAuthority(role.getCode()));
        UserDto user = new UserDto(userEntity.getUserName() , userEntity.getPassword() ,  true , true ,true
                , true , authorities);
        user.setFullname(userEntity.getFullName());
        return user;
    }
}
