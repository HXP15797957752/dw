package com.hxp.controller;

import com.hxp.service.DatabaseInfoManagementService;
import com.hxp.vo.DatabaseInfoVO;
import com.hxp.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hxp on 2020/3/25.
 */
@Controller
public class DatabaseInfoManagementController {
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseInfoManagementController.class);

    @Autowired
    DatabaseInfoManagementService databaseInfoManagementService;

    @RequestMapping("/database/query")
    public String queryDatabaseInfoList(Model model){
        List resultList = databaseInfoManagementService.queryDatabaseInfoList();
        if(null != resultList && resultList.size()>0){
            LOGGER.debug(resultList.toString());
            //return resultList.toString();
            model.addAttribute("databaseInfoList", resultList);
        }
        return "/database";

    }

    @GetMapping("/add-database")
    public String toAddDatabaseInfo(){
        return  "/add-database";

    }

    @PostMapping("/add-database")
    public String addDatabaseInfo(DatabaseInfoVO databaseInfoVO){
        System.out.print(databaseInfoVO.toString());
        List list = Arrays.asList(databaseInfoVO);
        databaseInfoManagementService.addDatabaseInfo(list);
        return "/database";
    }
    /*@RequestMapping("/databaseinfo/add")
    public void addDatabaseInfo(DatabaseInfoVO databaseInfo){

    }*/

    @RequestMapping("/databaseinfo/edit")
    public String editDatabaseInfo(DatabaseInfoVO databaseInfo, UserVO userVO){
        return null;
    }

    @RequestMapping("/databaseinfo/delete")
    public  void deleteDatabaseInfo(DatabaseInfoVO databaseInfo){

    }
}
