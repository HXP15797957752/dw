package com.hxp.service.impl;

import com.hxp.dao.UserDAO;
import com.hxp.service.UserService;
import com.hxp.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by hxp on 2020/3/23.
 */
@Service
public class UserServiceImpl implements UserService {
    private Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    UserDAO userDAO;

    @Override
    public UserVO getUserById(Long id) {
        return null;
    }

    @Override
    public UserVO getUserByUsername(UserVO userVO) {
        UserVO resultUserVO = userDAO.getUserByUsername(userVO.getUsername());
        if(resultUserVO != null){
            return resultUserVO;
        }else{
            LOGGER.warn("没有{}此用户", userVO.getUsername());
            return null;
        }
        //return resultUserVO;
    }

    @Override
    public String register(UserVO userVO) {
        String msg = "success";
        UserVO userByUsername = getUserByUsername(userVO);
        if(userByUsername != null){
            return "用户名重复，用户已注册";
        }
        //注册
        int result = userDAO.register(userVO);
        if(result > 0){
            return msg;
        }
        return msg;
    }
}
