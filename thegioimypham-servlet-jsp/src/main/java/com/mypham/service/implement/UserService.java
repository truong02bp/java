package com.mypham.service.implement;

import com.mypham.dao.IUserDao;
import com.mypham.model.UserModel;
import com.mypham.service.IUserService;

import javax.inject.Inject;

public class UserService implements IUserService
{
    @Inject
    private IUserDao userDao;

    @Override
    public UserModel findByUsernameAndPassword(String username , String password) {
        return userDao.findByUserNameAndPassword(username,password);
    }
}
