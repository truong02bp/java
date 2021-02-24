package com.mypham.dao.implement;

import java.util.List;

import com.mypham.dao.IUserDao;
import com.mypham.mapper.UserMapper;
import com.mypham.model.UserModel;

public class UserDao extends AbstractDao implements IUserDao
{
	@Override
	public UserModel findByUserNameAndPassword(String username, String password) {
		StringBuilder sql = new StringBuilder("select * from user as u inner join role as r on r.id = u.roleid");
		sql.append(" where username=? and password=?");
		List<UserModel> list = query(sql.toString(),new UserMapper() , username , password);
		if (list!=null)
			return list.get(0);
		return null;
	}
}
