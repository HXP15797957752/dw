package com.hxp.dao;

import com.hxp.vo.DatabaseInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hxp on 2020/4/1.
 */
@Mapper
//@Repository
public interface DatabaseInfoManagementDAO {
    /**
     * 插入数据库信息（可批量）
     * @param list
     * @return
     */
    int addDatabaseInfo(List<DatabaseInfoVO> list);
    List queryDatabaseInfoList();
    void deleteDatabaseInfo(DatabaseInfoVO databaseInfoVO);
    void editDatabaseInfo(DatabaseInfoVO databaseInfoVO);
}
