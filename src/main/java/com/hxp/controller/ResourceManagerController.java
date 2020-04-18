package com.hxp.controller;

import com.hxp.service.ResourceManagerService;
import com.hxp.utils.HDFSClient;
import com.hxp.vo.ResourceVO;
import com.hxp.vo.UserVO;
import org.apache.hadoop.fs.Path;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by hxp on 2020/3/24.
 */
@Controller
public class ResourceManagerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceManagerController.class);

    @Autowired
    private ResourceManagerService resourceManagerService;

    @PostMapping("/resource/createdir")
    public void creatDirectory(UserVO userVO, String dirname, HttpServletResponse response){

        HDFSClient.createHdfsDir(dirname);
        try{
            response.sendRedirect("/resource/query");
        }catch(Exception e){
            LOGGER.error("重定向出错........");
        }
    }

    @PostMapping("/resource/uploadfile")
    public void uploadFile(HttpServletRequest request, HttpServletResponse response, @RequestParam("file") MultipartFile file){
        UserVO userVO = (UserVO) request.getSession().getAttribute("user");
        ResourceVO resourceVO = new ResourceVO();
        if(userVO == null){
            LOGGER.error("上传文件用户名为空");
            try{
                response.sendRedirect("/resource/query");
            }catch(Exception e){
                LOGGER.error("重定向出错........");
            }

        }
        resourceVO.setUsername(userVO.getUsername());
        resourceVO.setFileName(file.getOriginalFilename());

        try {
            Path sourcePath = new Path(file.getOriginalFilename());
            HDFSClient.uploadFile(sourcePath, file);
        }catch (Exception e){
            LOGGER.error("HDFS保存文件失败！");
        }
        resourceManagerService.insertFileRecord(resourceVO);
        try{
            response.sendRedirect("/resource/query");
        }catch(Exception e){
            LOGGER.error("重定向出错........");
        }
    }

    @GetMapping("/resource/query")
    public String queryFile(UserVO userVO, Model model){
        List fielList = resourceManagerService.queryFile(userVO);
        return "/resource";
    }
}
