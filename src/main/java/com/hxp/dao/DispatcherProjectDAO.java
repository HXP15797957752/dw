package com.hxp.dao;

import com.hxp.vo.DispatcherProjectVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hxp on 2020/3/23.
 */
//@Repository
@Mapper
public interface DispatcherProjectDAO {
    int  createDispatcherProject(DispatcherProjectVO dispatcherProjectVO);
    List queryDispatcherProjectList();
}
