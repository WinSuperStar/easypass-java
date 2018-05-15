package com.joshua.easypass.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.joshua.easypass.config.filter.SessionFilter;
import com.joshua.easypass.config.listener.SessionAttributeListener;
import com.joshua.easypass.config.properties.FileUploadProperties;

@Configuration
public class WebAppConfig implements WebMvcConfigurer{
	@Autowired 
	private FileUploadProperties fileUploadProperties;

    @Bean
    @ConditionalOnProperty(prefix = FileUploadProperties.FILE_UPLOAD_PREFIX, name = "open", havingValue = "true", matchIfMissing = true)
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大KB,MB
        factory.setMaxFileSize(fileUploadProperties.getMaxFileSize());
        //设置总上传数据总大小
        factory.setMaxRequestSize(fileUploadProperties.getMaxRequestSize());
        return factory.createMultipartConfig();
    }
    

    @Bean
    public FilterRegistrationBean<SessionFilter> indexFilterRegistration() {
        FilterRegistrationBean<SessionFilter> registration = new FilterRegistrationBean<>(new SessionFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }
    
    @Bean
    public ServletListenerRegistrationBean<SessionAttributeListener> servletListenerRegistrationBean(){
        ServletListenerRegistrationBean<SessionAttributeListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean<SessionAttributeListener>();
        servletListenerRegistrationBean.setListener(new SessionAttributeListener());
        return servletListenerRegistrationBean;
    }    
}
