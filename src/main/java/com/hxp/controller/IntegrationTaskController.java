package com.hxp.controller;

import com.hxp.service.IntegrationTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hxp on 2020/3/25.
 */
@Controller
public class IntegrationTaskController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IntegrationTaskController.class);

    @Autowired
    IntegrationTaskService integrationTaskService;

    @RequestMapping("/integrationtask/query")
    public  String queryIntegrationTask(Object object){
        return null;
    }

    @RequestMapping("/add-integration-task")
    public  String toAddIntegrationTask(){
        return "/add-integration-task";
    }

    @RequestMapping("/integrationtask/create")
    public String createIntegrationTask(Object object){
        return null;
    }

    @RequestMapping("/integrationtask/queryall")
    public String queryAllIntegrationTask(){
        return null;
    }
}
