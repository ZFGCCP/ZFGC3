package com.zfgc;

import java.util.Arrays;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.github.ulisesbocchio.spring.boot.security.saml.annotation.EnableSAMLSSO;
import com.github.ulisesbocchio.spring.boot.security.saml.configurer.ServiceProviderBuilder;
import com.github.ulisesbocchio.spring.boot.security.saml.configurer.ServiceProviderConfigurerAdapter;

@Configuration
@ComponentScan
@SpringBootApplication
@EnableSAMLSSO
@MapperScan("com.zfgc.mappers")
public class ForumApplication extends org.springframework.boot.web.support.SpringBootServletInitializer {

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
        "dozer-bean-mappings.xml"
      );

      DozerBeanMapper dozerBean = new DozerBeanMapper();
      dozerBean.setMappingFiles(mappingFiles);
      return dozerBean;
    }
    
    @Configuration
    public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity security) throws Exception
        {
         security.httpBasic().disable();
         security.authorizeRequests().antMatchers("/").permitAll();
        }
    }
    
    @Configuration
    public static class MyServiceProviderConfig extends ServiceProviderConfigurerAdapter {

        @Override
        public void configure(ServiceProviderBuilder serviceProvider) throws Exception {

            serviceProvider
                .metadataGenerator()
                .entityId("zfgc-sp")
            .and()
                .sso()
                .defaultSuccessURL("/home")
                .idpSelectionPageURL("/idpselection")
            .and()
                .logout()
                .defaultTargetURL("/")
            .and()
                .metadataManager()
                .refreshCheckInterval(0)
                .metadataTrustCheck(false)
            .and()
                .extendedMetadata()
                .idpDiscoveryEnabled(true)
            .and()
                .keyManager();
                //.privateKeyDERLocation("classpath:/localhost.key.der")
                //.publicKeyPEMLocation("classpath:/localhost.cert");

        }
}
    
}