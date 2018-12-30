package com.seauf.user.service;

import com.seauf.user.interfs.StudentService;
import com.seauf.user.interfs.UserService;
import com.seauf.user.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private User user;
    @Autowired
    private StudentService studentService;

    @Bean
    public User getUser(){
        return new User();
    }

    public String getUserInfo(){
        System.out.println("我是用户");
        System.out.println(studentService.getStudentInfo());
        return "user"+user.toString();
    }

}
