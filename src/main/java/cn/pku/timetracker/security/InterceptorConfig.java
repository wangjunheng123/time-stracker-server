package cn.pku.timetracker.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


@Configuration
public class InterceptorConfig extends WebMvcConfigurationSupport {


    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor())// 配置jwt的拦截器规则
                .addPathPatterns("/**")          //addPathPatterns("/**")/**表示拦截所有的请求路径
                .excludePathPatterns("/**/login","/**/register");  //应该拦截除了登录，注册请求以外的所有路径
        super.addInterceptors(registry);
    }


    // 注册
    @Bean
    public JwtInterceptor jwtInterceptor() {
        return new JwtInterceptor();
    }

}