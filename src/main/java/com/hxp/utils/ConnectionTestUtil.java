package com.hxp.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 * Created by hxp on 2020/4/13.
 */
public class ConnectionTestUtil {

    private static Logger LOGGER = LoggerFactory.getLogger(ConnectionTestUtil.class);

    public static boolean connectionTest(String url,String username,String  password) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            LOGGER.error("驱动加载失败");
            //return false;
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
            LOGGER.info("success linked database");
            return true;
        } catch (Exception e) {
            LOGGER.error("faild linked database");
            //return false;
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
            }
        }
        return false;
    }
}
