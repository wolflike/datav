package com.bupt.cad.config;

import com.alibaba.fastjson.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@WebFilter(urlPatterns = "/*", filterName = "corsfilter") //这里的“/*” 表示的是需要拦截的请求路径
public class CorsConfig implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse)servletResponse;
        httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        httpResponse.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("Content-type", "*");
        httpResponse.addHeader("Access-Control-Allow-Origin", "*");
        httpResponse.setHeader("Access-Control-Max-Age", "3600");
        filterChain.doFilter(servletRequest, httpResponse);
    }
    @Override
    public void destroy() { }
}

//@Configuration
//public class CorsConfig implements WebMvcConfigurer{
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("**")
//                .allowedHeaders("*")
//                .allowedMethods("*")
//                .maxAge(1800)
//                .allowedOrigins("*");
//    }
//}