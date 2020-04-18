package com.hxp.service;

import com.hxp.vo.DatabaseInfoVO;

import java.util.List;

/**
 * Created by hxp on 2020/3/25.
 */
public interface DatabaseInfoManagementService {
    boolean addDatabaseInfo(List<DatabaseInfoVO> databaseInfoVOList);
    List<DatabaseInfoVO> queryDatabaseInfoList();
    void deleteDatabaseInfo(DatabaseInfoVO databaseInfoVO);
    void editDatabaseInfo(DatabaseInfoVO databaseInfoVO);
    String getPasswordByIpAndPort(String ip, String port);
}
