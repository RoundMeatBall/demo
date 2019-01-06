package com.seauf.user.service;

import com.seauf.user.dao.UserMapper;
import com.seauf.user.interfs.UserService;
import com.seauf.user.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public String getUserInfo(){
        User user = new User();
        user.setId(1L);
        user.setName("123");
        return user.toString();
    }

    @Override
    public Long createUser() {
        User user = new User();
        user.setName("lynn");
        user.setId(00001L);
        Long result = userMapper.insert(user);
        return result;
    }

}
