package com.hxp.service;

import com.hxp.vo.DispatcherProjectVO;
import com.hxp.vo.ProjectInfoVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hxp on 2020/3/23.
 */
@Service
public interface DispatcherProjectService {

     int createDispatcherProject(DispatcherProjectVO dispatcherProjectVO);
     List queryDispatcherProjectList();
     String queryDepartmentNameById(String id);
}
