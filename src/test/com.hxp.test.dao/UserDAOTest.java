package com.hxp.test.dao;

import com.hxp.dao.UserDAO;
import com.hxp.vo.UserVO;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by hxp on 2020/4/1.
 */
public class UserDAOTest extends BaseTest {
    private Logger LOGGER = LoggerFactory.getLogger(UserDAOTest.class);

    @Autowired
    UserDAO userDAO;
    @Test
    public void getUserByUsername(){
        UserVO userVO = userDAO.getUserByUsername("hxp");
        LOGGER.info("{}结果", userVO.toString());
        System.out.print("====================");
        System.out.print(userVO.toString());
    }

    @Test
    public void register(){
        UserVO userVO = userDAO.getUserByUsername("hxp");
        userVO.setId(1L);
        userVO.setUsername("huangxiaoping");
        userDAO.register(userVO);

    }

}
