package com.hxp.utils;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huang on 2020/4/17.
 */
public class HDFSClient {
    private static Logger LOGGER = LoggerFactory.getLogger(HDFSClient.class);
    private  static String uri = "hdfs://localhost:9000/";
    static {
        System.setProperty("hadoop.home.dir", "D:\\hadoop-3.1.3");
    }
    public static List<String>  getPathList(String path){
        if(path == null || path.equals(" ")){
            path = "/";
        }

        List<String> result = new ArrayList<>();
        try {
            Configuration configuration = new Configuration();
            configuration.set("fs.defaultFS", uri);
            FileSystem fs = FileSystem.get(URI.create(uri), configuration, "root");
            //获取/input/目录下的所有文件和目录
            FileStatus[] statuses = fs.listStatus(new Path(path));
            //回显路径信息
            for (FileStatus s: statuses) {
                result.add(s.getPath().toUri().getPath());
            }

            fs.close();

        }catch (Exception e){
            LOGGER.error("获取hdfs文件失败");
        }

        return result;
    }

    public static void createHdfsDir(String dir){
        try {
            Configuration configuration = new Configuration();
            configuration.set("fs.defaultFS", uri);
            FileSystem fs = FileSystem.get(URI.create(uri), configuration, "root");
            fs.create(new Path(dir));
            fs.close();
        }catch (Exception e){
            LOGGER.error("创建HDFS文件夹失败");
        }
    }

    public static  void uploadFile(Path src, MultipartFile file){
        try {
            Configuration configuration = new Configuration();
            configuration.set("fs.defaultFS", uri);
            FileSystem fs = FileSystem.get(URI.create(uri), configuration, "hdfs");
           // fs.create(src);
            String path = uri + "/jar/" + src.getName();
            FSDataOutputStream out = fs.create(new Path(path));
            InputStream in = file.getInputStream();
            IOUtils.copyBytes(in, out, 1024, true);
            fs.close();
        }catch (Exception e){
            LOGGER.error("上传HDFS文件失败");
        }
    }

    public static void createFile(Path sourcePath){
        try {
            Configuration configuration = new Configuration();
            configuration.set("fs.defaultFS", uri);
            FileSystem fs = FileSystem.get(URI.create(uri), configuration, "hdfs");
            fs.create(sourcePath);
            fs.close();
        }catch (Exception e){
            LOGGER.error("上传HDFS文件失败");
        }
    }
}
