package com.hxp.controller;

import com.hxp.dao.DatabaseInfoManagementDAO;
import com.hxp.service.DatabaseInfoManagementService;
import com.hxp.service.IntegrationTaskService;
import com.hxp.utils.ConnectionTestUtil;
import com.hxp.vo.IntegrationTaskVO;
import com.hxp.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by hxp on 2020/3/25.
 */
@Controller
public class IntegrationTaskController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IntegrationTaskController.class);

    @Autowired
    IntegrationTaskService integrationTaskService;
    @Autowired
    DatabaseInfoManagementService databaseInfoManagementService;

    @RequestMapping("/integrationtask/query")
    public  String queryIntegrationTask(Object object){
        return null;
    }

    @GetMapping("/add-integration-task")
    public  String toAddIntegrationTask(){
        return "/add-integration-task";
    }

    @PostMapping("/integrationtask/create")
    public void createIntegrationTask(HttpServletRequest request, HttpServletResponse response,
                                      IntegrationTaskVO  integrationTaskVO){
        UserVO userVO = (UserVO) request.getSession().getAttribute("user");
        integrationTaskVO.setUsername(userVO.getUsername());
        integrationTaskService.createIntegrationTask(integrationTaskVO);
        try{
            response.sendRedirect("/integrationtask/queryall");
        }catch(Exception e){
            LOGGER.error("重定向出错........");
        }
    }

    @GetMapping("/integrationtask/queryall")
    public String queryAllIntegrationTask(Model model){
        List<IntegrationTaskVO>  integrationTaskVOList = integrationTaskService.queryAllIntegrationTask();
        model.addAttribute("taskList", integrationTaskVOList);
        return "/integration-task";
    }

    @RequestMapping("/checktable")
    public String chechTable(String database, String table){
        //TODO 验证表是否存在
        return "success";
    }
    @PostMapping("/integrationtask/updateowner")
    public void  updateOwner(HttpServletResponse response, IntegrationTaskVO  integrationTaskVO){
        integrationTaskService.updateOwner(integrationTaskVO);
        try{
            response.sendRedirect("/integrationtask/queryall");
        }catch(Exception e){
            LOGGER.error("重定向出错........");
        }
    }

    @PostMapping("/integrationtask/testconnection")
    @ResponseBody
    public String testConnection(IntegrationTaskVO  integrationTaskVO){
        String ip = integrationTaskVO.getIp();
        int port = integrationTaskVO.getPort();
        String databaseName = integrationTaskVO.getDatabaseName();
        String url = "jdbc:mysql://" + ip + ":" + port + "/" + databaseName +
                "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String username = integrationTaskVO.getUsername();
        //根据ip port查询密码
        String password = databaseInfoManagementService.getPasswordByIpAndPort(ip, String.valueOf(port));
        Boolean result = ConnectionTestUtil.connectionTest(url,username,password);
        return result?"连接成功！":"连接失败";
    }
}
