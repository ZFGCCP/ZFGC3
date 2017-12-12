package com.zfgc;

import java.util.Arrays;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.github.ulisesbocchio.spring.boot.security.saml.annotation.EnableSAMLSSO;
import com.github.ulisesbocchio.spring.boot.security.saml.bean.SAMLConfigurerBean;
import com.github.ulisesbocchio.spring.boot.security.saml.configurer.ServiceProviderBuilder;
import com.github.ulisesbocchio.spring.boot.security.saml.configurer.ServiceProviderConfigurerAdapter;
import com.zfgc.config.ZfgcSamlConfig;
import com.zfgc.services.saml.SamlUsersDetailsServiceImpl;

@Configuration
@ComponentScan
@SpringBootApplication
@EnableSAMLSSO
@MapperScan("com.zfgc.mappers")
@EnableConfigurationProperties(ZfgcSamlConfig.class)
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
        "dozer-bean-mappings.xml"
      );

      DozerBeanMapper dozerBean = new DozerBeanMapper();
      dozerBean.setMappingFiles(mappingFiles);
      return dozerBean;
    }
    
    @Bean
    SAMLConfigurerBean saml() {
        return new SAMLConfigurerBean();
    }
    
    /*@Configuration
    //@Order(102)
    public class testConfig extends WebSecurityConfigurerAdapter{
    	@Override
    	public void configure(WebSecurity web) throws Exception {
    		web.ignoring().antMatchers("/bower_components/**","/scripts/**");
    	}
    }
    
    //@Order(101)
   @Configuration
    public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception
        {
        	http
        		.antMatcher("/**").anonymous();
        		
        		//.authenticated().anyRequest().permitAll();
            //.authorizeRequests()
            //.requestMatchers(saml().endpointsMatcher())
            //.permitAll();
        		
        }
    }*/

    @Configuration
    public static class MyServiceProviderConfig extends ServiceProviderConfigurerAdapter {

    	@Autowired
    	public ZfgcSamlConfig zfgcSamlConfig;
    	
        @Override
        public void configure(ServiceProviderBuilder serviceProvider) throws Exception {

            serviceProvider
            .authenticationProvider()
            	.userDetailsService(new SamlUsersDetailsServiceImpl())
            .and()
                .metadataGenerator()
                .entityId(zfgcSamlConfig.getEntityId())
                .entityBaseURL(zfgcSamlConfig.getEntityBaseUrl())
                .requestSigned(false)
                .metadataURL(zfgcSamlConfig.getMetadataUrl())
                
            .and()
                .sso()
                .defaultSuccessURL(zfgcSamlConfig.getDefaultSuccessUrl())
                .defaultFailureURL(zfgcSamlConfig.getDefaultFailureUrl())
                .idpSelectionPageURL(zfgcSamlConfig.getIdpSelectionPageUrl())
                
                //.ssoProcessingURL("/forum/SSO")
                
            .and()
                .logout()
                .defaultTargetURL("/")
            .and()
                .metadataManager()
                .refreshCheckInterval(0)
                .metadataTrustCheck(false)
                
                //.localMetadataLocation("classpath:/sp-metadata.xml")
            .and()
                .extendedMetadata()
               
                //.signingKey("test")
                //.encryptionKey("test")
                //.idpDiscoveryEnabled(true)
                
            .and()
                .keyManager()
                //.privateKeyDERLocation("classpath:/localhost.key.der")
                //.publicKeyPEMLocation("classpath:/localhost.cert");
            .and()
	            .samlContextProviderLb()
	            .scheme(zfgcSamlConfig.getScheme())
	            .contextPath(zfgcSamlConfig.getContextPath())
	            .serverName(zfgcSamlConfig.getServerName())
	            .serverPort(zfgcSamlConfig.getServerPort())
	            .includeServerPortInRequestURL(true);

        }
    }
    
}