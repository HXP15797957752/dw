package com.hxp.controller;

import com.hxp.service.OnlineTaskListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hxp on 2020/3/25.
 */
@RestController
public class OnlineTaskListController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OnlineTaskListController.class);

    @Autowired
    OnlineTaskListService onlineTaskListService;

    @RequestMapping("/onlinetask/query")
    public String queryOnlineTaskListBy(Object object){
        return null;
    }

    @RequestMapping("/onlinetask/queryall")
    public String queryAllOnlineTaskList(){
        return null;
    }
}
