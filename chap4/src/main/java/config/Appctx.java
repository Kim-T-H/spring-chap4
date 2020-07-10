package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import main.MemberService;


@Configuration	//설정을 위한 자바프로그램
@ComponentScan(basePackages= {"annotation"}) //객체화되는 패키지 설정     "main"
@EnableAspectJAutoProxy	//annotation으로 AOP를  사용 설정.

public class Appctx {
	
	@Bean
	public MemberService memberService2() {
		MemberService m = new MemberService();
		return m;
	}
}
