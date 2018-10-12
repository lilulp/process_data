package com.process.data.service.impl;

import com.process.data.dao.UserMapper;
import com.process.data.pojo.User;
import com.process.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void inset() {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setUsername("zhangsan");
        user.setPassword("11111");
        userMapper.insertSelective(user);
    }
}
