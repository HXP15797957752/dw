package com.hxp.interceptor;

import com.hxp.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hxp on 2020/4/13.
 */
public class LoginInterceptor   implements HandlerInterceptor {
    private Logger LOGGER = LoggerFactory.getLogger(LoginInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserVO user = (UserVO) request.getSession().getAttribute("user");
        if (user == null || !(user.getUsername() instanceof  String)){
            response.sendRedirect("/login");
            return false;
        }
        LOGGER.info("用户 " +  user.getUsername() + "已登录");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
