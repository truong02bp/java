package com.mypham.repository;

import com.mypham.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity,Long>
{
    UserEntity findOneByUserName(String username);
}
