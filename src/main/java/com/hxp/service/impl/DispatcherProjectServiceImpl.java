package com.hxp.service.impl;

import com.hxp.dao.DispatcherProjectDAO;
import com.hxp.service.DispatcherProjectService;
import com.hxp.vo.DispatcherProjectVO;
import com.hxp.vo.ProjectInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by hxp on 2020/3/23.
 */
@Service
public class DispatcherProjectServiceImpl implements DispatcherProjectService {
    private static final Logger LOGGER = LoggerFactory.getLogger(DispatcherProjectServiceImpl.class);

    @Autowired
    public DispatcherProjectDAO dispatcherProjectDAO;

    public int createDispatcherProject(DispatcherProjectVO dispatcherProjectVO) {
        //TODO 获取对应的部门名称
        int result = dispatcherProjectDAO.createDispatcherProject(dispatcherProjectVO);
        return result;
    }

    @Override
    public List queryDispatcherProjectList() {
        return dispatcherProjectDAO.queryDispatcherProjectList();
    }
}
