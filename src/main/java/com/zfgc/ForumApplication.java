package com.zfgc;

import java.io.IOException;
import java.security.Principal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.authentication.switchuser.SwitchUserFilter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.server.support.DefaultHandshakeHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;
import org.dozer.DozerBeanMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.annotation.EnableAsync;

import com.zfgc.config.ZfgcGeneralConfig;
import com.zfgc.interceptors.HttpUserAgentHandshakeInterceptor;
import com.zfgc.model.users.Users;
import com.zfgc.services.saml.OauthUsersDetailsServiceImpl;

import it.ozimov.springboot.mail.configuration.EnableEmailTools;

@Configuration
@ComponentScan
@SpringBootApplication
@MapperScan("com.zfgc.mappers")
@EnableConfigurationProperties({ZfgcGeneralConfig.class})
@EnableTransactionManagement
@EnableEmailTools
@EnableAsync
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
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:3000","http://dev3.zfgc.com");
			}
		};
	}
    
    public class Oauth2AuthorizationFilter extends GenericFilterBean {

		@Autowired
		private OauthUsersDetailsServiceImpl oauthUsersDetailsServiceImpl;
	  
	  public Oauth2AuthorizationFilter (OauthUsersDetailsServiceImpl userDetailsService) {
	    this.oauthUsersDetailsServiceImpl = userDetailsService;
	  }
	  
	  
	  @Override
	  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	      throws IOException, ServletException {

	    SecurityContext context = SecurityContextHolder.getContext();
	    if(context.getAuthentication() != null && context.getAuthentication().getPrincipal() instanceof Jwt) {
	      
	      UserDetails user = oauthUsersDetailsServiceImpl.loadUserByUsername(((Jwt)context.getAuthentication().getPrincipal()).getClaimAsString("user_name")); 
	      UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
	      context.setAuthentication(authentication);
	    }
	    
	    chain.doFilter(request, response);
	  }

	}
    
    
    @Configuration
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    @EnableWebSecurity
     public class SecurityConfig extends WebSecurityConfigurerAdapter {
    	
    	// userDetailsService bean
    	@Autowired
    	private OauthUsersDetailsServiceImpl oauthUsersDetailsServiceImpl;
    	
    	@Value("${clausius.auth.key}")
    	private String authKey;

    	@Bean
    	  public Oauth2AuthorizationFilter jwtAuthTokenFilterBean() throws Exception {
    	      return new Oauth2AuthorizationFilter(oauthUsersDetailsServiceImpl);
    	  }

    	
    	@Override
        protected void configure(HttpSecurity http) throws Exception
        {
    		//test key for now
    		SecretKeySpec key = new SecretKeySpec(authKey.getBytes(), "HMACSHA256");
    		
    		http.httpBasic().disable().csrf().disable().authorizeRequests().antMatchers("//*.map", 
					 "/**").permitAll().and().authorizeRequests().anyRequest().authenticated().and()
    		    .oauth2ResourceServer().jwt().decoder(NimbusJwtDecoder.withSecretKey(key).build());
    		
    		http.addFilterAfter(jwtAuthTokenFilterBean(), SwitchUserFilter.class);

        }
     }

    @Configuration
    @EnableWebSocketMessageBroker
    public static class websocketConfig extends AbstractWebSocketMessageBrokerConfigurer{

    	
    	@Override
    	public void configureMessageBroker(MessageBrokerRegistry config) {
    		config.enableSimpleBroker("/socket");
    		config.setApplicationDestinationPrefixes("/forum");
    	}
    	
		@Override
		public void registerStompEndpoints(StompEndpointRegistry registry) {
			registry.addEndpoint("/ws").addInterceptors(new HttpUserAgentHandshakeInterceptor()).withSockJS();
			
		}
    	
    }

    
}