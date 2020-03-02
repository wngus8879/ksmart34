package kr.or.ksmart.springboot34_mybatis.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import kr.or.ksmart.springboot34_mybatis.inteceptor.CommonInterceptor;
import kr.or.ksmart.springboot34_mybatis.inteceptor.LoginInterceptor;

@Configuration
public class WedConfig implements WebMvcConfigurer {
	
	@Autowired
	private CommonInterceptor commonInterceptor;
	
	@Autowired
	private LoginInterceptor loginInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(commonInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/")
				.excludePathPatterns("/css/**");//모든 경로에는 와일드카드(**)가 들어간다.
		
		
		registry.addInterceptor(loginInterceptor)
				.addPathPatterns("/**")
				.excludePathPatterns("/")
				.excludePathPatterns("/mInsert")//예외경로 
				.excludePathPatterns("/login")
				.excludePathPatterns("/css/**");
		
		
	}

}
