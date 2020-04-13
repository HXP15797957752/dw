package com.hxp.dao;

import com.hxp.vo.ResourceVO;
import com.hxp.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by hxp on 2020/4/13.
 */
@Mapper
public interface ResourceManagerDAO {
    void insertFileRecord(ResourceVO resourceVO);
    List<ResourceVO> queryFile(UserVO userVO);

}
