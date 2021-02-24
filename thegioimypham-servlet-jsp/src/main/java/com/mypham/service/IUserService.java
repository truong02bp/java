package com.mypham.service;

import com.mypham.model.UserModel;

public interface IUserService
{
    UserModel findByUsernameAndPassword(String username , String password);
}
