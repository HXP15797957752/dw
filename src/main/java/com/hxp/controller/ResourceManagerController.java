package com.hxp.controller;

import com.hxp.service.ResourceManagerService;
import com.hxp.vo.FileInfoVO;
import com.hxp.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hxp on 2020/3/24.
 */
@RestController
public class ResourceManagerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceManagerController.class);

    @Autowired
    private ResourceManagerService resourceManagerService;

    @RequestMapping("/resource/createdir")
    public void creatDirectory(UserVO userVO){

    }

    @RequestMapping("/resource/uploadfile")
    public void uploadFile(UserVO userVO, FileInfoVO fileInfoVO){

    }

    @RequestMapping("/resource/query")
    public String queryFile(UserVO userVO){
        return null;
    }
}
