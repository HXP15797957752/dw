package com.hxp.service;

import com.hxp.vo.IntegrationTaskVO;

import java.util.List;

/**
 * Created by hxp on 2020/3/25.
 */
public interface IntegrationTaskService {
     void createIntegrationTask(IntegrationTaskVO integrationTaskVO);
     List<IntegrationTaskVO> queryAllIntegrationTask();
    int updateOwner(IntegrationTaskVO integrationTaskVO);
}
