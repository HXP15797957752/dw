package com.hxp.controller;

import com.hxp.service.DispatcherProjectService;
import com.hxp.vo.DispatcherProjectVO;
import com.hxp.vo.ProjectInfoVO;
import com.hxp.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by hxp on 2020/3/23.
 */
@Controller
public class DispatcherProjectController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DispatcherProjectController.class);

    @Autowired
    DispatcherProjectService dispatcherProjectService;

    @GetMapping("/dispatcher/create")
    public String  toCreateDispatcherProject(ProjectInfoVO projectInfoVO){
        return "/add-dispatcher-project";
    }

    @PostMapping("/dispatcher/create")
    public String  createDispatcherProject(DispatcherProjectVO dispatcherProjectVO, HttpServletRequest request){
        UserVO user = (UserVO) request.getSession().getAttribute("user");
        dispatcherProjectVO.setUsername(user.getUsername());
        dispatcherProjectService.createDispatcherProject(dispatcherProjectVO);
        return "/dispatcher-project";
    }

    @GetMapping("/dispatcher/query")
    public String queryDispatcherProjectList(Model model){
       List list = dispatcherProjectService.queryDispatcherProjectList();
       model.addAttribute("jobList", list);
        return "/dispatcher-project";
    }


    @RequestMapping("/dispatcher/execute")
    public void executeDispatcherProject(ProjectInfoVO projectInfoVO){
        //TODO 周期调度 手动调度
    }




}
