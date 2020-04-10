package com.hxp.dao;

import com.hxp.vo.SqlHistory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by hxp on 2020/4/2.
 */
@Mapper
public interface SqlQueryDAO {
    int checkDatabase(String databasename);
    int checkTable(String tablename);
    int insertSql(SqlHistory sql);
    List querySqlAll();
}
