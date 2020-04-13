package com.hxp.service.impl;

import com.hxp.dao.IntegrationTaskDAO;
import com.hxp.service.IntegrationTaskService;
import com.hxp.vo.IntegrationTaskVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hxp on 2020/3/25.
 */
@Service
public class IntegrationTaskServiceImpl implements IntegrationTaskService {
    Logger LOGGER = LoggerFactory.getLogger(IntegrationTaskServiceImpl.class);

    @Autowired
    IntegrationTaskDAO integrationTaskDAO;

    @Override
    public void createIntegrationTask(IntegrationTaskVO integrationTaskVO) {
        integrationTaskDAO.createIntegrationTask(integrationTaskVO);
    }

    @Override
    public List<IntegrationTaskVO> queryAllIntegrationTask() {
        return integrationTaskDAO.queryAllIntegrationTask();
    }

    @Override
    public int updateOwner(IntegrationTaskVO integrationTaskVO) {
        return integrationTaskDAO.updateOwner(integrationTaskVO);
    }
}
