package com.hxp.controller;

import com.hxp.service.UserService;
import com.hxp.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by hxp on 2020/3/22.
 */
@Controller
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @GetMapping("/login")
    public String  login(){
        return "/login";
    }

    @PostMapping("/login")
    public String  login(UserVO userVO, Model model, HttpServletRequest request){
        UserVO resultUserVo = userService.getUserByUsername(userVO);
        if(resultUserVo.getUsername().equals(userVO.getUsername()) &&
                resultUserVo.getPassword().equals(userVO.getPassword())){
            LOGGER.info("{}登录成功....",userVO.getUsername());
            //model.addAttribute("user", resultUserVo);
            HttpSession session = request.getSession();
            session.setAttribute("user", resultUserVo);
            return "/index";
        }
        LOGGER.warn("{}登录失败,请重试....",userVO.getUsername());
        model.addAttribute("msg","登录失败，请重试！");
        return "/login";
    }

    @PostMapping("/register")
    public String register(UserVO userVO, @RequestParam("repeatPassword") String repeatPassword, Model model){
        System.out.println("==========" + userVO.toString()+ "-=======" + repeatPassword);
        if(!(userVO.getPassword().equals(repeatPassword))){
            model.addAttribute("msg", "两次密码不一致！");
            return "/register";
        }
        String  result = userService.register(userVO);
        LOGGER.debug("======" + result);
        if(result.equals("success")){
            return "/login";
        }else{
            model.addAttribute("msg", result);
            return "/register";
        }
    }

    @GetMapping("/register")
    public String  register(){
        return "/register";
    }

    @GetMapping("/index")
    public String index(Model model){
        /*UserVO user = new UserVO();
        user.setId(1L);
        user.setUsername("hxp");

        model.addAttribute("user", user);*/
        return "/index";
    }

    @GetMapping("/user/current")
    public void current(){
        System.out.print("user/current.........");
    }

    @RequestMapping("/online-list")
    public String  onlineList(){
        return "/online-list";
    }

    @RequestMapping("/database")
    public String  database(){
        return "/database";
    }

    @RequestMapping("/integration-task")
    public String  integrationTask(){
        return "/integration-task";
    }

    @RequestMapping("/dispatcher-project")
    public String  dispatcherProject(){
        return "/dispatcher-project";
    }

    @RequestMapping("/sql")
    public String  sql(){
        return "/sql";
    }

    @RequestMapping("/resource")
    public String  resource(){
        return "/resource";
    }

    @GetMapping("/loginout")
    public String  loginout(HttpServletRequest request){
        request.getSession().invalidate();
        return "/login";
    }

}
