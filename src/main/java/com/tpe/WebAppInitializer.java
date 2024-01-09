package com.tpe;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override

    //DB and Hibernate configuration
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
                RootContextConfig.class
        };
    }

    @Override
    //Mvc configuraion setting
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
                WebMvcConfig.class
        };
    }

    @Override
    // servlet and url mapping
    protected String[] getServletMappings() {
        return new String[]{"/"}; //all requests will be received by this serlvet
    }
}
