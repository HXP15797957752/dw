package com.hxp.test.hdfs;

import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;

import java.net.URI;
import org.apache.hadoop.conf.Configuration;
/**
 * Created by hxp on 2020/4/14.
 */
public class HDFSClient {
    @Test
    public void hdfsClientTest(){
        try {
            String uri = "hdfs://192.168.109.10:9000/";
            Configuration configuration = new Configuration();
            FileSystem fs = FileSystem.get(URI.create(uri), configuration);
            //获取/test/input/目录下的所有文件和目录
            FileStatus[] statuses = fs.listStatus(new Path("/huangxiaoping"));
            //回显路径信息
            for (FileStatus s: statuses) {
                System.out.print(s);
            }

        }catch (Exception e){}


    }
}
