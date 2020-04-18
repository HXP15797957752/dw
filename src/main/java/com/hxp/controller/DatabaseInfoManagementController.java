package com.hxp.controller;

import com.hxp.utils.ConnectionTestUtil;
import com.hxp.service.DatabaseInfoManagementService;
import com.hxp.vo.DatabaseInfoVO;
import com.hxp.vo.UserVO;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 根据id更新数据库信息
     * @param databaseInfo
     * @param userVO
     * @return
     */
    @RequestMapping("/databaseinfo/edit")
    public String editDatabaseInfo(DatabaseInfoVO databaseInfo, UserVO userVO){
        databaseInfoManagementService.editDatabaseInfo(databaseInfo);
        return null;
    }

    /**
     * 根据id删除数据库信息
     * @param databaseInfo
     */
    @RequestMapping("/databaseinfo/delete")
    public  void deleteDatabaseInfo(DatabaseInfoVO databaseInfo){
        databaseInfoManagementService.deleteDatabaseInfo(databaseInfo);
    }

    @PostMapping("/connectionTest")
    @ResponseBody
    public String connectionTest(DatabaseInfoVO databaseInfoVO, String databaseName){
        String ip = databaseInfoVO.getIp();
        int port = databaseInfoVO.getPort();
        //String databaseName = databaseInfoVO.
        //TODO String password = databaseInfoManagementService.getPasswordByIpAndPort(ip, String.valueOf(port));
        String username = databaseInfoVO.getUsername();
        String password = databaseInfoVO.getPassword();
        String url = "jdbc:mysql://" + ip + ":" + port + "/" + databaseName +
                "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        LOGGER.info(url);
        Boolean result = ConnectionTestUtil.connectionTest(url,username, password);
        return result?"连接成功！":"连接失败！";
    }
}
