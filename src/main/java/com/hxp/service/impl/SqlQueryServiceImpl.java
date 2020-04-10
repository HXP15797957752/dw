package com.hxp.service.impl;


import com.alibaba.druid.sql.SQLUtils;
import com.hxp.dao.SqlQueryDAO;
import com.hxp.service.SqlQueryService;
import com.hxp.vo.SqlHistory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hxp on 2020/3/24.
 */
@Service
public class SqlQueryServiceImpl implements SqlQueryService {
    private Logger LOGGER = LoggerFactory.getLogger(SqlQueryServiceImpl.class);

    @Autowired
    private SqlQueryDAO sqlQueryDAO;
    @Override
    public String formatSql(String sql) {
        String formatSql = SQLUtils.formatMySql(sql);
        return formatSql;
    }

    @Override
    public Boolean checkSql(String sql) throws Exception{
        //切割字符串取出databasename  tablename
        String databasename  = "dw";
        String tablename = null;
        //此处查询的是使用information_schema库，涉及到不同库的操作 TODO
        //检查库是否存在
        int resultDatabasename = sqlQueryDAO.checkDatabase(databasename);
        if(resultDatabasename <=0){
            LOGGER.error("对应的{}库不存在", databasename);
            //throw new  Exception("对应的" + databasename + "库不存在");
            return false;
        }
        //检查表是否存在
        int resultTablename = sqlQueryDAO.checkTable(tablename);
        if(resultTablename <=0){
            LOGGER.error("对应的{}库不存在", tablename);
            //throw new  Exception("对应的" + tablename + "库不存在");
            return false;
        }
        return true;
    }

    @Override
    public int insertSql(SqlHistory sql){
        int  result = sqlQueryDAO.insertSql(sql);
        return result;
    }

    @Override
    public void executeSql(String sql){
        //调用spark执行任务 TODO
    }

    @Override
    public List querySqlAll(){
        return sqlQueryDAO.querySqlAll();
    }

}
