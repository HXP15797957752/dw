package com.hxp.test.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.net.URI;

/**
 * Created by hxp on 2020/4/14.
 */
public class HDFSClient {
    private Logger LOGGER = LoggerFactory.getLogger(HDFSClient.class);
    String uri = "hdfs://localhost:9000/";
    static {
        System.setProperty("hadoop.home.dir", "D:\\hadoop-3.1.3");
    }
    @Test
    public void hdfsClientTest(){
        try {
            //String uri = "hdfs://47.97.222.61:9000/";

            Configuration configuration = new Configuration();
            configuration.set("fs.defaultFS", uri);
            //configuration.set("hadoop.home.dir", "D:\\\\hadoop-3.1.3");
            //configuration.set("HADOOP_HOME", "D:\\Program Files\\hadoop-3.1.3");
            FileSystem fs = FileSystem.get(URI.create(uri), configuration, "root");
            //获取/test/input/目录下的所有文件和目录
            FileStatus[] statuses = fs.listStatus(new Path("/input"));
            //回显路径信息
            for (FileStatus s: statuses) {
                System.out.println(s.getPath().toUri().getPath());
            }
            fs.close();

        }catch (Exception e){}

    }

    @Test
    public void createHdfsDir(){
        String dir = "/xxx";

        try {
            Configuration configuration = new Configuration();
            configuration.set("fs.defaultFS", uri);
            FileSystem fs = FileSystem.get(URI.create(uri), configuration, "hdfs");
            fs.mkdirs(new  Path(dir));
            fs.close();
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.error("创建HDFS文件夹失败");
        }
    }

    @Test
    public void testUpload(){
        com.hxp.utils.HDFSClient.uploadFile(new Path("D:\\hadoop-3.1.3\\etc\\hadoop\\hadoop-env.cmd"), null);
    }
}
