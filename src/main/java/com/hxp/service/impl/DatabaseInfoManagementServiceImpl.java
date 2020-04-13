package com.hxp.service.impl;

import com.hxp.dao.DatabaseInfoManagementDAO;
import com.hxp.service.DatabaseInfoManagementService;
import com.hxp.vo.DatabaseInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hxp on 2020/3/25.
 */
@Service
public class DatabaseInfoManagementServiceImpl implements DatabaseInfoManagementService  {
    private Logger LOGGER = LoggerFactory.getLogger(DatabaseInfoManagementServiceImpl.class);
    @Autowired
    private DatabaseInfoManagementDAO databaseInfoManagementDAO;
    @Override
    public boolean addDatabaseInfo(List<DatabaseInfoVO> databaseInfoVOList) {
        if(null != databaseInfoVOList && databaseInfoVOList.size()>0){
            int result = databaseInfoManagementDAO.addDatabaseInfo(databaseInfoVOList);
            if(result>0){
                return true;
            }
        }
        return false;
    }

    @Override
    public List<DatabaseInfoVO> queryDatabaseInfoList() {
        List resutList = databaseInfoManagementDAO.queryDatabaseInfoList();
        if(null != resutList && resutList.size()>0){
            return resutList;
        }else{
            LOGGER.info("查询结果为空，无数据库信息.....");
            return null;
        }
        //return databaseInfoManagementDAO.queryDatabaseInfoList();
    }

    @Override
    public void deleteDatabaseInfo(DatabaseInfoVO databaseInfoVO) {
        databaseInfoManagementDAO.deleteDatabaseInfo(databaseInfoVO);
    }

    @Override
    public void editDatabaseInfo(DatabaseInfoVO databaseInfoVO) {
        databaseInfoManagementDAO.editDatabaseInfo(databaseInfoVO);
    }
}
