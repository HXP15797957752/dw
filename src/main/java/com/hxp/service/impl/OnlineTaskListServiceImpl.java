package com.hxp.service.impl;

import com.hxp.dao.IntegrationTaskDAO;
import com.hxp.dao.OnlineTaskListDAO;
import com.hxp.service.OnlineTaskListService;
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
public class OnlineTaskListServiceImpl implements OnlineTaskListService {
    Logger LOGGER= LoggerFactory.getLogger(OnlineTaskListServiceImpl.class);

    @Autowired
    OnlineTaskListDAO onlineTaskListDAO;
    @Autowired
    IntegrationTaskDAO integrationTaskDAO;

    @Override
    public List<IntegrationTaskVO> queryAllOnlineTaskList() {
        return integrationTaskDAO.queryAllIntegrationTask();
    }

    @Override
    public void excuteIntegrationTask(IntegrationTaskVO integrationTaskVO) {
        //TODO 执行集成任务

    }
}
