package com.zfgc;

import java.util.Arrays;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@SpringBootApplication
@EnableAutoConfiguration(exclude = { 
        org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class 
    })
@MapperScan("com.zfgc.mappers")
public class ForumApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(applicationClass, args);
    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

    private static Class<ForumApplication> applicationClass = ForumApplication.class;
    
    @Bean(name = "org.dozer.Mapper")
    public DozerBeanMapper dozerBean() {
      List<String> mappingFiles = Arrays.asList(
        "dozer-global-configuration.xml", 
        "dozer-bean-mappings.xml",
        "more-dozer-bean-mappings.xml"
      );

      DozerBeanMapper dozerBean = new DozerBeanMapper();
      dozerBean.setMappingFiles(mappingFiles);
      return dozerBean;
    }
}