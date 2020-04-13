package com.hxp.config;

import com.hxp.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by hxp on 2020/4/13.
 */
@Configuration
public class LoginConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor);
        loginRegistry.addPathPatterns("/**");

        loginRegistry.excludePathPatterns("/login");
        loginRegistry.excludePathPatterns("/loginout");
        loginRegistry.excludePathPatterns("/css/**");
        loginRegistry.excludePathPatterns("/js/**");
        loginRegistry.excludePathPatterns("/img/**");

    }
}
