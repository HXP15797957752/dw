package com.hxp.service;

import com.hxp.vo.ResourceVO;
import com.hxp.vo.UserVO;

import java.util.List;

/**
 * Created by hxp on 2020/3/24.
 */
public interface ResourceManagerService {
    void insertFileRecord(ResourceVO resourceVO);

    List<ResourceVO> queryFile(UserVO userVO);
}
