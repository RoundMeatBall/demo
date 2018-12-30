package com.seauf.user.service;

import com.seauf.user.interfs.StudentService;
import org.springframework.stereotype.Service;

/**
 * @author: Mr.lynn
 * @create: 2018-12-28 22:53
 **/
@Service
public class StudentServiceImpl implements StudentService {

    @Override
    public String getStudentInfo() {
        return "我是学生";
    }
}
