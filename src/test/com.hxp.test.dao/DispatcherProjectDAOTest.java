package com.hxp.test.dao;

import com.hxp.dao.DispatcherProjectDAO;
import com.hxp.vo.DispatcherProjectVO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * Created by hxp on 2020/4/2.
 */
public class DispatcherProjectDAOTest extends BaseTest {

    @Autowired
    DispatcherProjectDAO dispatcherProjectDAO;

    @Test
    public void createDispatcherProject(){
        DispatcherProjectVO dispatcherProjectVO = new DispatcherProjectVO();
        dispatcherProjectVO.setUsername("hxp");
        dispatcherProjectVO.setJobName("job1");
        dispatcherProjectVO.setMainJar("xxxx.jar");
        dispatcherProjectVO.setMainClass("com.java.main");
        dispatcherProjectVO.setDependencyJar("xxx1.jar");
        dispatcherProjectVO.setFinishedNotify(0);
        dispatcherProjectVO.setJobParameter("opts : -jvm");
        dispatcherProjectVO.setCtime(new Date());
        dispatcherProjectVO.setMtime(new  Date());

        dispatcherProjectDAO.createDispatcherProject(dispatcherProjectVO);

    }
}
