package com.hyon01.minishop;

import com.hyon01.minishop.web.interceptor.LoginCheckInterceptor;
import com.hyon01.minishop.web.interceptor.MemberCheckInterceptor;
import lombok.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Override
   public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoginCheckInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/members/add","/members/addSuccess", "/login", "/logout",
                        "/members/deleteSuccess","/items/**",
                        "/css/**", "/*.ico", "/error","/images/**","/js/**");

        registry.addInterceptor(new MemberCheckInterceptor())
                .order(2)
                .addPathPatterns("/members/**","item/**")
                .excludePathPatterns("/", "/members/add","/members/addSuccess" ,"/login", "/logout",
                        "/members/deleteSuccess","/items/**",
                        "/css/**", "/*.ico", "/error","/images/**","/js/**");
    }

}