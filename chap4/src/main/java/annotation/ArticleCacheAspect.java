package annotation;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import xml.Article;

@Component
@Aspect
@Order(2)
public class ArticleCacheAspect {
	private Map<Integer, Article> cache= new HashMap<Integer,Article>();
	@Around("execution(public * *..ReadArticleService.*(..))")
	public Object cache(ProceedingJoinPoint joinPoint) throws Throwable{
		//기본 메서드 매개변수 목록
		Integer id=(Integer)joinPoint.getArgs()[0];
		
		//기본메서드의 이름을 가져올 수 있음  id는 매개변수
		System.out.println("[ACA]"+joinPoint.getSignature().getName()+"("+id+") 메서드 호출 전");	
		Article article = cache.get(id);
		if(article != null) {
			System.out.println("[ACA] cache에서 Article["+id+"] 가져옴");
			return article;
		}
		Object ret=joinPoint.proceed();
		System.out.println("[ACA]"+joinPoint.getSignature().getName()+"("+id+") 메서드 호출 후");	
		if(ret != null && ret instanceof Article) {
			cache.put(id, (Article)ret);
			System.out.println("[ACA] cache에 Article["+id+"] 추가함");
		}
		return ret;		//Main3 에서 a1이 리턴값을 받음.
	}
}
