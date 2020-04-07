package com.hxp.service;

import java.util.List;

/**
 * Created by hxp on 2020/3/24.
 */
public interface SqlQueryService {
    /**
     * 格式化SQL
     * @param sql
     * @return
     */
    String formatSql(String sql);

    /**
     *检查SQL 即检查表 库是否存在
     * @param sql
     * @return
     */
    Boolean checkSql(String sql) throws Exception;

    /**
     * 保存SQL
     * @param sql
     * @return
     */
    int insertSql(String sql);

    /**
     * 执行SQL spark任务
     * @param sql
     */
    void executeSql(String sql);

    /**
     * 查询sql历史记录
     * @return
     */
    List querySqlAll();
}
