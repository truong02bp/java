package com.mypham.dao;

import java.util.List;

import com.mypham.model.UserModel;

public interface IUserDao 
{
	UserModel findByUserNameAndPassword(String username , String password);
}
