package com.hxp.test.dao;

import com.alibaba.druid.sql.SQLUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by hxp on 2020/4/2.
 */
public class SqlQueryTest extends BaseTest {
    private Logger LOGGER = LoggerFactory.getLogger(SqlQueryTest.class);

    @Test
    public void formatSql(){
        String sql = "select * from table1";
        String formatSql = SQLUtils.formatMySql(sql);
        LOGGER.info(formatSql);
    }
}
