package com.hxp.dao;

import com.hxp.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * Created by hxp on 2020/3/23.
 */
//@Repository
@Mapper
public interface UserDAO {
    UserVO getUserById();

    UserVO getUserByUsername(String  username);
    int register(UserVO userVO);
}
