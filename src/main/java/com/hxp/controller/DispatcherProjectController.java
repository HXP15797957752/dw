package com.hxp.controller;

import com.hxp.service.DispatcherProjectService;
import com.hxp.utils.HDFSClient;
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
import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.ArrayList;
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
    public String  toCreateDispatcherProject(DispatcherProjectVO dispatcherProjectVO, Model model){

        //获取用户对应的HDFS jar包
        List<String> pathList = HDFSClient.getPathList("/jar");
        model.addAttribute("pathList", pathList);
        return "/add-dispatcher-project";
    }
    /*@RequestMapping("/add-dispatcher-project")
    public String  toAdddispatcherProject(){
        return "/add-dispatcher-project";
    }*/


    @PostMapping("/dispatcher/create")
    public void  createDispatcherProject(DispatcherProjectVO dispatcherProjectVO, HttpServletRequest request,
                                         HttpServletResponse response){
        UserVO user = (UserVO) request.getSession().getAttribute("user");
        dispatcherProjectVO.setUsername(user.getUsername());
        String departmentName = dispatcherProjectService.queryDepartmentNameById(user.getDepartmentId());
        dispatcherProjectVO.setDepartmentName(departmentName);
        dispatcherProjectService.createDispatcherProject(dispatcherProjectVO);
        //return "/dispatcher/query";
        try{
            response.sendRedirect("/dispatcher/query");
        }catch (Exception e){
            LOGGER.error("重定向出错.....");
        }


    }

    @GetMapping("/dispatcher/query")
    public String queryDispatcherProjectList(Model model){
       List list = dispatcherProjectService.queryDispatcherProjectList();
       model.addAttribute("jobList", list);
        return "/dispatcher-project";
    }


    @RequestMapping("/dispatcher/execute")
    public String executeDispatcherProject(DispatcherProjectVO dispatcherProjectVO){
        //TODO 周期调度 手动调度
        //TODO 调用spark脚本执行任务
        //通过projectVO获取执行参数
        /*YOUR_SPARK_HOME/bin/spark-submit \
        --class "SimpleApp" \
        --master local[4] \
        target/scala-2.12/simple-project_2.12-1.0.jar*/
        String classPath =  dispatcherProjectVO.getMainClass();
        String jarPath = dispatcherProjectVO.getMainJar();

        //配置loacl模式参数

        //配置standalone模式参数

        //配置yarn模式参数

        //执行脚本
        return null;
    }




}
