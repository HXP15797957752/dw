package com.hxp.service.impl;

import com.hxp.dao.ResourceManagerDAO;
import com.hxp.service.ResourceManagerService;
import com.hxp.vo.ResourceVO;
import com.hxp.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hxp on 2020/3/24.
 */
@Service
public class ResourceManagerServiceImpl implements ResourceManagerService {
    private Logger LOGGER = LoggerFactory.getLogger(ResourceManagerServiceImpl.class);

    @Autowired
    ResourceManagerDAO resourceManagerDAO;

    @Override
    public void insertFileRecord(ResourceVO resourceVO) {

        if(resourceVO != null && resourceVO.getFileName()!= null && !resourceVO.getFileName().equals("")){
            resourceManagerDAO.insertFileRecord(resourceVO);
        }else {
            LOGGER.error("resorceVO is null or filename is error");
        }
    }

    @Override
    public List<ResourceVO> queryFile(UserVO userVO) {
        return resourceManagerDAO.queryFile(userVO);
    }
}
