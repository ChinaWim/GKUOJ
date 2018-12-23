package com.oj.gkuoj.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @author m969130721@163.com
 * @date 18-6-20 下午3:52
 */
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public  void addInterceptors(InterceptorRegistry registry) {
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/index");
    }

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
////        registry.addResourceHandler("file/**").addResourceLocations("file:" + fileLocationPath + "/");
//    }


}
