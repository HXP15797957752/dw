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
import java.net.URI;
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
        //TODO 展示对应HDFS资源中的jar包路径
        //获取用户对应的HDFS jar包
        String uri = "hdfs://192.168.0.88:9000/";
        /*Configuration configuration = new  Configuration();
        FileSystem fileSystem = FileSystem.get(URI.create(uri), configuration);
        //获取/test/input/目录下的所有文件和目录
        FileStatus[] statuses = fs.listStatus(new Path("/test/input"));*/
        //回显路径信息

        return "/add-dispatcher-project";
    }

    @PostMapping("/dispatcher/create")
    public String  createDispatcherProject(DispatcherProjectVO dispatcherProjectVO, HttpServletRequest request){
        UserVO user = (UserVO) request.getSession().getAttribute("user");
        dispatcherProjectVO.setUsername(user.getUsername());
        String departmentName = dispatcherProjectService.queryDepartmentNameById(user.getDepartmentId());
        dispatcherProjectVO.setDepartmentName(departmentName);
        dispatcherProjectService.createDispatcherProject(dispatcherProjectVO);
        return "/dispatcher/query";
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
        //TODO 调用spark脚本执行任务
        //通过projectVO获取执行参数

        //配置loacl模式参数

        //配置standalone模式参数

        //配置yarn模式参数

        //执行脚本
    }




}
