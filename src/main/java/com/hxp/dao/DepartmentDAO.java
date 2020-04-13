package com.hxp.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * Created by hxp on 2020/4/13.
 */
@Mapper
public interface DepartmentDAO {
    String queryDepartmentNameById(String id);
}
