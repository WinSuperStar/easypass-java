package com.joshua.easypass.service;

import com.joshua.easypass.repository.UserRepository;
import com.joshua.easypass.entity.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService {
    public final static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepo;

    public User[] getUsers(String username, String phone, Integer roleid, String state) {
        logger.info("查询中：用户名为{},手机号码为{}, 岗位为{}, 状态为{}", username, phone, roleid, state);
        return userRepo.getUsers(username, phone, roleid, state);
    }
    
    public User[] getUsersByOwner(String username, String phone, Integer roleid, String state,Integer userid) {
        logger.info("查询中：用户名为{},手机号码为{}, 岗位为{}, 状态为{}", username, phone, roleid, state);
        return userRepo.getUsersByOwner(username, phone, roleid, state,userid);
    }

    public User[] getAllUsers(){return userRepo.getAllUsers();}

    public User getUser(Integer userid) {
        return userRepo.getUser(userid);
    }

    public User login(String username, String password) {
        logger.info("登录中，用户名为{}， 密码为{}", username, password);
        return userRepo.find(username, password);
    }
    @Transactional
    public void addUser(User user) {
        userRepo.saveUser(user.getUserid(),user.getUsername(),user.getPassword(),user.getGender(),user.getState(),user.getPhone(),user.getCertpath(),
                user.getCertnum(),user.getCreatedate(),user.getCreator(),user.getAdd1(),user.getAdd2(),user.getAdd3(), user.getRoleid());
    }
}
