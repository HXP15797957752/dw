package com.hxp.test.dao;

import com.hxp.dao.DatabaseInfoManagementDAO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by hxp on 2020/4/1.
 */
public class DatabseInfoManagementDAOTest extends BaseTest {
    @Autowired
    public DatabaseInfoManagementDAO databaseInfoManagementDAO;
    @Test
    public void queryTest(){
        List list = databaseInfoManagementDAO.queryDatabaseInfoList();
        System.out.print(list);
    }

}
