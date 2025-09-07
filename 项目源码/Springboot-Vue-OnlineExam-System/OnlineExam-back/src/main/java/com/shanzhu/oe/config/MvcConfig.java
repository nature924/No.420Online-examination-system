package com.shanzhu.oe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * SpringMvc 配置
 *
 * @author: ShanZhu
 * @date: 2023-11-20
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * 配置拦截器
     *
     * @param registry 相当于拦截器的注册中心
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns()
                .excludePathPatterns("/login");
    }


    /**
     * 跨域配置
     *
     * @return 跨域
     */
    @Bean
    public CorsFilter corsFilter() {
        // 1.创建 CORS 配置对象
        CorsConfiguration config = new CorsConfiguration();
        // 支持域
        config.addAllowedOrigin("*");
        // 是否发送 Cookie
        config.setAllowCredentials(true);
        // 支持请求方式
        config.addAllowedMethod("*");
        // 允许的原始请求头部信息
        config.addAllowedHeader("*");
        // 2.添加地址映射
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**", config);
        // 3.返回 CorsFilter 对象
        return new CorsFilter(corsConfigurationSource);
    }
}
