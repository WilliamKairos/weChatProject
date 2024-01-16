package com.wechat.filter;

import com.alibaba.fastjson.JSONObject;
import com.wechat.util.JwtUtils;
import com.wechat.util.Result;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class Jwtfilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //获取请求url
        String url = request.getRequestURI().toString();
        log.info("请求的url: {}", url);

        //判断请求url中是否包含login
        if(url.contains("login")){
            log.info("登录操作，放行");
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        //获取请求头中的token
        String jwt = request.getHeader("token");

        //判断token是否存在，如果不存在，则返回未登录
        if (!StringUtils.hasLength(jwt)){
            log.info("token为空，返回未登录");
            Result error = Result.error("NOT_LOGIN");
            //使用Alibaba的fastJSON工具包，将对象转化成json
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return;
        }

        //解析token，如果解析失败，说明token过期或token非法
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e){
            e.printStackTrace();
            log.info("token解析失败，返回未登录");
            Result error = Result.error("NOT_LOGIN");
            //使用Alibaba的fastJSON工具包，将对象转化成json
            String notLogin = JSONObject.toJSONString(error);
            response.getWriter().write(notLogin);
            return;
        }

        //token正确，放行
        log.info("token合法，放行");
        filterChain.doFilter(servletRequest, servletResponse);
    }

}
