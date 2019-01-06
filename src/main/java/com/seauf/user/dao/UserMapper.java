package com.seauf.user.dao;

import com.seauf.annotation.MyBatisRepository;
import com.seauf.user.po.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author: Mr.lynn
 * @create: 2019-01-03 22:10
 **/
@MyBatisRepository
public interface UserMapper {

    User getUser();

    long insert(@Param("user") User user);
}
