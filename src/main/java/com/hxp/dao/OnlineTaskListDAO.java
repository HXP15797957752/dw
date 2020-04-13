package com.hxp.dao;

import com.hxp.vo.IntegrationTaskVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by hxp on 2020/4/13.
 */
@Mapper
public interface OnlineTaskListDAO {
    List<IntegrationTaskVO> queryAllOnlineTaskList();
}
