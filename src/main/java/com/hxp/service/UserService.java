package com.hxp.service;

import com.hxp.vo.UserVO;
import org.springframework.stereotype.Component;

/**
 * Created by hxp on 2020/3/23.
 */
public interface UserService {
    /**
     * 根据ID查询用户信息
     * @param id
     * @return
     */
     UserVO getUserById(Long id);

    /**
     * 用户注册
     * @param userVO
     * @return
     */
    String register(UserVO userVO);

    /**
     * 根据username查询用户
     * @param userVO 查询条件
     * @return
     */
    UserVO getUserByUsername(UserVO userVO);
}
