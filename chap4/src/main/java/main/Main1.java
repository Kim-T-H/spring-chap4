package main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.ReadImpl;
import spring.WriteImpl;

public class Main1 {
	public static void main(String[] args) {
		AbstractApplicationContext ctx= new GenericXmlApplicationContext("classpath:aop.xml");
		WriteImpl bean= ctx.getBean("write",WriteImpl.class);
		//LoggingAspect.logging(...) 먼저 실행됨.
		//logging()의 joinPoint.proceed() 문장으로 write() 실제로 호출됨.
		bean.write(); //기본메서드
		//logging()의 joinPoint.proceed() 문장 이후로 제어 이동.
		System.out.println("================");
		ReadImpl read=ctx.getBean("read",ReadImpl.class);
		
		//LoggingAspect.logging(...) 먼저 실행됨.
		//logging()의 joinPoint.proceed() 문장으로 read() 실제로 호출됨.
		System.out.println("[main]"+ read.read());
		//logging()의 joinPoint.proceed() 문장 이후로 제어 이동.
		//ret 리턴 값을 loggin 메서드에서 main 으로 전달함
	}
}
