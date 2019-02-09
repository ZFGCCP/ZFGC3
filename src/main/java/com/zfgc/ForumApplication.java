package com.zfgc;

import java.io.IOException;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;
import org.dozer.DozerBeanMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;

import com.github.ulisesbocchio.spring.boot.security.saml.annotation.EnableSAMLSSO;
import com.github.ulisesbocchio.spring.boot.security.saml.bean.SAMLConfigurerBean;
import com.github.ulisesbocchio.spring.boot.security.saml.configurer.ServiceProviderBuilder;
import com.github.ulisesbocchio.spring.boot.security.saml.configurer.ServiceProviderConfigurerAdapter;
import com.zfgc.config.XhrSamlEntryPoint;
import com.zfgc.config.ZfgcSamlConfig;
import com.zfgc.services.saml.SamlHandshakeHandler;
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
    
    /*@Bean
    SAMLConfigurerBean saml() {
        return new SAMLConfigurerBean();
    }*/
    
    /*@Configuration
    //@Order(102)
    public class testConfig extends WebSecurityConfigurerAdapter{
    	@Override
    	public void configure(WebSecurity web) throws Exception {
    		web.ignoring().antMatchers("/bower_components/**","/scripts/**");
    	}
    }
    
    //@Order(101)*/
   @Configuration
    public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Override
        protected void configure(HttpSecurity http) throws Exception
        {
        	//http.anonymous().and().authorizeRequests().antMatchers("/forum**").permitAll();	
        }
    }

    @Configuration
    @EnableWebSocketMessageBroker
    public static class websocketConfig extends AbstractWebSocketMessageBrokerConfigurer{

    	@Autowired
    	SamlHandshakeHandler samlHandshakeHandler;
    	
    	@Override
    	public void configureMessageBroker(MessageBrokerRegistry config) {
    		config.enableSimpleBroker("/socket");
    		config.setApplicationDestinationPrefixes("/forum");
    	}
    	
		@Override
		public void registerStompEndpoints(StompEndpointRegistry registry) {
			registry.addEndpoint("/ws").setHandshakeHandler(samlHandshakeHandler).withSockJS();
			
		}
    	
    }

    @Configuration
    public static class MyServiceProviderConfig extends ServiceProviderConfigurerAdapter {

    	@Autowired
    	public ZfgcSamlConfig zfgcSamlConfig;
    	
    	@Autowired
    	public SamlUsersDetailsServiceImpl samlUserDetailsService;
    	
        @Override
        public void configure(ServiceProviderBuilder serviceProvider) throws Exception {

            serviceProvider
            .authenticationProvider()
            	.userDetailsService(samlUserDetailsService)
            .and()
                .metadataGenerator()
                .entityId(zfgcSamlConfig.getEntityId())
                .entityBaseURL(zfgcSamlConfig.getEntityBaseUrl())
                .requestSigned(false)
                .metadataURL(zfgcSamlConfig.getMetadataUrl())
            .and()
                .sso()
                .samlEntryPoint(new XhrSamlEntryPoint())
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
	            .includeServerPortInRequestURL(true)
	        .and()
	        	.http().httpBasic()
                .disable()
                .csrf()
                .disable()
                .anonymous()
                .and()
	        	.authorizeRequests().antMatchers("/ws/**","/**/*.css", "/**/*.js",
	        									 "/**/*.html",
	        									 "/**/*.map", 
	        									 "/forum/index", 
	        									 //"/zfgcui/**", 
	        									 "/zfgcui/bbs/index",
	        									 "/zfgcui/registration",
	        									 "/socket/whosonline",
	        									 "/lookups/**",
	        									 "/users/loggedInUser",
	        									 "/users/newuser").permitAll();
	        	//.authorizeRequests().antMatchers("/scripts/**","/assets/**","/node_modules/**","/images/**","/users/**","/ws/**","/lookups/**","/userprofile").permitAll();
	        	//.authorizeRequests().antMatchers("/pm/**").fullyAuthenticated()
	        	//.antMatchers("/**").permitAll();*/
	        		                

        }
    }
    
}