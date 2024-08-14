package common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// 1. 서블릿 실행 전 코드
		req.setCharacterEncoding("utf-8");
		// 2.체인의 다음 필터 처리
		// 연결된 필터가 더이상 없으면 원래 요청을 처리하는 서블릿 실행
		// 디자인 패턴: 프록시 패턴
		chain.doFilter(req, resp);
		
		// 3. 서블릿 실행 후 코드 
	}
}







