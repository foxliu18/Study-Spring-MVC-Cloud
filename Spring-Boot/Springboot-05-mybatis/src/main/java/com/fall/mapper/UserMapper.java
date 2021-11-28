package com.fall.mapper;

import com.fall.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<User> queryUserList();

    User queryUserByID(User user);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
