package com.seauf.user.service;

import com.seauf.user.interfs.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    public String getUserInfo(){
        System.out.println("我是用户");
        return "user";
    }

    public String throwE(){
        int i = 1/0;
        System.out.println("抛出异常");
        return "抛出异常";
    }

}
