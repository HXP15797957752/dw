package com.hxp.controller;

import com.hxp.service.OnlineTaskListService;
import com.hxp.vo.IntegrationTaskVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

    /**
     * 查询生效状态的集成任务
     * @return
     */
    @RequestMapping("/onlinetask/queryall")
    public String queryAllOnlineTaskList(Model model){
        List<IntegrationTaskVO>   activeTaskList =  onlineTaskListService.queryAllOnlineTaskList();
        model.addAttribute("activetask", activeTaskList);
        return "/online-list";
    }

    @GetMapping("/onlinetask/excute")
    public void excuteIntegrationTask(HttpServletRequest request,
                                      HttpServletResponse response, IntegrationTaskVO integrationTaskVO){
        onlineTaskListService.excuteIntegrationTask(integrationTaskVO);
        try{
            response.sendRedirect("/onlinetask/queryall");
        }catch(Exception e){
            LOGGER.error("重定向出错........");
        }
    }
}
